
package sistema.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import sistema.modelo.LoginM;

/**
 * @author Jose Luis
 */
public class LoginD extends Conexion {

    public boolean validar(LoginM loginM) throws Exception {
        
//        String sql = "SELECT * FROM user WHERE username=? and password=?";
        String sql = "SELECT CODPER, USEPER, CONPER FROM PERSONA WHERE USEPER=? and CONPER=sha1(md5(?))";
        
        PreparedStatement ps = this.conectar().prepareStatement(sql);
        ps.setString(1, loginM.getUser());
        ps.setString(2, loginM.getPassword());       
        ResultSet rs = ps.executeQuery();   
        if (rs.next()) {
            if(rs.getObject(2).equals(loginM.getUser())){
                loginM.setId((int)rs.getObject(1));
                return true;
            }  
            return false;
        } else {
            return false;
        }      
    }
}
