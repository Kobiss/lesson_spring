package com.softgroup.controller;

import com.softgroup.model.Tank;
import com.softgroup.repository.TankRepository;
import com.softgroup.response.MessResponse;
import com.softgroup.response.Response;
import com.softgroup.service.TankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    private TankService tankService;

    @Autowired
    public TankController(TankService tankService){
        this.tankService=tankService;
    }

//    @PostConstruct
//    public void init(){
//        List<Tank> tankList = new ArrayList<Tank>(){};
//        tankList.add(new Tank("T144", "USA", 12, "RED", 147));
//        tankList.add(new Tank("Tank1", "USSA", 12, "Green", 154));
//        tankList.add(new Tank("T134", "Ukrine", 12, "Blue", 754));
//        tankRepository.save(tankList);
//    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Tank> home() {
        return (List<Tank>) tankService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Tank getOneTankById(@PathVariable int id) {
        return tankService.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Response deleteOneTankById(@PathVariable int id,
                                  @RequestHeader String login,
                                  @RequestHeader String pass) {

        if(login.isEmpty()||pass.isEmpty()
                ||!login.trim().equals("user")||!pass.trim().equals("123")){
            return new MessResponse(403, "Forbidden");
        }

        if(tankService.deleteTankById(id)){
            return new MessResponse(203, "Delete successfully");
        }
            return new MessResponse(203, "Delete fail");

    }

}
