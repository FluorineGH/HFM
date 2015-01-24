/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hfm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author jcalvert
 */
public class HFM extends Application {
    
    public static String VERSION = "Version ~ 0.1";
    public static Fund player;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("HFMLogin.fxml"));       
        Scene scene = new Scene(root,400,300);
        stage.setTitle("Hedge Fund Manager ~ " + VERSION);
        stage.setScene(scene);
        stage.show();       
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
