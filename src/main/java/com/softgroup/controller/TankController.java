package com.softgroup.controller;

import com.softgroup.model.Tank;
import com.softgroup.repository.TankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by java-Andr on 25.04.2017.
 */

@RestController
@RequestMapping(value = "tank")
public class TankController {

    @Autowired
    private TankRepository tankRepository;

    @PostConstruct
    public void init(){
        List<Tank> tankList = new ArrayList<Tank>(){};
        tankList.add(new Tank("T144", "USA", 12, "RED", 147));
        tankList.add(new Tank("Tank1", "USSA", 12, "Green", 154));
        tankList.add(new Tank("T134", "Ukrine", 12, "Blue", 754));
        tankRepository.save(tankList);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Tank> home() {
        return (List<Tank>) tankRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Tank getOneTankById(@PathVariable int id) {
        return tankRepository.findOne(Integer.valueOf(id));
    }

}
