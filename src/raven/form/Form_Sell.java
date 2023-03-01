/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package raven.form;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import raven.component.ButtonTabComponent;
import raven.swing.TabbedPaneBill;

/**
 *
 * @author user
 */
public class Form_Sell extends javax.swing.JPanel {

    /**
     * Creates new form Form_Sell
     */
    public Form_Sell() {
        initComponents();
        materialTabbled1.setFocusable(false);
        JPanel buttonTab= new ButtonTabComponent(materialTabbled1);
        JPanel tabpanebill = new TabbedPaneBill();
        //JButton addButton= new JButton("+");
        /*addButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int index=materialTabbled1.indexOfComponent(addButton)+2;
                JLabel tabTitleJLabel = new JLabel("Tab "+ index);
                JPanel panelbill= new TabbedPaneBill(); 
                materialTabbled1.remove(index);
                materialTabbled1.insertTab("",null, panelbill, "Tab", index); 
                materialTabbled1.setTabComponentAt(index, tabTitleJLabel);
                materialTabbled1.addTab("",null);
                materialTabbled1.setTabComponentAt(index+1,addButton);
                System.out.printf(""+index);
            }
            
        });*/
        materialTabbled1.insertTab("Hóa đơn 1",null, tabpanebill, "Tab", 0);
        materialTabbled1.addTab("",null);
        materialTabbled1.setTabComponentAt(1,buttonTab);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        materialTabbled1 = new client.MaterialTabbled();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(materialTabbled1, javax.swing.GroupLayout.DEFAULT_SIZE, 1288, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(materialTabbled1, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private client.MaterialTabbled materialTabbled1;
    // End of variables declaration//GEN-END:variables
}
