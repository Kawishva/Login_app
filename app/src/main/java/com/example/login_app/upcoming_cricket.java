package com.example.login_app;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class upcoming_cricket extends AppCompatActivity {
    ImageButton next,previous;
    TextView currentDate;
    GridView gridView;
    DB DB;

    private static final int maxCalendarDays=42;
    Calendar calendar=Calendar.getInstance(Locale.ENGLISH);
    Context context;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM yyyy", Locale.ENGLISH);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
    SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM",Locale.ENGLISH);
    SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy",Locale.ENGLISH);

    MyGridAdapter myGridAdapter;
    AlertDialog alertDialog;
    List<Date> dates=new ArrayList<>();
    List<Events> eventsList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming_cricket);
        next=findViewById(R.id.next);
        previous=findViewById(R.id.previous);
        currentDate=findViewById(R.id.currentDate);
        gridView=findViewById(R.id.gridview);

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar.add(Calendar.MONTH,-1);
                SetUpCalendar();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar.add(Calendar.MONTH,1);
                SetUpCalendar();
            }
        });

       gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder=new AlertDialog.Builder(context);
                builder.setCancelable(true);
                View addView=LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_add_new_event,null);
                EditText EventName=addView.findViewById(R.id.events_id);
                TextView EventTime=addView.findViewById(R.id.eventtime);
                ImageButton SetTime=addView.findViewById(R.id.seteventtime);
                Button AddEvent = addView.findViewById(R.id.addevent);
                SetTime.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Calendar calendar = Calendar.getInstance();
                        int hours=calendar.get(Calendar.HOUR_OF_DAY);
                        int minuts=calendar.get(Calendar.MINUTE);
                        TimePickerDialog timePickerDialog=new TimePickerDialog(addView.getContext(), androidx.constraintlayout.widget.R.style.Theme_AppCompat_Dialog, new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                Calendar c=Calendar.getInstance();
                                c.set(Calendar.HOUR_OF_DAY,hourOfDay);
                                c.set(Calendar.MINUTE,minute);
                                c.setTimeZone(TimeZone.getDefault());
                                SimpleDateFormat hformate=new SimpleDateFormat("K:mm a",Locale.ENGLISH);
                                String event_Time=hformate.format(c.getTime());
                                EventTime.setText(event_Time);
                            }
                        },hours,minuts,false);
                        timePickerDialog.show();
                    }
                });
                String date=dateFormat.format(dates.get(position));
                String month=monthFormat.format(dates.get(position));
                String year=yearFormat.format(dates.get(position));
                AddEvent.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SaveEvent(EventName.getText().toString(),EventTime.getText().toString(),date,month,year);
                        SetUpCalendar();
                        alertDialog.dismiss();
                    }
                });
                builder.setView(addView);
                alertDialog=builder.create();
                alertDialog.show();
            }
        });
    }

    private void SaveEvent(String event,String time,String date,String month,String year){
        DB dbOpenHelper = new DB(context);
        SQLiteDatabase database=dbOpenHelper.getWritableDatabase();
        dbOpenHelper.SaveEvent(event,time,date,month,year,database);
        dbOpenHelper.close();
        Toast.makeText(context,"Event saved",Toast.LENGTH_SHORT).show();
    }

    private void IntializeLayout(){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.activity_upcoming_cricket,null);
        next = view.findViewById(R.id.next);
        previous = view.findViewById(R.id.previous);
        currentDate = view.findViewById(R.id.currentDate);
        gridView = view.findViewById(R.id.gridview);
    }
    private void SetUpCalendar() {
        String current_date=dateFormat.format(calendar.getTime());
        currentDate.setText(current_date);
        dates.clear();
        Calendar monthCalendar=(Calendar) calendar.clone();
        monthCalendar.set(Calendar.DAY_OF_MONTH,1);
        int FirstDayofMonth = monthCalendar.get(Calendar.DAY_OF_WEEK)-1;
        monthCalendar.add(Calendar.DAY_OF_MONTH,-FirstDayofMonth);

        while(dates.size()<maxCalendarDays){
            dates.add(monthCalendar.getTime());
            monthCalendar.add(Calendar.DAY_OF_MONTH,1);
        }
        //myGridAdapter=new MyGridAdapter(context,dates,calendar,eventsList);
        gridView.setAdapter(myGridAdapter);
    }

}