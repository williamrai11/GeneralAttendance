package com.example.william.sxcattendance.AttendancePage.MVP;

import android.content.Context;

import com.example.william.sxcattendance.AttendancePage.AttendanceActivity;
import com.example.william.sxcattendance.AttendancePage.Contract;
import com.example.william.sxcattendance.AttendancePage.DataModel.StudentsModel;
import com.example.william.sxcattendance.DataBase.SqlQuery;

import java.util.ArrayList;
import java.util.List;

public class AttendanceModel implements Contract.Model {
   private Context context;
   private SqlQuery sqlQuery;

   public AttendanceModel(Context context) {
      this.context = context;
      sqlQuery = new SqlQuery(context);
   }

   @Override
    public List<StudentsModel> getDatas(String checker,int semesterCode) {



        return sqlQuery.getStudents(checker,semesterCode);
    }
}
