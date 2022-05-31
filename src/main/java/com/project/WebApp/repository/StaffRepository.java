package com.project.WebApp.repository;

import com.project.WebApp.model.ResultGetStaffsByRoomID;
import com.project.WebApp.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StaffRepository extends JpaRepository<Staff,String> {
    @Query(value = "select s.staffID, s.full_name, s.gender, s.experience, s.phone, p.name_pos,s.roomID, r.name_room " +
            "FROM Staff s, Room r, Position p " +
            "WHERE s.roomID = r.roomID and s.posID = p.posID and s.roomID = :roomID ",
    nativeQuery = true)
    Iterable<ResultGetStaffsByRoomID> getResultGetStaffsB_yRoomID(@Param("roomID") String roomID);
}
