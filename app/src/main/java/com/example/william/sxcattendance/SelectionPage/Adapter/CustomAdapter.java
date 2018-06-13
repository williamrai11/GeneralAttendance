package com.example.william.sxcattendance.SelectionPage.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.william.sxcattendance.DataBase.Models.SemesterModel;
import com.example.william.sxcattendance.R;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private Context context;
    private List<SemesterModel> semesters;

    public CustomAdapter(Context context,List<SemesterModel> semesters){
        inflater = LayoutInflater.from(context);
        this.semesters = semesters;
    }

    @Override
    public int getCount() {
        return semesters.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewHolder;

        if (view==null){
            view = inflater.inflate(R.layout.list_view_details,null);
            viewHolder=new ViewHolder();
            viewHolder.semester = view.findViewById(R.id.names);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }

        
        int sem = semesters.get(position).getCode();

        switch (sem){
            case 1:

                viewHolder.semester.setText(sem+ "st Semester");
                break;

            case 2:
                viewHolder.semester.setText(sem+ "nd Semester");
                break;

            case 3:
                viewHolder.semester.setText(sem+ "rd Semester");
                break;

            case 4:
                viewHolder.semester.setText(sem+ "th Semester");
                break;

                default:
                    viewHolder.semester.setText(sem+ "th Semester");
                    break;


        }



        return view;
    }


    public static class ViewHolder{
     public TextView semester;

    }
}
