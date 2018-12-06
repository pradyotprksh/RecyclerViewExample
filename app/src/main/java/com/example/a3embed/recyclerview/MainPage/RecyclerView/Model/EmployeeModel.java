/*
 * Pradyot Prakash
 *
 * Copyright (c)
 *
 * This software is the confidential and proprietary information of
 * 3Embed Technologies
 */

package com.example.a3embed.recyclerview.MainPage.RecyclerView.Model;

/**
 * EmployeeModel.java
 * Employees RecyclerView Model Class
 *
 * @version 1.0 06 Dec 2018
 * @author Pradyot Prakash
 */

public class EmployeeModel {

    private String id;
    private String name;
    private String branch;
    private int age;

    /** EmployeeModel Constructor for Branch */
    public EmployeeModel(String branch) {
        this.branch = branch;
    }

    /** EmployeeModel Constructor */
    public EmployeeModel(String id, String name, String branch, int age) {
        this.id = id;
        this.name = name;
        this.branch = branch;
        this.age = age;
    }

    /** EmployeeModel get the employee id */
    public String getId() {
        return id;
    }

    /** EmployeeModel get the employee name */
    public String getName() {
        return name;
    }

    /** EmployeeModel get the employee branch */
    public String getBranch() {
        return branch;
    }

    /** EmployeeModel get the employee age */
    public int getAge() {
        return age;
    }

}
