package com.example.william.sxcattendance.Login.MVP;

import android.content.Context;

import com.example.william.sxcattendance.Login.Contract;
import com.example.william.sxcattendance.Network.NetworkCalls;

public class LoginPresenter implements Contract.Presenter,Contract.Model.CallBack {
    Contract.View view;
    Contract.Model model;
    NetworkCalls networkCalls;
    Context context;


    public LoginPresenter(Contract.View view, Contract.Model model,Context context){
        this.model = model;
        this.view = view;
        networkCalls = new NetworkCalls(context);
    }

    @Override
    public void set() {
            if (view!=null){
                view.initialize();
            }
    }

    @Override
    public void access(String email,String password) {
        if (model!=null) {
            if(email.equals("") || password.equals("")){
                view.showIfEmptyCredentials();
            }else {
                model.getCredentials(email, password, this);

            }
        }
    }

    @Override
    public void getDepartmentDatas() {
        networkCalls.getDepartmentDatas(this);
    }


    @Override
    public void loading() {
        if (view!=null && model!=null){
            view.showProgress();
        }

    }

    @Override
    public void onSuccess() {
        if (view!=null){

            view.runNetworkCalls();
        }
    }

    @Override
    public void hide() {
        if (view!=null){
            view.hideProgress();
        }
    }

    @Override
    public void onCredentialError(String message) {
        view.showToast(message);

    }

    @Override
    public void onSuccessResponse() {
        if (view!=null){
            view.hideProgress();
            view.startActivity();
        }
    }
}
