package com.example.william.sxcattendance.AttendancePage;



import java.util.ArrayList;

public interface Contract {

    public interface View{
        public void handleEvent();
        public void setData(ArrayList<String> studentNames);
        public void initialize();
        public void showToast(String message);
        public void startActivty(int Position);

        interface setValues{
            public void setAbsentAndPresent(int currentPresent, int currentAbsent);

        }

    }

    public interface Presenter{
        public void set();
        public void sendData();
        public void getMessages(String message);
        public void itemClick(int Position);
    }

    public interface Model{
        public  ArrayList<String> getDatas (int checker);

        interface listerner{
            public void onSuccess(ArrayList<String> datas);
            public void onFailure();

        }
    }

}
