package com.example.william.sxcattendance.SelectionPage;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.example.william.sxcattendance.DataBase.Models.SemesterModel;

import java.util.ArrayList;
import java.util.List;

public interface Contract {

    public interface  View{
        public void handleEvent();
        public void setData(List<SemesterModel > semesterNames);
        public void initialize();
        public void showToast(String message);
        public void startActivty(int Position);
    }

    public  interface presenter{
        public void set();
        public void sendData(int tag);
        public void getMessages(String message);
        public void getFragment(Fragment fragment, FragmentManager manager);
        public void itemClick(int Position);

    }


    public interface Model{
        public void setDataToAdapter(ArrayList<String> datas);
        public List<SemesterModel> getDatas (int checker);

        interface listerner{
            public void onSuccess(ArrayList<String> datas);
            public void onFailure();

        }
    }



}
