
package sistema;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @author Jose Luis
 */
public class LoginFx extends Application {
 
    private Stage primaryStage;
    
    @Override
    public void start(Stage stage) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("/sistema/view/loginV.fxml"));
        
        
        this.primaryStage = stage;
        this.primaryStage.initStyle( StageStyle.UNDECORATED );
        
        Scene scene = new Scene(root);
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
