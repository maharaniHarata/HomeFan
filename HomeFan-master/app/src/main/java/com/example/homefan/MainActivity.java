package com.example.homefan;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton toggeButton;
    ImageView imageView;
    ObjectAnimator rotateAnimator;
    Switch switchButton;
    SeekBar seekBar;
    final int SPEED[] = {0,5000,3000,1000};
    GradientDrawable gd = new GradientDrawable();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toggeButton = (ToggleButton) findViewById(R.id.off);
        imageView = (ImageView) findViewById(R.id.kipas);
        switchButton = (Switch) findViewById(R.id.nyala);
        seekBar = (SeekBar) findViewById(R.id.kecepatan);
        rotateAnimator = ObjectAnimator.ofFloat(imageView, "rotation", 0, 360 );
        rotateAnimator.setDuration(1000);
        rotateAnimator.setRepeatCount(ValueAnimator.INFINITE);
        rotateAnimator.setInterpolator(new LinearInterpolator());
        gd.setShape(GradientDrawable.OVAL);
        gd.setGradientType(GradientDrawable.RADIAL_GRADIENT);
        gd.setGradientRadius(330);

        toggeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toggeButton.isChecked() == true){
                    rotateAnimator.setDuration(SPEED[1]);
                    rotateAnimator.start();
                }else{
                    rotateAnimator.end();
                }
            }
        });

        switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(switchButton.isChecked() == true){
                    gd.setColors(new int[]{
                            Color.BLUE, Color.TRANSPARENT
                    });
                    imageView.setBackground(gd);
                }else{
                    imageView.setBackgroundColor(Color.TRANSPARENT);
                }

            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            int seekBarProgress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    rotateAnimator.setDuration(SPEED[progress]);
                    rotateAnimator.start();
                }else{
                    rotateAnimator.end();
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }



}
