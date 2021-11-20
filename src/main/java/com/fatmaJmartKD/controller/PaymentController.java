package com.fatmaJmartKD.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatmaJmartKD.ObjectPoolThread;
import com.fatmaJmartKD.Payment;
import com.fatmaJmartKD.dbjson.JsonAutowired;
import com.fatmaJmartKD.dbjson.JsonTable;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment>{
	public static final long DELIVERED_LIMIT_MS = 1;
	public static final long ON_DELIVERY_LIMIT_MS = 1;
	public static final long ON_PROGRESS_LIMIT_MS = 1;
	public static final long WAITING_CONF_LIMIT_MS = 1;
	
	@JsonAutowired(filepath = "C:\\Users\\Flex\\Documents\\Semester 5\\jmart\\src\\main\\java\\com\\randomPaymentList.json", value = Payment.class)
	public static JsonTable<Payment> paymentTable;
	public static ObjectPoolThread<Payment> poolThread = new ObjectPoolThread<Payment>(PaymentController::timekeeper);

	
	@PostMapping("/{id}/accept")
	public boolean accept(int id) {
		return false;
	}
	
	@PostMapping("/{id}/cancel")
	public boolean cancel(int id) {
		return false;
	}
	
	@PostMapping("/{id}/create")  
	public Payment create(int buyerId, int productId, int productCount, String shipmentAddress, byte shipmentPlan) {
		return null;
	}
	    
	@PostMapping("/{id}/submit")  
	public boolean submit(int id, String receipt) {
		return false;
	}
	    
	private static boolean timekeeper(Payment payment) {
	    return false;
	}

	@Override
	public JsonTable<Payment> getJsonTable() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
