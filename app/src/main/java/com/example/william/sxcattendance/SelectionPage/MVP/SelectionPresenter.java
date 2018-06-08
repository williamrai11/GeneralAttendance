package com.example.william.sxcattendance.SelectionPage.MVP;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.example.william.sxcattendance.R;
import com.example.william.sxcattendance.SelectionPage.Contract;

import java.util.ArrayList;

public class SelectionPresenter implements Contract.presenter {

    private Contract.View view;
    private Contract.Model model;
    private Context context;

    public SelectionPresenter(Contract.View view, Contract.Model model){
        this.model = model;
        this.view = view;
    }

    @Override
    public void set() {
     view.initialize();
     view.handleEvent();
    }

    @Override
    public void sendData(int tag) {


    }

    @Override
    public void getMessages(String message) {
        view.showToast(message);
    }

    @Override
    public void getFragment(Fragment fragment,FragmentManager manager) {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.layout_for_fragment_replace,fragment,"fragment")
                .commit();
    }

    @Override
    public void itemClick(int Position) {

    }
}
