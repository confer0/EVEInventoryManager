/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eveinventorymanager;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author 334226180
 */
public class BuyFrame extends javax.swing.JFrame {
    
    AccountFrame parent;
    
    /**
     * Creates new form BuyFrame
     * @param parent
     */
    public BuyFrame(AccountFrame parent) {
        initComponents();
        this.parent = parent;
        this.setIconImage(parent.getIconImage());
        setCloseOperation();
        itemComboBox.setModel(new DefaultComboBoxModel(parent.accountList.toNameArray()));
    }
    
    //If you close with the X, it re-enables the parent.
    public void setCloseOperation() {
        WindowListener exitListener = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                parent.setEnabled(true);
            }
        };
        this.addWindowListener(exitListener);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        itemLabel = new javax.swing.JLabel();
        itemComboBox = new javax.swing.JComboBox<>();
        quantityLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        quantitySpinner = new javax.swing.JSpinner();
        priceSpinner = new javax.swing.JSpinner();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        badNameLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        itemLabel.setText("Item");

        itemComboBox.setEditable(true);
        itemComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        itemComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemComboBoxActionPerformed(evt);
            }
        });

        quantityLabel.setText("Quantity");

        priceLabel.setText("Unit Price");

        quantitySpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 10));

        priceSpinner.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 10.0d));

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        badNameLabel.setForeground(new java.awt.Color(255, 0, 0));
        badNameLabel.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(itemLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(itemComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(quantityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(quantitySpinner))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(priceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(priceSpinner))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(badNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(itemLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(itemComboBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantityLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(quantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(priceSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(badNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //Updates accountList contents
    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        String name = (String)itemComboBox.getSelectedItem();
        int quantity = (int)quantitySpinner.getValue();
        double price = (double)priceSpinner.getValue();
        int ID = Functions.itemID(name);
        if(ID!=0) {
            Item item = parent.accountList.getItem(ID);
            if(item==null) {
                item = new Item(name,quantity,-1,price,ID);
                parent.accountList.addNewItem(item);
            } else {
                item.add(quantity, price);
            }
            parent.listsModified = true;
            parent.refreshTable();
        } else {
            System.out.println("Ya done messed up");
        }
        cancelButtonActionPerformed(evt);
    }//GEN-LAST:event_okButtonActionPerformed
    
    //Closes the frame.
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        parent.setEnabled(true);
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed
    
    //Used to detect whether item name is valid.
    private void itemComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemComboBoxActionPerformed
        if(Functions.itemID((String)itemComboBox.getSelectedItem())==0) {
            badNameLabel.setText("ITEM NAME NOT RECOGNIZED");
        } else {
            badNameLabel.setText(" ");
        }
    }//GEN-LAST:event_itemComboBoxActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BuyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuyFrame(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel badNameLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox<String> itemComboBox;
    private javax.swing.JLabel itemLabel;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JSpinner priceSpinner;
    private javax.swing.JLabel quantityLabel;
    private javax.swing.JSpinner quantitySpinner;
    // End of variables declaration//GEN-END:variables
}
