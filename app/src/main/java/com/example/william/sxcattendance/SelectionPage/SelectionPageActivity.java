package com.example.william.sxcattendance.SelectionPage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.example.william.sxcattendance.DataBase.Models.SemesterModel;
import com.example.william.sxcattendance.R;
import com.example.william.sxcattendance.SelectionPage.Fragments.BIMFragment;
import com.example.william.sxcattendance.SelectionPage.Fragments.BScCsitFragment;
import com.example.william.sxcattendance.SelectionPage.MVP.SelectionModel;
import com.example.william.sxcattendance.SelectionPage.MVP.SelectionPresenter;

import java.util.ArrayList;
import java.util.List;

public class SelectionPageActivity extends AppCompatActivity implements Contract.View {

    private Button bscCsit;
    private Button bIm;
    private SelectionPresenter presenter;
    private BScCsitFragment bScCsitFragment;
    private BIMFragment bimFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_selection__page_);

        presenter = new SelectionPresenter(this,new SelectionModel(this));
        presenter.set();
        presenter.getFragment(bScCsitFragment,getSupportFragmentManager());


    }

    @Override
    public void initialize() {
        bscCsit = findViewById(R.id.bsc_csit);
        bIm = findViewById(R.id.bim);
        bScCsitFragment = new BScCsitFragment();
        bimFragment = new BIMFragment();
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void startActivty(int Position) {

    }

    @Override
    public void handleEvent() {
        bscCsit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              presenter.getFragment(bScCsitFragment,getSupportFragmentManager());
            }
        });

        bIm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getFragment(bimFragment,getSupportFragmentManager());
            }
        });
    }

    @Override
    public void setData(List<SemesterModel> semesterNames ) {

    }


}
