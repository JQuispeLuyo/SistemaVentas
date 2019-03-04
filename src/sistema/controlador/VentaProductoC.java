/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.controlador;

import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sistema.dao.VentaProductoD;
import sistema.modelo.LoginM;
import sistema.modelo.VentaProductoM;
import sistema.view.PnlVentaProductoContainer;

/**
 *
 * @author Jose Luis
 */
public class VentaProductoC {

    VentaProductoD ventaProductoD = new VentaProductoD();
    VentaProductoM ventaProductoM = new VentaProductoM();
    LoginM loginM;


    public void listarVentaProductoTabla(DefaultTableModel modeloTablaVentaProducto, int tipoFiltro, String datoFiltro) {
        ventaProductoD.listarProductoTabla(modeloTablaVentaProducto, tipoFiltro, datoFiltro);
    }

    public void getClienteVentaProducto() {

    }

    public void cargarVariables() {
        loginM = LoginM.getInstance();

        if (!PnlVentaProductoContainer.jlCodigoVentaProducto.getText().equals("")) {
            ventaProductoM.setCODVENT(Integer.parseInt(
                    PnlVentaProductoContainer.jlCodigoVentaProducto.getText()));
        }

        if (PnlVentaProductoContainer.jcTipoVentaProducto.getSelectedIndex() == 0) {
            ventaProductoM.setTIPVENT("B");
        } else {
            ventaProductoM.setTIPVENT("F");
        }

        System.out.println("Tipo de venta " + ventaProductoM.getTIPVENT());

        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            ventaProductoM.setFECVENT(Date.valueOf(formatoFecha.format(PnlVentaProductoContainer.jcaFechaVentaProducto.getDate())));
        } catch (Exception e) {
            System.out.println("Algo anda  mal");
        }

        System.out.println("id usuario " + loginM.getId());
        System.out.println("id cliente " + PnlVentaProductoContainer.jlCodigoClienteVentaProducto.getText());
        ventaProductoM.setPERSONA_CODPER(Integer.parseInt(PnlVentaProductoContainer.jlCodigoClienteVentaProducto.getText()));
        ventaProductoM.setEMPLEADO_CODPER(loginM.getId());

    }

    public void cargarClienteVentaProducto(String DniRuc) {
        System.out.println("asdadas " + PnlVentaProductoContainer.jcTipoVentaProducto.getSelectedIndex());
        ventaProductoD.cargarClienteVentaProducto(DniRuc, PnlVentaProductoContainer.jcTipoVentaProducto.getSelectedIndex());
    }

    public boolean validar() {

        if (PnlVentaProductoContainer.jcTipoVentaProducto.getSelectedIndex() == 0) {
            if (PnlVentaProductoContainer.txtDniRucClienteVenta.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Ingrese DNI");
                return false;
            }
        }else{
            if (PnlVentaProductoContainer.txtDniRucClienteVenta.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Ingrese RUC");
                return false;
            }
        }

        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            Date.valueOf(formatoFecha.format(PnlVentaProductoContainer.jcaFechaVentaProducto.getDate()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ingrese Fecha correcta");
            return false;
        }

        if (PnlVentaProductoContainer.jlCodigoClienteVentaProducto.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "No se encuentra el codigo del cliente y/o empresa");
            return false;
        }

        return true;
    }
    
    public void limpiarVariable(){
        
        PnlVentaProductoContainer.jlCodigoClienteVentaProducto.setText("");
        PnlVentaProductoContainer.jlCodigoVentaProducto.setText("");
        PnlVentaProductoContainer.txtDniRucClienteVenta.setText("");
        PnlVentaProductoContainer.jlDatoClienteVentaProducto.setText("");
    }

}
