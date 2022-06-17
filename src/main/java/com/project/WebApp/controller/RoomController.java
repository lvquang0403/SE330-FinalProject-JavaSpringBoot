package com.project.WebApp.controller;

import com.project.WebApp.model.Position;
import com.project.WebApp.model.Room;
import com.project.WebApp.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.rmi.MarshalledObject;
import java.util.Optional;

@Controller
@RequestMapping(path = "rooms")
public class RoomController {
    @Autowired //Dependency injection
    private RoomRepository roomRepository;
    //get all room
    //localhost:8080/rooms
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getAllRooms(ModelMap modelMap) {
        Iterable<Room> rooms = roomRepository.findAll();
        modelMap.addAttribute("rooms",rooms);
        return "getAllRooms";
    }

    //insert new a room
    //localhost:8080/rooms/insertRoom
    @RequestMapping(value = "/insertRoom", method = RequestMethod.POST)
    public String insertRoom(@ModelAttribute Room room,
                             ModelMap modelMap){
        try{
        if(!roomRepository.findById(room.getRoomID()).isPresent()){
            Room newRoom = new Room(room.getRoomID(),room.getName_room());
            roomRepository.save(newRoom);
            return "redirect:/rooms";
        }
        else {
            modelMap.addAttribute("error","RoomID already exits !!");
            return "insertRoom";
        }
        }catch (Exception e){
            modelMap.addAttribute("error",e);
            return "insertRoom";
        }
    }
    //overloading
    @RequestMapping(value = "/insertRoom", method = RequestMethod.GET)
    public String insertRoom(ModelMap modelMap){
        modelMap.addAttribute("room",new Room());
        return "insertRoom";
    }
    //insert new a room
    //localhost:8080/rooms/insertRoom
    @RequestMapping(value="/deleteRoom/{roomID}", method = RequestMethod.POST)
    public String deleteRoom(@PathVariable String roomID) {
        roomRepository.deleteById(roomID);
        return "redirect:/rooms";
    }

    //edit any attribute of a Room
    //https:localhost:8080/rooms/editAtbOfRoom/
    @RequestMapping(value = "/editAtbOfRoom/{roomID}", method = RequestMethod.GET)
    public String editAtbOfRoom(ModelMap modelMap, @PathVariable String roomID) {
        Optional<Room> room = roomRepository.findById(roomID);
        modelMap.addAttribute("room", room.get());
        return "editAtbOfRoom";
    }

    //handle request update  a Room
    @RequestMapping(value = "/updateAtbOfRoom/{roomID}", method = RequestMethod.POST)
    public String editAtbOfDegree(@ModelAttribute("position") Room room,
                                  @PathVariable String roomID,
                                  ModelMap modelMap) {
        if(roomRepository.findById(roomID).isPresent()) {
            Room foundRoom = roomRepository.findById(roomID).get();
            if (!room.getRoomID().trim().isEmpty()) {
                foundRoom.setRoomID(room.getRoomID());
            }
            if (!room.getName_room().trim().isEmpty()) {
                foundRoom.setName_room(room.getName_room());
            }

            roomRepository.save(foundRoom);

        }
        //back to Degrees lists
        return "redirect:../";
    }
}
