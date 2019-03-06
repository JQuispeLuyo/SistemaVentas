/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.controlador;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import sistema.dao.VentaD;

/**
 *
 * @author Jose Luis
 */
public class VentaC {
    
    VentaD ventaD = new VentaD();
    
    public void listarVentaTabla(DefaultTableModel modeloTablaVenta, int tipoFiltro, String datoFiltro) {
        try {
            ventaD.listarVentaTabla(modeloTablaVenta, tipoFiltro, datoFiltro);
        } catch (Exception ex) {
            Logger.getLogger(VentaC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean validar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void cargarVariables() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void limpiarVariables() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void reporteVenta() {
        ventaD.reporteVenta(); 
    }
    
    
    
}
