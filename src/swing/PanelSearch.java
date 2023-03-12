/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package swing;

import event.EventClick;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import model.DataSearch;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author user
 */
public class PanelSearch extends javax.swing.JPanel {

     private EventClick event;

    public void addEventClick(EventClick event) {
        this.event = event;
    }
    public PanelSearch() {
        initComponents();
        setLayout(new MigLayout("fillx", "0[]0", "0[]0"));
    }
    
   public void setData(List<DataSearch> data) {
        this.removeAll();
        for (DataSearch d : data) {
            Search_items item = new Search_items(d);
            //  add event
            item.addEvent(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    //  when click
                    event.itemClick(d);
                }
            }, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    //  when remove
                    event.itemRemove(item, d);

                }
            });
            this.add(item, "wrap");
            //  wrap mean add to new row after this add
            //  this for miglayout option
        }
        repaint();
        revalidate();
        //  Refresh Component
    }

    public int getItemSize() {
        return getComponentCount();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
