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
import sistema.modelo.VentaDetalleProductoM;
import sistema.modelo.VentaProductoM;
import sistema.view.PnlVentaProductoContainer;

/**
 *
 * @author Jose Luis
 */
public class VentaProductoD extends Conexion {

    public void guardarVentaProducto(VentaProductoM ventaProductoM) {
        try {

            String sql = "INSERT INTO VENTAS"
                    + "(TIPVENT,FECVENT,EMPLEADO_CODPER,PERSONA_CODPER)"
                    + "VALUES"
                    + "(?,?,?,?);";

            PreparedStatement ps = this.conectar().prepareStatement(sql);

            ps.setString(1, ventaProductoM.getTIPVENT());
            ps.setDate(2, ventaProductoM.getFECVENT());
            ps.setInt(3, ventaProductoM.getEMPLEADO_CODPER());
            ps.setInt(4, ventaProductoM.getPERSONA_CODPER());

            ps.executeUpdate();
            ps.close();

            JOptionPane.showMessageDialog(null, "Registro ingresado VENTA correctamente");
        } catch (Exception e) {

            System.out.println("Error al guardar Empresa en el Dao");

        }
    }

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

    public int getVentaProducto(int CODPER) {

        try {
            int CODVENT = 0;
            
            String sql = "SELECT CODVENT FROM VENTAS where EMPLEADO_CODPER = ? ORDER by CODVENT DESC LIMIT 1;";

            PreparedStatement preparedstatement = Conexion.conectar().prepareStatement(sql);
            preparedstatement.setInt(1, CODPER);
            ResultSet rs = preparedstatement.executeQuery();

            while (rs.next()) {
                System.out.println("Resp. Servidor "+rs.getInt("CODVENT"));
                CODVENT = rs.getInt("CODVENT");
            }
            
            return CODVENT;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "error al mostar datos de DETALLE VENTA PRODUCTO");
            return 0;
        }
    }
    
    public void guardarVentaDetalle(VentaDetalleProductoM ventaDetalleProductoM) {

        try {        
            
            System.out.println(ventaDetalleProductoM.getCODVENT());
            System.out.println(ventaDetalleProductoM.getCANDETVENT());
            System.out.println(ventaDetalleProductoM.getCODPRO());
            
            String sql = "CALL INSERTAR_VENTA_DETALLE(?,?,?);";

            PreparedStatement preparedstatement = Conexion.conectar().prepareStatement(sql);
  
            preparedstatement.setInt(1, ventaDetalleProductoM.getCODVENT());
            preparedstatement.setInt(2, ventaDetalleProductoM.getCANDETVENT());
            preparedstatement.setInt(3, ventaDetalleProductoM.getCODPRO());
            
            preparedstatement.executeUpdate();
            preparedstatement.close();

            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "error al mostar datos de DETALLE VENTA PRODUCTO");
        }
    }
    
    

}
