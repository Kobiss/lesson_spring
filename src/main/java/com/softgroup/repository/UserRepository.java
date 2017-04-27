package com.softgroup.repository;

import com.softgroup.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by java-Andr on 27.04.2017.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findAll();
    User findByLogin(String login);
}
