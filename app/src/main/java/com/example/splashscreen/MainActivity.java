package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ImageView topImage;
    private ImageView bottomImage;
    private ImageView bottomImageLight;
    private ImageView roof;
    private ImageView leftWall;
    private ImageView rightWall;
    private TextView refugees;
    private View leftBox;
    private View rightBox;
    Interpolator interpolator = new OvershootInterpolator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        topImage = (ImageView)findViewById(R.id.topImage);
        bottomImage = (ImageView)findViewById(R.id.bottomImage);
        bottomImageLight = (ImageView)findViewById(R.id.bottomImageLight);
        roof = findViewById(R.id.roofx);
        leftWall = findViewById(R.id.leftWallx);
        rightWall = findViewById(R.id.rightWallx);
        refugees = findViewById(R.id.refugeesx);
        leftBox = findViewById(R.id.leftBox);
        rightBox = findViewById(R.id.rightBox);
//        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//        getWindow().setStatusBarColor(Color.argb(1,128, 172, 239));
        move_top();
        move_down();

    }
    public void move_bottom() {
        Animation move_bottom = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_bottom);
        bottomImage.startAnimation(move_bottom);
        bottomImageLight.startAnimation(move_bottom);
    }
    public void move_top() {
        Animation move = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
        move.setAnimationListener(new Animation.AnimationListener(){
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                move_bottom();
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        topImage.startAnimation(move);
    }
    public void move_down() {
        Animation move_down = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_down);
        Animation move_down2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_down);
        move_down.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                refugees.setVisibility(View.VISIBLE);
                leftWall.animate().setDuration(0).translationYBy(732);
                rightWall.animate().setDuration(0).translationYBy(732);
                move_sideways();
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        roof.startAnimation(move_down);
        leftWall.startAnimation(move_down2);
        rightWall.startAnimation(move_down);
    }
    public void move_sideways() {
        Animation move_sideways_right = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_sideways_right);
        Animation move_sideways_right2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_sideways_right);
        Animation move_sideways_left = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_sideways_left);
        Animation move_sideways_left2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_sideways_left);
        leftWall.startAnimation(move_sideways_right2);
        rightWall.startAnimation(move_sideways_left2);
        leftBox.startAnimation(move_sideways_left);
        rightBox.startAnimation(move_sideways_right);
    }
}