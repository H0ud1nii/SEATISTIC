/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seatsistic;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

/**
 *
 * @author the_k
 */
public class Match {
    private int id;
    private String name1;
    private ImageView logo1;
    private String name2;
    private ImageView logo2;
    private String date;
    private String time;
    private Button delete;

    public Match() {

    }

    public Match(int id, String name1, ImageView logo1, String name2, ImageView logo2, String date, String time, Button delete){
        this.id = id;
        this.name1 = name1;
        this.logo1= logo1;
        this.name2 = name2;
        this.logo2 = logo2;
        this.date = date;
        this.time = time;
        this.delete = delete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstTeamName(){
        return name1;
    }
    
    public void setFirstTeamName(String name1) {
        this.name1 = name1;
    }
    
    public ImageView getFirstTeamLogo(){
        return logo1;
    }
    
    public void setFirstTeamLogo(ImageView logo1) {
        this.logo1 = logo1;
    }

    public String getSecondTeamName(){
        return name2;
    }
    
    public void setSecondTeamName(String name2) {
        this.name2 = name2;
    }
    
    public ImageView getSecondTeamLogo(){
        return logo2;
    }
    
    public void setSecondTeamLogo(ImageView logo2) {
        this.logo2 = logo2;
    }

    public String getDate(){
        return date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }

    public String getTime(){
        return time;
    }
    
    public void setTime(String time) {
        this.time = time;
    }

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }



}
