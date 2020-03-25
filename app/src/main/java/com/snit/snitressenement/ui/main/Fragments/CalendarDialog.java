package com.snit.snitressenement.ui.main.Fragments;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;

import com.snit.snitressenement.R;


public class CalendarDialog extends DialogFragment implements View.OnClickListener {

    private DatePicker datePicker;
    private Button button;
    private boolean isDatesetted = false;
    private int year;
    private int month;
    private int day;;
    public Date1Listner listner;

    public interface Date1Listner{
        public void onAppDateSelected(int year, int month, int day);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.calender, container, false);
        getDialog().setTitle("DatePicker");
        datePicker = (DatePicker) rootview.findViewById(R.id.datepicker);
        button = (Button) rootview.findViewById(R.id.button);
        button.setOnClickListener(this);


        if(isDatesetted){
            datePicker.updateDate(year, month,day);
        }

        return rootview;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.button:
                int year = datePicker.getYear();
                int month = datePicker.getMonth()+1;
                int day = datePicker.getDayOfMonth();
                listner.onAppDateSelected(year, month, day);
                break;
        }
        this.dismiss();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            listner = (Date1Listner) getTargetFragment();
            System.out.println(listner);
        }catch (ClassCastException e){

        }
    }

    public void setDate(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
        this.isDatesetted = true;
    }


}