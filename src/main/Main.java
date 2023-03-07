package main;

import java.awt.Button;
import java.awt.Color;
import java.awt.Scrollbar;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.table.DefaultTableModel;
import cell.TableActionCellEditor;
import cell.TableActionCellRender;
import event.TableActionEvent;
import cell.TableAvatarCellRender;
import cellofproduct.TableActionCellProEditor;
import cellofproduct.TableActionCellProRender;
import cellofproduct.TableimageProCellRender;
import event.EventMenuSelected;
import form.Form_InventoryManagement;
import form.Form_PersonnelManagement;
import form.Form_ProductsManagement;
import form.Form_Sell;
import form.Form_RevenueReport;

public class Main extends javax.swing.JFrame {

    private Form_Sell form_Sell;
    private Form_PersonnelManagement form_PersonnelManagement;
    private Form_ProductsManagement form_ProductsManagement;
    private Form_InventoryManagement form_InventoryManagement;
    private Form_RevenueReport form_RevenueReport;
    public Main() {
        initComponents();
        getContentPane().setBackground(Color.white);
        setExtendedState(MAXIMIZED_BOTH);
        form_Sell = new Form_Sell();
        form_PersonnelManagement = new Form_PersonnelManagement();
        form_ProductsManagement = new Form_ProductsManagement();
        form_InventoryManagement =new Form_InventoryManagement();
        form_RevenueReport = new Form_RevenueReport();
        
        setForm(form_PersonnelManagement);
        menu.addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                if (index == 0) {
                    setForm(form_PersonnelManagement);
                    System.out.println("0");
                } else if (index == 1) {
                    setForm(form_ProductsManagement);
                    System.out.println("1");
                } else if (index == 2) {
                    setForm(form_InventoryManagement);
                    System.out.println("2");
                } else if (index == 3) {
                    setForm(form_Sell);
                    System.out.println("3");
                } else if (index == 4) {
                    setForm(form_RevenueReport);
                    System.out.println("4");
                }
            }

        });

    }

    private void setForm(JComponent com) {
        MainPanel.removeAll();
        MainPanel.add(com);
        MainPanel.revalidate();
        MainPanel.repaint();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        menu = new component.Menu();
        MainPanel = new javax.swing.JPanel();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        menu.setOpaque(true);

        MainPanel.setOpaque(false);
        MainPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainPanel;
    private javax.swing.JLabel jLabel4;
    private component.Menu menu;
    // End of variables declaration//GEN-END:variables
}
