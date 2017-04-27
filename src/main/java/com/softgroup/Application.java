package com.softgroup;

import com.softgroup.model.User;
import com.softgroup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Created by java-Andr on 25.04.2017.
 */

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private UserService userService;

    @PostConstruct
    public void init(){
        User user = new User();
        user.setLogin("name");
        user.setPass("123");
        user.setMoney(1000000);
        userService.save(user);
    }

}
