/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.json.JSONObject;
import sistema.modelo.EmpresaM;

/**
 *
 * @author Jose Luis
 */
public class EmpresaD extends Conexion {

    private ArrayList<String> DatosEmpresa = new ArrayList<String>();

    public ArrayList<String> resPersona(String RUC) {
        DatosEmpresa.clear();
        try {
            String webService = "https://api.sunat.cloud/ruc/" + RUC;
            URL url = new URL(webService);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/xml");

            if (conn.getResponseCode() == 200) {

                BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

                String Respuesta, resul = "";

                while ((Respuesta = br.readLine()) != null) {
                    resul += Respuesta;
                }

//                if (!(resul.trim() == "")) {
//                    String[] parts = resul.split("\\|");
//
//                    DatosPersona.add(parts[0]);
//                    DatosPersona.add(parts[1]);
//                    DatosPersona.add(parts[2]);
//                    try {
//                        if (!parts[3].isEmpty()) {
//                            JOptionPane.showMessageDialog(null,"Dni no encontrado","Mensaje", 2);
//                        }
//                    } catch (Exception e) {
//                        JOptionPane.showMessageDialog(null, "Hiciste lo correcto bob .jpg", "Mensaje", 1);
//                        
//                    }
//                }
                try {

                    JSONObject obj = new JSONObject(resul);
                    String razonSocial = obj.getString("razon_social");
                    DatosEmpresa.add(razonSocial);
                    JOptionPane.showMessageDialog(null, "Hiciste lo correcto bob .jpg", "Mensaje", 1);
                    return DatosEmpresa;

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "RUC no encontrado", "Mensaje", 2);

                }

            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Problema con el api");
        }
        return null;
    }

    public void guardarEmpresa(EmpresaM empresaM) throws Exception {

        try {

            String sql = "INSERT INTO PERSONA"
                    + "(NOMPER,APEPER,RUCDNIPER,TIPPER,ESTAPER)"
                    + "VALUES"
                    + "(?,?,?,?,?);";

            PreparedStatement ps = this.conectar().prepareStatement(sql);

            ps.setString(1, empresaM.getNOMPER());
            ps.setString(2, empresaM.getAPEPER());
            ps.setString(3, empresaM.getRUCDNIPER());
            ps.setString(4, empresaM.getTIPPER());
            ps.setString(5, empresaM.getESTAPER());

            ps.executeUpdate();
            ps.close();

            JOptionPane.showMessageDialog(null, "Registro ingresado correctamente");
        } catch (Exception e) {

            System.out.println("Error al guardar Empresa en el Dao");

        }

    }

    public void editarEmpresa(EmpresaM empresaM) throws Exception {

        try {
            String sql = "Update"
                    + "	PERSONA"
                    + "	set NOMPER=?,APEPER=?,RUCDNIPER=?,TIPPER=?,ESTAPER=?"
                    + "where CODPER=?;";

//                        CALL EDITAR_USUARIO_DATOS(12,'Jose Luis1', 'Quispe Luyo', '12345678900','2000/11/19','140409',
//							'Mz. 10 Lt 10','123456789','M','E','A');
            PreparedStatement ps = this.conectar().prepareStatement(sql);

            ps.setString(1, empresaM.getNOMPER());
            ps.setString(2, empresaM.getAPEPER());
            ps.setString(3, empresaM.getRUCDNIPER());
            ps.setString(4, empresaM.getTIPPER());
            ps.setString(5, empresaM.getESTAPER());
            ps.setInt(6, empresaM.getCODPER());

            ps.executeUpdate();
            ps.close();

            JOptionPane.showMessageDialog(null, "Registro actualizado");
        } catch (Exception e) {

            System.out.println("Error al actualizar EMPRESA en el Dao");

        }

    }

    public void eliminarEmpresa(int CODPER) throws Exception {

        try {
            String sql = "delete from PERSONA where CODPER=?";

            PreparedStatement ps = this.conectar().prepareStatement(sql);

            ps.setInt(1, CODPER);
            ps.executeUpdate();
            ps.close();

            JOptionPane.showMessageDialog(null, "Resgistro eliminado");

        } catch (Exception e) {

            System.out.println("Error al eliminar EMPRESA en el Dao");

        }
    }

    public void listarEmpresaTabla(DefaultTableModel modeloTabla, Integer tipo, String dato) throws SQLException, Exception {
        try {

            String sql = "";

            switch (tipo) {
                case 0:
                    sql = "CALL MOSTRAR_EMPRESA()";
                    break;
                case 1:
                    sql = "CALL FILTRAR_EMPRESA('1', '%" + dato + "%')"; // Nombre
                    break;
                case 2:
                    sql = "CALL FILTRAR_EMPRESA('2', '%" + dato + "%')"; // Apellido
                    break;
                case 3:
                    sql = "CALL FILTRAR_EMPRESA('3', '%" + dato + "%')"; // DNI
                    break;
                case 4:
                    sql = "CALL FILTRAR_EMPRESA('4', '%" + dato + "%')"; // DNI
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
            System.out.println("Error en Dao Empresa Listar");
        }

    }

    public boolean validarExistenciaEmpresa(String DNI) throws Exception {

        System.out.println("Dao " + DNI);
        String sql = "CALL VERIFICAR_EXISTENCIA_EMPRESA(?);";

        PreparedStatement ps = this.conectar().prepareStatement(sql);
        ps.setString(1, DNI);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            System.out.println("rs : " + rs.getObject(1));
            if (rs.getObject(1).equals(DNI)) {
                return true;
            }
        }

        return false;

    }

}
