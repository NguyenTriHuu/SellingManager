/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cellofBill;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author user
 */
public class TableActionCellProInBillRender extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        ProductInBillAction productInBillAction=new ProductInBillAction();
        if(isSelected ==false && row %2 ==0){
            productInBillAction.setBackground(Color.WHITE);
        }else{
            productInBillAction.setBackground(component.getBackground());
        }
        return productInBillAction;
    }
    
}
