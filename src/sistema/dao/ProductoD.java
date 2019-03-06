/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import sistema.controlador.ProductoC;
import sistema.modelo.CategoriaM;
import sistema.modelo.ProductoM;
import sistema.modelo.UnidadM;
import sistema.view.PnlProductosContainer;

public class ProductoD extends Conexion {

    public void guardarProducto(ProductoM productoM) throws Exception {

        try {
//            String sql = "Insert Into PRODUCTO "
//                    + "(CODPRO, DESPRO, CODUNI, PREPRO, CODCAT) "
//                    + "values"
//                    + "(?,?,?,?,?)";

            String sql = "INSERT INTO PRODUCTO"
                    + "	(CODPRO,CODCAT,DESPRO,PREPRO,CODUNI)"
                    + "    VALUES"
                    + "		(?,?,?,?,?);";

            PreparedStatement ps = this.conectar().prepareStatement(sql);

            ps.setInt(1, productoM.getCODPRO());
            ps.setInt(2, productoM.getCODCAT());
            ps.setString(3, productoM.getDESPRO());
            ps.setDouble(4, productoM.getPREPRO());
            ps.setInt(5, productoM.getCODUNI());
            ps.executeUpdate();
            ps.close();

            JOptionPane.showMessageDialog(null, "Registro ingresado");
        } catch (Exception e) {

            System.out.println("Error al guardar producto en el Dao");

        }

    }

    public void editarProducto(ProductoM productoM) throws Exception {

        try {
//            String sql = "Update PRODUCTO set DESPRO=?, CODUNI=?, PREPRO=?, CODCAT=? where CODPRO=?";
            String sql = "Update PRODUCTO set "
                    + "CODCAT=?, DESPRO=?, PREPRO=?, CODUNI=? "
                    + "where CODPRO=?;";

            PreparedStatement ps = this.conectar().prepareStatement(sql);

            ps.setInt(1, productoM.getCODCAT());
            ps.setString(2, productoM.getDESPRO());
            ps.setDouble(3, productoM.getPREPRO());
            ps.setInt(4, productoM.getCODUNI());
            ps.setInt(5, productoM.getCODPRO());
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Actualización correcta");
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error al actualiza");

        }

    }

    public void eliminarProducto(int CODPRO) throws Exception {

        try {
            String sql = "delete from PRODUCTO where CODPRO =?;";

            PreparedStatement ps = this.conectar().prepareStatement(sql);

            ps.setInt(1, CODPRO);
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

            jcUnidadMedida.addItem(new UnidadM(1, "Selecione Unidad"));

            while (rs.next()) {
                jcUnidadMedida.addItem(
                        new UnidadM(
                                rs.getInt("CODUNI"),
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

            jcCategoria.addItem(new CategoriaM(1, "Selecione Categoria"));
            jcCategoriaFiltro.addItem(new CategoriaM(1, "Selecione Categoria"));

            while (rs.next()) {
                jcCategoria.addItem(
                        new CategoriaM(
                                rs.getInt("CODCAT"),
                                rs.getString("DESCAT")
                        )
                );
                jcCategoriaFiltro.addItem(
                        new CategoriaM(
                                rs.getInt("CODCAT"),
                                rs.getString("DESCAT")
                        )
                );
            }

        } catch (Exception ex) {
            Logger.getLogger(UnidadM.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR LAS CATEGORIAS");
        }
    }

    public void mostrarCategoriaFiltroAgregar(JComboBox<CategoriaM> jcCategoriaFiltro) {
        try {
            String sql = "select * from CATEGORIA";

            PreparedStatement preparedstatement = Conexion.conectar().prepareStatement(sql);
            ResultSet rs = preparedstatement.executeQuery();

            jcCategoriaFiltro.addItem(new CategoriaM(1, "Selecione Categoria"));

            while (rs.next()) {
                jcCategoriaFiltro.addItem(
                        new CategoriaM(
                                rs.getInt("CODCAT"),
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
                    sql = "CALL FILTRAR_PRODUCTO('1', '%" + dato + "%')"; // todos , activado el chkTodos
                    break;
                case 2:
                    sql = "CALL FILTRAR_PRODUCTO('2', '%" + dato + "%')"; // DNI
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

//     public void generarReporte() throws net.sf.jasperreports.engine.JRException{
//        InputStream inputStream = null;
//        try {
////            inputStream = new FileInputStream ("src/prueba1.jrxml");
//            inputStream = new FileInputStream ("src/reportes/ProductoReporte.jrxml");
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(ProductoD.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        Map parameters = new HashMap();
//        JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
//        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters);
//        JasperExportManager.exportReportToPdfFile(jasperPrint, "src/prueba1.pdf");
//         
//    }
    
    public void reporteProducto() {
        try {
        String path = "src\\reportes\\ProductoReporte.jasper";

//            Map parametro = new HashMap();
//            parametro.put("id_estado", 36);
            JasperReport reporte = null;
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);

            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, this.conectar());

            JasperViewer view = new JasperViewer(jprint, false);

            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            view.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(PnlProductosContainer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ProductoD.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }

}
