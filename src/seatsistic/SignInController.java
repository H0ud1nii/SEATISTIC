package seatsistic;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static seatsistic.GlobalConfiguration.makeSceneMoveable;

/**
 *
 * @author the_k
 */
public class SignInController implements Initializable {
    
    @FXML private TextField tf_username, pf_password;
    @FXML private Label l_error;
    
    private Connection conn;
    private PreparedStatement preparedStatement;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            conn = DatabaseManager.connectToDB();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Could not connect to database: " + ex.getMessage());
        }
    }
    
    public void openAdminDashboard(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("AdminDashboard.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        makeSceneMoveable(root, stage);
        stage.show();
    }

    public void signIn(ActionEvent event) throws ClassNotFoundException, SQLException, IOException{
        String username = tf_username.getText().toLowerCase();
        String password = pf_password.getText();
        
        String checkSignInSuccessSql = "SELECT password FROM users WHERE username = ?";
        preparedStatement = conn.prepareStatement(checkSignInSuccessSql);
        preparedStatement.setString(1, username);
        
        ResultSet res = preparedStatement.executeQuery();

        if(res.next()){
            if(BCrypt.checkpw(password, res.getString("password"))){
                openAdminDashboard(event);
                System.out.println("Sign In Success");

            }
            else {
                l_error.setText("Invalid Username or Password!");
                System.out.println("Sign In Invalid");
            }
        }
        else {
            l_error.setText("Invalid Username or Password!");
            System.out.println("Sign In Invalid");
        }
        
    }
}
