package com.example.william.sxcattendance.DataBase.Models;

public class SemesterModel {

    private int id;
    private int code; //semseter
    private String value;
    private String department;
    private int batch;

    public SemesterModel(int id, int code, String value, String department, int batch) {
        this.id = id;
        this.code = code;
        this.value = value;
        this.department = department;
        this.batch = batch;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getBatch() {
        return batch;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }
}
