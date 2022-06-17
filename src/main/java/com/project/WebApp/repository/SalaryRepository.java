package com.project.WebApp.repository;

import com.project.WebApp.model.Salary;
import com.project.WebApp.model.Timesheets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Optional;

@Repository
public interface SalaryRepository extends JpaRepository<Salary,String> {
    @Query(value = "select top(1) * from Salary where staffID = :staffID and applicableDate <= :applicableDate order by applicableDate",
            nativeQuery = true)
    Optional<Salary> findByStaffIDAndYear(@Param("staffID") String staffID,
                                          @Param("applicableDate") Date applicableDate);
}
