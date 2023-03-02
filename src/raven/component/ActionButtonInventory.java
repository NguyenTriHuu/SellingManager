/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package raven.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import raven.event.ButtonActionInventoryEvent;

/**
 *
 * @author user
 */
public class ActionButtonInventory extends javax.swing.JPanel {

    /**
     * Creates new form ActionButtonInventory
     */
    public ActionButtonInventory() {
        initComponents();
    }

   public void setEvent(ButtonActionInventoryEvent event){
       cmdCancel.addActionListener(new  ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               event.onCancel();
           }
       });
       cmdPrint.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               event.onPrint();
           }
       });
       cmdSave.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               event.onSave();
           }
       });
       
       
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdCancel = new javax.swing.JButton();
        cmdSave = new javax.swing.JButton();
        cmdPrint = new javax.swing.JButton();

        cmdCancel.setText("Hủy");
        cmdCancel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cmdSave.setBackground(new java.awt.Color(0, 204, 0));
        cmdSave.setForeground(new java.awt.Color(255, 255, 255));
        cmdSave.setText("Lưu");
        cmdSave.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cmdPrint.setBackground(new java.awt.Color(0, 204, 0));
        cmdPrint.setForeground(new java.awt.Color(255, 255, 255));
        cmdPrint.setText("In mã vạch");
        cmdPrint.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmdCancel, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(cmdSave, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(cmdPrint, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdCancel)
                    .addComponent(cmdSave)
                    .addComponent(cmdPrint))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdCancel;
    private javax.swing.JButton cmdPrint;
    private javax.swing.JButton cmdSave;
    // End of variables declaration//GEN-END:variables
}
