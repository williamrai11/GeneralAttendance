package com.example.william.sxcattendance.Login;

import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    private ImageView logo;
    private EditText username, password;
    private TextView forgot_password;
    private Button login;

    private LoginPresenter loginPresenter;
    private NetworkCalls networkCalls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                                  WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        loginPresenter = new LoginPresenter(this,new LoginModel());
        loginPresenter.set();

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.alp);
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
        networkCalls = new NetworkCalls();

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
        networkCalls.get();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(LoginActivity.this,SelectionPageActivity.class));

            }
        },3000);
    }

    @Override
    public void showIfEmptyCredentials() {
        Toast.makeText(getApplicationContext(),"Some fields are missing!! Please fill up all the fields",Toast.LENGTH_SHORT).show();
    }
}
