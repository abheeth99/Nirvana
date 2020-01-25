package com.example.nirvana;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class HomeActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homescreen);

        final TextView quote = (TextView)findViewById(R.id.quote);
        final Button meditate = (Button)findViewById(R.id.meditate);
        final Button learn = (Button)findViewById(R.id.learn);
        final Button media = (Button)findViewById(R.id.media);
        final Button calendar = (Button)findViewById(R.id.calendar);
        final ImageView home =(ImageView)findViewById(R.id.home);

        //quotes tika dapung methana
        final String[] quotes = new String[] { "Three things cannot be long hidden: the sun, the moon, and the truth.", "The mind is everything. What you think you become.", "Do not dwell in the past, do not dream of the future, concentrate the mind on the present moment.",
                "You, yourself, as much as anybody in the entire universe, deserve your love and affection", "All that we are is the result of what we have thought", "Peace comes from within. Do not seek it without.", "All that we are is the result of what we have thought.", "Three things cannot be long hidden: the sun, the moon, and the truth.", "The mind is everything. What you think you become.", "All that we are is the result of what we have thought.", };

        final Handler h = new Handler();
        h.post(new Runnable() {
            @Override
            public void run() {
                Random generator = new Random();
                final int random = generator.nextInt(quotes.length);
                quote.setText(quotes[random]);
                h.postDelayed(this, 6000);
            }
        });
        meditate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),toggled_meditate.class);
                Pair [] pairs= new Pair[2];
                pairs[0]= new Pair<View,String>(meditate,"toggle");
                pairs[1]=new Pair<View,String>(home,"imageTransition");
                ActivityOptions options=  ActivityOptions.makeSceneTransitionAnimation(HomeActivity.this,
                        pairs);
                startActivity(intent,options.toBundle());

            }
        });
        learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),toggled_learn.class);
                Pair [] pairs= new Pair[2];
                pairs[0]= new Pair<View,String>(learn,"toggleLearn");
                pairs[1]=new Pair<View,String>(home,"imageTransition");
                ActivityOptions options=  ActivityOptions.makeSceneTransitionAnimation(HomeActivity.this,
                        pairs);
                startActivity(intent,options.toBundle());

            }
        });
        media.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),toggled_media.class);
                Pair [] pairs= new Pair[2];
                pairs[0]= new Pair<View,String>(media,"toggleMedia");
                pairs[1]=new Pair<View,String>(home,"imageTransition");
                ActivityOptions options=  ActivityOptions.makeSceneTransitionAnimation(HomeActivity.this,
                        pairs);
                startActivity(intent,options.toBundle());

            }
        });
        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),toggled_calendar.class);
                Pair [] pairs= new Pair[2];
                pairs[0]= new Pair<View,String>(calendar,"toggleCalendar");
                pairs[1]=new Pair<View,String>(home,"imageTransition");
                ActivityOptions options=  ActivityOptions.makeSceneTransitionAnimation(HomeActivity.this,
                        pairs);
                startActivity(intent,options.toBundle());

            }
        });



    }
}
