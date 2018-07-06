package com.thevarungupta.splashscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class StartActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // remove title and must be called before content set
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_start);
//
//        imageView = (ImageView) findViewById(R.id.logo);
//        textView = (TextView) findViewById(R.id.tag_line);
//        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        StartAnimations();
    }

//    private void LoadActivity() {
//        startActivity(new Intent(StartScreen.this, MainActivity.class));
//        finish();
//    }

    private void StartAnimations() {
//        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
//        anim.reset();
//        imageView.clearAnimation();
//        textView.clearAnimation();
//
//        imageView.startAnimation(anim);
//        textView.startAnimation(anim);
//        anim.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//                new TaskCheckVersion().execute();
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//
//            }
//        });
    }
}
