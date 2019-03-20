package com.example.money;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    ListView liste ;
    Button btn1;
    EditText editText;
    TextView textview;
    EditText t ;
    public static DBAdapter db ;
    public static adapter array ;
    public static ArrayList<flous> base ;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db= new DBAdapter(this);
      //  t =findViewById(R.id.t);
        base=new ArrayList<flous>();
        base= db.afficher();
        liste=findViewById(R.id.liste);
        //t.setText(Float.toString(db.total()));
        array=new adapter(this,R.layout.item,base);
        btn1=findViewById(R.id.b);
        editText=findViewById(R.id.t);
        textview=findViewById(R.id.text);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textinput=editText.getText().toString();
                //  textview.setText(textinput);
                // Toast.makeText(MainActivity.this,"hello  "+textinput,Toast.LENGTH_SHORT).show();


                Intent intent2=new Intent(MainActivity.this,Main4Activity.class);
                intent2.putExtra("bagage",textinput);
                startActivity(intent2);
            }
        });

        liste.setAdapter(array);

        liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, final View view, final int position, long id){
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("voulez vous supprimer")
                        .setMessage("vous etes sur?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                                db.delete(base.get(position).getId());
                                base=db.afficher();

                                array=new adapter(MainActivity.this,R.layout.item,base);

                                liste.setAdapter(array);
                                Toast.makeText(MainActivity.this, "produit supprime", Toast.LENGTH_SHORT).show(); }})
                        .setNegativeButton(android.R.string.no, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();


            }

        }     );


    }

    @Override
    public void onResume(){
        super.onResume();

        base=db.afficher();
        array=new adapter(this,R.layout.item,base);

        liste.setAdapter(array);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_flous,menu);
        return true ;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if( item.getItemId()==R.id.b)
        {
            Intent intent = new Intent(MainActivity.this, Main2Activity.class); startActivity(intent);
        }
        if( item.getItemId()==R.id.t)
        {
            Intent intent = new Intent(MainActivity.this, Main3Activity.class); startActivity(intent);
        }
        return true ;

    }

    public static long getAppFirstInstallTime(Context context){
        PackageInfo packageInfo;
        try {
            if(Build.VERSION.SDK_INT>8 ){
                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                return packageInfo.firstInstallTime;
            }else{

                ApplicationInfo appInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
                String sAppFile = appInfo.sourceDir;
                return new File(sAppFile).lastModified();
            }
        } catch (PackageManager.NameNotFoundException e) {

            return 0;
        }
    }
    public static String getDate(long milliSeconds, String dateFormat) {
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return formatter.format(calendar.getTime());
    }




}
