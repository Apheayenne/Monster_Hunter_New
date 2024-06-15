/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xml_api;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import monster_hunter.Item;
import monster_hunter.ItemMap;

/**
 *
 * @author howan
 */
public class StAX_Write {
	
	public void Write_Main(ByteArrayOutputStream out, File file){
		try {
			XMLOutputFactory output = XMLOutputFactory.newInstance();
			XMLStreamWriter writer = output.createXMLStreamWriter(out);
		

			LinkedHashMap map = ItemMap.getInstance();
			Set keySet = map.keySet();
			Iterator iter = keySet.iterator();
			//Logger.getLogger(StAX_Write.class.getName()).log(Level.INFO, keySet.toString());

			writer.writeStartDocument("UTF-8", "1.0");
			writer.writeStartElement("Items");

			while (iter.hasNext()){
				String value = (String)iter.next();
				//Logger.getLogger(StAX_Write.class.getName()).log(Level.INFO, value.toString());

				Item item = (Item)map.get(value);
				writeItem(item, writer);
			}
			
			writer.writeEndElement();
			writer.writeEndDocument();
			
			String xml = new String(out.toByteArray(), StandardCharsets.UTF_8);
			String prettyPrintXML = formatXML(xml);
			
			Files.writeString(Paths.get(file.getAbsolutePath()), prettyPrintXML, StandardCharsets.UTF_8);
		} catch (XMLStreamException | IOException | TransformerException e){
			Logger.getLogger(StAX_Read.class.getName()).log(Level.SEVERE, e.getMessage(), e);
		}
	}
	
	private void writeItem(Item item, XMLStreamWriter writer) throws XMLStreamException{
		Logger.getLogger(StAX_Write.class.getName()).log(Level.INFO, "Item: {0}", item);
		//for (int i = 0; i < item.size(); i++){
		//Logger.getLogger(StAX_Write.class.getName()).log(Level.INFO, item.get(i).toString());
		writer.writeComment(item.getName());
		writer.writeStartElement("Item");
		writer.writeAttribute("id", Integer.toString(item.getID()));
		writer.writeAttribute("name", item.getName());
		writer.writeAttribute("quantity", Integer.toString(item.getQuantity()));
		writeRanking(item, writer);

		writer.writeEndElement();

	}
	
	private void writeRanking(Item item, XMLStreamWriter writer){
		try{
			writer.writeStartElement("Rankings");
			ArrayList<String> rankings = item.getRankings();
			for (String i : rankings){
				Logger.getLogger(StAX_Write.class.getName()).log(Level.INFO, "Ranking: {0}", i);
				writer.writeStartElement("Ranking");
				writer.writeCharacters(i);
				writer.writeEndElement();
			}
			writer.writeEndElement();
		} catch (XMLStreamException xse) {
			Logger.getLogger(StAX_Read.class.getName()).log(Level.SEVERE, null, xse);
		}
	}
	
	private String formatXML(String xml) throws TransformerException{
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();

		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");	

		StreamSource source = new StreamSource(new StringReader(xml));
		StringWriter output = new StringWriter();

		transformer.transform(source, new StreamResult(output));
		return output.toString();
	}
}
