package com.example.nirvana;

import java.util.Calendar;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MeditateScreen extends AppCompatActivity {

    private static TextView set_date, set_time;
    private static final int Date_id = 0;
    private static final int Time_id = 1;
    private static Button setButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditate_screen);

        boolean alarm = (PendingIntent.getBroadcast(this, 0, new Intent("ALARM"), PendingIntent.FLAG_NO_CREATE) == null);

        if(alarm){
            Intent itAlarm = new Intent("ALARM");
            PendingIntent pendingIntent = PendingIntent.getBroadcast(this,0,itAlarm,0);
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
            calendar.add(Calendar.SECOND, 3);
            AlarmManager alarme = (AlarmManager) getSystemService(ALARM_SERVICE);
            alarme.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),60000, pendingIntent);
        }

        set_date = (TextView) findViewById(R.id.setDate);
        set_time = (TextView) findViewById(R.id.setTime);
        set_date.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                // Show Date dialog
                showDialog(Date_id);
            }
        });
        set_time.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                // Show time dialog
                showDialog(Time_id);
            }
        });

        setButton=(Button)findViewById(R.id.set);
        setButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                if(set_time.getText().toString()=="Set time" || set_date.getText().toString()=="Set date"){
                    Toast.makeText(getApplicationContext(),"Please set a date and time",Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent("app.BroadcastManager");
                    intent.putExtra("date", set_date.getText().toString());
                    intent.putExtra("time", set_time.getText().toString());
                    sendBroadcast(intent);
                    set_time.setText("Set time");
                    set_date.setText("Set date");
                    Toast.makeText(getApplicationContext(), "Reminder Set", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    protected Dialog onCreateDialog(int id) {

        // Get the calander
        Calendar c = Calendar.getInstance();

        // From calander get the year, month, day, hour, minute
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        switch (id) {
            case Date_id:

                // Open the datepicker dialog
                return new DatePickerDialog(MeditateScreen.this, date_listener, year,
                        month, day);
            case Time_id:

                // Open the timepicker dialog
                return new TimePickerDialog(MeditateScreen.this, time_listener, hour,
                        minute, false);

        }
        return null;
    }

    // Date picker dialog
    DatePickerDialog.OnDateSetListener date_listener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int month, int day) {
            // store the data in one string and set it to text
            int eMonth=month+1;
            String date1 = (day) + "/" + (eMonth)
                    + "/" + (year);
            set_date.setText(date1);
        }
    };
    TimePickerDialog.OnTimeSetListener time_listener = new TimePickerDialog.OnTimeSetListener() {

        @Override
        public void onTimeSet(TimePicker view, int hour, int minute) {
            // store the data in one string and set it to text
            String mins;
            if(minute<10){
                mins="0"+(minute);
            }
            else{
                mins=String.valueOf(minute);
            }
            String time1 = (hour) + ":" + (mins) + ":00";
            set_time.setText(time1);
        }
    };
}
