package com.project.WebApp.controller;

import com.project.WebApp.model.Timesheets;
import com.project.WebApp.repository.TimesheetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "timesheets")
//https:localhost:8080/timesheets
public class TimesheetsController {
    @Autowired
    private TimesheetsRepository timesheetsRepository;
    @RequestMapping(value="", method = RequestMethod.GET)
    public String getAllTimesheet(ModelMap modelMap) {
        Iterable<Timesheets> timesheets = timesheetsRepository.findAll();
        modelMap.addAttribute("timesheets",timesheets);
        return "timesheetsListByID";
    }
    //https:localhost:8080/timesheets/getTimesheetsByStaffID/{staffID}
    @RequestMapping(value = "/getTimesheetsByStaffID/{staffID}", method = RequestMethod.GET)
    public String getTimesheetsByStaffID(ModelMap modelMap, @PathVariable String staffID) {
        Iterable<Timesheets> timesheets = timesheetsRepository.findByStaffID(staffID);
        modelMap.addAttribute("timesheets", timesheets);
        return "timesheetsListByID";
    }
}
