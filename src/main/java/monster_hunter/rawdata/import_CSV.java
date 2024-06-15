///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package monster_hunter.rawdata;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.HashMap;
//import monster_hunter.Item;
//import monster_hunter.ItemMap;
//import monster_hunter.Util;
///**
// *
// * @author howan
// */
//public class import_CSV {
//    
//    public static void readCSV(File file){
//        String line = "";
//        String delimiter = ",";
//        try{
//            BufferedReader reader = new BufferedReader(new FileReader(file));
//            while ((line = reader.readLine()) != null){
//                ParseLine(line.split(delimiter));
//            }
//            reader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        //System.out.println(file.getPath() + " - " + file.exists());
//    }
//    
//    public static void ParseLine(String[] line){
//        String name = "";
//        int quantity = -1;
//        for(int i = 0; i < line.length; i++){
//            switch(i){
//                case 0:
//                    name = line[i];
//                    break;
//                case 1:
//                    quantity = Integer.parseInt(line[i]);
//                    break;
//            }
//        }
//        //Item item = new Item(name, quantity);
//        HashMap itemMap = ItemMap.getInstance();
//        
//        itemMap.put(name, item);
//        //System.out.println("Name: " + Util.padRight(name, 20) + "Quantity: " + quantity);
//    }
//    
//    
//    
//}
//
//    
