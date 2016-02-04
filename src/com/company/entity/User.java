package com.company.entity;

/**
 * Created by Ira on 29.01.2016.
 */
public class User {
    private int id;
    private String name;
    private String surname;
    private String login;
    private String password;
    private boolean isBlack;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isBlack() {
        return isBlack;
    }

    public void setIsBlack(boolean isBlack) {
        this.isBlack = isBlack;
    }

    public void initUser(String name, String surname, String login, String password, boolean isBlack) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.isBlack = isBlack;
    }
}
