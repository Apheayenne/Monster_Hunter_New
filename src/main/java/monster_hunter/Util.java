/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monster_hunter;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author howan
 */
public class Util {

	public static String padRight(String text, int totalLength){
		int length = text.length();
		int diff = totalLength-length;
		String padding = "";
		
		if (diff < 0){ 
			return text + " "; 
		};
		
		for (int i = diff+1; i > 0; i--){
			padding = padding.concat(" ");
		}
		
		return text.concat(padding);
	}
	
	public static void print(Object text){
		System.out.println(text);
	}
}
