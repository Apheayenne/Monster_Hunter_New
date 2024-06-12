/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monster_hunter;

import java.io.File;
import java.io.IOException;
import monster_hunter.rawdata.import_CSV;

/**
 *
 * @author howan
 */
public class fileHandler {
    private String basePath = new File("").getAbsolutePath().concat("\\src\\main\\java\\monster_hunter");
    private String XMLItems = "\\rawdata\\items.xml";
    private String CSVItems = "\\rawdata\\items.csv";
    
    public void loadFiles(){
        File itemXML = new File(basePath + XMLItems);        
        
        if (!itemXML.exists()){
            File itemCSV = new File(basePath + CSVItems);
            import_CSV.readCSV(itemCSV);
            try{
                itemXML.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }else{
            readXML();
        }
    }
    
    public void readXML(){
        
    }
    
    public void writeXML(){
        
    }
}


