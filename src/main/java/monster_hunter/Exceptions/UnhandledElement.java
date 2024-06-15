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
public class UnhandledElement extends Exception{

	//public UnhandledElement(String message){
        //super(message);
    //}
	
	public UnhandledElement(String e){
		//System.out.println("Unhandled Element in <" + method + ">. Element name <" + element + ">" );
		Util.print(e);
	}

}
