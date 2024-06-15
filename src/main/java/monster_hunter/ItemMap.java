/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monster_hunter;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 *
 * @author howan
 */
public class ItemMap extends HashMap<String, Item> {
	private static LinkedHashMap<String, Item> itemMap;

	public static LinkedHashMap<String, Item> getInstance(){
		if (itemMap == null){
			itemMap = new LinkedHashMap<>();
		}
		return itemMap;
	}
}
