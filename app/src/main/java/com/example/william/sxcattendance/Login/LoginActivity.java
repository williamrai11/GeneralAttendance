package com.example.william.sxcattendance.Login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.william.sxcattendance.Login.MVP.LoginModel;
import com.example.william.sxcattendance.Login.MVP.LoginPresenter;
import com.example.william.sxcattendance.Network.NetworkCalls;
import com.example.william.sxcattendance.R;
import com.example.william.sxcattendance.SelectionPage.SelectionPageActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener,Contract.View {

    private ImageView logo,animation;
    private EditText username, password;
    private TextView forgot_password,loading_text;
    private Button login;

    private LoginPresenter loginPresenter;


    private AnimationDrawable animationDrawable;
    private Animation blinkAnimation;

    private ProgressDialog progressDialog;
    private SharedPreferences loginSessionPrefs;
    private SharedPreferences.Editor editor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                                  WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        loginSessionPrefs = getSharedPreferences("loginPrefs",0);
        editor = loginSessionPrefs.edit();

        loginPresenter = new LoginPresenter(this,new LoginModel(),this);
        loginPresenter.set();

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.alp);
        blinkAnimation = AnimationUtils.loadAnimation(this,R.anim.blink);

        logo.setAnimation(animation);
        username.setAnimation(animation);
        password.setAnimation(animation);
        forgot_password.setAnimation(animation);
        logo.setAnimation(animation);
        login.setOnClickListener(this);

    }

    @Override
    public void initialize() {
        logo = findViewById(R.id.ImageLogo);
        username = findViewById(R.id.user_name);
        password = findViewById(R.id.password);
        forgot_password = findViewById(R.id.forget_password);
        login = findViewById(R.id.login);

        progressDialog = new ProgressDialog(this);

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    public void onClick(View view) {
        loginPresenter.access(username.getText().toString(),password.getText().toString());
    }

    @Override
    public void handleEvent() {

    }



    @Override
    public void showToast(String message) {
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }



    @Override
    public void startActivity() {
        editor.putBoolean("isLoggedIn",true);
        editor.apply();
        startActivity(new Intent(LoginActivity.this,SelectionPageActivity.class));
        finish();


    }

    @Override
    public void runNetworkCalls() {
        loginPresenter.getDepartmentDatas();
    }

    @Override
    public void showIfEmptyCredentials() {
        Toast.makeText(getApplicationContext(),"Some fields are missing!! Please fill up all the fields",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
      progressDialog.setMessage("Logging.......");
      progressDialog.setCancelable(false);
      progressDialog.show();

    }

    @Override
    protected void onResume() {
        boolean isLoggedIn = loginSessionPrefs.getBoolean("isLoggedIn",false);
        if (isLoggedIn){
            startActivity();
        }
        super.onResume();
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }
}
