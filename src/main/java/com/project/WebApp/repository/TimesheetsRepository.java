package com.project.WebApp.repository;

import com.project.WebApp.model.Timesheets;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TimesheetsRepository extends CrudRepository<Timesheets,String> {
    Iterable<Timesheets> findByStaffID(String staffID);
    @Query(value = "select top(1) with ties * from Timesheets where staffID = :staffID and mon = :mon order by yea DESC",
    nativeQuery = true)
    Optional<Timesheets> findByStaffIDAndMon(@Param("staffID") String staffID,
                                             @Param("mon") int mon);

    // find all Timesheet in a month
    @Query(value = "select * from Timesheets where mon = :mon order by yea DESC",
            nativeQuery = true)
    Iterable<Timesheets> findAllByMon(@Param("mon") int mon);

    //find all Timesheet of staff in a room
    @Query(value = "select TS.* " +
            "from Timesheets TS, Staff ST, Room RO " +
            "where  TS.staffID = ST.staffID AND ST.roomID = RO.roomID AND RO.roomID = :roomID AND  " +
            "mon = :mon AND yea = :yea  " +
            "order by yea DESC",
    nativeQuery = true)
    Iterable<Timesheets> findByRoomIDAndMon(@Param("roomID") String roomID,
                                            @Param("mon") int mon,
                                            @Param("yea") int yea);

}
