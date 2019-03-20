package com.example.money;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class flous {
    private String produit ;
    private Float money ;
    String date ;
    int id ;
    public static float total ;


    public  flous (String produit, Float money) {
        this.produit = produit;
        this.money = money;
        String pattern = "MM/dd/yyyyHH:mm:ss";

        DateFormat df = new SimpleDateFormat(pattern);
        Date today = Calendar.getInstance().getTime();

        date = df.format(today);

    }

    public int getId() {
        return id;
    }

    public static float getTotal() {
        return total;
    }

    public static void setTotal(float total) {
        flous.total = total;
    }

    public String getProduit() {
        return produit;
    }

    public Float getMoney() {
        return money;
    }

    public String getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProduit(String produit) {
        this.produit = produit;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
