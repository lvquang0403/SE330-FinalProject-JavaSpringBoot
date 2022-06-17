package com.project.WebApp.repository;

import com.project.WebApp.model.ResultSalaryPayment;
import com.project.WebApp.model.SalaryPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SalaryPayRepository extends JpaRepository<SalaryPayment,Long> {
    @Query(value = "select DISTINCT s.staffID, s.full_name, s.phone ,r.name_room, p.name_pos, sp.actReceived " +
            "FROM Staff s, Room r, Position p, SalaryPayment sp " +
            "WHERE s.staffID = sp.staffID and s.roomID = r.roomID and s.posID = p.posID",
            nativeQuery = true)
    Iterable<ResultSalaryPayment> resultSalaryPayment();


    @Query(value = "select DISTINCT s.staffID, s.full_name, s.phone ,r.name_room, p.name_pos, sp.actReceived " +
            "FROM Staff s, Room r, Position p, SalaryPayment sp " +
            "WHERE s.staffID = sp.staffID and s.roomID = r.roomID and s.posID = p.posID and s.roomID = :roomID",
            nativeQuery = true)
    Iterable<ResultSalaryPayment> resultSalaryPaymentByRoomID(@Param("roomID") String roomID);


    //cal sum actReceived
    @Query(value = "select sum(actReceived) from (" +
            " select DISTINCT s.staffID, s.full_name, s.phone ,r.name_room, p.name_pos, sp.actReceived " +
            "FROM Staff s, Room r, Position p, SalaryPayment sp " +
            "WHERE s.staffID = sp.staffID and s.roomID = r.roomID and s.posID = p.posID) t1",
            nativeQuery = true)
    Double sumActReceived();

    @Query(value = "select sum(actReceived) from (" +
            " select DISTINCT s.staffID, s.full_name, s.phone ,r.name_room, p.name_pos, sp.actReceived " +
            "FROM Staff s, Room r, Position p, SalaryPayment sp " +
            "WHERE s.staffID = sp.staffID and s.roomID = r.roomID and s.posID = p.posID and r.roomID = :roomID) t1",
            nativeQuery = true)
    Double sumActReceivedByRoomID(@Param("roomID") String roomID);



    @Query(value = "select top(1) * from SalaryPayment where staffID = :staffID and mon = :mon order by staffID",
    nativeQuery = true)
    Optional<SalaryPayment> findByStaffIDAndMon(@Param("staffID") String staffID,
                                                @Param("mon") int mon);
}
