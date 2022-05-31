package com.project.WebApp.repository;

import com.project.WebApp.model.Timesheets;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TimesheetsRepository extends CrudRepository<Timesheets,String> {
    Iterable<Timesheets> findByStaffID(String staffID);
}
