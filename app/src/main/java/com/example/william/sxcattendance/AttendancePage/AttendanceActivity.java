package com.example.william.sxcattendance.AttendancePage;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.william.sxcattendance.AttendancePage.Adapter.AttendanceAdapter;
import com.example.william.sxcattendance.AttendancePage.DataModel.StudentsModel;
import com.example.william.sxcattendance.AttendancePage.MVP.AttendanceModel;
import com.example.william.sxcattendance.AttendancePage.MVP.AttendancePresenter;
import com.example.william.sxcattendance.DataBase.SqlQuery;
import com.example.william.sxcattendance.R;

import java.util.ArrayList;
import java.util.List;

public class AttendanceActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, Contract.View,Contract.View.setValues {

    public static final String DEPARTMENT_NAME = "department_name";
    private RecyclerView recyclerView;
    private AttendancePresenter attendancePresenter;
    private GridLayoutManager gridLayoutManager;
    private AttendanceAdapter attendanceAdapter;
    private TextView presentStatus, absentStatus;
    private TextView totalStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String name = getIntent().getStringExtra(DEPARTMENT_NAME);
        Log.d("department", "onCreate: "+name);


        attendancePresenter = new AttendancePresenter(this,new AttendanceModel(this));
        attendancePresenter.set();
        attendancePresenter.sendData(name);

        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.setDrawerIndicatorEnabled(false);

        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(GravityCompat.START);
            }
        });

        toggle.setHomeAsUpIndicator(R.drawable.att_hamburger);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void handleEvent() {

    }

    @Override
    public void initialize() {
        recyclerView = findViewById(R.id.recycler_view);
        presentStatus = findViewById(R.id.present_number);
        absentStatus = findViewById(R.id.absent_number);
        totalStudent = findViewById(R.id.total_student);


        gridLayoutManager = new GridLayoutManager(this,6);

    }

    @Override
    public void setData(List<StudentsModel> studentNames) {

        presentStatus.setText(String.valueOf(studentNames.size()));
        totalStudent.setText(String.valueOf(studentNames.size()));
        int currentPresent = Integer.parseInt(presentStatus.getText().toString());
        int currentAbsent = Integer.parseInt(absentStatus.getText().toString());

        attendanceAdapter = new AttendanceAdapter(this,studentNames,this,currentAbsent,currentPresent);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(attendanceAdapter);
    }



    @Override
    public void showToast(String message) {

    }

    @Override
    public void startActivty(int Position) {

    }

    @Override
    public void setAbsentAndPresent(int currentPresent, int currentAbsent) {
        presentStatus.setText(String.valueOf(currentPresent));
        absentStatus.setText(String.valueOf(currentAbsent));
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return true;
    }
}
