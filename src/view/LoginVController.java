
package view;

import controlador.LoginC;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;


public class LoginVController implements Initializable {
    
    @FXML
    private TextField txtUser;
    @FXML
    private TextField txtPassword;
    
    @FXML
    private void EntrarLogin(ActionEvent event) throws Exception{
             
        String user = txtUser.getText();
        String Password = txtPassword.getText();
        
        LoginC loginC = new LoginC();
        loginC.cargarVariables(user,Password);
        loginC.Verificar();         
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
