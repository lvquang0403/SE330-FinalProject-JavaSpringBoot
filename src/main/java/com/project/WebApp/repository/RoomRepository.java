package com.project.WebApp.repository;

import com.project.WebApp.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoomRepository extends JpaRepository<Room,String> {
    @Query(value = "select roomID from Room")
    Iterable<String> findAllRoomID();

}
