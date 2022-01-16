/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seatsistic;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.ImageView;

/**
 *
 * @author the_k
 */

/* public class Team {
    String teamName;
    String teamLogo;


    public Team() {
        
    }
    public Team(String teamname, String teamlogo) {
        super();
        this.teamName = teamname;
        this.teamLogo = teamlogo;
    }
    public String getName(){
        return teamName;
    }
    public void setName(String teamname) {
        this.teamName = teamname;
    }
    public String getLogo(){
        return teamLogo;
    }
    public void setLogo(String teamlogo) {
        this.teamLogo = teamlogo;
    }  */


    public class Team {
    String teamName;
    ImageView teamLogo; 

    public Team() {

    }

    public Team(String teamname, ImageView teamlogo) {
        this.teamName = teamname;
        this.teamLogo = teamlogo;
    }
    public String getName(){
        return teamName;
    }
    public void setName(String teamname) {
        this.teamName = teamname;
    }
    public ImageView getLogo(){
        return teamLogo;
    }
    public void setLogo(ImageView teamlogo) {
        this.teamLogo = teamlogo;
    } 

}
