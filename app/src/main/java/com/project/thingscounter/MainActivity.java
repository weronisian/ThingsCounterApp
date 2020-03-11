package com.project.thingscounter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data = (TextView) findViewById(R.id.textView3);
        SharedPreferences prefs = getSharedPreferences("dates", Context.MODE_PRIVATE);
        data.setText(prefs.getString("date", " "));
    }

    public void wybranyPrzycisk(View view) {
        final Intent intencja;
        switch (view.getId()) {
            case R.id.button1:
                intencja = new Intent(this, ActivityTabs.class);
                intencja.putExtra("tab", 0);
                startActivity(intencja);
                break;
            case R.id.button2:
                intencja = new Intent(this, ActivityTabs.class);
                intencja.putExtra("tab", 1);
                startActivity(intencja);
                break;
            case R.id.button3:
                intencja = new Intent(this, ActivityTabs .class);
                intencja.putExtra("tab", 2);
                startActivity(intencja);
                break;

        }
    }
}
