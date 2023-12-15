package com.example.schoolmanagementsystem.models;

public class Users {
String name,email,password,number,branch,year;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
//constructor

    public Users(String name, String email, String password, String number, String branch, String year) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.number = number;
        this.branch = branch;
        this.year = year;
    }
    public Users()
    {
        this.name = name;
        this.email = email;
        this.password = password;
        this.number = number;
        this.branch = branch;
        this.year = year;
    }
}
