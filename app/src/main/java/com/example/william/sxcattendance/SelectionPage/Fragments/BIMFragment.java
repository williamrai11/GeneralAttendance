package com.example.william.sxcattendance.SelectionPage.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.william.sxcattendance.R;
import com.example.william.sxcattendance.SelectionPage.Adapter.CustomAdapter;
import com.example.william.sxcattendance.SelectionPage.Contract;
import com.example.william.sxcattendance.SelectionPage.MVP.SelectionModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BIMFragment extends Fragment implements Contract.View {

    private FragmentPresenter fragmentPresenter;
    private ListView listView;
    private CustomAdapter customAdapter;
    private View view;


    public BIMFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_bim, container, false);
        fragmentPresenter = new FragmentPresenter(this,new SelectionModel(getActivity()));
        fragmentPresenter.set();
        fragmentPresenter.sendData(1);

        return view;
    }

    @Override
    public void initialize() {
        listView = view.findViewById(R.id.bim_list_view);

    }
    @Override
    public void setData(ArrayList<String> semesterNames) {
        customAdapter = new CustomAdapter(getActivity(),semesterNames);
        listView.setDivider(null);
        listView.setAdapter(customAdapter);
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

    }
}
