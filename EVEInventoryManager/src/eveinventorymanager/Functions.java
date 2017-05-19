/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eveinventorymanager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Connor
 */
public class Functions {
    private static Scanner scanner = new Scanner(System.in);
    
    public static String readUrl(String urlStr) {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlStr);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1) {buffer.append(chars, 0, read);}
            reader.close();
            return buffer.toString();
        } catch (Exception ex) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static int itemID(String itemName) {
        try {
            return Integer.parseInt((readUrl("https://www.fuzzwork.co.uk/api/typeid.php?typename="+URLEncoder.encode(itemName,"UTF-8")).split(","))[0].substring(11));
        } catch (UnsupportedEncodingException ex) {
            return -1;
        }
    }
    
    public static Item itemData(String itemName) {
        return itemData(itemID(itemName));
    }
    
    public static Item itemData(int ID) {
        return new Item(null,1,-1,Double.parseDouble(readUrl("http://api.eve-central.com/api/marketstat/json?typeid="+ID).split("[,\\:]")[53]),ID);
    }
    
    public static void save(ItemList accountList,ArrayList alertList) {
        try {
            File file = new File("save.txt");
            file.createNewFile();
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(accountList);
            out.writeObject(alertList);
            out.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static Object[] load() {
        try {
            Object[] data = new Object[2];
            FileInputStream fileIn = new FileInputStream("save.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            data[0] = in.readObject();
            data[1] = in.readObject();
            in.close();
            return data;
        } catch(Exception e) {
            return null;
        }
    }
}
