package com.softgroup.repository;

import com.softgroup.model.Tank;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TankRepositoryTest {

    @Autowired
    private TankRepository tankRepository;

    @Before
    public void setUp() throws Exception {
        List<Tank> tankList = new ArrayList<Tank>(){};
        tankList.add(new Tank("T144", "USA", 12, "RED", 147));
        tankList.add(new Tank("Tank1", "USSA", 12, "Green", 154));
        tankList.add(new Tank("T134", "Ukrine", 12, "Blue", 754));
        tankRepository.save(tankList);
    }

    @Test
    public void testFindByNameAndColor() throws Exception {

        List<Tank> tankList = tankRepository.findAll();
        System.out.println(Arrays.toString(tankList.toArray()));

        List<Tank> tankList1 = tankRepository.findByNameAndColor("Tank1", "Green");

        System.out.println(Arrays.toString(tankList1.toArray()));

    }
}