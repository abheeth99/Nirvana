package com.example.nirvana;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import sun.bob.mcalendarview.listeners.OnDateClickListener;
import sun.bob.mcalendarview.listeners.OnMonthChangeListener;
import sun.bob.mcalendarview.views.ExpCalendarView;
import sun.bob.mcalendarview.vo.DateData;

public class calendarScreen extends FragmentActivity {
    Map <String,String> map = new HashMap<String,String>();
    Map <String,String> map2 = new HashMap<String,String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_screen);
        final TextView details = (TextView)findViewById(R.id.detailsText);
        final TextView title = (TextView)findViewById(R.id.eventTitle);
        final TextView c_date = (TextView)findViewById(R.id.date);
        ExpCalendarView calendarView = ((ExpCalendarView) findViewById(R.id.calendar_exp));
        ArrayList<DateData> dates=new ArrayList<>();
        map.put("0120","Duruthu Full Moon Poya Day");
        map.put("0219","Navam Full Moon Poya Day");
        map.put("0320","Medin Full Moon Poya Day");
        map.put("0419","Bak Full Moon Poya Day");
        map.put("0520","Vesak Full Moon Poya Day");
        map.put("0618","Poson Full Moon Poya Day");
        map.put("0720","Esala Full Moon Poya Day");
        map.put("0814","Nikini Full Moon Poya Day");
        map.put("0913","Binara Full Moon Poya Day");
        map.put("1026","Vap Full Moon Poya Day");
        map.put("1112","Il Full Moon Poya Day");
        map.put("1211","Uduvap Full Moon Poya Day");

        map2.put("0120","This is a key religious and historic date in the calendar for Sri Lankans as it marks Gautama Buddha's first visit to Sri Lanka on the ninth month after attaining Enlightenment.");
        map2.put("0219","This poya day is usually celebrated on the first full moon in February, though in some years it can take place in late January.");
        map2.put("0320","Also known as Medin Full Moon Day, this poya marks the Buddha’s first visit to his father's palace following his enlightenment.");
        map2.put("0419","This poya (Bak Pura Pasaloswaka Poya Day) commemorates the second visit of The Buddha to Sri Lanka which took place in the fifth year of his Supreme Enlightenment.");
        map2.put("0520","The Buddha's birthday is observed annually on the Sunday nearest to the full moon in May. It is a holiday observed by Buddhists across the world, though the exact date may differ from country to country.");
        map2.put("0618","This public holiday in Sri Lanka takes place on the full moon day of Poson, the seventh month in the Sinhalese calendar. It usually falls in June in the Western calendar.");
        map2.put("0720","Esala Poya takes place on the full moon in the eighth lunar month, usually in July.");
        map2.put("0814","This public holiday in Sri Lanka takes place on the full moon day of Nikini, the ninth month in the Sinhalese calendar.");
        map2.put("0913","This public holiday in Sri Lanka takes place on the full moon day of Binara, the sixth month in the Sinhalese calendar.");
        map2.put("1026","The festival Marks Buddha's preaching of Abhidamma to the gods in Tavatimsa and the end of the Buddhist period of fasting.");
        map2.put("1112","Every full moon (usually one a month) is a public holiday in Sri Lanka. Each of the full moons have its own name and they are days to commemorate key events in Buddhism");
        map2.put("1211","This public holiday in Sri Lanka takes place on the full moon day of Unduvap, the ninth month in the Sinhalese calendar.");


        //highlight the poya days like this,eken eka add karapung;

        dates.add(new DateData(2019,1,20));
        dates.add(new DateData(2019,2,19));
        dates.add(new DateData(2019,3,20));
        dates.add(new DateData(2019,4,19));
        dates.add(new DateData(2019,5,18));
        dates.add(new DateData(2019,6,16));
        dates.add(new DateData(2019,7,16));
        dates.add(new DateData(2019,8,14));
        dates.add(new DateData(2019,9,13));
        dates.add(new DateData(2019,10,26));
        dates.add(new DateData(2019,11,12));
        dates.add(new DateData(2019,12,11));
        dates.add(new DateData(2019,1,20));
        dates.add(new DateData(2020,2,19));
        dates.add(new DateData(2020,3,20));
        dates.add(new DateData(2020,4,19));




        for(int i=0;i<dates.size();i++) {
            calendarView.markDate(dates.get(i).getYear(),dates.get(i).getMonth(),dates.get(i).getDay());
        }
        calendarView.setOnMonthChangeListener(new OnMonthChangeListener() {
            @Override
            public void onMonthChange(int year, int month) {
                Toast.makeText(calendarScreen.this, String.format("%d-%d", year, month), Toast.LENGTH_SHORT).show();
            }
        });
        calendarView.setOnDateClickListener(new OnDateClickListener() {
            @Override
            public void onDateClick(View view, DateData date) {
                String key =date.getMonthString()+date.getDayString();
                String main = map.get(key);
                String discription = map2.get(key);
                title.setText(main);
                details.setText(discription);
                c_date.setText(date.getDayString());


            }
        });

    }
}