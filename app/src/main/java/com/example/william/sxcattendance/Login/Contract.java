package com.example.william.sxcattendance.Login;

public interface Contract {

    public interface View{
        public void handleEvent();
        public void initialize();
        public void showToast(String message);
        public void startActivity();
        public void showIfEmptyCredentials();

    }

    public interface Presenter{
        public void set();
        public void access(String email,String password);



    }

    public interface Model{

        public void getCredentials(String email,String password,CallBack callBack);

        interface CallBack{
            public void onSuccess();
            public void onCredentialError(String message);
        }

    }


}