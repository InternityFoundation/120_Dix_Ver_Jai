package com.example.maternity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.Toast;

public class SplashScreenActivity extends AppCompatActivity {

    Animation fadeIn = new AlphaAnimation(0, 1);
    Animation fadeOut = new AlphaAnimation(1, 0);
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        logo = findViewById(R.id.splashscreenlogo);
        fadeIn(logo);
        String user = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString("USER", "");
        String phone = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString("PHONE", "");
        if (user.equals("") || phone.equals(""))
        {
            startActivity(new Intent(this, LoginActivity.class));
        }else if(user.toLowerCase().equals("parent")){
            startActivity(new Intent(this, MainActivity.class).putExtra("id", phone));
        }else if (user.toLowerCase().equals("doctor")){
            startActivity(new Intent(this, DoctorHomeActivity.class).putExtra("id", phone));
        }else if (user.toLowerCase().equals("babysitter")){
            startActivity(new Intent(this, BabysitterHomeActivity.class).putExtra("id", phone));
        }else{
            Toast.makeText(this, "Something went wrong.", Toast.LENGTH_SHORT).show();
        }


    }

    public void fadeIn(final ImageView appLogoDesc) {

        fadeIn.setInterpolator(new AccelerateInterpolator());
        fadeIn.setDuration(1500);
        fadeIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                fadeOut(appLogoDesc);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

        appLogoDesc.startAnimation(fadeIn);

    }

    public void fadeOut(final ImageView appLogoDesc) {
        fadeOut.setInterpolator(new AccelerateInterpolator());
        fadeOut.setDuration(1500);
        fadeOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                fadeIn(appLogoDesc);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        appLogoDesc.startAnimation(fadeOut);

    }
}
