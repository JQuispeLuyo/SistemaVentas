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
import sistema.modelo.UsuarioM;

/**
 *
 * @author Jose Luis
 */
public class UsuarioD extends Conexion {

    private ArrayList<String> DatosPersona = new ArrayList<String>();
    private ArrayList<String> CredencialUsuario = new ArrayList<String>();

    public ArrayList<String> resPersona(String dni) {
        DatosPersona.clear();
        try {
            String webService = "http://aplicaciones007.jne.gob.pe/srop_publico/Consulta/Afiliado/GetNombresCiudadano?DNI=" + dni;
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

                if (!(resul.trim() == "")) {
                    String[] parts = resul.split("\\|");

                    DatosPersona.add(parts[0]);
                    DatosPersona.add(parts[1]);
                    DatosPersona.add(parts[2]);
                }

//                JSONObject obj = new JSONObject(resul);
//                String nombre = obj.getString("nombres");
//                String apellido = obj.getString("apellido_paterno") + " " + obj.getString("apellido_materno"); 
//                DatosPersona.add(nombre);
//                DatosPersona.add(apellido);
                return DatosPersona;

            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return null;
    }

    public void guardarUsuario(UsuarioM usuarioM) throws Exception {

        try {
//            String sql = "Insert Into PRODUCTO "
//                    + "(CODPRO, DESPRO, CODUNI, PREPRO, CODCAT) "
//                    + "values"
//                    + "(?,?,?,?,?)";

            String sql = "CALL INSERTAR_USUARIO(?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement ps = this.conectar().prepareStatement(sql);

            ps.setString(1, usuarioM.getNOMPER());
            ps.setString(2, usuarioM.getAPEPER());
            ps.setString(3, usuarioM.getRUCDNIPER());
            ps.setDate(4, usuarioM.getFECNAC());
            ps.setString(5, usuarioM.getUBIPER());
            ps.setString(6, usuarioM.getDIRPER());
            ps.setString(7, usuarioM.getTEL1PER());
            ps.setString(8, usuarioM.getGENPER());
            ps.setString(9, usuarioM.getUSEPER());
            ps.setString(10, usuarioM.getCONPER());
            ps.setString(11, usuarioM.getTIPPER());
            ps.setString(12, usuarioM.getESTAPER());

            ps.executeUpdate();
            ps.close();

            JOptionPane.showMessageDialog(null, "Registrado correctamente");
        } catch (Exception e) {

            System.out.println("Error al guardar USUARIO en el Dao");

        }

    }

    public void editarUsuarioDatos(UsuarioM usuarioM) throws Exception {

        try {
            String sql = "CALL EDITAR_USUARIO_DATOS(?,?,?,?,?,?,?,?,?,?,?)";

//                        CALL EDITAR_USUARIO_DATOS(12,'Jose Luis1', 'Quispe Luyo', '12345678900','2000/11/19','140409',
//							'Mz. 10 Lt 10','123456789','M','E','A');
            PreparedStatement ps = this.conectar().prepareStatement(sql);

            ps.setInt(1, usuarioM.getCODPER());
            ps.setString(2, usuarioM.getNOMPER());
            ps.setString(3, usuarioM.getAPEPER());
            ps.setString(4, usuarioM.getRUCDNIPER());
            ps.setDate(5, usuarioM.getFECNAC());
            ps.setString(6, usuarioM.getUBIPER());
            ps.setString(7, usuarioM.getDIRPER());
            ps.setString(8, usuarioM.getTEL1PER());
            ps.setString(9, usuarioM.getGENPER());
            ps.setString(10, usuarioM.getTIPPER());
            ps.setString(11, usuarioM.getESTAPER());
            ps.executeUpdate();
            ps.close();

            JOptionPane.showMessageDialog(null, "Actualización correcta");
        } catch (Exception e) {

            System.out.println("Error al actualizar USUARIO DATOS en el Dao");

        }

    }

    public void editarUsuarioLogin(UsuarioM usuarioM) throws Exception {

        try {
            String sql = "CALL EDITAR_USUARIO_LOGIN(?,?,sha1(md5(?)))";

            PreparedStatement ps = this.conectar().prepareStatement(sql);

            ps.setInt(1, usuarioM.getCODPER());
            ps.setString(2, usuarioM.getUSEPER());
            ps.setString(3, usuarioM.getCONPER());
            ps.executeUpdate();
            ps.close();

        } catch (Exception e) {

            System.out.println("Error al actualizar USUARIO LOGIN en el Dao");

        }
    }

    public void eliminarUsuario(UsuarioM usuarioM) throws Exception {

        try {
            String sql = "CALL ELIMINAR_USUARIO(?,?)";

            PreparedStatement ps = this.conectar().prepareStatement(sql);

            ps.setInt(1, usuarioM.getCODPER());
            ps.setString(2, "B");
            ps.executeUpdate();
            ps.close();

        } catch (Exception e) {

            System.out.println("Error al actualizar USUARIO LOGIN en el Dao");

        }
    }

    public void listarUsuarioTabla(DefaultTableModel modeloTabla, Integer tipo, String dato) throws SQLException, Exception {
        try {

            String sql = "";

            switch (tipo) {
                case 0:
                    sql = "CALL MOSTRAR_USUARIO()";
                    break;
                case 1:
                    sql = "CALL FILTRAR_USUARIO('1', '%" + dato + "%')"; // todos , activado el chkTodos
                    break;
                case 2:
                    sql = "CALL FILTRAR_USUARIO('2', '%" + dato + "%')"; // DNI
                    break;
                case 3:
                    sql = "CALL FILTRAR_USUARIO('3', '%" + dato + "%')"; // Nombre
                    break;
                case 4:
                    sql = "CALL FILTRAR_USUARIO('4', '%" + dato + "%')"; // DNI
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
            System.out.println("Error en Dao USUARIO Listar");
        }

    }

    public boolean validarExistenciaUsuarioLogin(String usuario) throws Exception {

        System.out.println("Dao " + usuario);
        String sql = "CALL VERIFICAR_EXISTENCIA_USUARIO_LOGIN(?);";

        PreparedStatement ps = this.conectar().prepareStatement(sql);
        ps.setString(1, usuario);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            System.out.println("rs : " + rs.getObject(1));
            if (rs.getObject(1).equals(usuario)) {
                return true;
            }
        }
        
        return false;
    }

    public boolean validarExistenciaUsuario(String DNI) throws Exception {

        System.out.println("Dao " + DNI);
        String sql = "CALL VERIFICAR_EXISTENCIA_USUARIO(?);";

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
