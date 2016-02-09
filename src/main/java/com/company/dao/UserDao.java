package com.company.dao;

import com.company.entity.User;

import java.util.List;


/**
 * Created by Ira on 30.01.2016.
 */
public interface UserDao {


    /**
     * Save new user
     * @param user
     * @return ID user
     */
    int save(User user);

    /**
     * Find user by login and password
     * @param login user login
     * @param password user password
     * @return User
     */
    User findByLoginPass(String login, String password);

    /**
     * Find user by ID
     * @param id
     * @return
     */
    User findById(int id);

    /**
     * Find all users
     * @return list of users
     */
    List<User> findAll();

    /**
     * Find users which in blacklist
     * @return
     */
    List<User> listBlackUser();

    /**
     * Update info about user
     * If isBlack = 1, then user in blacklist
     * If isBlack = 0, then user in white list
     * @param idUser ID user
     * @param isBlack
     */
    void updateInfo(int idUser, int isBlack); //update user set isBlack = 1 where id = idUser

}
