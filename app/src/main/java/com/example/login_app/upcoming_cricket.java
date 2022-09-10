package com.example.login_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class upcoming_cricket extends AppCompatActivity {
    ImageButton next,previous;
    TextView currentDate;
    GridView gridView;

    private static final int maxCalendarDays=31;
    Calendar calendar=Calendar.getInstance(Locale.ENGLISH);
    Context context;
    SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy MMMM",Locale.ENGLISH);
    SimpleDateFormat monthFormat=new SimpleDateFormat("MMMM",Locale.ENGLISH);
    SimpleDateFormat yearFormat=new SimpleDateFormat("");

    List<Date> dates=new ArrayList<>();
    List<Events> eventsList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming_cricket);
    }
}