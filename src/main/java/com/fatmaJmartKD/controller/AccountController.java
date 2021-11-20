package com.fatmaJmartKD.controller;
import com.fatmaJmartKD.Account;
import com.fatmaJmartKD.Store;
import com.fatmaJmartKD.dbjson.JsonAutowired;
import com.fatmaJmartKD.dbjson.JsonTable;

import java.util.regex.Pattern;

//TODO sesuaikan dengan package Anda: package com.alvinJmartRK.controller;


//TODO sesuaikan dengan package Anda: import com.alvinJmartRK.Account;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{
	public static final String REGEX_EMAIL = "^[a-zA-Z0-9&_*~]+(?:\\\\.[a-zA-Z0-9&_*~]+)*@\\\\w+([.-]?\\\\w+)+$";
	public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\\\d)[a-zA-Z\\\\d]{8,}$";
	public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
	public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);
	
	@JsonAutowired(filepath = "C:\\Users\\Flex\\Documents\\Semester 5\\jmart\\src\\main\\java\\com\\account.json", value = Account.class)
	public static JsonTable<Account> accountTable;
	
	@GetMapping
	String index() { return "account page"; }
	
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
	                    return null;
	                }
	            }
	            return new Account(name, email, password, 0);
	        }
	        return null;
	}
	
//	@GetMapping("/{id}")
//	String getById(@PathVariable int id) { return "account id " + id + " not found!"; }

	@Override
	public JsonTable<Account> getJsonTable() {
		// TODO Auto-generated method stub
		return accountTable;
	}
	
	@PostMapping("/login")
	public Account login
	(
			@RequestParam String email, 
			@RequestParam String password
	) {
		for(Account account : accountTable){
            if (account.email.equals(email) && account.password.equals(password)) {
                return account;
            }
        }
        return null;
		
	}
	
	@PostMapping("/{id}/registerStore")
    Store registerStore(int id, String name, String address, String phoneNumber){
        if(accountTable.contains(accountTable.get(id)) && accountTable.get(id).store == null){
            Store newStore = new Store(name, address, phoneNumber, 0);
            accountTable.get(id).store = newStore;
            return newStore;
        }else{
            return null;
        }
    }
	
    @PostMapping("/{id}/topUp")
    boolean topUp(int id, double balance){
        if(accountTable.contains(accountTable.get(id))){
            accountTable.get(id).balance += balance;
            return true;
        }else{
            return false;
        }
    }
}
