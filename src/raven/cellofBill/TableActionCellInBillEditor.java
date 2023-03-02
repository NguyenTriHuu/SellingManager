/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.cellofBill;

import raven.cellofproduct.*;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import raven.event.TableActionEvent;
import raven.event.TableActionInBillEvent;

/**
 *
 * @author user
 */
public class TableActionCellInBillEditor extends DefaultCellEditor {
    private TableActionInBillEvent event;
    public TableActionCellInBillEditor(TableActionInBillEvent event) {
        super(new JCheckBox());
        this.event=event;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        ProductInBillAction productInBillAction =new ProductInBillAction();
        productInBillAction.setBackground(table.getSelectionBackground());
        return productInBillAction;
    }
    
    
}
