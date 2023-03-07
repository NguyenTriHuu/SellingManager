/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cellofproduct;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import event.TableActionEvent;
import event.TableActionProductEvent;

/**
 *
 * @author user
 */
public class TableActionCellProEditor extends DefaultCellEditor {
    private TableActionProductEvent event;
    public TableActionCellProEditor(TableActionProductEvent event) {
        super(new JCheckBox());
        this.event=event;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        ProductAction productAction =new ProductAction();
        productAction.setBackground(table.getSelectionBackground());
        return productAction;
    }
    
    
}
