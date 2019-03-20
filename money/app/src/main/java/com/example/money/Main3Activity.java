package com.example.money;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.money.MainActivity.db;
import static com.example.money.MainActivity.getAppFirstInstallTime;
import static com.example.money.MainActivity.getDate;

public class Main3Activity extends AppCompatActivity {
   // String date ;
    long date;
    TextView t ;
    TextView da ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        t =findViewById(R.id.t);
        t.setText(Float.toString(db.total()));
        date= getAppFirstInstallTime(this);
        String d = getDate(date, "dd/MM/yyyy");
        da=findViewById(R.id.d);
        da.setText(d);

    }
}
