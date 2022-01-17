/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package seatsistic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 * FXML Controller class
 *
 * @author the_k
 */
public class TeamsAdministrationController implements Initializable {

    @FXML private TableColumn<Team, String> TeamLogo;
    @FXML private TableColumn<Team, String> TeamName;
    @FXML private TableColumn<Team, String> TeamDelete;
    @FXML private Button btn_Add;
    @FXML private TableView<Team> teamstableview;
    @FXML private TextField txt_logo;
    @FXML private TextField txt_name;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TeamName.setCellValueFactory(new PropertyValueFactory<>("name"));
        TeamLogo.setCellValueFactory(new PropertyValueFactory<>("logo"));
        TeamDelete.setCellValueFactory(new PropertyValueFactory<>("delete"));
        teamstableview.setItems(getTeamsList());
    }

    ObservableList<Team> getTeamsList() {
        ObservableList<Team> teams = FXCollections.observableArrayList();
        ImageView teamLogo = new ImageView("img/logos/nejme.png");
        Button teamDeleteBtn = new Button("-");
        teamDeleteBtn.setStyle("-fx-background-color: red; -fx-text-fill: white; -fx-background-radius: 50%; -fx-min-width:36.5px; "
                                + "-fx-min-height:36.5px; -fx-max-width:36.5px; -fx-max-height:36.5px;");
        teamLogo.setFitHeight(75);
        teamLogo.setFitWidth(75);
        teams.add(new Team(1, "Nejme SC", teamLogo, teamDeleteBtn));
        return teams;
    }    

    @FXML
    public void logoChooser (ActionEvent event) {

        FileChooser logoChooser = new FileChooser ();
        logoChooser.getExtensionFilters().add(new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
        File logo = logoChooser.showOpenDialog(null);

        if (logo != null){
            txt_logo.setText("file:" + logo.getAbsolutePath());
        }

    }
    
    public void AddTeam(){
        Team team = new Team();
        team.setName(txt_name.getText());
        ImageView teamLogo = new ImageView(txt_logo.getText());
        Button teamDeleteBtn = new Button("-");
        teamDeleteBtn.setStyle("-fx-background-color: red; -fx-text-fill: white; -fx-background-radius: 50%; -fx-min-width:36.5px; "
                                + "-fx-min-height:36.5px; -fx-max-width:36.5px; -fx-max-height:36.5px;");
        teamLogo.setFitHeight(75);
        teamLogo.setFitWidth(75);
        team.setLogo(teamLogo);
        team.setDelete(teamDeleteBtn);
        teamstableview.getItems().add(team);
        txt_name.clear();
        txt_logo.clear();
    } 
}