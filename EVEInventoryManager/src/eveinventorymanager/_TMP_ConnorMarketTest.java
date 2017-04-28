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
public class _TMP_ConnorMarketTest {
    public static void main(String[] args) {
        Functions func = new Functions();
        System.out.print("Desired Item: ");
        String itemName = func.uIn();
        System.out.println(func.itemID(itemName));
        System.out.println(func.itemData(func.itemID(itemName)));
    }
}
