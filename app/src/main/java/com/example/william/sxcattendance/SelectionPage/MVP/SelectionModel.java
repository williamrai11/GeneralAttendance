package com.example.william.sxcattendance.SelectionPage.MVP;

import android.content.Context;

import com.example.william.sxcattendance.DataBase.Models.SemesterModel;
import com.example.william.sxcattendance.DataBase.SqlQuery;
import com.example.william.sxcattendance.SelectionPage.Adapter.CustomAdapter;
import com.example.william.sxcattendance.SelectionPage.Contract;
import com.example.william.sxcattendance.R;

import java.util.ArrayList;
import java.util.List;

public class SelectionModel implements Contract.Model {

    private Context context;
    private SqlQuery sqlQuery;
    private List<SemesterModel> semesterModels;

    public SelectionModel(Context context){
        this.context = context;
        sqlQuery = new SqlQuery(context);
    }

    @Override
    public void setDataToAdapter(ArrayList<String> datas) {


    }

    @Override
    public List<SemesterModel> getDatas(int checker) {
        semesterModels = new ArrayList<>();

        if (checker == 0){
            semesterModels = sqlQuery.getSemester(1);

            return semesterModels;
        }else {
            semesterModels = sqlQuery.getSemester(2);

            return semesterModels;
        }
    }
}
