/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eveinventorymanager;

/**
 *
 * @author Connor
 */
public class EVEInventoryManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	System.out.println("Sean was here");
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccountFrame().setVisible(true);
            }
        });
    }
    
}
