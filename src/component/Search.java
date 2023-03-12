/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package component;

import Controller.ClientCtr;
import event.EventClick;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JPopupMenu;
import model.DataSearch;
import swing.PanelSearch;

/**
 *
 * @author user
 */
public class Search extends javax.swing.JPanel {

    private JPopupMenu menu;
    private PanelSearch search;

    public Search() {
        initComponents();
        setOpaque(false);
        setBackground(Color.WHITE);
        menu = new JPopupMenu();
        search = new PanelSearch();
        menu.setBorder(BorderFactory.createLineBorder(new Color(164, 164, 164)));
        menu.add(search);
        menu.setFocusable(false);
        search.addEventClick(new EventClick() {
            @Override
            public void itemClick(DataSearch data) {
                menu.setVisible(false);
                searchText1.setText(data.getText());

                System.out.println("Click Item : " + data.getText());
            }

            @Override
            public void itemRemove(Component com, DataSearch data) {
                search.remove(com);
                removeHistory(data.getText());
                menu.setPopupSize(menu.getWidth(), (search.getItemSize() * 35) + 2);
                if (search.getItemSize() == 0) {
                    menu.setVisible(false);
                }
                System.out.println("Remove Item : " + data.getText());
            }
        });
    }

    public void settext(String text) {
        searchText1.setHinttext(text);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        searchText1 = new swing.SearchText();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-search-25.png"))); // NOI18N

        searchText1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchText1MouseClicked(evt);
            }
        });
        searchText1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchText1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(searchText1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchText1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchText1MouseClicked
        if (search.getItemSize() > 0) {
            menu.show(jLabel1, 0, jLabel1.getHeight());
        }
    }//GEN-LAST:event_searchText1MouseClicked

    private void searchText1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchText1KeyReleased
        String text = searchText1.getText().trim().toLowerCase();
        try {
            search.setData(search(text));
        } catch (IOException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (search.getItemSize() > 0) {
            //  * 2 top and bot border
            menu.show(jLabel1, 0, jLabel1.getHeight());
            menu.setPopupSize(menu.getWidth(), (search.getItemSize() * 35) + 2);
        } else {
            menu.setVisible(false);
        }
    }//GEN-LAST:event_searchText1KeyReleased

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(0, 0, 25, getHeight());
        g2.fillRect(getWidth() - 25, getHeight() - 25, getWidth(), getHeight());
        super.paintComponent(grphcs);
    }

    private List<DataSearch> search(String search) throws IOException, ClassNotFoundException {
        int limitData = 7;
        List<DataSearch> list = new ArrayList<>();        
        ClientCtr ctr = new ClientCtr();
        ctr.Connect();
        ctr.SearchNameProduct("SearchNameProduct", search);
        ArrayList<String> result = ctr.ResultNameProduct();
        Iterator<String> iterator = result.iterator();
        while (iterator.hasNext()) {
            String d = iterator.next();
            if (d.toLowerCase().contains(search)) {
                boolean story = isStory(d);
                if (story) {
                    list.add(0, new DataSearch(d, story));
                    //  add or insert to first record
                } else {
                    list.add(new DataSearch(d, story));
                    //  add to last record
                }
                if (list.size() == limitData) {
                    break;
                }
            }
        }
        
        return list;
    }
    
    ArrayList<String> dataStory = new ArrayList<String>();
    
    private void removeHistory(String text) {
       for (int i = 0; i < dataStory.size(); i++) {
            if (dataStory.get(i).toLowerCase().equals(text.toLowerCase())) {
              dataStory.remove(dataStory.get(i));
            }
        } 
    }

    private boolean isStory(String text) {
        for (int i = 0; i < dataStory.size(); i++) {
            if (dataStory.get(i).toLowerCase().equals(text.toLowerCase())) {
              return true;
            }
        } 
        return false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private swing.SearchText searchText1;
    // End of variables declaration//GEN-END:variables
}
