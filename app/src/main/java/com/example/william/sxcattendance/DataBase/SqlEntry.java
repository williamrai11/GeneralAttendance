package com.example.william.sxcattendance.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.william.sxcattendance.DataBase.Models.DbModel;
import com.example.william.sxcattendance.DataBase.Repo.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by william on 3/25/18.
 */

public class SqlEntry implements Repository {

    private Context context;

    public SqlEntry(Context context) {
        this.context = context;
    }



    @Override
    public void addDatas(DbModel dbModels) {
        ContentValues departmentDatas = new ContentValues();
        ContentValues semesterDatas = new ContentValues();
        ContentValues studentsDatas = new ContentValues();

        int i =0;
        int j = 0;
        int k = 0;

        for (i =0 ; i<dbModels.getData().size();i++){
            departmentDatas.put(DbContract.DepartmentEntry.id,dbModels.getData().get(i).getId());
            departmentDatas.put(DbContract.DepartmentEntry.HOD,dbModels.getData().get(i).getHod());
            departmentDatas.put(DbContract.DepartmentEntry.NAME_OF_DEPARTMENT,dbModels.getData().get(i).getName_of_department());
            departmentDatas.put(DbContract.DepartmentEntry.CODE,dbModels.getData().get(i).getCode());

            context.getContentResolver().insert(DbContract.DepartmentEntry.DEPARTMENT_URI,departmentDatas);
            
            for ( j=0;j<dbModels.getData().get(i).getSemester().size();j++){
                semesterDatas.put(DbContract.SemesterEntry.id,dbModels.getData().get(i).getSemester().get(j).getId());
                semesterDatas.put(DbContract.SemesterEntry.CODE,dbModels.getData().get(i).getSemester().get(j).getCode());
                semesterDatas.put(DbContract.SemesterEntry.VALUE,dbModels.getData().get(i).getSemester().get(j).getValue());
                semesterDatas.put(DbContract.SemesterEntry.DEPARTMENT,dbModels.getData().get(i).getSemester().get(j).getDepartment());
                semesterDatas.put(DbContract.SemesterEntry.BATCH,dbModels.getData().get(i).getSemester().get(j).getBatch());

                context.getContentResolver().insert(DbContract.SemesterEntry.SEMESTER_URI,semesterDatas);


                for (k=0;k<dbModels.getData().get(i).getSemester().get(j).getStudents().size();k++){
                    studentsDatas.put(DbContract.StudentsEntry.id,dbModels.getData().get(i).getSemester().get(j).getStudents().get(k).getId());
                    studentsDatas.put(DbContract.StudentsEntry.STUDENT_FNAME,dbModels.getData().get(i).getSemester().get(j).getStudents().get(k).getFirst_name());
                    studentsDatas.put(DbContract.StudentsEntry.STUDENT_LNAME,dbModels.getData().get(i).getSemester().get(j).getStudents().get(k).getLast_name());
                    studentsDatas.put(DbContract.StudentsEntry.CONTACT,dbModels.getData().get(i).getSemester().get(j).getStudents().get(k).getContact());
                    studentsDatas.put(DbContract.StudentsEntry.DEPARTMENT,dbModels.getData().get(i).getSemester().get(j).getStudents().get(k).getDepartment());
                    studentsDatas.put(DbContract.StudentsEntry.STUDENT_MNAME,dbModels.getData().get(i).getSemester().get(j).getStudents().get(k).getMiddle_name());
                    studentsDatas.put(DbContract.StudentsEntry.SEMESTER,dbModels.getData().get(i).getSemester().get(j).getStudents().get(k).getSemester());
                    studentsDatas.put(DbContract.StudentsEntry.ATTENDANCE,1);

                    context.getContentResolver().insert(DbContract.StudentsEntry.STUDENT_URI,studentsDatas);

                }

            }
        }


    }
}
