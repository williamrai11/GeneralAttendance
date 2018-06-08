package com.example.william.sxcattendance.SplashScreen;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.william.sxcattendance.Login.LoginActivity;
import com.example.william.sxcattendance.R;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {

    private ProgressBar progressBar;
    private Handler handler;
    private Runnable runnable;
    private Timer timer;
    private TextView LoadingText,appText;
    private Animation animation;
    private ImageView sxc_logo;

    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //remocve title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);

        progressBar = findViewById(R.id.sxc_progressBar);
        LoadingText = findViewById(R.id.loadingText);
        sxc_logo = findViewById(R.id.sxc_logo);
        appText = findViewById(R.id.app_text);

        //blink Animation
        animation = AnimationUtils.loadAnimation(this,R.anim.blink);

        LoadingText.setVisibility(View.VISIBLE);
        LoadingText.startAnimation(animation);

        progressBar.setProgress(0);
        progressBar.setMax(100);

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                if (i<=100){

                    progressBar.setProgress(i);
                }else {
                    progressBar.setVisibility(View.GONE);
                    timer.cancel();
                    StartLoginActivity();
                }
            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                i = i+1;

                handler.post(runnable);
            }
        },0,50);

    }

    public void StartLoginActivity(){
        Intent intent = new Intent(Splash.this, LoginActivity.class);

       /* Pair [] pairs = new Pair[2];
        pairs[0] = new Pair<View,String>(sxc_logo,"text");
        pairs[1] = new Pair<View,String>(appText,"text");


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Splash.this,pairs);
            startActivity(intent,options.toBundle());
            finish();
        }
*/      startActivity(intent);
        finish();

    }
}
