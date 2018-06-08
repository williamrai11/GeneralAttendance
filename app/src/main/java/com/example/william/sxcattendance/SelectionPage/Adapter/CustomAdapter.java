package com.example.william.sxcattendance.SelectionPage.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.william.sxcattendance.R;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private Context context;
    private ArrayList<String> semesters;

    public CustomAdapter(Context context,ArrayList<String> semesters){
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
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.list_view_details,null);

        TextView names = view.findViewById(R.id.names);
                names.setText(semesters.get(position));

        return view;
    }
}
