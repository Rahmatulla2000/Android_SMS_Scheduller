package com.example.android_sms_scheduller;

import static android.provider.ContactsContract.Contacts.HAS_PHONE_NUMBER;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.BreakIterator;
import java.util.Calendar;

public class sms_fragment extends Fragment implements View.OnClickListener{


    TextView phone, cName, cMessage, Stime, Sdate;
    ImageView picContact,ImagDate,ImageTime;
    Button Send;
    private int mYear, mMonth, mDay, mHour, mMinute;

    public sms_fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sms_fragment, container, false);

        phone = view.findViewById(R.id.Phone);
        cName = view.findViewById(R.id.cName);
        cMessage = view.findViewById(R.id.cMessage);
        Stime = view.findViewById(R.id.STime);
        Sdate = view.findViewById(R.id.Sdate);
        picContact = view.findViewById(R.id.picContract);
        Send = view.findViewById(R.id.Send);
        ImagDate=view.findViewById(R.id.imageDate);
        ImageTime=view.findViewById(R.id.imageTime);

        ImagDate.setOnClickListener(this);
        ImageTime.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        if (v ==ImagDate ) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(requireActivity(),
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            Sdate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (v == ImageTime) {

            // Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(requireActivity(),
                    new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {
                            Stime.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }
    }
}