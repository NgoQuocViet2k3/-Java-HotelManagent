package com.codegym.model;

import java.io.Serializable;

public class User implements Serializable {
    private String acount;
    private String passwork;
    private String name;
    private int age;
    private String phoneNumber;


    public User(String acount, String passwork, String name, int age, String phoneNumber) {
        this.acount = acount;
        this.passwork = passwork;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public String getAcount() {
        return acount;
    }

    public void setAcount(String acount) {
        this.acount = acount;
    }

    public String getPasswork() {
        return passwork;
    }

    public void setPasswork(String passwork) {
        this.passwork = passwork;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @Override
    public String toString() {
        return "acount: " + acount + ", " +
                " passwork: " + passwork + ", " +
                " name: " + name + ", " +
                " age: " + age + ", " +
                " phoneNumber='" + phoneNumber;

    }
}
