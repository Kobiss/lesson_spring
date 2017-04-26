package com.softgroup.repository;

import com.softgroup.model.Tank;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by java-Andr on 25.04.2017.
 */

public interface TankRepository extends CrudRepository<Tank, Integer>{

    Tank findById(int id);
    List<Tank> findByNameAndColor(String name, String color);
    List<Tank> findAll();


}
