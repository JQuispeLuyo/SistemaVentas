
package sistema.controlador;

import sistema.dao.LoginD;
import sistema.modelo.LoginM;

public class LoginC {
    
    LoginVController loginV = new LoginVController();
    
    LoginD loginD;
    LoginM loginM;
    
    public LoginC(){
        loginD = new LoginD();
        loginM = LoginM.getInstance();
    }
    
    public void cargarVariables(String user, String password){ 
         try {
            loginM.setUser(user);
            loginM.setPassword(password);
        } catch (Exception e) {
            System.out.println("Error en Cargas las variables " + e.getMessage());
        }    
    }
    
    public boolean Verificar(){
        try {
            if(loginD.validar(loginM)){
                return true;
            }    
        } catch (Exception e) {
            System.out.println("En en controlador verificar: "+ e.getMessage());   
        }      
        return false;
    }
    
}
