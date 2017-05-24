/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eveinventorymanager;

import java.util.Scanner;

/**
 *
 * @author Connor
 */
public class _TMP_ConnorMarketTest {
    public static void main(String[] args) {
        System.out.print("Desired Item: ");
        Scanner in = new Scanner(System.in);
        String itemName = in.next();
        System.out.println(func.itemID(itemName));
        System.out.println(func.itemData(func.itemID(itemName)));
    }
}
