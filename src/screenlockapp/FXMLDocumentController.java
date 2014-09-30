/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package screenlockapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sun.net.www.http.HttpClient;

/**
 *
 * @author oscar
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML private Text actiontarget;
    @FXML private PasswordField passwordField;
    @FXML private TextField accountField;
    private Stage root;
    
    @FXML
    private void handleSubmitButtonAction(ActionEvent event) {
       String password = passwordField.getText();
       
       String account = accountField.getText();
       actiontarget.setText("");
       if(account.equals("")||password.equals("")){
           actiontarget.setText("account or password not set");
       }else{
           actiontarget.setText("Sign in button pressed");
           //REMOTE LOGIN HERE
       }
        
    }
    @FXML
    private void handleCloseButtonAction(ActionEvent e){
        
        root.close();
    }
    
    void setStageAndSetupListeners(Stage s){
        root =s;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    

    
}
