
package sistema.controlador;

import sistema.dao.LoginD;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sistema.modelo.LoginM;
import javafx.scene.Node;
import javafx.scene.control.Label;
import sistema.view.PanelControl;

public class LoginVController implements Initializable {
    LoginD loginD;
    LoginM loginM;
    
    public LoginVController(){
        loginD = new LoginD();
        loginM = LoginM.getInstance();   
    }
    
    @FXML
    private TextField txtUser;

    @FXML
    private TextField txtPassword;
    
    @FXML
    private Label lblInvalid;
    
    @FXML 
    public Button btnLogin; 
  
    
    
    @FXML
    private void EntrarLogin(ActionEvent event) throws Exception {
        cargarVariables();
        if(Verificar()){
           ((Node) (event.getSource())).getScene().getWindow().hide();
            System.out.println("Usuario correcto");
//            Stage stage = (Stage) btnLogin.getScene().getWindow(); 
//            stage.close(); 
            

//            Parent parent = FXMLLoader.load(getClass().getResource("/sistema/view/admin.fxml"));
//            
//            Stage stage1 = new Stage();
//            Scene scene1 = new Scene(parent);
//            
//            stage1.setScene(scene1);
//            stage1.initStyle( StageStyle.UNDECORATED );
//            stage1.show();
       
            new PanelControl().setVisible(true);
            

        }else{
             System.out.println("Usuario incorrecto");
             txtUser.setText("");
             txtPassword.setText("");
             btnLogin.setText("Login");
             lblInvalid.setVisible(true);
        }

    }
    
    @FXML
    private void CerrarLogin(MouseEvent event) {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblInvalid.setVisible(false);
    }
 
    
    public void cargarVariables(){ 
         try {
            loginM.setUser(txtUser.getText());
            loginM.setPassword(txtPassword.getText());
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
