package com.example.william.sxcattendance.SelectionPage.MVP;

import android.content.Context;

import com.example.william.sxcattendance.SelectionPage.Adapter.CustomAdapter;
import com.example.william.sxcattendance.SelectionPage.Contract;
import com.example.william.sxcattendance.R;

import java.util.ArrayList;

public class SelectionModel implements Contract.Model {

    private Context context;

    public SelectionModel(Context context){
        this.context = context;
    }

    @Override
    public void setDataToAdapter(ArrayList<String> datas) {


    }

    @Override
    public ArrayList<String> getDatas(int checker) {
        ArrayList<String> bscCsit = new ArrayList<>();
        bscCsit.add("1st Semester");
        bscCsit.add("3rd Semester");
        bscCsit.add("5th Semester");
        bscCsit.add("7th Semester");

        ArrayList<String> bim = new ArrayList<>();
        bim.add("1st Semester");
        bim.add("7th Semester");

        if (checker == 0){
            return bscCsit;
        }else {
            return bim;
        }
    }
}
