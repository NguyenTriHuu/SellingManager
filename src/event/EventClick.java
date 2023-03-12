/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package event;

import java.awt.Component;
import model.DataSearch;

/**
 *
 * @author user
 */
public interface EventClick {
         public void itemClick(DataSearch data);

        public void itemRemove(Component com, DataSearch data);
}
