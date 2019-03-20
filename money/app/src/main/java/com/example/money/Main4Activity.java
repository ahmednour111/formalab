package com.example.money;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        text=findViewById(R.id.text);
        String bagagee=getIntent().getStringExtra("bagage");
        text.setText(bagagee);
    }
}

