/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sistema.view.PnlVentaProductoContainer;

/**
 *
 * @author Jose Luis
 */
public class VentaProductoD {

    public void listarProductoTabla(DefaultTableModel modeloTablaVentaProducto, int tipoFiltro, String datoFiltro) {

    }

    public void cargarClienteVentaProducto(String DniRuc, int tipo) {
        try {

            String sql = "";
            String Dato = "";
            int CODPER = 0;

            if (tipo == 0) {
                sql = "SELECT CODPER, NOMPER, APEPER FROM PERSONA WHERE RUCDNIPER=? and TIPPER = 'C';";
            } else {

                sql = "SELECT CODPER, NOMPER FROM PERSONA WHERE RUCDNIPER=? and TIPPER = 'E';";
            }

            PreparedStatement preparedstatement = Conexion.conectar().prepareStatement(sql);
            preparedstatement.setString(1, DniRuc);
            ResultSet rs = preparedstatement.executeQuery();

            while (rs.next()) {
                if (tipo == 0) {
                    CODPER = rs.getInt("CODPER");
                    Dato += rs.getString("NOMPER") + rs.getString("APEPER");
                } else {

                    CODPER = rs.getInt("CODPER");
                    Dato += rs.getString("NOMPER");
                }

            }

            PnlVentaProductoContainer.jlCodigoClienteVentaProducto.setText(String.valueOf(CODPER));
            PnlVentaProductoContainer.jlDatoClienteVentaProducto.setText(Dato);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "error al mostar datos de VENTA CLIENTE PRODUCTO");
        }
    }

}
