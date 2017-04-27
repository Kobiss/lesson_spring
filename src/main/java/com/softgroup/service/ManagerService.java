package com.softgroup.service;

import com.softgroup.model.Tank;
import com.softgroup.model.User;
import com.softgroup.response.MessResponse;
import com.softgroup.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by java-Andr on 27.04.2017.
 */
@Service
public class ManagerService {

    private UserService userService;
    private TankService tankService;

    @Autowired
    public ManagerService(UserService userService, TankService tankService) {
        this.userService = userService;
        this.tankService = tankService;
    }

    public int buyTank(User user, int tank_id){

        Tank tank = tankService.findById(tank_id);
        if(tank==null) return 405;

        if(user.getMoney()<tank.getPrice()) return 406;

        return (buyTransaction(user, tank))?200:407;
    }

    @Transactional
    private boolean buyTransaction(User user, Tank tank) {
        try {
            user.setMoney(user.getMoney()-tank.getPrice());
            tank.setOwner(user);
            tankService.save(tank);
            userService.save(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
