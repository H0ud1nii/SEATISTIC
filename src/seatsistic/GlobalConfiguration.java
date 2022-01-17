/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seatsistic;

import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class GlobalConfiguration {
   
    public static double xNull = 0;
    public static double yNull = 0;
   
    public static void makeSceneMoveable(Parent root, Stage stage){
        root.setOnMousePressed((MouseEvent event) -> {
            xNull = event.getSceneX();
            yNull = event.getSceneY();
        });
        root.setOnMouseDragged((MouseEvent event) -> {
            stage.setX(event.getScreenX() - xNull);
            stage.setY(event.getScreenY() - yNull);
        }); 
    }
}
