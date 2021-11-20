package com.fatmaJmartKD;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fatmaJmartKD.dbjson.Serializable;

/**
 * Write a description of class Account here.
 *
 * @author fatma
 * @version 25/9/2021
 */
public class Account extends Serializable
{
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9&_*~]+(?:\\.[a-zA-Z0-9&_*~]+)*@[A-Za-z0-9]{1}[a-zA-Z0-9]+(?:\\.[a-zA-Z0-9-]+)*$";
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
    public String name;
    public String email;
    public String password;
    public Store store;
    public double balance;
    
    public Account(String name, String email, String password, double balance){
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
    }
    
    public boolean validate(){
        Pattern patternEmail = Pattern.compile(REGEX_EMAIL);
        Pattern patternPass = Pattern.compile(REGEX_PASSWORD);
        Matcher mEmail = patternEmail.matcher(email);
        Matcher mPass = patternPass.matcher(password);
        if(mEmail.find() && mPass.find()){
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public String toString(){
        return
        "name : " + this.name + "\n" +
        "email: " + this.email +" \n"+
        "password: " + this.password;
    }

}
