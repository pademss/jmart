package com.fatmaJmartKD.controller;

/**
 * Class CouponController - Controller terkait kupon
 *
 * @author Fatma Putri Ramadhani
 *
 */

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fatmaJmartKD.Algorithm;
import com.fatmaJmartKD.Coupon;
import com.fatmaJmartKD.Predicate;
import com.fatmaJmartKD.dbjson.JsonAutowired;
import com.fatmaJmartKD.dbjson.JsonTable;

@RestController
@RequestMapping("/coupon")
public class CouponController implements BasicGetController<Coupon>{
	
	@JsonAutowired(filepath = "C:\\Users\\Flex\\Documents\\Semester 5\\jmart\\bin\\main\\com\\account.json", value = Coupon.class)
	public static JsonTable<Coupon> couponTable;
	
    @GetMapping("/{id}/canApply")
    boolean canApply(
            @PathVariable int id, 
            @PathVariable double price, 
            @PathVariable double discount
    ){
         for(Coupon coupon : couponTable){
             if(coupon.id == id){
                 return coupon.canApply(price, discount);
             }
         }
         return false;
    };
	
	@GetMapping("/getAvailable")
	@ResponseBody
	List<Coupon> getAvailable(
			@PathVariable int page, 
			@PathVariable int pageSize){
		Predicate<Coupon> pred = coupon -> !coupon.isUsed();
        return Algorithm.paginate(couponTable, page, pageSize, pred);
	}
	
	@Override
	public JsonTable<Coupon> getJsonTable() {
		// TODO Auto-generated method stub
		return couponTable;
	}
	
	@GetMapping("/{id}/isUsed")
	boolean isUsed(@PathVariable int id) {
		Coupon coupon = Algorithm.<Coupon>find(couponTable, obj -> obj.id == id);
        return coupon.isUsed();
	}
	
	

}
