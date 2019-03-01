/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.controlador;

import javax.swing.table.DefaultTableModel;
import sistema.dao.VentaProductoD;

/**
 *
 * @author Jose Luis
 */
public class VentaProductoC {
    
    VentaProductoD ventaProductoD = new VentaProductoD();
    

    public void listarVentaProductoTabla(DefaultTableModel modeloTablaVentaProducto, int tipoFiltro, String datoFiltro) {
        ventaProductoD.listarProductoTabla(modeloTablaVentaProducto, tipoFiltro, datoFiltro);
    }
    
}
