package com.docker.xmpl.springdocker.controller;

import com.docker.xmpl.springdocker.dao.BoatDaoServiceImpl;
import com.docker.xmpl.springdocker.model.Boat;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BoatController {
    @Autowired
    private BoatDaoServiceImpl boatDaoService;

    @GetMapping("/boats")
    public String allBoats() {
        List<Boat> boatList = boatDaoService.findAll();

        if (boatList.isEmpty()){
            return "List is empty";
        }

        String sb = boatList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining("\n"));

        return sb;
    }

    @PostMapping("/boats")
    public String createBoatWithJson(@RequestBody Boat boat){
        boatDaoService.save(boat);

        return boat.toString();
    }

    @PostMapping("/boats/create")
    public String createBoatWithParams(@RequestParam (name = "name") String name){
        Boat boat = new Boat();
        boat.setName(name);
        boatDaoService.save(boat);

        return boat.toString();
    }

}
