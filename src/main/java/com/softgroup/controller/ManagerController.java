package com.softgroup.controller;

import com.softgroup.model.Tank;
import com.softgroup.model.User;
import com.softgroup.response.MessResponse;
import com.softgroup.response.Response;
import com.softgroup.service.ManagerService;
import com.softgroup.service.TankService;
import com.softgroup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by java-Andr on 27.04.2017.
 */

@RestController
@RequestMapping(value = "/buy")
public class ManagerController  {

    private UserService userService;
    private TankService tankService;
    private ManagerService managerService;

    @Autowired
    public ManagerController(UserService userService, TankService tankService, ManagerService managerService) {
        this.userService = userService;
        this.tankService = tankService;
        this.managerService = managerService;
    }

    @RequestMapping(value = "/tank/{tank_id}", method = RequestMethod.GET)
    public Response buyTank(@RequestHeader String login,
                            @RequestHeader String pass,
                            @PathVariable int tank_id){

        User user = userService.validateAuth(login, pass);
        if(user==null)
            return new MessResponse(401, "Auth fail");



        int response = managerService.buyTank(user, tank_id);

    }
}
