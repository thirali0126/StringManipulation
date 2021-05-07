package com.example.stringmanipulation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class output extends Fragment {
    TextView edoutput;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_output, container, false);

        edoutput =v.findViewById(R.id.txtoutput);
        String gettext = getArguments().getString("string");
        edoutput.setText("");
        edoutput.setText(gettext);
        // Inflate the layout for this fragment
        return v;


    }
}