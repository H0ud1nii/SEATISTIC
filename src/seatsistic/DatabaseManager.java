/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seatsistic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class DatabaseManager {
    
   public static Connection connectToDB() throws ClassNotFoundException, SQLException {
       String host = "localhost";
       String username = "root";
       String password = "";
        
       // Load the JDBC driver
       Class.forName("com.mysql.cj.jdbc.Driver");
       System.out.println("Driver loaded");

        // Establish a connection
       Connection connection = DriverManager
                .getConnection("jdbc:mysql://" + host + "/seatsistic?"
                        + "user=" + username + "&password=" + password);

       System.out.println("Database connected");

       return connection;

    }
    
}
