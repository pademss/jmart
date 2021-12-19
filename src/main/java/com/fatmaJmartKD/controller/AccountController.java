//package com.fatmaJmartKD.controller;
//import com.fatmaJmartKD.Account;
//import com.fatmaJmartKD.Store;
//import com.fatmaJmartKD.dbjson.JsonAutowired;
//import com.fatmaJmartKD.dbjson.JsonTable;
//import java.math.BigInteger;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//
//import java.util.regex.Pattern;
//
////TODO sesuaikan dengan package Anda: package com.alvinJmartRK.controller;
//
//
////TODO sesuaikan dengan package Anda: import com.alvinJmartRK.Account;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/account")
//public class AccountController implements BasicGetController<Account>
//{
//	
//	@JsonAutowired(filepath = "C:\\Users\\Flex\\Documents\\Semester 5\\jmart\\src\\main\\java\\com\\account.json", value = Account.class)
//	public static JsonTable<Account> accountTable;
//	
//    public static final String REGEX_EMAIL = "^[a-zA-Z0-9&_*~]+(?:\\.[a-zA-Z0-9&_*~]+)*@[A-Za-z0-9]{1}[a-zA-Z0-9]+(?:\\.[a-zA-Z0-9-]+)*$";
//    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
//    public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
//    public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);
//
//    public JsonTable<Account> getJsonTable(){
//        return accountTable;
//    }
//
//    @PostMapping("/login")
//    Account login
//            (
//                    @RequestParam String email,
//                    @RequestParam String password
//            )
//    {
//        for(Account account : accountTable){
//            try{
//                MessageDigest md = MessageDigest.getInstance("MD5");
//                md.update(password.getBytes());
//                byte[] bytes = md.digest();
//                StringBuilder sb = new StringBuilder();
//                for(int i = 0; i < bytes.length; i++){
//                    sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
//                }
//                if(account.email.equals(email) && account.password.equals(sb.toString())){ //Compare hash in string with equals
//                    return account;
//                }
//            } catch (NoSuchAlgorithmException e){
//                e.printStackTrace();
//            }
//
//        }
//        return null;
//    }
//
//    @PostMapping("/register")
//    Account register
//            (
//                    @RequestParam String name,
//                    @RequestParam String email,
//                    @RequestParam String password
//            )
//    {
//        if((REGEX_PATTERN_EMAIL.matcher(email).find()) && (REGEX_PATTERN_PASSWORD.matcher(password).find()) && !name.isBlank()){
//            for(Account account : accountTable){
//                if(account.email.equals(email)){
//                    return null;
//                }
//            }
//            try{
//                MessageDigest md = MessageDigest.getInstance("MD5");
//                md.update(password.getBytes());
//                byte[] bytes = md.digest();
//                StringBuilder sb = new StringBuilder();
//                for(int i = 0; i < bytes.length; i++){
//                    sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
//                }
//                Account newAccount = new Account(name, email, sb.toString(), 0);
//                accountTable.add(newAccount);
//                return newAccount;
//            }catch (NoSuchAlgorithmException e){
//                e.printStackTrace();
//            }
//        }
//        return null;
//    }
//
//    @PostMapping("/{id}/registerStore")
//    Store registerStore(@PathVariable int id, @RequestParam String name, @RequestParam String address, @RequestParam String phoneNumber){
//        if(accountTable.contains(accountTable.get(id)) && accountTable.get(id).store == null){
//            Store newStore = new Store(name, address, phoneNumber, 0);
//            accountTable.get(id).store = newStore;
//            return newStore;
//        }else{
//            return null;
//        }
//    }
//
//    @PostMapping("/{id}/topUp")
//    Account topUp(@PathVariable int id, @RequestParam double balance){
//        if(accountTable.contains(accountTable.get(id))){
//            accountTable.get(id).balance += balance;
//            return accountTable.get(id);
//        }else{
//            return null;
//        }
//
//    }
//}

package com.fatmaJmartKD.controller;

/**
 * Class AccountController - Controller untuk membuat akun, masuk ke akun, membuat store
 *
 * @author Fatma Putri Ramadhani
 *
 */

import com.fatmaJmartKD.Account;
import com.fatmaJmartKD.Store;
import com.fatmaJmartKD.dbjson.JsonAutowired;
import com.fatmaJmartKD.dbjson.JsonTable;
import com.fatmaJmartKD.Algorithm;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{
 public static final String REGEX_EMAIL = "^\\w+([\\.]?[&\\*~\\w+])*@\\w+([\\.-]?)*(\\.\\w{2,3})+$";
    public static final String REGEX_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=\\S+$)(?=.*[A-Z]).{8,}$";
    public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
    public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);
    @JsonAutowired(value = Account.class, filepath = "C:\\Users\\Flex\\Documents\\Semester 5\\jmart\\src\\main\\java\\com\\account.json")
    public static JsonTable<Account> accountTable;
 
 @Override
 public JsonTable<Account> getJsonTable(){
  return accountTable;
 }
 
 //mendapatkan account
 @GetMapping
 String index() { return "account page"; }
 
 //membuat account
 @PostMapping("/register")
 Account register
 (
     @RequestParam String name,
     @RequestParam String email,
     @RequestParam String password
 )
 {
     if((REGEX_PATTERN_EMAIL.matcher(email).find()) && (REGEX_PATTERN_PASSWORD.matcher(password).find()) && !name.isBlank()){
         for(Account account : accountTable){
             if(account.email.equals(email)){
                 return account;
             }
         }
         try {
             MessageDigest md;
             md = MessageDigest.getInstance("MD5");
             byte[] messageDigest = md.digest(password.getBytes());
             BigInteger no = new BigInteger(1, messageDigest);
             String hashtext = no.toString(16);
             while (hashtext.length() < 32) {
                 hashtext = "0" + hashtext;
             }
             getJsonTable().add(new Account(name, email, hashtext, 0));
             return new Account(name, email, password, 0);
         } catch (NoSuchAlgorithmException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
         
     }
     return null;
 }
 
 //masuk ke account
 @PostMapping("/login")
 Account login
 (
  @RequestParam String email,
  @RequestParam String password
 )
 {
  String generatedPassword;
  try {
   MessageDigest md = MessageDigest.getInstance("MD5");
     
            byte[] bytes = md.digest(password.getBytes());

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < bytes.length; i++)
             sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            
            generatedPassword = sb.toString();
  }
  catch(NoSuchAlgorithmException e) {
   throw new RuntimeException(e);
  }
  for(Account account : accountTable)
        {
            if (account.email.equals(email) && account.password.equals(generatedPassword))
                return account;
        }
        return null;
 }
 
 //membuat store
 @PostMapping("/{id}/registerStore")
 Store registerStore(
   @PathVariable int id,
   @RequestParam String name,
   @RequestParam String address,
   @RequestParam String phoneNumber
   ) {
  Account acc = Algorithm.<Account>find(getJsonTable(), (account -> account.id == id && account.store == null));
  acc.store = new Store(name, address, phoneNumber, 0);
  return acc.store;
 }
 
 //top up balance
 @PostMapping("/{id}/topUp")
 Account topUp(@PathVariable int id, @RequestParam double balance){
  Account acc = Algorithm.<Account>find(getJsonTable(), (account -> account.id == id));
  acc.balance += balance;
  return acc;
 }
}
