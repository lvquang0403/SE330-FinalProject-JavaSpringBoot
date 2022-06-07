package com.project.WebApp.controller;

import com.project.WebApp.model.Position;
import com.project.WebApp.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.rmi.MarshalledObject;

@Controller
@RequestMapping(path = "positions")
public class PositionController {
    @Autowired //Dependency injection
    private PositionRepository positionRepository;
    //get all room
    //localhost:8080/positions
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getAllRooms(ModelMap modelMap) {
        Iterable<Position> positions = positionRepository.findAll();
        modelMap.addAttribute("positions",positions);
        modelMap.addAttribute("newPosition", new Position());
        return "getAllPositions";
    }
    //overloading
    //insert new a position
    //localhost:8080/positions/insertPosition, method = POST
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String insertRoom(@ModelAttribute Position position,
                             ModelMap modelMap){
        Iterable<Position> positions = positionRepository.findAll();
        modelMap.addAttribute("positions",positions);
        modelMap.addAttribute("newPosition", new Position());
        try{
            if(!positionRepository.findById(position.getPosID()).isPresent()){
                Position newPosition = new Position(position.getPosID(),position.getName_Pos());
                positionRepository.save(newPosition);
                return "redirect:/positions";
            }
            else {
                modelMap.addAttribute("error","PositionID already exits !!");
                return "getAllPositions";
            }
        }catch (Exception e){
            modelMap.addAttribute("error",e);
            return "getAllPositions";
        }
    }
    //insert new a Position
    //localhost:8080/positions/insertPosition
    @RequestMapping(value="/deletePosition/{posID}", method = RequestMethod.POST)
    public String deleteRoom(@PathVariable String posID) {
        positionRepository.deleteById(posID);
        return "redirect:/positions";
    }
}
