package com.example.money;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class adapter extends ArrayAdapter<flous> {
private ArrayList<flous> arrayList;
private Context ctx;
private int item;


public adapter(@NonNull Context context, int resource , ArrayList<flous> myarray) {
        super(context, resource,myarray);
        this.arrayList=myarray;
        this.ctx=context;
        this.item=resource; }

@NonNull
@Override
public boolean isEnabled(int position)
        {
        return true;
        }

public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView= LayoutInflater.from(ctx).inflate(item,parent,false);
        TextView prix=convertView.findViewById(R.id.p);
        TextView  produit=convertView.findViewById(R.id.a);
        TextView date=convertView.findViewById(R.id.d);
        prix.setText(Float.toString(arrayList.get(position).getMoney()));
        produit.setText(arrayList.get(position).getProduit());
        date.setText(arrayList.get(position).getDate());

        return convertView; }
}
