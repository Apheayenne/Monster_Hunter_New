
package monster_hunter;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 *
 * @author howan
 */
public class Monster_Hunter {
	
	public static void main(String[] args) {
		long start, end, read_execution, write_execution;
		fileHandler handle = new fileHandler();
    
//  Reading from File
		Util.print("Loading Files");
		start = System.nanoTime();
		handle.loadFiles();
		end = System.nanoTime();
		read_execution = (end - start) / 1000000;
		System.out.printf("Loading Complete: Loading Files took <%d> Milliseconds\n\n", read_execution);
    
//  Changing the Items
		LinkedHashMap map = ItemMap.getInstance();
		
		Set itemSet = map.keySet();
		Item item;
		Iterator iter = itemSet.iterator();
		
		item = (Item)map.get("Potion");
		item.setQuantityDiff(5, false);
		while (iter.hasNext()){
			String value = (String)iter.next();
			Item items = (Item)map.get(value);
			//System.out.println(items.toString());
		}
    
//  Writing to File
		Util.print("Writing to File");
		start = System.nanoTime();
		handle.writeXML();
		end = System.nanoTime();
		write_execution = (end - start) / 1000000;
		System.out.printf("Loading Complete: Loading Files took <%d> Milliseconds\n", read_execution);
		System.out.printf("Writing Complete: Writing Files took <%d> Milliseconds\n", write_execution);
	}
}
