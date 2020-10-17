package com.example.splashscreen;


import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class AnimateLogo extends AppCompatActivity {
    ImageView roof;
    ImageView leftWall;
    ImageView rightWall;
    AnimateLogo() {
        roof = findViewById(R.id.roofx);
        leftWall = findViewById(R.id.leftWallx);
        rightWall = findViewById(R.id.rightWallx);
    }
    public void move_down() {
        Animation move_down = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_down);
        roof.startAnimation(move_down);
        leftWall.startAnimation(move_down);
        rightWall.startAnimation(move_down);
    }
}
