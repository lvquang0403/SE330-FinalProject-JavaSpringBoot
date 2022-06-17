package com.project.WebApp.controller;

import com.project.WebApp.model.Degree;
import com.project.WebApp.repository.DegreeRepository;
import com.project.WebApp.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
@RequestMapping(path = "degrees")
public class DegreeController {
    @Autowired //Dependency injection
    private DegreeRepository degreeRepository;
    @Autowired
    private StaffRepository staffRepository;
    //get all degree
    //localhost:8080/degree
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getAllDegrees(ModelMap modelMap) {
        Iterable<Degree> degrees = degreeRepository.findAll();
        modelMap.addAttribute("degrees",degrees);
        return "getAllDegrees";
    }

    //insert new a degree
    //localhost:8080/degrees/insertDegree
    @RequestMapping(value = "/insertDegree", method = RequestMethod.POST)
    public String insertDegree(@ModelAttribute Degree degree,
                             ModelMap modelMap){
        try{
            if(!degreeRepository.findById(degree.getDegreeID()).isPresent()){
                Degree newDegree = new Degree(degree.getDegreeID(), degree.getStaffID(),
                                              degree.getName_major(), degree.getName_university(),
                                              degree.getAcademic_level());
                degreeRepository.save(newDegree);
                return "redirect:/degrees";
            }
            else {
                modelMap.addAttribute("error","degreeID already exits !!");
                return "insertDegree";
            }
        }catch (Exception e){
            modelMap.addAttribute("error",e);
            modelMap.addAttribute("staffIDs", staffRepository.findAllStaffID());
            return "insertDegree";
        }
    }
    //overloading
    @RequestMapping(value = "/insertDegree", method = RequestMethod.GET)
    public String insertDegree(ModelMap modelMap){
        Iterable<String> staffIDs = staffRepository.findAllStaffID();
        modelMap.addAttribute("degree",new Degree());
        modelMap.addAttribute("staffIDs", staffIDs);
        return "insertDegree";
    }
    //insert new a degree
    //localhost:8080/degrees/insertDegree
    @RequestMapping(value="/deleteDegree/{degreeID}", method = RequestMethod.POST)
    public String deleteDegree(@PathVariable String degreeID) {
        degreeRepository.deleteById(degreeID);
        return "redirect:/degrees";
    }


    //edit any attribute of a degree
    //https:localhost:8080/degrees/editAtbOfdegree/
    @RequestMapping(value = "/editAtbOfDegree/{degreeID}", method = RequestMethod.GET)
    public String editAtbOfDegree(ModelMap modelMap, @PathVariable String degreeID) {
        Optional<Degree> degree = degreeRepository.findById(degreeID);
        modelMap.addAttribute("degree", degree.get());
        modelMap.addAttribute("staffIDs",staffRepository.findAllStaffID());
        return "editAtbOfDegree";
    }

    @RequestMapping(value = "/updateAtbOfDegree/{degreeID}", method = RequestMethod.POST)
    public String editAtbOfDegree(@ModelAttribute("degree") Degree degree,
                                 @PathVariable String degreeID,
                                 ModelMap modelMap) {
        if(degreeRepository.findById(degreeID).isPresent()) {
            Degree foundDegree = degreeRepository.findById(degreeID).get();
            if (!degree.getDegreeID().trim().isEmpty()) {
                foundDegree.setDegreeID(degree.getDegreeID());
            }
            if (!degree.getStaffID().trim().isEmpty()) {
                foundDegree.setStaffID(degree.getStaffID());
            }
            if (!degree.getName_major().trim().isEmpty()) {
                foundDegree.setDegreeID(degree.getDegreeID());
            }

            if (!degree.getName_university().trim().isEmpty()) {
                foundDegree.setName_university(degree.getName_university());
            }

            foundDegree.setAcademic_level(degree.getAcademic_level());
            degreeRepository.save(foundDegree);

        }
        //back to Degrees lists
        return "redirect:../";
    }
}
