package com.example.william.sxcattendance.SelectionPage.Fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.example.william.sxcattendance.SelectionPage.Contract;

import java.util.ArrayList;

public class FragmentPresenter implements Contract.presenter,Contract.Model.listerner {

    private Contract.View view;
    private Contract.Model model;

    public FragmentPresenter(Contract.View view,Contract.Model model){
        this.view = view;
        this.model = model;
    }


    @Override
    public void set() {
        view.initialize();
        view.handleEvent();
    }

    @Override
    public void sendData(int tag) {
        view.setData(model.getDatas(tag));
    }

    @Override
    public void getMessages(String message) {

    }

    @Override
    public void getFragment(Fragment fragment, FragmentManager manager) {

    }

    @Override
    public void itemClick(int Position) {
        view.startActivty(Position);
    }

    @Override
    public void onSuccess(ArrayList<String> datas) {

    }

    @Override
    public void onFailure() {

    }
}
