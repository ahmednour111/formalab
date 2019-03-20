package com.example.money;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import static com.example.money.MainActivity.db;

public class Main2Activity extends AppCompatActivity {
        Button b ;
        EditText produit ;
        EditText prix ;
        ListView liste ;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main2);

            b=findViewById(R.id.click);
            produit=findViewById(R.id.a);
            prix=findViewById(R.id.p);
            b.setOnClickListener(new View.OnClickListener(){

                public void onClick(View v)
                {
                    String p = produit.getText().toString();
                    Float money =Float.valueOf(prix.getText().toString());
                    flous c = new flous(p, money);
                    db.ajouter(c);
                    Toast.makeText(Main2Activity.this, " notre produit est enregistrer ", Toast.LENGTH_SHORT).show();

                }

            });
        }

    }

