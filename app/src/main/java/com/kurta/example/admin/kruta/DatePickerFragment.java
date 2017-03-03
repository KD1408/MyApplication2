package com.kurta.example.admin.kruta;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;


import com.example.admin.kurta.R;

import java.util.Calendar;

/**
 * Created by kruta on 11/16/2016.
 */

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        //return new DatePickerDialog(getActivity(), R.style.datepicker, year, month, day);
        return new DatePickerDialog(getActivity(), R.style.datePicker,this,year,month,day);    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        // Do something with the date chosen by the user
        ((EditText) getActivity().findViewById(R.id.etBdate)).setText(""+(month+1)+"/"+day+"/"+year);
    }
}
