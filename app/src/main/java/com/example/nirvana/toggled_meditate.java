package com.example.nirvana;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class toggled_meditate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toggled_meditate);
        final Button meditate1 = (Button)findViewById(R.id.togglemeditate);
        final ImageView home1 =(ImageView)findViewById(R.id.togglehome);
        home1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),HomeActivity.class);
                Pair[] pairs= new Pair[2];
                pairs[0]= new Pair<View,String>(meditate1,"toggle");
                pairs[1]=new Pair<View,String>(home1,"imageTransition");
                ActivityOptions options=  ActivityOptions.makeSceneTransitionAnimation(toggled_meditate.this,
                        pairs);
                startActivity(intent,options.toBundle());

            }
        });
        meditate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(toggled_meditate.this,MeditateScreen.class);
                startActivity(intent);
            }
        });

        final Button media=(Button)findViewById(R.id.media);
        final Button learn=(Button)findViewById(R.id.learn);
        final Button calendar=(Button)findViewById(R.id.calendar);

        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(toggled_meditate.this,toggled_calendar.class);
                startActivity(intent);
                overridePendingTransition(R.anim.no_anim,R.anim.slide_down);
            }
        });
        media.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(toggled_meditate.this,toggled_media.class);
                startActivity(intent);
                overridePendingTransition(R.anim.no_anim,R.anim.slide_down);
            }
        });
        learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(toggled_meditate.this,toggled_learn.class);
                startActivity(intent);
                overridePendingTransition(R.anim.no_anim,R.anim.slide_down);
            }
        });
    }
}
