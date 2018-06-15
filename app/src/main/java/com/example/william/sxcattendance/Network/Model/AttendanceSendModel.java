package com.example.william.sxcattendance.Network.Model;

public class AttendanceSendModel {


    /**
     * date : 2015-02-05
     * is_present : 0
     * id : 1
     * remarks : hello
     */

    private String date;
    private int is_present;
    private int id;
    private String remarks;

    public AttendanceSendModel(String date, int is_present, int id, String remarks) {
        this.date = date;
        this.is_present = is_present;
        this.id = id;
        this.remarks = remarks;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getIs_present() {
        return is_present;
    }

    public void setIs_present(int is_present) {
        this.is_present = is_present;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
