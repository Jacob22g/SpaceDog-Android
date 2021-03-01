package com.example.spacedog;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity{

    List<Map<String,Object>> data;
    HashMap<String,Object> temp1;
    HashMap<String,Object> temp2;
    HashMap<String,Object> temp3;
    HashMap<String,Object> temp4;
    HashMap<String,Object> temp5;
    HashMap<String,Object> temp6;
    HashMap<String,Object> temp7;
    HashMap<String,Object> temp8;
    HashMap<String,Object> temp9;
    HashMap<String,Object> temp10;

    private Button buttonPlay;
    private Button buttonScore;
    private Button buttonSettings;
    MediaPlayer mediaPlayer;

    boolean gameSound;
    boolean gameMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting the orientation to landscape
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        ImageView pawIv = findViewById(R.id.paw_iv);
        buttonPlay = findViewById(R.id.play_btn);
        ImageView spacemanDogIv = findViewById(R.id.space_man_dog);

        // set animation
        ObjectAnimator animator;
        ObjectAnimator animator2;

        animator = ObjectAnimator.ofFloat(pawIv,"rotation",360,1).setDuration(6000);
        animator.setRepeatCount(100);
        animator.start();

        animator = ObjectAnimator.ofFloat(buttonPlay,"scaleX",1.1f,1).setDuration(2000);
        animator2 = ObjectAnimator.ofFloat(buttonPlay,"scaleY",1.1f,1).setDuration(2000);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setRepeatCount(100);
        animator2.setRepeatMode(ValueAnimator.REVERSE);
        animator2.setRepeatCount(100);
        AnimatorSet set1 = new AnimatorSet();
        set1.playTogether(animator,animator2);
        set1.start();

        animator = ObjectAnimator.ofFloat(spacemanDogIv,"translationX",100).setDuration(5000);
        animator2 = ObjectAnimator.ofFloat(spacemanDogIv,"translationY",300).setDuration(5000);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setRepeatCount(100);
        animator2.setRepeatMode(ValueAnimator.REVERSE);
        animator2.setRepeatCount(100);
        AnimatorSet set2 = new AnimatorSet();
        set2.playTogether(animator,animator2);
        set2.start();

        data = new ArrayList<>();
        temp1 = new HashMap<>();
        temp2 = new HashMap<>();
        temp3 = new HashMap<>();
        temp4 = new HashMap<>();
        temp5 = new HashMap<>();
        temp6 = new HashMap<>();
        temp7 = new HashMap<>();
        temp8 = new HashMap<>();
        temp9 = new HashMap<>();
        temp10 = new HashMap<>();

        final SharedPreferences sharedPreferences = getSharedPreferences("high_score", MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();

        gameSound = sharedPreferences.getBoolean("sound",true);
        gameMusic = sharedPreferences.getBoolean("music",true);

        mediaPlayer = MediaPlayer.create(this, R.raw.intro_music);
        if (gameMusic) {
            mediaPlayer.start();
            mediaPlayer.setLooping(true);
        }


        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();

                startActivity(new Intent(MainActivity.this, PreGameSelection.class));

            }
        });

        buttonScore = findViewById(R.id.high_score_btn);
        buttonScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                View dialogViewHighScore = getLayoutInflater().inflate(R.layout.dialog_high_score, null);
                ListView listView = dialogViewHighScore.findViewById(R.id.listView);

                ArrayList<String> HighScore = new ArrayList<>();

                for(int j = 0; j < 10; j++ ){
                    HighScore.add(String.valueOf(j+1) + " " + sharedPreferences.getString("namePlayer"+(j+1),"") + " " +sharedPreferences.getInt("score"+(j+1),0));
                }

                data.clear();

                temp1.put("id","1.");
                temp1.put("name",sharedPreferences.getString("namePlayer"+(1),""));
                temp1.put("score",sharedPreferences.getInt("score"+(1),0));
                data.add(temp1);

                temp2.put("id","2.");
                temp2.put("name",sharedPreferences.getString("namePlayer"+(2),""));
                temp2.put("score",sharedPreferences.getInt("score"+(2),0));
                data.add(temp2);

                temp3.put("id","3.");
                temp3.put("name",sharedPreferences.getString("namePlayer"+(3),""));
                temp3.put("score",sharedPreferences.getInt("score"+(3),0));
                data.add(temp3);

                temp4.put("id","4.");
                temp4.put("name",sharedPreferences.getString("namePlayer"+(4),""));
                temp4.put("score",sharedPreferences.getInt("score"+(4),0));
                data.add(temp4);

                temp5.put("id","5.");
                temp5.put("name",sharedPreferences.getString("namePlayer"+(5),""));
                temp5.put("score",sharedPreferences.getInt("score"+(5),0));
                data.add(temp5);

                temp6.put("id","6.");
                temp6.put("name",sharedPreferences.getString("namePlayer"+(6),""));
                temp6.put("score",sharedPreferences.getInt("score"+(6),0));
                data.add(temp6);

                temp7.put("id","7.");
                temp7.put("name",sharedPreferences.getString("namePlayer"+(7),""));
                temp7.put("score",sharedPreferences.getInt("score"+(7),0));
                data.add(temp7);

                temp8.put("id","8.");
                temp8.put("name",sharedPreferences.getString("namePlayer"+(8),""));
                temp8.put("score",sharedPreferences.getInt("score"+(8),0));
                data.add(temp8);

                temp9.put("id","9.");
                temp9.put("name",sharedPreferences.getString("namePlayer"+(9),""));
                temp9.put("score",sharedPreferences.getInt("score"+(9),0));
                data.add(temp9);

                temp10.put("id","10.");
                temp10.put("name",sharedPreferences.getString("namePlayer"+(10),""));
                temp10.put("score",sharedPreferences.getInt("score"+(10),0));
                data.add(temp10);


                String [] from = {"id" , "name" , "score"};
                int [] ids = {R.id.number,R.id.name,R.id.score};

                SimpleAdapter simpleAdapter = new SimpleAdapter(MainActivity.this,data,R.layout.score_cell,from,ids);
                listView.setAdapter(simpleAdapter);
                //ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1, HighScore);
                //listView.setAdapter(adapter);
                builder.setView(dialogViewHighScore).show();

            }
        });

        buttonSettings = findViewById(R.id.settings_btn);
        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                View dialogViewSettings = getLayoutInflater().inflate(R.layout.dialog_settings, null);

                builder.setView(dialogViewSettings).show();

                CheckBox soundCheckBox = dialogViewSettings.findViewById(R.id.sound_cb);
                soundCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        gameSound = isChecked;
                        editor.putBoolean("sound",gameSound);
                        editor.commit();
                    }
                });
                CheckBox musicCheckBox = dialogViewSettings.findViewById(R.id.music_cb);
                musicCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        gameMusic = isChecked;
                        if (gameMusic) {
                            mediaPlayer.start();
                            mediaPlayer.setLooping(true);
                        } else {
                            mediaPlayer.pause();
                        }
                        editor.putBoolean("music",gameMusic);
                        editor.commit();
                    }
                });

                musicCheckBox.setChecked(gameMusic);
                soundCheckBox.setChecked(gameSound);

//                if (gameMusic) {
//                    mediaPlayer.start();
//                    mediaPlayer.setLooping(true);
//                } else {
//                    mediaPlayer.pause();
//                }

            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (gameMusic)
            mediaPlayer.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (gameMusic) {
            mediaPlayer.start();
            mediaPlayer.setLooping(true);
        }
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
