package com.fatmaJmartKD;
import java.util.Date;
import java.util.ArrayList;

/**
 * Abstract class Invoice - write a description of the class here
 *
 * @author fatma
 * @version 27/9/2021
 */
public abstract class Invoice extends Serializable
{
	public int buyerId;
    public int productId;
    public int complaintId;
    public Rating rating;
    public final Date date;

    protected Invoice(int buyerId, int productId) {
        this.buyerId = buyerId;
        this.productId = productId;
        date = java.util.Calendar.getInstance().getTime();
        this.complaintId = -1;
        this.rating = Rating.NONE;
    }

    public enum Status {
        WAITING_CONFIRMATION,
        CANCELLED,
        ON_PROGRESS,
        ON_DELIVERY,
        COMPLAINT,
        FINISHED,
        FAILED,
        DELIVERED
    }

    public enum Rating {
        NONE,
        BAD,
        NEUTRAL,
        GOOD
    }

    public abstract double getTotalPay(Product product);
}
