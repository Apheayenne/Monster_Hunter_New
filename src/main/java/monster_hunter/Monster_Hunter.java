/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package monster_hunter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import monster_hunter.fileHandler;

/**
 *
 * @author howan
 */
public class Monster_Hunter {
    
    private static fileHandler handle;
    
    public static void main(String[] args) {
        handle = new fileHandler();
        handle.loadFiles();
        
        HashMap map = ItemMap.getInstance();
        Item item = (Item)map.get("Potion");
        item.setQuantityDiff(5, false);
        
        Set itemSet = map.keySet();
        
        Iterator iter = itemSet.iterator();
        while (iter.hasNext()){
            String value = (String)iter.next();
            Item items = (Item)map.get(value);
            System.out.println(items.toString());
        }
        
        handle.writeXML();
    }
    
}
