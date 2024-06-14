/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xml_api;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import javax.xml.namespace.QName;
import monster_hunter.Util;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import monster_hunter.Item;
import monster_hunter.ItemMap;

/**
 *
 * @author howan
 */
public class StAX_Read {
	private String methodName = "";
	HashMap itemMap;
	private Item items;
	boolean isRanking = false;
	
	public void Read_Main(File file) throws FileNotFoundException, XMLStreamException{
		XMLInputFactory factory = XMLInputFactory.newInstance();
		itemMap = ItemMap.getInstance();
		XMLEventReader reader = factory.createXMLEventReader(new FileReader(file));
		
		while (reader.hasNext()){
			XMLEvent eventReader = reader.nextEvent();
			evaluateEvent(eventReader);
		}
	}

	private void evaluateEvent(XMLEvent event){
		methodName = "evaluateEvent";
		String elementName = getElementType(event.getEventType());
		switch(elementName){
			case "START_ELEMENT" -> {
				checkStartElement(event.asStartElement());
			}
			case "END_ELEMENT" -> {
				checkEndElement(event.asEndElement());
			}
			case "PROCESSING_INSTRUCTION" -> {
				Util.print(Util.padRight(methodName + " - " + elementName + ": ", 30) + event.toString());
			}
			case "CHARACTERS" -> {
				String newLine = "\n";
				if (event.toString().contains(newLine)){
					break;
				}
				checkCharacters(event);
			}
			case "COMMENT" -> {
				break;
			}
			case "SPACE" -> {
				Util.print(Util.padRight(methodName + " - " + elementName + ": ", 30) + event.toString());
			}
			case "START_DOCUMENT" -> {
				Util.print(Util.padRight(methodName + " - " + elementName, 30) + event.toString());
			}
			case "END_DOCUMENT" -> {
				Util.print(Util.padRight(methodName + " - " + elementName + ": ", 30) + event.toString());
			}
			case "ENTITY_REFERENCE" -> {
				Util.print(Util.padRight(methodName + " - " + elementName + ": ", 30) + event.toString());
			}
			case "ATTRIBUTE" -> {
				Util.print(Util.padRight(methodName + " - " + elementName + ": ", 30) + event.toString());
			}
			case "DTD" -> {
				Util.print(Util.padRight(methodName + " - " + elementName + ": ", 30) + event.toString());
			}
			case "CDATA" -> {
				Util.print(Util.padRight(methodName + " - " + elementName + ": ", 30) + event.toString());
			}
			case "NAMESPACE" -> {
				Util.print(Util.padRight(methodName + " - " + elementName + ": ", 30) + event.toString());
			}
			case "NOTATION_DECLARATION" -> {
				Util.print(Util.padRight(methodName + " - " + elementName + ": ", 30) + event.toString());
			}
			case "ENTITY_DECLARATION" -> {
				Util.print(Util.padRight(methodName + " - " + elementName + ": ", 30) + event.toString());
			}
		}
	}

	private void checkStartElement(StartElement element){
		methodName = "checkStartElement";
		String elementName = element.getName().getLocalPart();
		switch (elementName){
			case "Items" -> {
				Util.print(Util.padRight(methodName + ": ", 30) + elementName);
			}
			case "Item" -> {
				Util.print(Util.padRight("\t" + methodName + ": ", 30) + elementName);
				items = new Item();
				checkAttributes(element.getAttributes());
			}
			case "Rankings" -> {
				Util.print(Util.padRight("\t" + methodName + ": ", 30) + elementName);
			}
			case "Ranking" -> {
				Util.print(Util.padRight("\t\t" + methodName + ": ", 30) + elementName);
				isRanking = true;
			}
			default -> {
				break;
			}
		}
	}
	
	private void checkEndElement(EndElement element){
		methodName = "checkEndElement";
		String elementName = element.getName().getLocalPart();
		switch (elementName){
			case "Items" -> {
				Util.print(Util.padRight(methodName + ": ", 30) + "/" + elementName);
			}
			case "Item" -> {
				Util.print(Util.padRight("\t" + methodName + ": ", 30) + "/" + elementName);
				itemMap.put(items.getName(), items);
			}
			case "Rankings" -> {
				Util.print(Util.padRight("\t" + methodName + ": ", 30) + "/" + elementName);
			}
			case "Ranking" -> {
				Util.print(Util.padRight("\t\t" + methodName + ": ", 30) + "/" + elementName);

			}
			default -> {
				break;
			}
		}
	}
	
	private void checkCharacters(XMLEvent event){
		methodName = "checkText";
		String charName = event.toString();
		switch (charName){
			case "Low", "High", "Master" -> {
				if (isRanking){
					Util.print(Util.padRight("\t\t\t" + methodName + ": ", 30) + event.toString());
					if (!items.hasRanking(charName)){
						items.setRankings(charName);
					}
				}
				isRanking = false;
			}

			default -> {
				break;
			}
		}
	}

	private void checkAttributes(Iterator<Attribute> attributes){
		methodName = "checkAttributes";
		while (attributes.hasNext()){
			Attribute attr = attributes.next();
			
			Util.print(Util.padRight("\t\t" + methodName + ": ", 30) + attr.toString());
			
			switch (attr.getName().getLocalPart()){
				case "name" -> {
					items.setName(attr.getValue());
				}
				case "quantity" -> {
					items.setQuantity(Integer.valueOf(attr.getValue()));
				}
				default -> {
					break;
				}
			}
		}
	}
	
		private String getElementType(int elementID){
		return switch (elementID){
            case 1 ->   "START_ELEMENT";
            case 2 ->   "END_ELEMENT";
            case 3 ->   "PROCESSING_INSTRUCTION";
            case 4 ->   "CHARACTERS";
            case 5 ->   "COMMENT";
            case 6 ->   "SPACE";
            case 7 ->   "START_DOCUMENT";
            case 8 ->   "END_DOCUMENT";
            case 9 ->   "ENTITY_REFERENCE";
            case 10 ->  "ATTRIBUTE";
            case 11 ->  "DTD";
            case 12 ->  "CDATA";
            case 13 ->  "NAMESPACE";
            case 14 ->  "NOTATION_DECLARATION";
            case 15 ->  "ENTITY_DECLARATION";
			default ->  "";
		};
	}
}
