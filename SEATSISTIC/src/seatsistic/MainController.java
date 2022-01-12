package seatsistic;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 *
 * @author the_k
 */
public class MainController implements Initializable {
    
    @FXML
    private VBox FormBox;
    private Parent FormLoader;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TranslateTransition SlideForms = new TranslateTransition(Duration.seconds(1), FormBox);
        SlideForms.setToX(FormBox.getLayoutX() * 31);
        SlideForms.play();
        SlideForms.setOnFinished((e) ->{
            try{
                FormLoader = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
                FormBox.getChildren().removeAll();
                FormBox.getChildren().setAll(FormLoader);
            }catch(IOException ex) {

            }
        });
    }

    public void open_signin(ActionEvent event){
        TranslateTransition SlideForms = new TranslateTransition(Duration.seconds(1), FormBox);
        SlideForms.setToX(FormBox.getLayoutX() * 31);
        SlideForms.play();
        SlideForms.setOnFinished((e) ->{
            try{
                FormLoader = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
                FormBox.getChildren().removeAll();
                FormBox.getChildren().setAll(FormLoader);
            }catch(IOException ex) {

            }
        });
    }    
    public void open_signup(ActionEvent event){
        TranslateTransition SlideForms = new TranslateTransition(Duration.seconds(1), FormBox);
        SlideForms.setToX(0);
        SlideForms.play();
        SlideForms.setOnFinished((e) ->{
            try{
                FormLoader = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
                FormBox.getChildren().removeAll();
                FormBox.getChildren().setAll(FormLoader);
            }catch(IOException ex) {

            }
        });
    }     
}
