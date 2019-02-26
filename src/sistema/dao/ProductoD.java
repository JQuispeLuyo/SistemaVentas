/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sistema.modelo.CategoriaM;
import sistema.modelo.ProductoM;
import sistema.modelo.UnidadM;

public class ProductoD extends Conexion {

    public void guardarProducto(ProductoM productoM) throws Exception {

        try {
//            String sql = "Insert Into PRODUCTO "
//                    + "(CODPRO, DESPRO, CODUNI, PREPRO, CODCAT) "
//                    + "values"
//                    + "(?,?,?,?,?)";

            String sql = "CALL INSERTAR_PRODUCTO(?,?,?,?,?)";
            

            PreparedStatement ps = this.conectar().prepareStatement(sql);

            ps.setString(1, productoM.getCODPRO());
            ps.setString(2, productoM.getCODCAT());
            ps.setString(3, productoM.getDESPRO());
            ps.setDouble(4, productoM.getPREPRO());
            ps.setInt(5, productoM.getCODUNI());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {

            System.out.println("Error al guardar producto en el Dao");

        }

    }
    
    public void editarProducto(ProductoM productoM) throws Exception {

        try {
//            String sql = "Update PRODUCTO set DESPRO=?, CODUNI=?, PREPRO=?, CODCAT=? where CODPRO=?";
            String sql = "CALL EDITAR_PRODUCTO(?,?,?,?,?)";
            

            PreparedStatement ps = this.conectar().prepareStatement(sql);
            
            ps.setString(1, productoM.getCODPRO());
            ps.setString(2, productoM.getCODCAT());
            ps.setString(3, productoM.getDESPRO());
            ps.setDouble(4, productoM.getPREPRO());
            ps.setInt(5, productoM.getCODUNI());
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Actualización correcta");
        } catch (Exception e) {

            System.out.println("Error al actualizar producto en el Dao");

        }

    }
    
    public void eliminarProducto(ProductoM productoM) throws Exception {

        try {
            String sql = "CALL ELIMINAR_PRODUCTO(?)";
            
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            
            ps.setString(1, productoM.getCODPRO());
            ps.execute();
            ps.close();
            
            JOptionPane.showMessageDialog(null, "Eliminado");
        } catch (Exception e) {

            System.out.println("Error al actualizar producto en el Dao");

        }

    }

    public void mostrarUnidad(JComboBox<UnidadM> jcUnidadMedida) {
        try {
            String sql = "select * from UNIDAD";

            PreparedStatement preparedstatement = Conexion.conectar().prepareStatement(sql);
            ResultSet rs = preparedstatement.executeQuery();
            
            jcUnidadMedida.addItem(new UnidadM("0000","Selecione Unidad"));
            
            while (rs.next()) {
                jcUnidadMedida.addItem(
                        new UnidadM(
                                rs.getString("CODUNI"),
                                rs.getString("DESUNI")
                        )
                );
            }

        } catch (Exception ex) {
            Logger.getLogger(UnidadM.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR LAS UNIDADES DE MEDIDA");
        }
    }

    public void mostrarCategoria(JComboBox<CategoriaM> jcCategoria, JComboBox<CategoriaM> jcCategoriaFiltro) {
        try {
            String sql = "select * from CATEGORIA";
            
            PreparedStatement preparedstatement = Conexion.conectar().prepareStatement(sql);
            ResultSet rs = preparedstatement.executeQuery();

            jcCategoria.addItem(new CategoriaM("0000","Selecione Categoria"));
            jcCategoriaFiltro.addItem(new CategoriaM("0000","Selecione Categoria"));
            
            while (rs.next()) {
                jcCategoria.addItem(
                        new CategoriaM(
                                rs.getString("CODCAT"),
                                rs.getString("DESCAT")
                        )
                );
                jcCategoriaFiltro.addItem(
                        new CategoriaM(
                                rs.getString("CODCAT"),
                                rs.getString("DESCAT")
                        )
                );
            }

        } catch (Exception ex) {
            Logger.getLogger(UnidadM.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR LAS CATEGORIAS");
        }
    }
    
    public void listarProductoTabla(DefaultTableModel modeloTabla, Integer tipo, String dato) throws SQLException, Exception {
        try {
            
            String sql = "";
            
            switch (tipo) {
                case 0:
                    sql = "CALL MOSTRAR_PRODUCTO()";
                    break;
                case 1:
                    sql = "CALL FILTRAR_PRODUCTO('1', '%"+dato+"%')"; // todos , activado el chkTodos
                    break;
                case 2:
                    sql = "CALL FILTRAR_PRODUCTO('2', '%"+dato+"%')"; // DNI
                    break;
            }
            PreparedStatement preparedstatement = this.conectar().prepareStatement(sql);
            ResultSet rs = preparedstatement.executeQuery();
            int columnCount = rs.getMetaData().getColumnCount(); 
            
            Object datos[] = new Object[columnCount]; // cantidad de columnas
            while (rs.next()) {
                for (int i = 0; i < columnCount; i++) {
                    datos[i] = rs.getObject(i + 1);
                }
                modeloTabla.addRow(datos);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error en Dao producto Listar");
        }

    }

    
}
