package ca.usherbrooke.gegi.server.business;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import java.security.Principal;
import java.sql.*;
import java.util.ArrayList;

public class Notification {
    String date = null, description, lien, id;
    int expediteurId;

    public void setDate(String date){
        this.date = date;
    }
    public String getDate(){
        return date;
    }

    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return description;
    }
    public void setLien(String lien){
        this.lien = lien;
    }
    public String getLien(){
        return lien;
    }
    public void setId(String id){ this.id = id; }
    public String getId(){
        return id;
    }
    public void setExpediteurId(int expediteurId){ this.expediteurId = expediteurId;}
    public int getExpediteurId(){return expediteurId;}
    // public String getTitre(){return id;}
}