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
import sistema.modelo.ClienteM;

/**
 *
 * @author Jose Luis
 */
public class ClienteD extends Conexion {

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

    public void guardarCliente(ClienteM clienteM) throws Exception {

        try {
//            String sql = "Insert Into PRODUCTO "
//                    + "(CODPRO, DESPRO, CODUNI, PREPRO, CODCAT) "
//                    + "values"
//                    + "(?,?,?,?,?)";

            String sql = "CALL INSERTAR_CLIENTE(?,?,?,?,?,?)";

            PreparedStatement ps = this.conectar().prepareStatement(sql);

            ps.setString(1, clienteM.getNOMPER());
            ps.setString(2, clienteM.getAPEPER());
            ps.setString(3, clienteM.getRUCDNIPER());;
            ps.setString(4, clienteM.getGENPER());;
            ps.setString(5, clienteM.getTIPPER());
            ps.setString(6, clienteM.getESTAPER());

            ps.executeUpdate();
            ps.close();

            JOptionPane.showMessageDialog(null, "Registrado correctamente");
        } catch (Exception e) {

            System.out.println("Error al guardar USUARIO en el Dao");

        }

    }

    public void editarCliente(ClienteM clienteM) throws Exception {

        try {
            String sql = "CALL EDITAR_CLIENTE(?,?,?,?,?,?,?)";

//                        CALL EDITAR_USUARIO_DATOS(12,'Jose Luis1', 'Quispe Luyo', '12345678900','2000/11/19','140409',
//							'Mz. 10 Lt 10','123456789','M','E','A');
            PreparedStatement ps = this.conectar().prepareStatement(sql);

            ps.setInt(1, clienteM.getCODPER());
            ps.setString(2, clienteM.getNOMPER());
            ps.setString(3, clienteM.getAPEPER());
            ps.setString(4, clienteM.getRUCDNIPER());
            ps.setString(5, clienteM.getGENPER());
            ps.setString(6, clienteM.getTIPPER());
            ps.setString(7, clienteM.getESTAPER());
            ps.executeUpdate();
            ps.close();

            JOptionPane.showMessageDialog(null, "Actualización correcta");
        } catch (Exception e) {

            System.out.println("Error al actualizar USUARIO DATOS en el Dao");

        }

    }

    public void eliminarCliente(ClienteM clienteM) throws Exception {

        try {
            String sql = "CALL ELIMINAR_USUARIO(?,?)";

            PreparedStatement ps = this.conectar().prepareStatement(sql);

            ps.setInt(1, clienteM.getCODPER());
            ps.setString(2, "B");
            ps.executeUpdate();
            ps.close();

        } catch (Exception e) {

            System.out.println("Error al actualizar USUARIO LOGIN en el Dao");

        }
    }

    public void listarClienteTabla(DefaultTableModel modeloTabla, Integer tipo, String dato) throws SQLException, Exception {
        try {

            String sql = "";

            switch (tipo) {
                case 0:
                    sql = "CALL MOSTRAR_CLIENTE()";
                    break;
                case 1:
                    sql = "CALL FILTRAR_CLIENTE('1', '%" + dato + "%')"; // Nombre
                    break;
                case 2:
                    sql = "CALL FILTRAR_CLIENTE('2', '%" + dato + "%')"; // Apellido
                    break;
                case 3:
                    sql = "CALL FILTRAR_CLIENTE('3', '%" + dato + "%')"; // DNI
                    break;
                case 4:
                    sql = "CALL FILTRAR_CLIENTE('4', '%" + dato + "%')"; // Codigo
                    break;
                case 5:
                    sql = "CALL FILTRAR_CLIENTE('5', '%" + dato + "%')"; // Inactivos
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

    public boolean validarExistenciaCliente(String DNI) throws Exception {

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
