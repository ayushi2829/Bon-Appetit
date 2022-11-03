package com.example.bonappetit;

import static android.view.View.GONE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.bonappetit.activities.WelcomeActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

@SuppressWarnings("ALL")
public class SplashActivity extends AppCompatActivity {

    View bowl, bike;
    Animation middleAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        middleAnimation = AnimationUtils.loadAnimation(this,R.anim.middle_animation);

        bowl = findViewById(R.id.bowl) ;
        bike = findViewById(R.id.bike);

        bike.setAnimation(middleAnimation);

        bowl.animate().alpha(0.0f).setDuration(2000).withEndAction(new Runnable() {
            @Override
            public void run() {
                bowl.setVisibility(GONE);
            }
        });

        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(3800);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
                if (currentUser != null) {
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Intent intent = new Intent(SplashActivity.this, WelcomeActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });thread.start();
    }
}