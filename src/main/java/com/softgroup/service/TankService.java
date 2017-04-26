package com.softgroup.service;

import com.softgroup.model.Tank;
import com.softgroup.repository.TankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by java-Andr on 26.04.2017.
 */

@Service
public class TankService {

    private TankRepository tankRepository;

    @Autowired
    public TankService(TankRepository tankRepository){
        this.tankRepository=tankRepository;
    }

    public Tank findById(int id){
        return tankRepository.findById(id);
    };

    public List<Tank> findByNameAndColor(String name, String color){
        return tankRepository.findByNameAndColor(name, color);
    };

    public List<Tank> findAll(){
        return tankRepository.findAll();
    };

    public boolean deleteTankById(int id){
        try {
            tankRepository.delete(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
