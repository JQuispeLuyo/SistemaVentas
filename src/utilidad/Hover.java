/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidad;

import javax.swing.JPanel;

/**
 *
 * @author Jose Luis
 */
public class Hover {

    int NumItems;
    JPanel PanelContenedor;

    public Hover(int NumItems, JPanel PanelContenedor) {
        this.NumItems = NumItems;
        this.PanelContenedor = PanelContenedor;
    }
    
    public void menu(int PanelActual) {
        for (int i = 0; i < NumItems; i++) {
            if (i == PanelActual && PanelContenedor.getComponent(i).isEnabled()) {
                PanelContenedor.getComponent(i).setBackground(new java.awt.Color(204, 204, 204));
            } else {
                if (PanelContenedor.getComponent(i).isEnabled()) {
                    PanelContenedor.getComponent(i).setBackground(new java.awt.Color(243, 243, 243));
                } else {
                    PanelContenedor.getComponent(i).setBackground(new java.awt.Color(255, 255, 255));
                }
            }
        }
    }

}
