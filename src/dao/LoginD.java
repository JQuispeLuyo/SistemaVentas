
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.LoginM;

/**
 * @author Jose Luis
 */
public class LoginD extends Conexion {

    public void validar(LoginM loginM) throws Exception {
         
        String sql = "SELECT * FROM user WHERE username=? and password=?";
        
        PreparedStatement ps = this.conectar().prepareStatement(sql);
        ps.setString(1, loginM.getUser());
        ps.setString(2, loginM.getPassword());       
        ResultSet rs = ps.executeQuery();   
        if (rs.next()) {
            System.out.println("Entro pe :D, amen c:");
        } else {
            System.out.println("La gacas :v");
        }      
   
    }

}
