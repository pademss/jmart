package com.fatmaJmartKD;

/**
 * Class Payment - Mengatur payment, history dari pesanan, dan total harga
 *
 * @author Fatma Putri Ramadhani
 *
 */

import java.util.ArrayList;
import java.util.Date;

/**
 * Write a description of class Payment here.
 *
 * @author fatma
 * @version 25/9/2021
 */
public class Payment extends Invoice
{
	 public int productCount;
	    public Shipment shipment;
	    public ArrayList<Record> history = new ArrayList<>();

	    public Payment(int buyerId, int productId, int productCount,Shipment shipment){
	        super(buyerId, productId);
	        this.shipment = shipment;
	        this.productCount = productCount;
	    }

	    public static class Record {
	        public final Date date;
	        public String message;
	        public Status status;


	        public Record( Status status, String message) {
	            this.date = java.util.Calendar.getInstance().getTime();
	            this.status = status;
	            this.message = message;
	        }

	    }

	    @Override
	    public double getTotalPay(Product product){
	        return (productCount * Treasury.getAdjustedPrice(product.price, product.discount));
	    }
}
