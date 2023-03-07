/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cell;

import java.awt.Color;
import java.awt.Component;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author user
 */
public class TableAvatarCellRender extends DefaultTableCellRenderer {


    public TableAvatarCellRender() {
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        JLabel cell = new JLabel();
        cell.setHorizontalAlignment(SwingConstants.CENTER);
        cell.setVerticalAlignment(SwingConstants.CENTER);
        cell.setOpaque(true);
        if (column == 2) {
            ImageIcon avatarIcon = new ImageIcon(String.valueOf(value));
            cell.setIcon(avatarIcon);
        } else {
            cell.setText(value.toString());
        }
        if (isSelected == false && row % 2 == 0) {
            cell.setBackground(Color.WHITE);
        } else {
            cell.setBackground(com.getBackground());
        }
        return cell;
    }

}
