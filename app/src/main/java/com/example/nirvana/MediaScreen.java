package com.example.nirvana;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MediaScreen extends AppCompatActivity {
    ListView mListView;

    String[] countryNames = {"The Dharma Wheel","Buddha Statue "," Think!","The Buddhist Flag","The man who changed sri lankan Buddhist school system"};
    int[] countryFlags = {R.drawable.six,
            R.drawable.seven,
            R.drawable.eight,
            R.drawable.nine,
            R.drawable.ten};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_screen);
        mListView = (ListView) findViewById(R.id.listview2);
        com.example.nirvana.MyAdapter2 myAdapter = new com.example.nirvana.MyAdapter2(MediaScreen.this, countryNames, countryFlags);
        mListView.setAdapter(myAdapter);
    }
}
