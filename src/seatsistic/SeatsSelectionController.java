/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package seatsistic;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author the_k
 */
public class SeatsSelectionController implements Initializable {

    @FXML private AnchorPane DashboardContent;
    @FXML private Button seat1;
    @FXML private ImageView seat1img;
    @FXML private Button seat2;
    @FXML private ImageView seat2img;
    @FXML private Button seat3;
    @FXML private ImageView seat3img;
    @FXML private Button seat4;
    @FXML private ImageView seat4img;
    @FXML private Button seat5;
    @FXML private ImageView seat5img;
    @FXML private Button seat6;
    @FXML private ImageView seat6img;
    @FXML private Button seat7;
    @FXML private ImageView seat7img;
    @FXML private Button seat8;
    @FXML private ImageView seat8img;
    @FXML private Button seat9;
    @FXML private ImageView seat9img;
    Parent root;   

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }   

    public void backButton(ActionEvent event) {
        try{
            root = FXMLLoader.load(getClass().getResource("MatchesList.fxml"));
            DashboardContent.getChildren().removeAll();
            DashboardContent.getChildren().setAll(root);
        }catch(IOException ex) {

        }
    }

    public void showReceipt(ActionEvent event) {
        try{
            FXMLLoader receiptLoader = new FXMLLoader();
            receiptLoader.setLocation(getClass().getResource("Receipt.fxml"));
            DialogPane receiptDialogPane = receiptLoader.load();
            ReceiptController receiptController = receiptLoader.getController();

            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.setDialogPane(receiptDialogPane);
            dialog.setTitle("Seat Reserved");
            Optional<ButtonType> clickedButton = dialog.showAndWait();
        }catch(IOException ex) {

        }
    }
    
}
