package com.fatmaJmartKD;

/**
 * Class PhoneTopUp - fitur top up pada aplikasi
 *
 * @author Fatma Putri Ramadhani
 *
 */

public class PhoneTopUp extends Invoice{
	public String phoneNumber;
	public Status status;
	
	public PhoneTopUp(int buyerId, int productId, String phoneNumber) {
		super(buyerId, productId);
		this.phoneNumber = phoneNumber;
	}
	
	public double getTotalPay(Product product) {
		return Treasury.getAdjustedPrice(product.price, product.discount);
	}
	
}
