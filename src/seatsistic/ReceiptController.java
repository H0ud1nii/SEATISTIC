/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package seatsistic;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author the_k
 */
public class ReceiptController implements Initializable {

    @FXML private ImageView AwayLogo;
    @FXML private Label AwayTeam;
    @FXML private Label DateOfPurchase;
    @FXML private DialogPane DialogPane;
    @FXML private Label EmailAddress;
    @FXML private Label FirstName;
    @FXML private ImageView HomeLogo;
    @FXML private Label HomeTeam;
    @FXML private Label LastName;
    @FXML private AnchorPane ListPane;
    @FXML private Label MatchID;
    @FXML private Label NumberOfSeats;
    @FXML private Label PricePerSeat;
    @FXML private Label TotalPrice;
    @FXML private Label Username;
    @FXML private Label invoiceNumber;
    Stage stage;
    Scene scene;
    Parent root;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }


    public void closeButton(ActionEvent event){
            stage = (Stage) ListPane.getScene().getWindow();
            stage.close();
        }  
    
}
