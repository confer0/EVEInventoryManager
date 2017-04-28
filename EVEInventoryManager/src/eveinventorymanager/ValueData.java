/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.eveinventorymanager;

/**
 *
 * @author Connor
 */
public class ValueData {
   double wavgBuy;
   double avgBuy;
   double medianBuy;
   double fivePercentBuy;
   
   double wavgSell;
   double avgSell;
   double medianSell;
   double fivePercentSell;
   
   public ValueData(String[] marketRaw) {
       wavgBuy = Double.parseDouble(marketRaw[53]);
       avgBuy = Double.parseDouble(marketRaw[55]);
       medianBuy = Double.parseDouble(marketRaw[61]);
       fivePercentBuy = Double.parseDouble(marketRaw[63]);
       
       wavgSell = Double.parseDouble(marketRaw[89]);
       avgSell = Double.parseDouble(marketRaw[91]);
       medianSell = Double.parseDouble(marketRaw[97]);
       fivePercentSell = Double.parseDouble(marketRaw[99]);
   }
   
   @Override
   public String toString() {
       return wavgBuy+"/"+wavgSell;
   }
}
