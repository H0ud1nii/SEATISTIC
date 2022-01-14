/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package seatsistic;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author the_k
 */
public class AdminDashboardController {
    @FXML
    private Pane DashboardContentBox;
    private Parent FormLoader;
    @FXML
    private AnchorPane DashboardPane;
    Stage stage;
    Scene scene;
    Parent root;


    public void closeButton(ActionEvent event){
        stage = (Stage) DashboardPane.getScene().getWindow();
        stage.close();
    }  
    public void minimizeButton(ActionEvent event){
        stage = (Stage) DashboardPane.getScene().getWindow();
        stage.setIconified(true);
    } 
    public void maximizeButton(ActionEvent event){
        stage = (Stage) DashboardPane.getScene().getWindow();
        if(stage.isMaximized()){
            stage.setMaximized(false);
        }
        else{
            stage.setMaximized(true);
        }
    }   
    
}
