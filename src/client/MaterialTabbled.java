/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.plaf.metal.MetalTabbedPaneUI;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.interpolation.PropertySetter;
import component.ButtonTabComponent;

/**
 *
 * @author user
 */
public class MaterialTabbled extends JTabbedPane {
    public MaterialTabbled() {
        setUI(new MaterialTabbbedUI());
    }

   
    public class MaterialTabbbedUI extends MetalTabbedPaneUI {

        /**
         * @param currenRectangle the currenRectangle to set
         */
        public void setCurrenRectangle(Rectangle currenRectangle) {
            this.currenRectangle = currenRectangle;
            repaint();
        }

        private Animator animator;
        private Rectangle currenRectangle;
        private TimingTarget taget;

        public MaterialTabbbedUI() {

        }

        @Override
        public void installUI(JComponent c) {
            super.installUI(c);
            animator = new Animator(500);
            animator.setResolution(0);
            animator.setAcceleration(.5f);
            animator.setDeceleration(.5f);
            tabPane.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    int selected = tabPane.getSelectedIndex();
                    if (selected != -1) {
                        if (currenRectangle != null) {
                            if (animator.isRunning()) {
                                animator.stop();
                            }
                            animator.removeTarget(taget);
                            taget = new PropertySetter(MaterialTabbbedUI.this, "currenRectangle", currenRectangle, getTabBounds(selected, calcRect));
                            animator.addTarget(taget);
                            animator.start();
                        }
                    }
                }
            });
        }

        @Override
        protected Insets getTabInsets(int tabPlacement, int tabIndex) {
            if (tabPlacement == TOP) {
                    return new Insets(10,10, 10, 10);
                } else if (tabPlacement == BOTTOM) {
                   

                } else if (tabPlacement == LEFT) {
                   
                    return new Insets(20,20, 20, 20);
                } else if (tabPlacement == RIGHT) {
                 

                }
         return new Insets(20,20, 20, 20);
        }

        @Override
        protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
            Graphics2D g2;
            g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(new Color(0, 255, 51));
            if (currenRectangle == null || !animator.isRunning()) {
                if (isSelected) {
                    currenRectangle = new Rectangle(x, y, w, h);
                }
            }
            if (currenRectangle != null) {
                if (tabPlacement == TOP) {
                    g2.fillRect(currenRectangle.x, currenRectangle.y + currenRectangle.height - 3, currenRectangle.width, 3);
                } else if (tabPlacement == BOTTOM) {
                    g2.fillRect(currenRectangle.x, currenRectangle.y, currenRectangle.width, 3);

                } else if (tabPlacement == LEFT) {
                    g2.fillRect(currenRectangle.x + currenRectangle.width - 3, currenRectangle.y, 3, currenRectangle.height);

                } else if (tabPlacement == RIGHT) {
                    g2.fillRect(currenRectangle.x, currenRectangle.y, 3, currenRectangle.height);

                }
            }
            g2.dispose();
        }

        @Override
        protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) {
            Graphics2D g2;
            g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(new Color(200, 200, 200));
            Insets insets = getTabAreaInsets(tabPlacement);
            int width = tabPane.getWidth();
            int height = tabPane.getHeight();
            if (tabPlacement == TOP) {
                int tabHeight = calculateTabAreaHeight(tabPlacement, runCount, maxTabHeight);
                g2.drawLine(insets.left, tabHeight, width - insets.right - 1, tabHeight);
            } else if (tabPlacement == BOTTOM) {
                int tabHeight = height - calculateTabAreaHeight(tabPlacement, runCount, maxTabHeight);
                g2.drawLine(insets.left, tabHeight, width - insets.right - 1, tabHeight);
            } else if (tabPlacement == LEFT) {
                int tabWidth = calculateTabAreaWidth(tabPlacement, runCount, maxTabWidth);
                g2.drawLine(tabWidth, insets.top, tabWidth, height - insets.bottom - 1);
            } else if (tabPlacement == RIGHT) {
                int tabWidth = width - calculateTabAreaWidth(tabPlacement, runCount, maxTabWidth);
                g2.drawLine(tabWidth, insets.top, tabWidth, height - insets.bottom - 1);
            }
            g2.dispose();
        }

       @Override
        protected void paintFocusIndicator(Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex, Rectangle iconRect, Rectangle textRect, boolean isSelected) {
            
        }

        @Override
        protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
             Graphics2D g2;
            g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(new Color(242, 242, 242));
            if (currenRectangle == null || !animator.isRunning()) {
                if (isSelected) {
                    currenRectangle = new Rectangle(x, y, w, h);
                }
            }
            if (currenRectangle != null) {
                g2.fillRect(x, y , w, h);
            }
            g2.dispose();
        }
       

    }
    
   

}
