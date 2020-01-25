package com.example.nirvana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class LearnScreen extends AppCompatActivity {

    ListView mListView;

    String[] countryNames = {"What the Buddha Taught ", "Mindfulness of Breathing ", "A Buddhist Dictionary ", "Authenticity ", "Buddhism and Science "};
    int[] countryFlags = {R.drawable.one,
            R.drawable.two,
            R.drawable.three,
            R.drawable.four,
            R.drawable.five,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_screen);
        mListView = (ListView) findViewById(R.id.listview);
        com.example.nirvana.MyAdapter myAdapter = new com.example.nirvana.MyAdapter(LearnScreen.this, countryNames, countryFlags);
        mListView.setAdapter(myAdapter);


    }
}
