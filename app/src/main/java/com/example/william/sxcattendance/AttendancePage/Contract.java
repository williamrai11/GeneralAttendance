package com.example.william.sxcattendance.AttendancePage;



import com.example.william.sxcattendance.AttendancePage.DataModel.StudentsModel;

import java.util.ArrayList;
import java.util.List;

public interface Contract {

    public interface View{
        public void handleEvent();
        public void setData(List<StudentsModel> studentNames);
        public void initialize();
        public void showToast(String message);
        public void startActivty(int Position);
        public void showProgress();
        public void hideProgress();


        interface setValues{
            public void setAbsentAndPresent(int currentPresent, int currentAbsent);

        }



    }

    public interface Presenter{
        public void set();
        public void sendData(String name,int semesterCode);
        public void getMessages(String message);
        public void itemClick(int Position);
    }

    public interface Model{
        public List<StudentsModel> getDatas (String checker,int semesterCode);

        interface listerner{
            public void onSuccess(ArrayList<String> datas);
            public void onFailure();

        }
    }

}
