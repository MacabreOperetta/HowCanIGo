/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgpublic.transport;

import java.io.IOException;
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

/**
 *
 * @author Macabre Operetta
 */
public class Login_ScreenController implements Initializable {
        
    @FXML
    TextField passwordText = new TextField();
    @FXML
    TextField userNameText = new TextField();
    @FXML
    Button loginButton = new Button();
        
    private String userName;
    private String password;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO        
    }    
    
    public boolean CanLogin(String user_name, String pass_word)
    {
        return !(user_name.isEmpty() && pass_word.isEmpty());
    }
    
    public void loginButtonClick(ActionEvent event) throws IOException
    {
        userName = userNameText.getText();
        password= passwordText.getText();
        
        CanLogin(userName,password);
        
            Parent root = FXMLLoader.load(getClass().getResource("Main_Menu.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();
    }
    
    public void signUpButtonClick(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("Sign_Up.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    
}
