package com.example.spacedog;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PreGameSelection extends AppCompatActivity {

    ImageView dog1Iv, dog2Iv, dog3Iv;
    TextView dogsTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_game_selection);

        //setting the orientation to landscape
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


        dog1Iv = findViewById(R.id.dog1_iv);
        dog2Iv = findViewById(R.id.dog2_iv);
        dog3Iv = findViewById(R.id.dog3_iv);
        dogsTv = findViewById(R.id.dogs_tv);

        ObjectAnimator animator;
        ObjectAnimator animator2;

        animator = ObjectAnimator.ofFloat(dogsTv,"scaleX",1,0.8f).setDuration(1000);
        animator2 = ObjectAnimator.ofFloat(dogsTv,"scaleY",1,0.8f).setDuration(1000);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setRepeatCount(100);
        animator2.setRepeatMode(ValueAnimator.REVERSE);
        animator2.setRepeatCount(100);
        AnimatorSet set1 = new AnimatorSet();
        set1.playTogether(animator,animator2);
        set1.start();

//        animator = ObjectAnimator.ofFloat(dogsTv,"translationX",100).setDuration(1000);
//        animator2 = ObjectAnimator.ofFloat(dogsTv,"translationY",100).setDuration(1000);
//        animator.setRepeatMode(ValueAnimator.REVERSE);
//        animator.setRepeatCount(100);
//        animator2.setRepeatMode(ValueAnimator.REVERSE);
//        animator2.setRepeatCount(100);
//        AnimatorSet set1 = new AnimatorSet();
//        set1.playTogether(animator,animator2);
//        set1.start();

        animator = ObjectAnimator.ofFloat(dog1Iv,"rotation",20).setDuration(1500);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setRepeatCount(100);
        animator.start();

        animator = ObjectAnimator.ofFloat(dog2Iv,"rotation",20).setDuration(1500);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setRepeatCount(100);
        animator.start();

        animator = ObjectAnimator.ofFloat(dog3Iv,"rotation",20).setDuration(1500);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setRepeatCount(100);
        animator.start();

        boolean gameSound;
        boolean gameMusic;

        final SharedPreferences sharedPreferences = getSharedPreferences("high_score", MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();

        gameSound = sharedPreferences.getBoolean("sound",true);
        gameMusic = sharedPreferences.getBoolean("music",true);

//        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.intro_music);
//        if (gameMusic) {
//            mediaPlayer.start();
//            mediaPlayer.setLooping(true);
//        }

        Button level1Btn = findViewById(R.id.level_1_btn);
        level1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mediaPlayer.stop();
                editor.putInt("level",1);
                editor.commit();
                startActivity(new Intent(PreGameSelection.this, GameActivity.class));
                finish();
            }
        });

        Button level2Btn = findViewById(R.id.level_2_btn);
        level2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putInt("level",2);
                editor.commit();
                startActivity(new Intent(PreGameSelection.this, GameActivity.class));
                finish();
            }
        });

        Button level3Btn = findViewById(R.id.level_3_btn);
        level3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putInt("level",3);
                editor.commit();
                startActivity(new Intent(PreGameSelection.this, GameActivity.class));
                finish();
            }
        });
    }


    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        startActivity(new Intent(PreGameSelection.this, MainActivity.class));
        finish();
    }
}
