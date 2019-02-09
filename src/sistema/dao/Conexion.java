
package sistema.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    protected static Connection cn = null;
    
    public static Connection conectar() throws Exception {
        
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/sistema_venta";
        String user = "root";
        String pwd = "root";
        try {
            Class.forName(driver);
            cn = DriverManager.getConnection(url, user, pwd);
//            if (cn != null) {
//                System.out.println("Si hay conexion");
//            }
        } catch (Exception e) {
            System.out.println("Error en la conexion " + e.getMessage());
        }
        return cn;
    }

    public static void cerrar() throws Exception {
        try {
            if (cn != null) {
                cn.close();
            } else {
                return;
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public static void main(String[] args) throws Exception {
        conectar();
    }
}
