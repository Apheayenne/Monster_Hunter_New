/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monster_hunter.Exceptions;

import monster_hunter.Util;

/**
 *
 * @author howan
 */
public class FileIsEmpty extends Exception {
	public FileIsEmpty(String message){
		Util.print(message);
	}
}
