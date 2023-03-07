/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cellofBill;

import java.awt.Color;
import java.awt.Component;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author user
 */
public class TableimageProCellInBillRender extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component= super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
        JLabel jLabel=new JLabel();
        jLabel.setOpaque(true);
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel.setVerticalAlignment(SwingConstants.CENTER);
        if(column ==2){
            ImageIcon imageIcon=new ImageIcon(String.valueOf(value));
            jLabel.setIcon(imageIcon);
        }else{
            jLabel.setText(String.valueOf(value));
        }
        if (isSelected == false && row % 2 == 0) {
            jLabel.setBackground(Color.WHITE);
        } else {
            jLabel.setBackground(component.getBackground());
        }
        return jLabel;
    }
    
}
