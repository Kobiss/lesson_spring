package com.softgroup.controller;

import com.softgroup.model.Tank;
import com.softgroup.model.User;
import com.softgroup.repository.TankRepository;
import com.softgroup.request.TankRequest;
import com.softgroup.response.MessResponse;
import com.softgroup.response.Response;
import com.softgroup.response.TankResponse;
import com.softgroup.service.TankService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping(value = "tank")
public class TankController {

    private TankService tankService;

    @Autowired
    public TankController(TankService tankService) {
        this.tankService = tankService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Tank> home(HttpSession httpSession) {
        httpSession.setAttribute("list", tankService.findAll());
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
        if (validateAuth(login, pass)) return new MessResponse(403, "Forbidden");
        if (tankService.deleteTankById(id)) {
            return new MessResponse(203, "Delete successfully");
        }
        return new MessResponse(203, "Delete fail");
    }

    private boolean validateAuth(String login, String pass) {
        if (login.isEmpty() || pass.isEmpty()
                || !login.trim().equals("user") || !pass.trim().equals("123")) {
            return true;
        }
        return false;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Response addOneTank(@RequestBody TankRequest tankRequest,
                               @RequestHeader String login,
                               @RequestHeader String pass) {
        if (validateAuth(login, pass)) return new MessResponse(403, "Forbidden");
        if (tankRequest == null) return new MessResponse(400, "Bad request");

        try {
            Tank tank = tankService.addOne(new Tank(tankRequest));
            return new TankResponse(201, tank);
        } catch (Exception e) {
            e.printStackTrace();
            return new MessResponse(501, "Fail to create Tank");
        }
    }

}
