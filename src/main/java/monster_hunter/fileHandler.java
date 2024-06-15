/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monster_hunter;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import monster_hunter.Exceptions.FileIsEmpty;
import xml_api.StAX_Read;
import xml_api.StAX_Write;

/**
 *
 * @author howan
 */
public class fileHandler {

	private final String basePath = new File("").getAbsolutePath().concat("\\src\\main\\java\\monster_hunter");
	private final String XMLItems = "\\rawdata\\Items_Test.xml";
	//private String master_Items = "\\rawdata\\Items_master.xml";
	
	public void loadFiles() {
		File itemXML = new File(basePath + XMLItems);
		//File masterXML = new File(basePath + master_Items);
		
		try {
			if (!itemXML.exists()){
				itemXML.createNewFile();
			}else{
				if (itemXML.length() != 0){
					readXML(itemXML);
				}else throw new FileIsEmpty("File <" + itemXML + "> is empty.");
			}
		} catch (IOException | FileIsEmpty ex) {
			Logger.getLogger(fileHandler.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
		}
	}
	
	public void readXML(File file) {
		StAX_Read read = new StAX_Read();
		read.Read_Main(file);
		
	}
	
	public void writeXML(){
		StAX_Write write = new StAX_Write();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		write.Write_Main(out, new File(basePath + XMLItems));

	}
}


