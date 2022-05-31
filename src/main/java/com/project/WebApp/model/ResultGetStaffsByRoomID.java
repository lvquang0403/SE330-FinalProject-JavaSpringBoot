package com.project.WebApp.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

public interface ResultGetStaffsByRoomID {
    String getStaffID();
    String setStaffID();
    String getFull_name();
    String setFull_name();
    boolean getGender();
    boolean setGender();
    int getExperience();
    int setExperience();

    String getPhone();
    String setPhone();
    String getName_Pos();
    String setName_Pos();
    String getRoomID();
    String setRoomID();
    String getName_room();
    String setName_room();

//    staffID, full_name, gender, bod, experience, adr, phone, posID, Room.name_room


}
