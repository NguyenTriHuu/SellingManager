/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package swing;

import java.awt.BorderLayout;
import javax.swing.JButton;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author htson
 */
public class Jchart extends javax.swing.JPanel {

    /**
     * Creates new form Jchart
     */
    public Jchart() {
        initComponents();
       String[] day = {"01/03/2023", "02/03/2023", "03/03/2023", "04/03/2023"};
        String[][] money = {{"1","3"}, {"2","3"}, {"4","1"}, {"5","2"}};
        String rev = "Doanh thu";
        String cap = "Tiền vốn";
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for(int i=0;i<day.length;i++){
            dataset.addValue(Integer.parseInt(money[i][0]), rev , day[i]);
            dataset.addValue(Integer.parseInt(money[i][1]), cap, day[i]);
        }   
        // Tạo biểu đồ đường từ bộ dữ liệu
        JFreeChart barChart = ChartFactory.createBarChart("Doanh thu", "Thời gian", "Đồng",
                                                           dataset, PlotOrientation.VERTICAL, true, true, false); 

        ChartPanel chartPanel = new ChartPanel(barChart);
        
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        xYSmoothLineAndShapeRenderer1 = new org.jfree.experimental.chart.renderer.xy.XYSmoothLineAndShapeRenderer();
        xYSmoothLineAndShapeRenderer2 = new org.jfree.experimental.chart.renderer.xy.XYSmoothLineAndShapeRenderer();

        setOpaque(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 339, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleParent(this);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jfree.experimental.chart.renderer.xy.XYSmoothLineAndShapeRenderer xYSmoothLineAndShapeRenderer1;
    private org.jfree.experimental.chart.renderer.xy.XYSmoothLineAndShapeRenderer xYSmoothLineAndShapeRenderer2;
    // End of variables declaration//GEN-END:variables
}
