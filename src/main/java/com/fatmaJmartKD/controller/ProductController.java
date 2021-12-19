package com.fatmaJmartKD.controller;

/**
 * Class ProductController - Controller terkait product
 *
 * @author Fatma Putri Ramadhani
 *
 */

import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
import com.fatmaJmartKD.Payment;
import com.fatmaJmartKD.Predicate;
import com.fatmaJmartKD.controller.AccountController;
import com.fatmaJmartKD.controller.PaymentController;
import com.fatmaJmartKD.controller.ProductController;

@RestController
@RequestMapping("/product")
public class ProductController implements BasicGetController<Product>  {

    public static @JsonAutowired(filepath = "C:\\Users\\Flex\\Documents\\Semester 5\\jmart\\bin\\main\\com\\randomProductList.json", value = Product.class)JsonTable<Product>  productTable;
    
  //mendapatkan product dari penjual
  	@GetMapping("/{id}/page")
      @ResponseBody List<Product> getProducts(@PathVariable int id, @RequestParam(defaultValue="0") int page, @RequestParam(defaultValue="1000") int pageSize){
  		List<Product> productList = new ArrayList<>();
          Account accountTarget = Algorithm.<Account>find(AccountController.accountTable,  a -> a.id == id);
          if(accountTarget != null){
              for(Product product : ProductController.productTable){
                  for(Payment payment : PaymentController.paymentTable){
                      if(payment.productId == product.id && product.accountId == accountTarget.id){
                          productList.add(product);
                      }
                  }
              }
          }
          return Algorithm.paginate(productList, page, pageSize, e->true);
      }
  	
  	//mendapatkan product yang dibeli
      @GetMapping("/{id}/purchases/page")
      @ResponseBody List<Product> getMyProducts(@PathVariable int id, @RequestParam(defaultValue="0") int page, @RequestParam(defaultValue="1000") int pageSize){
          List<Product> productList = new ArrayList<>();
          List<Payment> paymentList = Algorithm.<Payment>paginate(PaymentController.paymentTable, page, pageSize, p -> p.buyerId == id);
          for(Product product : getJsonTable()){
              for(Payment payment : paymentList){
                  if(payment.productId == product.id){
                      productList.add(product);
                  }
              }
          }
          return Algorithm.<Product>paginate(productList, page, pageSize, e -> true);
      }
  	
      //membuat product baru
      @PostMapping("/create")
      Product create(@RequestParam int accountId, @RequestParam String name, @RequestParam int weight, @RequestParam boolean conditionUsed, @RequestParam double price, @RequestParam double discount, @RequestParam ProductCategory category, @RequestParam byte shipmentPlans){
          for(Account account : AccountController.accountTable){
              if(account.id == accountId && account.store != null){
                  Product newProduct = new Product(accountId, name, weight, conditionUsed, price, discount, category, shipmentPlans);
                  productTable.add(newProduct);
                  return newProduct;
              }
          }
          return null;
      }
      
      public JsonTable<Product> getJsonTable() {
          return productTable;
      }
      
      //product by store
      @GetMapping("/{id}/store")
      List<Product> getProductByStore(@RequestParam int id, @RequestParam int page, @RequestParam int pageSize){
          return Algorithm.<Product>paginate(getJsonTable(),page,pageSize, p -> (p.accountId == id));
      }
      
      //melakukan filter product
      @GetMapping("/getFiltered")
      List<Product> getProductFiltered(@RequestParam(defaultValue="0")  int page, @RequestParam(defaultValue="5")  int pageSize,
                                       @RequestParam  String search,
                                       @RequestParam  int minPrice, @RequestParam  int maxPrice,
                                       @RequestParam  ProductCategory category)
      {
          Predicate<Product> pred = p -> ((p.name.toLowerCase().contains(search.toLowerCase())) && (p.price >= minPrice && p.price <= maxPrice) && (p.category == category));
          return Algorithm.<Product>paginate(getJsonTable(),page,pageSize, pred);
      }
    
    
}