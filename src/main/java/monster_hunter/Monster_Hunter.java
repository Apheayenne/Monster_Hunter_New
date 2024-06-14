/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package monster_hunter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import javax.xml.stream.XMLStreamException;
import monster_hunter.fileHandler;

/**
 *
 * @author howan
 */
public class Monster_Hunter {
	
	private static fileHandler handle;
	
	public static void main(String[] args) throws XMLStreamException, IOException {
		handle = new fileHandler();
		Util.print("Loading Files");
		handle.loadFiles();
		Util.print("Loading Complete");

		
		HashMap map = ItemMap.getInstance();
		
		Set itemSet = map.keySet();
		Iterator iter = itemSet.iterator();
		while (iter.hasNext()){
			String value = (String)iter.next();
			Item items = (Item)map.get(value);
			System.out.println(items.toString());
		
		Item item = (Item)map.get("Potion");
		item.setQuantityDiff(5, false);
		

		
		
		}
		
		//handle.writeXML();
	}
}
