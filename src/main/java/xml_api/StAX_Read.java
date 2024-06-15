
package xml_api;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.*;
import javax.xml.stream.events.*;
import monster_hunter.Exceptions.UnhandledElement;
import monster_hunter.Util;
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
	String message;
	
	boolean isDebug = false;
	
	public void Read_Main(File file) {
		try {
			XMLInputFactory factory = XMLInputFactory.newInstance();
			itemMap = ItemMap.getInstance();
			XMLEventReader reader = factory.createXMLEventReader(new FileReader(file));
			
			while (reader.hasNext()){
				XMLEvent eventReader = reader.nextEvent();
				evaluateEvent(eventReader);
			}
		} catch (FileNotFoundException | XMLStreamException ex){
			Logger.getLogger(StAX_Read.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
		}
	}

	private void evaluateEvent(XMLEvent event){
		methodName = "evaluateEvent";
		String elementName = getElementType(event.getEventType());
		try{
		switch(elementName){
			case "START_ELEMENT" -> {
				checkStartElement(event.asStartElement());
			}
			case "END_ELEMENT" -> {
				checkEndElement(event.asEndElement());
			}
			case "PROCESSING_INSTRUCTION" -> {
				Logger.getLogger(StAX_Read.class.getName()).log(Level.INFO, "{0}{1}", 
						new Object[]{Util.padRight("evaluateEvent - PROCESSING_INSTRUCTION: ", 30), event.toString()});
			}
			case "CHARACTERS" -> {
				checkCharacters(event);
			}
			case "COMMENT" -> {
				break;
			}
			case "SPACE" -> {
				Logger.getLogger(StAX_Read.class.getName()).log(Level.INFO, "{0}{1}", 
						new Object[]{Util.padRight("evaluateEvent - SPACE: ", 30), event.toString()});
			}
			case "START_DOCUMENT" -> {
				Logger.getLogger(StAX_Read.class.getName()).log(Level.INFO, "{0}{1}", 
						new Object[]{Util.padRight("evaluateEvent - START_DOCUMENT: ", 30), event.toString()});
			}
			case "END_DOCUMENT" -> {
				Logger.getLogger(StAX_Read.class.getName()).log(Level.INFO, "{0}{1}", 
						new Object[]{Util.padRight("evaluateEvent - END_DOCUMENT: ", 30), event.toString()});
			}
			case "ENTITY_REFERENCE" -> {
				Logger.getLogger(StAX_Read.class.getName()).log(Level.INFO, "{0}{1}", 
						new Object[]{Util.padRight("evaluateEvent - ENTITY_REFERENCE: ", 30), event.toString()});
			}
			case "ATTRIBUTE" -> {
				Logger.getLogger(StAX_Read.class.getName()).log(Level.INFO, "{0}{1}", 
						new Object[]{Util.padRight("evaluateEvent - ATTRIBUTE: ", 30), event.toString()});
			}
			case "DTD" -> {
				Logger.getLogger(StAX_Read.class.getName()).log(Level.INFO, "{0}{1}", 
						new Object[]{Util.padRight("evaluateEvent - DTD: ", 30), event.toString()});
			}
			case "CDATA" -> {
				Logger.getLogger(StAX_Read.class.getName()).log(Level.INFO, "{0}{1}", 
						new Object[]{Util.padRight("evaluateEvent - CDATA: ", 30), event.toString()});
			}
			case "NAMESPACE" -> {
				Logger.getLogger(StAX_Read.class.getName()).log(Level.INFO, "{0}{1}", 
						new Object[]{Util.padRight("evaluateEvent - NAMESPACE: ", 30), event.toString()});
			}
			case "NOTATION_DECLARATION" -> {
				Logger.getLogger(StAX_Read.class.getName()).log(Level.INFO, "{0}{1}", 
						new Object[]{Util.padRight("evaluateEvent - NOTATION_DECLARATION: ", 30), event.toString()});
			}
			case "ENTITY_DECLARATION" -> {
				Logger.getLogger(StAX_Read.class.getName()).log(Level.INFO, "{0}{1}", 
						new Object[]{Util.padRight("evaluateEvent - ENTITY_DECLARATION: ", 30), event.toString()});
			}
			default -> {
				throw new UnhandledElement("Unhandled Element in <" + methodName + ">. Element name <" + elementName + ">");
			}
		}
		} catch (UnhandledElement ue){
			Logger.getLogger(StAX_Read.class.getName()).log(Level.SEVERE, ue.getMessage(), ue);
		}
	}

	private void checkStartElement(StartElement element){
		methodName = "checkStartElement";
		String elementName = element.getName().getLocalPart();
		try{
		switch (elementName){
			case "Items" -> {
				if (isDebug) {
					Logger.getLogger(StAX_Read.class.getName()).log(Level.INFO, "{0}{1}", 
							new Object[]{Util.padRight("checkStartElement: ", 30), "Items"});
				}
			}
			case "Item" -> {
				if (isDebug) {
					Logger.getLogger(StAX_Read.class.getName()).log(Level.INFO, "{0}{1}", 
							new Object[]{Util.padRight("checkStartElement: ", 30), "Item"});
				}
				items = new Item();
				checkAttributes(element.getAttributes());
			}
			case "Rankings" -> {
				if (isDebug) {
					Logger.getLogger(StAX_Read.class.getName()).log(Level.INFO, "{0}{1}", 
							new Object[]{Util.padRight("checkStartElement: ", 30), "Rankings"});
				}
			}
			case "Ranking" -> {
				if (isDebug) {
					Logger.getLogger(StAX_Read.class.getName()).log(Level.INFO, "{0}{1}", 
							new Object[]{Util.padRight("checkStartElement: ", 30), "Ranking"});
				}
				isRanking = true;
			}
			default -> {
				throw new UnhandledElement("Unhandled Element in <" + methodName + ">. Element name <" + elementName + ">");
			}
		}
		} catch (UnhandledElement ue){
			Logger.getLogger(StAX_Read.class.getName()).log(Level.SEVERE, ue.getMessage(), ue);
		}
	}
	
	private void checkEndElement(EndElement element){
		methodName = "checkEndElement";
		String elementName = element.getName().getLocalPart();
		try{
		switch (elementName){
			case "Items" -> {
				if (isDebug) {
					Logger.getLogger(StAX_Read.class.getName()).log(Level.INFO, "{0}/{1}",
							new Object[]{Util.padRight("checkEndElement: ", 30), "Items"});
				};
			}
			case "Item" -> {
				if (isDebug) {
					Logger.getLogger(StAX_Read.class.getName()).log(Level.INFO, "{0}/{1}",
							new Object[]{Util.padRight("checkEndElement: ", 30), "Item"});
				};
				itemMap.put(items.getName(), items);
			}
			case "Rankings" -> {
				if (isDebug) {
					Logger.getLogger(StAX_Read.class.getName()).log(Level.INFO, "{0}/{1}",
							new Object[]{Util.padRight("checkEndElement: ", 30), "Rankings"});
				};
			}
			case "Ranking" -> {
				if (isDebug) {
					Logger.getLogger(StAX_Read.class.getName()).log(Level.INFO, "{0}/{1}",
							new Object[]{Util.padRight("checkEndElement: ", 30), "Ranking"});
				};

			}
			default -> {
				throw new UnhandledElement("Unhandled Element in <" + methodName + ">. Element name <" + elementName + ">");
			}
		}
		} catch (UnhandledElement ue){
			Logger.getLogger(StAX_Read.class.getName()).log(Level.SEVERE, ue.getMessage(), ue);
		}
	}
	
	private void checkCharacters(XMLEvent event){
		methodName = "checkText";
		String charName = event.toString();
		try{
		switch (charName){
			case "Low", "High", "Master" -> {
				if (isRanking){
					if (isDebug) {
						Logger.getLogger(StAX_Read.class.getName()).log(Level.INFO, "{0}{1}", 
								new Object[]{Util.padRight("checkText: ", 30), event.toString()});
					};
					if (!items.hasRanking(charName)){
						items.setRankings(charName);
					}
				}
				isRanking = false;
			}
			default -> {
				if (charName.contains("\n")){
					break;
				}
				throw new UnhandledElement("Unhandled Element in <" + methodName + ">. Element name <" + charName + ">");
			}
		}
		} catch (UnhandledElement ue){
			Logger.getLogger(StAX_Read.class.getName()).log(Level.SEVERE, ue.getMessage(), ue);
		}
	}

	private void checkAttributes(Iterator<Attribute> attributes){
		methodName = "checkAttributes";
		try {
		while (attributes.hasNext()){
			Attribute attr = attributes.next();
			String att = attr.getName().getLocalPart();
			switch (att){
				case "id" -> {
					if (isDebug) { 
						Logger.getLogger(StAX_Read.class.getName()).log(Level.INFO, "{0}{1}", 
								new Object[]{Util.padRight(methodName + ": ", 30), attr.getValue()});
					}
					items.setID(Integer.parseInt(attr.getValue()));
				}
				case "name" -> {
					if (isDebug) { 
						Logger.getLogger(StAX_Read.class.getName()).log(Level.INFO, "{0}{1}", 
								new Object[]{Util.padRight(methodName + ": ", 30), attr.getValue()});
					}
					items.setName(attr.getValue());
				}
				case "quantity" -> {
					if (isDebug) { 
						Logger.getLogger(StAX_Read.class.getName()).log(Level.INFO, "{0}{1}", 
								new Object[]{Util.padRight(methodName + ": ", 30), attr.getValue()});
					}
					items.setQuantity(Integer.parseInt(attr.getValue()));
				}
				default -> {
					throw new UnhandledElement("Unhandled Element in <" + methodName + ">. Element name <" + att + ">");
				}
			}
		}
		}catch (UnhandledElement ue){
			Logger.getLogger(StAX_Read.class.getName()).log(Level.SEVERE, ue.getMessage(), ue);
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
