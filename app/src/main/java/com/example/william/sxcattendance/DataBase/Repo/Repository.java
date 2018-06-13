package com.example.william.sxcattendance.DataBase.Repo;


import com.example.william.sxcattendance.AttendancePage.DataModel.StudentsModel;
import com.example.william.sxcattendance.DataBase.Models.DbModel;
import com.example.william.sxcattendance.DataBase.Models.SemesterModel;
import com.example.william.sxcattendance.Login.Contract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by william on 3/25/18.
 */

public interface Repository {

    public void addDatas(DbModel dbModels);

    interface NetworkCalls{

        public void getDepartmentDatas(Contract.Model.CallBack callBack);

    }

    interface query {
        public List<SemesterModel> getSemester(int departmentCode);
        public List<StudentsModel> getStudents(String departmentName);
    }



}
