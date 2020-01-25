package com.example.nirvana;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class toggled_learn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toggled_learn);
        final Button learn1 = (Button)findViewById(R.id.toggledLearn);
        final ImageView home1 =(ImageView)findViewById(R.id.toggleLearn);
        home1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),HomeActivity.class);
                Pair[] pairs= new Pair[2];
                pairs[0]= new Pair<View,String>(learn1,"toggleLearn");
                pairs[1]=new Pair<View,String>(home1,"imageTransition");
                ActivityOptions options=  ActivityOptions.makeSceneTransitionAnimation(toggled_learn.this,
                        pairs);
                startActivity(intent,options.toBundle());


            }
        });

        learn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(toggled_learn.this,LearnScreen.class);
                startActivity(intent);

            }
        });

        final Button meditate=(Button)findViewById(R.id.meditate);
        final Button calendar=(Button)findViewById(R.id.calendar);
        final Button media=(Button)findViewById(R.id.media);

        media.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(toggled_learn.this,toggled_media.class);
                startActivity(intent);
                overridePendingTransition(R.anim.no_anim,R.anim.slide_down);
            }
        });
        meditate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(toggled_learn.this,toggled_meditate.class);
                startActivity(intent);
                overridePendingTransition(R.anim.no_anim,R.anim.slide_down);
            }
        });
        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(toggled_learn.this,toggled_calendar.class);
                startActivity(intent);
                overridePendingTransition(R.anim.no_anim,R.anim.slide_down);;
            }
        });
    }
}
