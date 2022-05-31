package com.project.WebApp.model;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Position")
public class Position {
    @Id
    @Column(name ="posID")
    private String posID;
    @Column(name = "name_Pos")
    private String name_Pos;

    public Position(String posID, String name_Pos) {
        this.posID = posID;
        this.name_Pos = name_Pos;
    }

    public Position() {
    }

    public String getPosID() {
        return posID;
    }

    public void setPosID(String posID) {
        this.posID = posID;
    }

    public String getName_Pos() {
        return name_Pos;
    }

    public void setName_Pos(String name_Pos) {
        this.name_Pos = name_Pos;
    }
}
