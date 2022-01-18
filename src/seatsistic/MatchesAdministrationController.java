/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package seatsistic;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author the_k
 */
public class MatchesAdministrationController implements Initializable {

    @FXML private TableColumn<Match, String> FirstLogo;
    @FXML private TableColumn<Match, String> FirstName;
    @FXML private TableColumn<Match, String> SecondLogo;
    @FXML private TableColumn<Match, String> SecondName;
    @FXML private TableColumn<Match, String> MatchDate;
    @FXML private TableColumn<Match, String> MatchTime;
    @FXML private TableColumn<Match, String> TeamDelete;
    @FXML private TextField txt_first_team;
    @FXML private TextField txt_second_team;
    @FXML private DatePicker txt_date;
    @FXML private TextField txt_time;
    @FXML private Button btn_Create;
    @FXML private TableView<Match> matchestableview;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FirstName.setCellValueFactory(new PropertyValueFactory<>("name1"));
        FirstLogo.setCellValueFactory(new PropertyValueFactory<>("logo1"));
        SecondName.setCellValueFactory(new PropertyValueFactory<>("name2"));
        SecondLogo.setCellValueFactory(new PropertyValueFactory<>("logo2"));
        MatchDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        MatchTime.setCellValueFactory(new PropertyValueFactory<>("time"));
        TeamDelete.setCellValueFactory(new PropertyValueFactory<>("delete"));
        matchestableview.setItems(getMatchesList());
    } 

    ObservableList<Match> getMatchesList() {
        ObservableList<Match> matches = FXCollections.observableArrayList();
        ImageView teamLogo1 = new ImageView("img/logos/nejme.png");
        ImageView teamLogo2 = new ImageView("img/logos/al_ahed.png");
        Button teamDeleteBtn = new Button("-");
        teamDeleteBtn.setStyle("-fx-background-color: red; -fx-text-fill: white; -fx-background-radius: 50%; -fx-min-width:36.5px; "
                                + "-fx-min-height:36.5px; -fx-max-width:36.5px; -fx-max-height:36.5px;");
        teamLogo1.setFitHeight(75);
        teamLogo1.setFitWidth(75);
        teamLogo2.setFitHeight(75);
        teamLogo2.setFitWidth(75);
        matches.add(new Match(1, "Nejme SC", teamLogo1, "Al Ahed", teamLogo2, "1/29/22", "9:45 PM", teamDeleteBtn));
        return matches;
    }
    
    public void CreateMatch(){
        Match match = new Match();
        match.setFirstTeamName(txt_first_team.getText());
        match.setSecondTeamName(txt_second_team.getText());
        ImageView teamLogo1 = new ImageView("img/logos/nejme.png");
        ImageView teamLogo2 = new ImageView("img/logos/al_ahed.png");
        LocalDate matchDate = txt_date.getValue();
        String fromattedDate = matchDate.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        match.setDate(fromattedDate);
        match.setTime(txt_time.getText());
        Button teamDeleteBtn = new Button("-");
        teamDeleteBtn.setStyle("-fx-background-color: red; -fx-text-fill: white; -fx-background-radius: 50%; -fx-min-width:36.5px; "
                                + "-fx-min-height:36.5px; -fx-max-width:36.5px; -fx-max-height:36.5px;");
        teamLogo1.setFitHeight(75);
        teamLogo1.setFitWidth(75);
        teamLogo2.setFitHeight(75);
        teamLogo2.setFitWidth(75);
        match.setFirstTeamLogo(teamLogo1);
        match.setSecondTeamLogo(teamLogo2);
        match.setDelete(teamDeleteBtn);
        matchestableview.getItems().add(match);
        txt_first_team.clear();
        txt_second_team.clear();
        txt_date.getEditor().clear();
        txt_time.clear();
    } 
    
}
