package com.example.william.sxcattendance.Login.MVP;

import com.example.william.sxcattendance.Login.Contract;

public class LoginPresenter implements Contract.Presenter,Contract.Model.CallBack {
    Contract.View view;
    Contract.Model model;


    public LoginPresenter(Contract.View view, Contract.Model model){
        this.model = model;
        this.view = view;
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
    public void loading() {
        if (view!=null && model!=null){
            view.showProgress();
        }

    }

    @Override
    public void onSuccess() {
        if (view!=null){
            view.hideProgress();
            view.startActivity();
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
}
