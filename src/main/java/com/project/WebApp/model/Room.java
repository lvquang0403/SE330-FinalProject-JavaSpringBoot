package com.project.WebApp.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Room")
public class Room {
    @Id
    @Column(name = "roomID")
    private String roomID;
    @Column(name ="name_room")
    private String name_room;

    public Room(String roomID, String name_room) {
        this.roomID = roomID;
        this.name_room = name_room;
    }

    public Room() {
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getName_room() {
        return name_room;
    }

    public void setName_room(String name_room) {
        this.name_room = name_room;
    }
}
//    roomID varchar(6) primary key not null,
//        name_room varchar(50) not null