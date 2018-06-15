package com.example.william.sxcattendance.AttendancePage.MVP;

import com.example.william.sxcattendance.AttendancePage.Contract;

public class AttendancePresenter implements Contract.Presenter {
    private Contract.View view;
    private Contract.Model model;

    public AttendancePresenter(Contract.View view, Contract.Model model){
        this.view = view;
        this.model = model;
    }


    @Override
    public void set() {
        view.initialize();
        view.handleEvent();
    }

    @Override
    public void sendData(String name,int SemesterCode) {
        view.setData(model.getDatas(name,SemesterCode));
    }

    @Override
    public void getMessages(String message) {

    }

    @Override
    public void itemClick(int Position) {

    }
}
