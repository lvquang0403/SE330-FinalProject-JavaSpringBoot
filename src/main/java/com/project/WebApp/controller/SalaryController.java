package com.project.WebApp.controller;

import com.project.WebApp.model.Salary;
import com.project.WebApp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(path = "salary")
public class SalaryController {
    //dependency ịnjection
    @Autowired
    private SalaryRepository salaryRepository;
    @Autowired
    private SalaryPayRepository salaryPayRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private TimesheetsRepository timesheetsRepository;

    //insert new a salary
    //localhost:8080/rooms/insertSalary
    @RequestMapping(value = "/insertSalary", method = RequestMethod.POST)
    public String insertRoom(@ModelAttribute Salary salary,
                             ModelMap modelMap){
        modelMap.addAttribute("salaryOfStaffs", salaryRepository.findAll());
        modelMap.addAttribute("newSalary",new Salary());
        modelMap.addAttribute("staffIDs", staffRepository.findAllStaffID());
        try{
            if(!roomRepository.findById(salary.getSalaryID()).isPresent()){
                Salary newSalary = new Salary(salary.getSalaryID(),salary.getStaffID(),salary.getBasicSalary(),salary.getApplicableDate());
                salaryRepository.save(newSalary);
                return "redirect:/salary/insertSalary";
            }
            else {
                modelMap.addAttribute("error","SalaryID already exits !!");
                return "insertSalary";
            }
        }catch (Exception e){
            modelMap.addAttribute("error",e);
            return "insertSalary";
        }
    }
    //overloading
    @RequestMapping(value = "/insertSalary", method = RequestMethod.GET)
    public String insertSalary(ModelMap modelMap){
        modelMap.addAttribute("salaryOfStaffs", salaryRepository.findAll());
        modelMap.addAttribute("newSalary",new Salary());
        modelMap.addAttribute("staffIDs", staffRepository.findAllStaffID());
        return "insertSalary";
    }
    //delete room
    //localhost:8080/salary/deleteSalary/{salaryID}
    @RequestMapping(value="/deleteSalary/{salaryID}", method = RequestMethod.POST)
    public String deleteSalary(@PathVariable String salaryID) {
        salaryRepository.deleteById(salaryID);
        return "redirect:/salary/insertSalary";
    }


    //localhost:8080/getSalary
    @RequestMapping(value = "/getSalary",method = RequestMethod.GET)
    public String getHomeSalary(ModelMap modelMap) {
        modelMap.addAttribute("roomIDs",roomRepository.findAllRoomID());
        modelMap.addAttribute("staffIDs",staffRepository.findAllStaffID());
        return "salaryMenu";
    }
}
