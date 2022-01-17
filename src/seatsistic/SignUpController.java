package seatsistic;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author the_k
 */
public class SignUpController implements Initializable {
    
    
    @FXML private TextField tf_first_name, tf_last_name, tf_email_address, tf_username;
    @FXML private PasswordField pf_password, pf_cpassword;
    @FXML private Label l_error, l_success;
    
    private Connection conn;
    private PreparedStatement preparedStatement;
    
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            conn = DatabaseManager.connectToDB();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Could not connect to database: " + ex.getMessage());
        }
    }
    
    private boolean validateRequiredFields(String ...fieldsData){
        for(String i:fieldsData){
            if(i.equals("")){
                return false;
            }
        }
        
        return true;
    }
    
    private boolean validateEmailAddress(String emailAddress) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailAddress);
        
        return matcher.find();
    }
    
    private boolean validateUsernameUnique(String username) throws SQLException{
        String checkUserExistSql = "SELECT id FROM users WHERE username = ?";
        preparedStatement = conn.prepareStatement(checkUserExistSql);
        preparedStatement.setString(1, username);
        
        ResultSet res = preparedStatement.executeQuery();

        return !res.next();
    }
    
    private boolean validatePasswordStrength(String password){
        if(password.length() < 8){
            return false;
        }
        else if(!password.matches("(?=.*[0-9]).*")){
            return false;
        }
        else if(!password.matches("(?=.*[a-z]).*")){
            return false;
        }
        else if(!password.matches("(?=.*[A-Z]).*")){
            return false;
        }
        else if(!password.matches("(?=.*[~!@#$%^&*()_-]).*")){
            return false;
        }
        
        return true;
    }
    

    public void signUp(ActionEvent event) throws SQLException{
        
        String firstName = tf_first_name.getText().trim();
        String lastName = tf_last_name.getText().trim();
        String emailAddress = tf_email_address.getText().trim();
        String username = tf_username.getText().trim().toLowerCase();
        String password = pf_password.getText().trim();
        String confirmPassword = pf_cpassword.getText().trim();
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        
        l_error.setText("");
        l_success.setText("");

        
        if(!validateRequiredFields(firstName, lastName, emailAddress, username, password, confirmPassword)){
            l_error.setText("Please fill in all fields!");
        }
        else if(!validateEmailAddress(emailAddress)){
            l_error.setText("Please enter a valid email address!");
        }
        else if(username.length() < 5){
            l_error.setText("Username should consist of 5 characters at least!");
        }
        else if(!validateUsernameUnique(username)){
            l_error.setText("Username already in use!");
        }
        else if(!validatePasswordStrength(password)){
            l_error.setText("Password should be of 8 characters at least, including lowercase, uppercase, numbers and symbols!");
        }
        else if(!password.equals(confirmPassword)){
            l_error.setText("Password and confirm password do not match!");
        }
        else {
            String insertUserSql = "INSERT INTO users (first_name, last_name, email_address, username, password, is_admin) VALUES (?, ?, ?, ?, ?, ?)";
            
            preparedStatement = conn.prepareStatement(insertUserSql);
            
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, emailAddress);
            preparedStatement.setString(4, username);
            preparedStatement.setString(5, hashedPassword);
            preparedStatement.setBoolean(6, false);

            preparedStatement.executeUpdate();

            tf_first_name.clear();
            tf_last_name.clear();
            tf_email_address.clear();
            tf_username.clear();
            pf_password.clear();
            pf_cpassword.clear();

            l_success.setText("Sign Up Success!");
        }

    }
}
