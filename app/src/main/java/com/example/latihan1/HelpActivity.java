package com.example.latihan1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        TextView txtHelp  = (TextView)findViewById(R.id.textView);

        Bundle b = getIntent().getExtras();
        String textHelp = b.getString("help_String");
        txtHelp.setText(textHelp);
    }
}