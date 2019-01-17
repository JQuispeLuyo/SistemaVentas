
package controlador;

import view.LoginVController;
import dao.LoginD;
import modelo.LoginM;

public class LoginC {
    
    LoginVController loginV = new LoginVController();
    
    LoginD loginD;
    LoginM loginM;
    
    public LoginC(){
        loginD = new LoginD();
        loginM = new LoginM();
    }
    
    public void cargarVariables(String user, String password){ 
         try {
            loginM.setUser(user);
            loginM.setPassword(password);
        } catch (Exception e) {
            System.out.println("Error en Cargas las variables " + e.getMessage());
        }    
    }
    
    public void Verificar(){
        try {
            loginD.validar(loginM); 
        } catch (Exception e) {
            System.out.println("En en controlador verificar: "+ e.getMessage());
          
        }
 
    }
    
}
