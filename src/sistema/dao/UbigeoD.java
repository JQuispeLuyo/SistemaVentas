/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import sistema.modelo.UbigeoM;

/**
 *
 * @author Jose Luis
 */
public class UbigeoD extends Conexion {
    
    
    // método para listar los departamentos
    public void listarDepartamentoUbigeo(JComboBox box) throws Exception {
        box.removeAllItems();
        try {
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery("select distinct DEPUBI from ubigeo");
            while (rs.next()) {
                box.addItem(rs.getString("DEPUBI"));
            }
            st.close();
            rs.close();
        } catch (SQLException ex) {           
            System.out.println(ex.getCause() +  ex.getMessage());
        }
    }

    // listar las provincias cuando tenga el texto del departamento
    public void listarProvinciaUbigeo(JComboBox box, String dpto) throws Exception {
        box.removeAllItems();
        try {
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery("select distinct PROUBI from ubigeo where DEPUBI='" + dpto + "'");
            while (rs.next()) {
                box.addItem(rs.getString("PROUBI"));
            }
            st.close();
            rs.close();
        } catch (SQLException ex) {            
            System.out.println(ex.getCause()+ex.getMessage());
        }
    }

    // obtener toda la lista de distritos cuando se escoge el texto de la provincia
    public void listarDistritoUbigeo(JComboBox Box, String prov) {
        DefaultComboBoxModel value;
        try {
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery("select CODUBI, DISUBI from ubigeo where PROUBI='" + prov + "'");
            value = new DefaultComboBoxModel();
            while (rs.next()) {
                value.addElement(new UbigeoM(rs.getString("CODUBI"), rs.getString("DISUBI")));
            }
            Box.setModel(value);
            st.close();
            rs.close();
        } catch (Exception ex) {
            ex.getMessage();
            System.out.println(ex.getCause());
        }
    }

    public void listarUbigeo(JComboBox Departamento,JComboBox Provincia,JComboBox Distrito, String CODUBI) {
        
        
        try {
            
            String rsDepartamento = "";
            String rsProvincia = "";
            String rsDistrito = "";
            
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery("select DEPUBI, PROUBI, DISUBI from ubigeo where CODUBI='" + CODUBI + "'");
            while (rs.next()) {
                rsDepartamento = rs.getString("DEPUBI");
                rsProvincia = rs.getString("PROUBI");
                rsDistrito = rs.getString("DISUBI");
            }

            for (int index = 0; index < Departamento.getItemCount(); index++) {
                if (Departamento.getItemAt(index).equals(rsDepartamento)) {
                    Departamento.setSelectedIndex(index);
                    break;
                };
            }
            
            for (int index = 0; index < Provincia.getItemCount(); index++) {
                if (Provincia.getItemAt(index).equals(rsProvincia)) {
                    Provincia.setSelectedIndex(index);
                    break;
                };
            }
            
            for (int index = 0; index < Distrito.getItemCount(); index++) {
                if (Distrito.getItemAt(index).toString().equals(rsDistrito)) {
                    Distrito.setSelectedIndex(index);
                    break;
                };
            }
            
            
            st.close();
            rs.close();
        } catch (Exception ex) {
            ex.getMessage();
            System.out.println(ex.getCause());
        }
    }
    
    
}
