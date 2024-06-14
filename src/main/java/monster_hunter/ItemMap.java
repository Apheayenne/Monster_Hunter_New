/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monster_hunter;

import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author howan
 */
public class ItemMap extends HashMap<String, Item> {
	private static HashMap<String, Item> itemMap;

	
	private ItemMap() { }
	
	
	public static HashMap<String, Item> getInstance(){
		if (itemMap == null){
			itemMap = new HashMap<String, Item>();
		}
		return itemMap;
	}
}
