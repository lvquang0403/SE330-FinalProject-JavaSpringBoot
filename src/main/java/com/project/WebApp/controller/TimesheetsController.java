package com.project.WebApp.controller;

import com.project.WebApp.model.Timesheets;
import com.project.WebApp.repository.StaffRepository;
import com.project.WebApp.repository.TimesheetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Time;

@Controller
@RequestMapping(path = "timesheets")
//https:localhost:8080/timesheets
public class TimesheetsController {
    @Autowired
    private TimesheetsRepository timesheetsRepository;
    @Autowired
    private StaffRepository staffRepository;
    @RequestMapping(value="", method = RequestMethod.GET)
    public String getAllTimesheet(ModelMap modelMap) {
        //get all staffID
        Iterable<String> staffIDs = staffRepository.findAllStaffID();
        Iterable<Timesheets> timesheets = timesheetsRepository.findAll();
        modelMap.addAttribute("timesheets",timesheets);
        modelMap.addAttribute("newTimesheet", new Timesheets());
        modelMap.addAttribute("staffIDs",staffIDs);
        return "getAllTimesheets";
    }
    //insert Timesheet
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String insertTimesheet(@ModelAttribute Timesheets timesheet,
                             ModelMap modelMap){
        modelMap.addAttribute("timesheets",timesheetsRepository.findAll());
        modelMap.addAttribute("newTimesheet", new Timesheets());
        modelMap.addAttribute("staffIDs",staffRepository.findAllStaffID());
        try{
            if(!timesheetsRepository.findById(timesheet.getTimeshID()).isPresent()){
                Timesheets newTimesheet = new Timesheets(timesheet.getTimeshID(),timesheet.getStaffID(),
                        timesheet.getDay_off(),timesheet.getDay_on(),
                        timesheet.getMon(),timesheet.getYea());
                timesheetsRepository.save(newTimesheet);
                return "redirect:/timesheets";
            }
            else {
                modelMap.addAttribute("error","TimesheetID already exits !!");
                return "getAllTimesheets";
            }
        }catch (Exception e){
            modelMap.addAttribute("error",e);
            return "getAllTimesheets";
        }
    }
    //https:localhost:8080/timesheets/getTimesheetsByStaffID/{staffID}
    @RequestMapping(value = "/getTimesheetsByStaffID/{staffID}", method = RequestMethod.GET)
    public String getTimesheetsByStaffID(ModelMap modelMap, @PathVariable String staffID) {
        Iterable<Timesheets> timesheets = timesheetsRepository.findByStaffID(staffID);
        modelMap.addAttribute("timesheets", timesheets);
        return "timesheetsListByID";
    }

//    @RequestMapping(value = "/insertTimesheet", method = RequestMethod.GET)
//    public String insertTimesheet(ModelMap modelMap){
//        modelMap.addAttribute("timesheets",new Timesheets());
//        return "getAllTimesheets";
//    }
    //delete Timesheet
    @RequestMapping(value="/deleteTimesheet/{timeshID}", method = RequestMethod.POST)
    public String deleteRoom(@PathVariable String timeshID) {
        timesheetsRepository.deleteById(timeshID);
        return "redirect:/timesheets";
    }
}
