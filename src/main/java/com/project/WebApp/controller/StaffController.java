package com.project.WebApp.controller;

import com.project.WebApp.model.ResultGetStaffsByRoomID;
import com.project.WebApp.model.Staff;
import com.project.WebApp.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(path="staffs")
//https:localhost:8080/staffs
public class StaffController {
    @Autowired //dependency injection
    private StaffRepository staffRepository;
    //return name of html file
    @RequestMapping(value="", method = RequestMethod.GET)
    public String getAllStaff(ModelMap modelMap) {
        Iterable<Staff> staffs = staffRepository.findAll();
        modelMap.addAttribute("staffs",staffs);
        //sent data from controller to view
//        modelMap.addAttribute("name","quang");
//        modelMap.addAttribute("age",21);
        return "index";
    }
    //return all staffs in room by roomID
    //https:localhost:8080/staffs/getAllStaffByRoomID/{roomID}
    @RequestMapping(value = "/getAllStaffByRoomID/{roomID}", method = RequestMethod.GET)
    public String getAllStaffByRoomID(ModelMap modelMap, @PathVariable String roomID) {
        Iterable<ResultGetStaffsByRoomID> resultGetStaffsByRoomID = staffRepository.getResultGetStaffsB_yRoomID(roomID);
        modelMap.addAttribute("results",resultGetStaffsByRoomID);
        return "staffsByRoomID";
    }
}
