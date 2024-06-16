
package monster_hunter;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import monster_hunter.Exceptions.DuplicateRanking;
import monster_hunter.Item.Ranking;

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
		Iterator iter = itemSet.iterator();
		
		Item potion = (Item)map.get("Potion");
		potion.setQuantityDiff(5, false);
		
		Util.print(Item.getRanking("Low"));
		Util.print(Item.getRanking("High"));
		Util.print(Item.getRanking("Master"));

		
		try{
			Item antidote = (Item)map.get("Antidote");
			antidote.setRankings(Ranking.HIGH);
		} catch (DuplicateRanking dr){
			Logger.getLogger(fileHandler.class.getName()).log(Level.SEVERE, dr.getMessage(), dr);

		}
		
		
		
		
		while (iter.hasNext()){
			String value = (String)iter.next();
			Item items = (Item)map.get(value);
			System.out.println(items.toString());
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
