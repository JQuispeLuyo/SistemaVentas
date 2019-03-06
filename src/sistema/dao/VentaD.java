/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import sistema.view.PnlProductosContainer;

/**
 *
 * @author Jose Luis
 */
public class VentaD extends Conexion {

    public void listarVentaTabla(DefaultTableModel modeloTabla, Integer tipo, String dato){
        try {

            String sql = "";

            switch (tipo) {
                case 0:
                    sql = "CALL MOSTRAR_VENTA();";
                    break;
                case 1:
                    sql = "CALL FILTRAR_VENTA('1', '%" + dato + "%')"; // todos , activado el chkTodos
                    break;
                case 2:
                    sql = "CALL FILTRAR_VENTA('2', '%" + dato + "%')"; // DNI
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

    public void reporteVenta() {
        try {
        String path = "src\\reportes\\VentaReporte.jasper";

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
