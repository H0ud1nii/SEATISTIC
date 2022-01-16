/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package seatsistic;

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

/**
 * FXML Controller class
 *
 * @author the_k
 */
public class TeamsAdministrationController implements Initializable {

    @FXML private TableColumn<Team, String> TeamLogo;

    @FXML private TableColumn<Team, String> TeamName;

    @FXML private Button btn_Add;

    @FXML private TableView<Team> teamstableview;

    @FXML private TextField txt_logo;

    @FXML private TextField txt_name;

   /* @Override
     public void initialize(URL url, ResourceBundle rb) {
        TeamName.setCellValueFactory(new PropertyValueFactory<>("name"));
        TeamLogo.setCellValueFactory(new PropertyValueFactory<>("logo"));
        teamstableview.setItems(getTeamsList());
    }

    ObservableList<Team> getTeamsList() {
        ObservableList<Team> teams = FXCollections.observableArrayList();
        teams.add(new Team("Team 1", "Team 1 Logo"));
        return teams;
    }    
    
    public void AddTeam(){
        Team team = new Team();
        team.setName(txt_name.getText());
        team.setLogo(txt_logo.getText());
        teamstableview.getItems().add(team);
        txt_name.clear();
        txt_logo.clear();
    } */



      @Override
     public void initialize(URL url, ResourceBundle rb) {
        TeamName.setCellValueFactory(new PropertyValueFactory<>("teamName"));
        TeamLogo.setCellValueFactory(new PropertyValueFactory<>("teamLogo"));
        teamstableview.setItems(getTeamsList());
    }

    ObservableList<Team> getTeamsList() {
        ObservableList<Team> teams = FXCollections.observableArrayList();
        ImageView teamLogo = new ImageView("file:Al-Ahed.png");
        teams.add(new Team("Team 1", teamLogo));
        return teams;
    }    
    
    public void AddTeam(){
        Team team = new Team();
        team.setName(txt_name.getText());
        ImageView teamLogo = new ImageView(txt_logo.getText());
        team.setLogo(teamLogo);
        teamstableview.getItems().add(team);
        txt_name.clear();
        txt_logo.clear();
    } 
}