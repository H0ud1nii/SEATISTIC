/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package seatsistic;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author the_k
 */
public class MatchesListController implements Initializable {
    
    @FXML private AnchorPane InternalSceneContainer;
    @FXML private ScrollPane scrollPane;
    @FXML private AnchorPane scrollAnchor;
    @FXML private Button MatchContainerButton;
    @FXML private AnchorPane MatchContainer;
    @FXML private Label DateContainer;
    @FXML private Label TimeContainer;
    @FXML private Label HomeTeam;
    @FXML private ImageView HomeLogo;
    @FXML private ImageView VS;
    @FXML private Label AwayTeam;
    @FXML private ImageView AwayLogo;
    Parent root;
    Stage stage;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // The Design is like 90% done from fxml to javaFx enta 3lek tzbtn metl ma badk mechen l loop li bdk ta3mela bass ana khl2telak l nodes li 3ayezn ma3 size tb3n
        // w positionning (ma 3ada l z-index)
        ScrollPane scrollPane = new ScrollPane(); // Making scroll pane
        scrollPane.setPrefSize(1280, 625); // sizing scroll Pane 
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER); //turning off horizontal scrol bar
        
        AnchorPane scrollAnchor = new AnchorPane(); // making anchor pane
        scrollAnchor.setPrefWidth(1280); //sizing anchor pane

        Button MatchContainerButton = new Button(); //making button
        MatchContainerButton.setPrefSize(1280, 170); //sizin button
        scrollAnchor.setLeftAnchor(MatchContainerButton, 0.0); // locking button in position
        scrollAnchor.setRightAnchor(MatchContainerButton, 0.0);
        MatchContainerButton.setStyle("-fx-background-color: #F5F5F5;");

        AnchorPane MatchContainer = new AnchorPane(); // making anchor pane to set graphics inside button
        MatchContainer.setPrefSize(1280, 170); // sizing anchor pane
        MatchContainer.setStyle("-fx-border-color: #34AF72; -fx-border-width: 0px 0px 2px 2px;");

        Label DateContainer = new Label("1/18/2022"); //making Date Label
        DateContainer.setLayoutX(15); // positioning Date Label
        DateContainer.setLayoutY(68);
        DateContainer.setFont(Font.font("System", FontWeight.BOLD, 24)); // setting Label font
        MatchContainer.setLeftAnchor(DateContainer, 15.0); // locking label in position
        DateContainer.setStyle("-fx-text-fill: #208251;");

        Label TimeContainer = new Label("9:45 PM"); //making time Label
        TimeContainer.setLayoutX(42); //positioning time Label
        TimeContainer.setLayoutY(99);
        TimeContainer.setFont(Font.font("System", 18)); // swtting label font
        MatchContainer.setLeftAnchor(TimeContainer, 42.0); // locking label in position
        TimeContainer.setStyle("-fx-text-fill: #208251;");

        ImageView VS = new ImageView("file:C:\\Users\\the_k\\OneDrive\\Documents\\NetBeansProjects\\SEATSISTIC\\src\\img\\VS.png"); // same comments ta2riban
        VS.setFitHeight(164);
        VS.setFitWidth(767);
        VS.setLayoutX(248.5);
        VS.setLayoutY(14);
        MatchContainer.setLeftAnchor(VS, 249.5);
        MatchContainer.setRightAnchor(VS, 249.5);
        MatchContainer.setBottomAnchor(VS, 5.0);
        VS.toBack(); // trying to change the z-index of the images so the VS image go back wel be2e fw2a bass ma zbtit hyde trktlk yeha elk 

        Label HomeTeam = new Label("Al Ahed");
        HomeTeam.setLayoutX(257);
        HomeTeam.setLayoutY(105);
        HomeTeam.setFont(Font.font("System", FontWeight.BOLD, 36));
        MatchContainer.setLeftAnchor(HomeTeam, 260.0);
        HomeTeam.setStyle("-fx-text-fill: #F5F5F5;");
        HomeTeam.toFront();

        Label AwayTeam = new Label("Nejme SC");
        AwayTeam.setLayoutX(885);
        AwayTeam.setLayoutY(105);
        AwayTeam.setFont(Font.font("System", FontWeight.BOLD, 36));
        MatchContainer.setRightAnchor(AwayTeam, 260.0);
        AwayTeam.setStyle("-fx-text-fill: #F5F5F5;");
        AwayTeam.toFront();

        ImageView HomeLogo = new ImageView("file:C:\\Users\\the_k\\OneDrive\\Documents\\NetBeansProjects\\SEATSISTIC\\src\\img\\logos\\al_ahed.png");
        HomeLogo.setFitHeight(120);
        HomeLogo.setFitWidth(120);
        HomeLogo.setLayoutX(415);
        HomeLogo.setLayoutY(25);
        MatchContainer.setLeftAnchor(HomeLogo, 460.0);
        MatchContainer.setTopAnchor(HomeLogo, 25.0);
        HomeLogo.toFront();

        ImageView AwayLogo = new ImageView("file:C:\\Users\\the_k\\OneDrive\\Documents\\NetBeansProjects\\SEATSISTIC\\src\\img\\logos\\nejme.png");
        AwayLogo.setFitHeight(120);
        AwayLogo.setFitWidth(120);
        AwayLogo.setLayoutX(720);
        AwayLogo.setLayoutY(25);
        MatchContainer.setRightAnchor(AwayLogo, 460.0);
        MatchContainer.setTopAnchor(AwayLogo, 25.0);
        AwayLogo.toFront();

        scrollPane.setContent(scrollAnchor); // putting the anchor pane inside the scroll pane so the anchor pane bi sir 3nda scroll bar
        scrollAnchor.getChildren().add(MatchContainerButton); // puttin the button  inside the anchor pane
        MatchContainerButton.setGraphic(new AnchorPane(MatchContainer)); // setting the anchor pane that hold the graphic inside a button mechen tir clickable
        MatchContainer.getChildren().addAll(DateContainer, TimeContainer, HomeTeam, HomeLogo, AwayTeam, AwayLogo, VS);
}


public void openStadium(ActionEvent event){
        RotateTransition RotateStadium = new RotateTransition(Duration.seconds(1), InternalSceneContainer);
        RotateStadium.setByAngle(360);
        ScaleTransition ZoomStadium = new ScaleTransition(Duration.seconds(1), InternalSceneContainer);
        RotateStadium.play();
        RotateStadium.setOnFinished((e) ->{
            try{
                root = FXMLLoader.load(getClass().getResource("StadiumMain.fxml"));
                InternalSceneContainer.getChildren().removeAll();
                InternalSceneContainer.getChildren().setAll(root);
                ZoomStadium.setByX(1.5);
                ZoomStadium.setByY(1.5);
                ZoomStadium.play();
                ZoomStadium.setOnFinished((z) ->{
                    try{
                        root = FXMLLoader.load(getClass().getResource("StadiumSection.fxml"));
                        InternalSceneContainer.getChildren().removeAll();
                        InternalSceneContainer.getChildren().setAll(root);
                        ZoomStadium.setToX(1);
                        ZoomStadium.setToY(1);
                        ZoomStadium.play();
                        ZoomStadium.setOnFinished((q) ->{
                            try{
                                root = FXMLLoader.load(getClass().getResource("SeatsSelection.fxml"));
                                InternalSceneContainer.getChildren().removeAll();
                                InternalSceneContainer.getChildren().setAll(root);
                            }catch(IOException ex) {

                            }
                        });
                    }catch(IOException ex) {

                    }
                });
            }catch(IOException ex) {

            }
        });
        

    }
 
    
}
