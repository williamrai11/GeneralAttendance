package com.example.william.sxcattendance.SelectionPage.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.william.sxcattendance.AttendancePage.AttendanceActivity;
import com.example.william.sxcattendance.R;
import com.example.william.sxcattendance.SelectionPage.Adapter.CustomAdapter;
import com.example.william.sxcattendance.SelectionPage.Contract;
import com.example.william.sxcattendance.SelectionPage.MVP.SelectionModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BScCsitFragment extends Fragment implements Contract.View {

    private FragmentPresenter fragmentPresenter;
    private ListView listView;
    private CustomAdapter adapter;
    View view;

    public BScCsitFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       view  = inflater.inflate(R.layout.fragment_selection_fragment, container, false);
       fragmentPresenter = new FragmentPresenter(this,new SelectionModel(getActivity()));
       fragmentPresenter.set();
       fragmentPresenter.sendData(0);

        return view;
    }

    @Override
    public void initialize() {
        listView = view.findViewById(R.id.bscCsit_list_view);

    }

    @Override
    public void setData(ArrayList<String> semesterNames) {
        adapter = new CustomAdapter(getActivity(),semesterNames);
        listView.setDivider(null);
        listView.setAdapter(adapter);

    }


    @Override
    public void handleEvent() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                fragmentPresenter.itemClick(position);
            }
        });
    }




    @Override
    public void showToast(String message) {
        Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void startActivty(int Position) {
        Intent intent = new Intent(getActivity(), AttendanceActivity.class);
        startActivity(intent);
    }
}
