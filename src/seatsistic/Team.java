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

public class Team {
    private int id;
    private String name;
    private ImageView logo;
    private Button delete; 

    public Team(){
        
    }

    public Team(int id, String name, ImageView logo, Button delete) {
        this.id = id;
        this.name = name;
        this.logo = logo;
        this.delete = delete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public ImageView getLogo(){
        return logo;
    }
    
    public void setLogo(ImageView logo) {
        this.logo = logo;
    }

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }
    
}
