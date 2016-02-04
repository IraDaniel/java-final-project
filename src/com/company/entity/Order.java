package com.company.entity;

/**
 * Created by Ira on 30.01.2016.
 */
public class Order {

    private int id;
    private int idUser;
    private int idProduct;
    private int number;
    private boolean isPaid;

    public Order() {
    }

    public void initOrder(int idUser, int idProduct, int number, boolean isPaid) {
        this.idUser = idUser;
        this.idProduct = idProduct;
        this.number = number;
        this.isPaid = isPaid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }
}
