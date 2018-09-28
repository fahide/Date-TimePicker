package com.example.fahid.demodtaetime;

import android.app.DatePickerDialog;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Button Btn, time;
    private EditText etx, etxtime;
    private int year, month, day, hour, minute;
    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Btn = (Button) findViewById(R.id.datebtn);
        time = (Button) findViewById(R.id.timebtn);
        etx = (EditText) findViewById(R.id.editdate);
        etxtime = (EditText) findViewById(R.id.edittime);
        calendar=Calendar.getInstance(Locale.getDefault());
        year=calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR);
        minute = calendar.get(Calendar.MINUTE);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void setdate(View view) {
        DatePickerDialog dpd=new DatePickerDialog(this,datelistener,year,month,day);
        dpd.show();
    }
    private DatePickerDialog.OnDateSetListener datelistener=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            month=month+1;
            String date=year+"/"+month+"/"+dayOfMonth;
            etx.setText(date);
        }
    };


    public void settime(View view) {
        TimePickerDialog tpd=new TimePickerDialog(this,timelistener,hour,minute,false);
        tpd.show();
    }
    private TimePickerDialog.OnTimeSetListener timelistener=new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            String am_pm="";
            if (calendar.get(Calendar.AM_PM)==Calendar.AM)
                am_pm="AM";
            else if (calendar.get(Calendar.AM_PM)==Calendar.PM)
                    am_pm="PM";



            String time=hourOfDay+":"+minute+":"+am_pm;
            etxtime.setText(time);

        }
    };
}
