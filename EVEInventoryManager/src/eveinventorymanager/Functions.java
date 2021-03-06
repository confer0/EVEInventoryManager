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
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 *
 * @author Connor
 */
public class Functions {
    //This is the bit that tells it to trust anyhting
    static TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {return null;}
        public void checkClientTrusted(X509Certificate[] certs, String authType) {}
        public void checkServerTrusted(X509Certificate[] certs, String authType) {}
    }};
    
    public static String readUrl(String urlStr) {
        BufferedReader reader = null;
        try {
            //This is the bit that implements the thing that makes it trust anything.
            final SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            
            URL url = new URL(urlStr);
            URLConnection con = url.openConnection();
            reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1) {buffer.append(chars, 0, read);}
            reader.close();
            return buffer.toString();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Error:\nCould not connect to server.\nPlease check your internet connection.","Connection Error", 0);
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
    
    public static String itemName(int ID) {
        return (readUrl("https://www.fuzzwork.co.uk/api/typeid.php?typeid="+ID).split("\""))[5];
    }
    
    public static Item itemData(String itemName) {
        return itemData(itemID(itemName));
    }
    
    public static Item itemData(int ID) {
        return new Item(null,1,Double.parseDouble(readUrl("http://api.eve-central.com/api/marketstat/json?typeid="+ID).split("[,\\:]")[53]),ID);
    }
    
    public static String itemDescription(int ID) {
        String[] s = Functions.readUrl("https://esi.tech.ccp.is/latest/universe/types/"+ID).split("\"");
        for(int i=0;i<s.length;i++) {
            if(s[i].equals("description")) {
                String st = s[i+2];
                st = st.replaceAll("\\\\n", "\n");
                st = st.replaceAll("\\\\r", "\r");
                st = st.replaceAll("(<[^>]*>)", "");//Witchcract that detects and removes "<stuff>"
                return st;
            }
        }
        return "Error finding description.";
    }
    
    public static void save(AccountFrame frame) {
        if(frame.mostRecentFile!=null) {
            try {
                String fileName = frame.mostRecentFile;
                File file = new File(fileName);
                file.createNewFile();
                FileOutputStream fileOut = new FileOutputStream(file);
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(frame.accountList);
                out.writeObject(frame.alertList);
                out.writeObject(frame.alertInterval);
                frame.listsModified=false;
                frame.mostRecentFile = fileName;
                out.close();
            } catch (Exception e) {}
        } else {
            saveAs(frame);
        }
    }
    
    public static void saveAs(AccountFrame frame) {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogType(JFileChooser.SAVE_DIALOG);
        if(frame.mostRecentFile!=null) {chooser.setSelectedFile(new File(frame.mostRecentFile));}
        else {chooser.setSelectedFile(new File("inventory.eim"));}
        chooser.setFileFilter(new FileNameExtensionFilter("Eve Inventory Manager File (*.eim)","eim"));
        if(chooser.showSaveDialog(null)==JFileChooser.APPROVE_OPTION) {
            try {
                String fileName = chooser.getSelectedFile().toString();
                if (!fileName .endsWith(".eim")) {fileName += ".eim";}
                File file = new File(fileName);
                file.createNewFile();
                FileOutputStream fileOut = new FileOutputStream(file);
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(frame.accountList);
                out.writeObject(frame.alertList);
                out.writeObject(frame.alertInterval);
                frame.listsModified=false;
                frame.mostRecentFile = fileName;
                out.close();
            } catch (Exception e) {}
        }
    }
    
    public static void load(AccountFrame frame) {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogType(JFileChooser.OPEN_DIALOG);
        chooser.setSelectedFile(new File("inventory.eim"));
        chooser.setFileFilter(new FileNameExtensionFilter("Eve Inventory Manager File (*.eim)","eim"));
        if(chooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
            try {
                Object[] data = new Object[2];
                String fileName = chooser.getSelectedFile().toString();
                FileInputStream fileIn = new FileInputStream(fileName);
                ObjectInputStream in = new ObjectInputStream(fileIn);
                frame.accountList = (ItemList)in.readObject();
                frame.alertList = (ArrayList)in.readObject();
                frame.alertInterval = (long)in.readObject();
                frame.listsModified = false;
                frame.mostRecentFile = fileName;
                in.close();
            } catch(Exception e) {}
        }
    }
    
    public static String marketInfo(Item item) {
        double owned = item.getPrice();
        double market = Math.round(itemData(item.getID()).getPrice()*100.0)/100.0;
        double diff = Math.round(10000.0-(10000.0*owned/market))/100.0;
        String r = "Per Owned:\t"+owned;
        r+="\nPer Market:\t"+market;
        r+="\nMarkup:\t"+diff+"%";
        r+="\nAssessment:\t";
        if(diff==0.0) {
            r+="No Difference";
        } else if(diff<0.0) {
            r+="Unprofitable Sale";
        } else {
            r+="Profitable Sale";
        }
        return r;
    }
}
