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
    private ImageView sheild;
    private TextView weGuideYou;
    private View sheildBox;
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
        sheild = findViewById(R.id.sheildx);
        weGuideYou = findViewById(R.id.weGuideYoux);
        sheildBox = findViewById(R.id.sheildBox);
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
        Animation move_down3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_down);
        move_down.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                refugees.setVisibility(View.VISIBLE);
                sheild.setVisibility(View.VISIBLE);
                weGuideYou.setVisibility(View.VISIBLE);
                leftWall.animate().setDuration(0).translationYBy(732);
                rightWall.animate().setDuration(0).translationYBy(732);
                move_sideways();
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        roof.startAnimation(move_down3);
        leftWall.startAnimation(move_down2);
        rightWall.startAnimation(move_down);
    }
    public void move_sideways() {
        Animation move_sideways_right = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_sideways_right);
        Animation move_sideways_left = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_sideways_left);
        leftWall.startAnimation(move_sideways_right);
        rightWall.startAnimation(move_sideways_left);
        leftBox.startAnimation(move_sideways_left);
        rightBox.startAnimation(move_sideways_right);
        move_sideways_left.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                move_sheild_box();
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }
    public void move_sheild_box() {
        Animation move_sheild_box = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_sheild_box);
        move_sheild_box.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                sheildBox.animate().setDuration(0).translationXBy(210);
                move_sheild();
            }
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        sheildBox.startAnimation(move_sheild_box);
    }
    public void move_sheild() {
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_sheild);
        Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_sheild);
        sheild.startAnimation(animation);
        sheildBox.startAnimation(animation2);
    }
}