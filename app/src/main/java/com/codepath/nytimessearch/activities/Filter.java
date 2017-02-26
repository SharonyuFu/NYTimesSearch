package com.codepath.nytimessearch.activities;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.Calendar;

import com.codepath.nytimessearch.R;

/**
 * Created by sharonyu on 2017/2/26.
 */

public class Filter extends DialogFragment {

    private TextView beginDate;
    private TextView sort;
    private TextView deskValue;
    private TextView dateView;
    private Spinner spinner;

    public Filter (){

    }

    public static Filter newInstance(String title) {
        Filter frag = new Filter();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.filter, container);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Get field from view
        beginDate = (TextView) view.findViewById(R.id.fraDate);
        spinner = (Spinner) view.findViewById(R.id.spinner);


        getDialog().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

    }


}
