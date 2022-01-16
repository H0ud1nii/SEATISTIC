/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package seatsistic;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author the_k
 */
public class AdminDashboardController implements Initializable {
    @FXML
    private AnchorPane DashboardContentBox;
    @FXML
    private AnchorPane DashboardPane;
    Stage stage;
    Scene scene;
    Parent root;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
            try{
                root = FXMLLoader.load(getClass().getResource("TeamsAdministration.fxml"));
                DashboardContentBox.getChildren().removeAll();
                DashboardContentBox.getChildren().setAll(root);
            }catch(IOException ex) {

            }
    }

    public void openTeamsAdmin(ActionEvent event) throws IOException{
        try{
                root = FXMLLoader.load(getClass().getResource("TeamsAdministration.fxml"));
                DashboardContentBox.getChildren().removeAll();
                DashboardContentBox.getChildren().setAll(root);
            }catch(IOException ex) {

            }
    }
    public void openLeagueAdmin(ActionEvent event) throws IOException{
        try{
                root = FXMLLoader.load(getClass().getResource("LeagueAdministration.fxml"));
                DashboardContentBox.getChildren().removeAll();
                DashboardContentBox.getChildren().setAll(root);
            }catch(IOException ex) {

            }
    }


    public void closeButton(ActionEvent event){
        stage = (Stage) DashboardPane.getScene().getWindow();
        stage.close();
    }  
    public void minimizeButton(ActionEvent event){
        stage = (Stage) DashboardPane.getScene().getWindow();
        stage.setIconified(true);
    }  
    
}
