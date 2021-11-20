package com.fatmaJmartKD;
import java.util.Date;

import com.fatmaJmartKD.dbjson.Serializable;

import java.text.SimpleDateFormat;

/**
 * Write a description of class Complaint here.
 *
 * @author fatma
 * @version 25/9/2021
 */
public class Complaint extends Serializable
{
    public Date date;
    public String desc;
    
    public Complaint(String desc){
        this.desc = desc;
        this.date = new Date();
        System.out.println(date);
    }
    @Override
    public String toString(){
        //Complaint{date=10/03/2021, desc='Pengiriman tidak cepat, kurir tersesat'}
        //Complaint{date=25/05/2021, desc='Barang yang dikirimkan tidak sesuai pesanan'}
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return ("Complaint{date=" + df.format(date) + ", desc='" + desc + "'}");
    }

    
}
