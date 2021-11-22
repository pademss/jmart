package com.fatmaJmartKD.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fatmaJmartKD.Account;
import com.fatmaJmartKD.Algorithm;
import com.fatmaJmartKD.Product;
import com.fatmaJmartKD.ProductCategory;
import com.fatmaJmartKD.dbjson.JsonAutowired;
import com.fatmaJmartKD.dbjson.JsonTable;

@RestController
@RequestMapping("/product")
public class ProductController implements BasicGetController<Product>{

	@JsonAutowired(filepath = "C:\\Users\\Flex\\Documents\\Semester 5\\jmart\\bin\\main\\com\\randomProductList.json", value = Product.class)
	public static JsonTable<Product> productTable;
	
	@PostMapping("/create")
	@ResponseBody
	Product create(
	        @RequestParam int accountId,
	        @RequestParam String name,
	        @RequestParam int weight,
	        @RequestParam boolean conditionUsed,
	        @RequestParam double price,
	        @RequestParam double discount,
	        @RequestParam ProductCategory category,
	        @RequestParam byte shipmentPlans
	) {
        AccountController control1 = new AccountController();
        JsonTable<Account> accountTable = control1.getJsonTable();
        
        for(Account account : accountTable){
            if(account.id == accountId && account.store != null){
                return new Product(accountId, name, weight, conditionUsed, price, discount, category, shipmentPlans);
            }
        }
        return null;
	}
	
	@Override
	public JsonTable<Product> getJsonTable() {
		// TODO Auto-generated method stub
		return productTable;
	}
	
	@GetMapping("/{id}/store")
	@ResponseBody
	List<Product> getProductByStore(
		@RequestParam int id,
        @RequestParam int page,
        @RequestParam int pageSize
     )
	{
		return Algorithm.paginate(productTable, page, pageSize,pred->pred.accountId == id);
	}
	
	@GetMapping("/getFiltered")
	@ResponseBody
	List<Product> getProductFiltered(
		@RequestParam int page,
        @RequestParam int pageSize,
        @RequestParam int accountId,
        @RequestParam String search,
        @RequestParam int minPrice,
        @RequestParam int maxPrice,
        @RequestParam ProductCategory category
	)
	{
		List<Product> tempProduct = null;
		for (Product i : productTable) {
		if (i.accountId == accountId)
		    if (i.name.contains(search))
		        if (minPrice <= i.price)
		            if (maxPrice >= i.price)
		                if (i.category == category)
		                    tempProduct.add(i);
		}
		return tempProduct;
		}

}
