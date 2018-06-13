package com.example.william.sxcattendance.DataBase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.william.sxcattendance.AttendancePage.DataModel.StudentsModel;
import com.example.william.sxcattendance.DataBase.Models.SemesterModel;
import com.example.william.sxcattendance.DataBase.Repo.Repository;

import java.util.ArrayList;
import java.util.List;

public class SqlQuery implements Repository.query {

    private Context context;

    public SqlQuery(Context context){
        this.context = context;
    }

    @Override
    public List<SemesterModel> getSemester(int departmentCode) {
        List<SemesterModel> list = new ArrayList<>();

        String rawQuery = "Select * from semester where value == "+departmentCode;


        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(rawQuery,null);

        if (cursor!=null){
            int id=0;
            int code = 0, batch = 0;
            String departments = "", value ="";

            while (cursor.moveToNext()){
                id = cursor.getInt(cursor.getColumnIndex(DbContract.SemesterEntry.id));
                code = cursor.getInt(cursor.getColumnIndex(DbContract.SemesterEntry.CODE));
                batch = cursor.getInt(cursor.getColumnIndex(DbContract.SemesterEntry.BATCH));
                departments = cursor.getString(cursor.getColumnIndex(DbContract.SemesterEntry.DEPARTMENT));
                value = cursor.getString(cursor.getColumnIndex(DbContract.SemesterEntry.VALUE));

                SemesterModel semesterModel = new SemesterModel(
                        id,
                        code,
                        value,
                        departments,
                        batch
                );

                list.add(semesterModel);
            }
        }
        cursor.close();
        return list;

    }

    @Override
    public List<StudentsModel> getStudents(String departmentName) {
        List<StudentsModel> lists = new ArrayList<>();

        String where = new StringBuilder()
                .append('\'')
                .append(departmentName)
                .append('\'')
                .toString();

        String rawQuery = "Select * from students where department == "+ where;

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(rawQuery,null);

        if (cursor!=null){
            int id = 0, semester = 0;
            String firstName = "",middleName="",lastName="";

            while (cursor.moveToNext()){
                id = cursor.getInt(cursor.getColumnIndex(DbContract.StudentsEntry.id));
                semester = cursor.getInt(cursor.getColumnIndex(DbContract.StudentsEntry.SEMESTER));
                firstName= cursor.getString(cursor.getColumnIndex(DbContract.StudentsEntry.STUDENT_FNAME));
                middleName= cursor.getString(cursor.getColumnIndex(DbContract.StudentsEntry.STUDENT_MNAME));
                lastName= cursor.getString(cursor.getColumnIndex(DbContract.StudentsEntry.STUDENT_LNAME));

                StudentsModel studentsModel = new StudentsModel(
                        id,
                        firstName,
                        middleName,
                        lastName,
                        semester
                );

                lists.add(studentsModel);

            }
        }


        return lists;
    }

}
