package com.company.dao;

import com.company.entity.User;

import java.util.List;


/**
 * Created by Ira on 30.01.2016.
 */
public interface UserDao {

    void save(User user);

    User findByLoginPass(String login, String password);

    List<User> findAll();

    List<User> listBlackUser();

    void updateInfo(int idUser, int isBlack); //update user set isBlack = 1 where id = idUser

}
