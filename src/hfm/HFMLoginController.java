
package hfm;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HFMLoginController {

    @FXML private TextField nameField;
    @FXML private PasswordField passField;
    @FXML private Button loginButton;
    @FXML private Button newButton;
    @FXML private Label warningLabel;

    String Name;
    String Password;
    Logon log;
    Fund player;
    
    public HFMLoginController(){
        log = new Logon();        
    }
    
    @FXML void loginButtonAction(ActionEvent event) {
        if(nameField.getText().equals("")) {
            warningLabel.setText("Please enter or create an Account.");
            return;
        }
        if(passField.getText().equals("")) {
            warningLabel.setText("Please enter a password.");
            return;
        }
        warningLabel.setText("");        
        Name = nameField.getText();
        Password = passField.getText();
        player = log.login(Name,Password);
        if(player != null){                      
            HFM.player = player;   
            Stage stage2 = new Stage();
            Parent root2;            
            try {
                root2 = FXMLLoader.load(getClass().getResource("HFM.fxml"));                
                Scene scene2 = new Scene(root2,1200,800);
                stage2.setTitle("Hedge Fund Manager ~ " + HFM.VERSION);
                stage2.setScene(scene2);
                stage2.show();
                
                ((Node)(event.getSource())).getScene().getWindow().hide();                
            } catch (IOException e) {
                e.printStackTrace();
            }                        
        }else{
            passField.clear();
            warningLabel.setText("Account not found! Retry or create account.");           
        }
    }

    @FXML  void newButtonAction(ActionEvent event) {
        if(nameField.getText().equals("")) return;
         Name = nameField.getText();
         Password = passField.getText();
         boolean ok = log.newFund(Name,Password);
         if(ok == true)warningLabel.setText("Account Created: " + Name);
         else warningLabel.setText("Account " + Name + " already exists.");
    }

}
