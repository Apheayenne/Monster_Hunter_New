/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monster_hunter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.stream.XMLStreamException;

import monster_hunter.rawdata.import_CSV;
import xml_api.StAX_Read;

/**
 *
 * @author howan
 */
public class fileHandler {
	private String basePath = new File("").getAbsolutePath().concat("\\src\\main\\java\\monster_hunter");
	private String XMLItems = "\\rawdata\\Items_Test.xml";
	private String CSVItems = "\\rawdata\\items.csv";
	
	public void loadFiles() throws XMLStreamException, FileNotFoundException, IOException{
		File itemXML = new File(basePath + XMLItems);		
		
		if (!itemXML.exists()){
			File itemCSV = new File(basePath + CSVItems);
			import_CSV.readCSV(itemCSV);
			
			itemXML.createNewFile();
		}else{
			readXML(itemXML);
		}
	}
	
	public void readXML(File file) throws XMLStreamException, FileNotFoundException{
		StAX_Read read = new StAX_Read();
		read.Read_Main(file);
		
	}
	
	public void writeXML(File file){
		
	}
}


