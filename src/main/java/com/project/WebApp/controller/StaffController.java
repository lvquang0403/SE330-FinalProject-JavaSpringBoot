package com.project.WebApp.controller;

import com.project.WebApp.model.ResultGetStaffsByRoomID;
import com.project.WebApp.model.Staff;
import com.project.WebApp.repository.PositionRepository;
import com.project.WebApp.repository.RoomRepository;
import com.project.WebApp.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path="staffs")
//https:localhost:8080/staffs
public class StaffController {
    @Autowired //dependency injection
    private StaffRepository staffRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private PositionRepository positionRepository;
    //return name of html file
    @RequestMapping(value="", method = RequestMethod.GET)
    public String getAllStaff(ModelMap modelMap) {
        Iterable<Staff> staffs = staffRepository.findAll();
        modelMap.addAttribute("staffs",staffs);
        //sent data from controller to view
//        modelMap.addAttribute("name","quang");
//        modelMap.addAttribute("age",21);
        return "getAllStaffs";
    }
    //return all staffs in a room by roomID
    //https:localhost:8080/staffs/getAllStaffByRoomID/{roomID}
    @RequestMapping(value = "/getAllStaffByRoomID/{roomID}", method = RequestMethod.GET)
    public String getAllStaffByRoomID(ModelMap modelMap, @PathVariable String roomID) {
        Iterable<ResultGetStaffsByRoomID> resultGetStaffsByRoomID = staffRepository.getResultGetStaffsB_yRoomID(roomID);
        modelMap.addAttribute("results",resultGetStaffsByRoomID);
        return "staffsByRoomID";
    }
    //insert a new Staff
    //https:localhost:8080/staffs/insertStaff
    @RequestMapping(value = "/insertStaff", method = RequestMethod.GET)
    public String insertStaff(ModelMap modelMap) {
        modelMap.addAttribute("rooms",roomRepository.findAll());
        modelMap.addAttribute("positions",positionRepository.findAll());
        modelMap.addAttribute("staff", new Staff());
        return "insertStaff";
    }

    @RequestMapping(value = "/insertStaff", method = RequestMethod.POST)
    public String insertStaff(@ModelAttribute Staff staff,
                              ModelMap modelMap) {
        if (!staffRepository.findById(staff.getStaffID()).isPresent()) {
            staffRepository.save(new Staff(staff.getStaffID(),
                    staff.getFull_name(),
                    staff.isGender(),
                    staff.getBod(),
                    staff.getExperience(),
                    staff.getAdr(),
                    staff.getPhone(),
                    staff.getPosID(),
                    staff.getRoomID()));
            return "redirect:./";
        } else {
            modelMap.addAttribute("rooms",roomRepository.findAll());
            modelMap.addAttribute("positions",positionRepository.findAll());
            modelMap.addAttribute("staff", new Staff());
            modelMap.addAttribute("error","staffID already exits !!");
            return "insertStaff";
        }
    }
    //edit any attribute of a staff
    //https:localhost:8080/staffs/editAtbOfStaff/
    @RequestMapping(value = "/editAtbOfStaff/{staffID}", method = RequestMethod.GET)
    public String editAtbOfStaff(ModelMap modelMap, @PathVariable String staffID) {
        Optional<Staff> staff = staffRepository.findById(staffID);
        modelMap.addAttribute("staff", staff);
        return "editAtbOfStaff";
    }

    @RequestMapping(value = "/updateAtbOfStaff/{staffID}", method = RequestMethod.POST)
    public String editAtbOfStaff(@ModelAttribute("staff") Staff staff,
                                 @PathVariable String staffID,
                                 ModelMap modelMap) {
        if(staffRepository.findById(staffID).isPresent()) {
            Staff foundStaff = staffRepository.findById(staffID).get();
            if (!staff.getStaffID().trim().isEmpty()) {
                foundStaff.setStaffID(staff.getStaffID());
            }
            if (!staff.getFull_name().trim().isEmpty()) {
                foundStaff.setFull_name(staff.getFull_name());
            }
            if (!staff.getStaffID().trim().isEmpty()) {
                foundStaff.setStaffID(staff.getStaffID());
            }

            foundStaff.setGender(staff.isGender());

            if (staff.getBod()!=null) {
                foundStaff.setBod(staff.getBod());
            }

            foundStaff.setExperience(staff.getExperience());
            if (!staff.getAdr().trim().isEmpty()) {
                foundStaff.setAdr(staff.getAdr());
            }
            if (!staff.getPhone().trim().isEmpty()) {
                foundStaff.setPhone(staff.getPhone());
            }if (!staff.getPosID().trim().isEmpty()) {
                foundStaff.setPosID(staff.getPosID());
            }
            if (!staff.getRoomID().trim().isEmpty()) {
                foundStaff.setRoomID(staff.getRoomID());
            }
            staffRepository.save(foundStaff);

        }
        //back to Staffs lists
        return "redirect:../";
    }
    //delete a staff
    @RequestMapping(value="/deleteStaff/{staffID}", method = RequestMethod.POST)
    public String deleteRoom(@PathVariable String staffID) {
        staffRepository.deleteById(staffID);
        return "redirect:/staffs";
    }

}
