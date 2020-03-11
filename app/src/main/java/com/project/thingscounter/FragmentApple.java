package com.project.thingscounter;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FragmentApple extends Fragment {

    TextView txtNumber;
    Button left, right;
    String savedText;

    public FragmentApple() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_apple, container, false);

        txtNumber = (TextView) view.findViewById(R.id.textViewNumber);
        left = (Button) view.findViewById(R.id.buttonLeft);
        right = (Button) view.findViewById(R.id.buttonRight);

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savedText = txtNumber.getText().toString();
                int number = Integer.parseInt(savedText);
                number = number + 1;
                savedText = String.valueOf(number);

                //to save data
                SharedPreferences.Editor editor = getContext().getSharedPreferences("numbers", Context.MODE_PRIVATE).edit();
                editor.putString("numberApple",savedText);
                editor.apply();

                SharedPreferences prefs = getContext().getSharedPreferences("numbers", Context.MODE_PRIVATE);
                txtNumber.setText(prefs.getString("numberApple", "0"));
            }
        });

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savedText = txtNumber.getText().toString();
                int number = Integer.parseInt(savedText);
                if(number>0)
                    number = number - 1;
                savedText = String.valueOf(number);

                //to save data
                SharedPreferences.Editor editor = getContext().getSharedPreferences("numbers", Context.MODE_PRIVATE).edit();
                editor.putString("numberApple",savedText);
                editor.apply();

                SharedPreferences prefs = getContext().getSharedPreferences("numbers", Context.MODE_PRIVATE);
                txtNumber.setText(prefs.getString("numberApple", "0"));
            }
        });

        //to retrive data  from SharedPreferences
        SharedPreferences prefs = getContext().getSharedPreferences("numbers", Context.MODE_PRIVATE);
        txtNumber.setText(prefs.getString("numberApple", "0"));

        return view;
    }

}
