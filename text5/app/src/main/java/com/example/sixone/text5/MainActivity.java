package com.example.sixone.text5;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int m=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button star = (Button) findViewById(R.id.star);
        Button me= (Button) findViewById(R.id.me);
        Button mont = (Button) findViewById(R.id.mont);
        Button input_bt = (Button) findViewById(R.id.input_bt);
        Button behind = (Button) findViewById(R.id.behind);
        final View turntable = findViewById(R.id.turntable);


        //取的intent中的bundle物件
        Bundle input_b =this.getIntent().getExtras();
        //String a_str =input_b.getString("a_str");


        final ValueAnimator animator = ValueAnimator.ofFloat(0, 1.0f);
        animator.setDuration(2000);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        // ValueAnimator.INFINITE 無限重播
        // animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new DecelerateInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float value = (float) valueAnimator.getAnimatedValue();
                turntable.setRotation(m * value);
            }
        });

        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                String values = "";
                if (m % 360 <= 44 && m % 360 >= 0) {
                    values = "H";
                    Toast.makeText(MainActivity.this, "來去吃 " + values, Toast.LENGTH_SHORT).show();
                } else if (m % 360 <= 89 && m % 360 >= 45) {
                    values ="G";
                    Toast.makeText(MainActivity.this, "來去吃 " + values, Toast.LENGTH_SHORT).show();
                } else if (m % 360 <= 134 && m % 360 >= 90) {
                    values = "F";
                    Toast.makeText(MainActivity.this, "來去吃 " + values, Toast.LENGTH_SHORT).show();
                } else if (m % 360 <= 179 && m % 360 >= 135) {
                    values = "E";
                    Toast.makeText(MainActivity.this, "來去吃 " + values, Toast.LENGTH_SHORT).show();
                } else if (m% 360 <= 224 && m % 360 >= 180) {
                    values = "D";
                    Toast.makeText(MainActivity.this, "來去吃 " + values, Toast.LENGTH_SHORT).show();
                } else if (m% 360 <= 269 && m % 360 >= 225) {
                    values = "C";
                    Toast.makeText(MainActivity.this, "來去吃 " + values, Toast.LENGTH_SHORT).show();
                } else if (m % 360 <= 314 && m % 360 >= 270) {
                    values = "B";
                    Toast.makeText(MainActivity.this, "來去吃 " + values, Toast.LENGTH_SHORT).show();
                } else if (m % 360 <= 359 && m % 360 >= 315) {
                    values = "A";
                    Toast.makeText(MainActivity.this, "來去吃 " + values, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int n = (int) (Math.random() * 1500) + 360;
                m = n;
                turntable.setRotation(0);
                animator.start();
            }
        });

        mont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,  mont.class);
                startActivity(intent);
                MainActivity.this.finish();
            }
        });
        behind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent();
                intent2.setClass(MainActivity.this,behind.class);
                startActivity(intent2);
                MainActivity.this.finish();
            }
        });
        input_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent();
                intent3.setClass(MainActivity.this,input.class);
                startActivity(intent3);
                MainActivity.this.finish();

            }
        });
       /* me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text = "";
                text=a_str;
                Toast.makeText(MainActivity.this, "來去吃 " + text, Toast.LENGTH_SHORT).show();
            }
        });*/

    }
}