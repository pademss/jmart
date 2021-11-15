package fatmaJmartKD;

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
	public Shipment shipment;
    public int productCount;
    public ArrayList<Record> history;

    public Payment(int buyerId, int productId, int productCount, Shipment shipment){
        super(buyerId, productId);
        this.shipment = shipment;
        this.productCount = productCount;
    }

    @Override
    public double getTotalPay(Product product) {
        return 0;
    }

    public  static class Record {
        public final Date date;
        public String message;
        public Status status;


        public Record( Status status, String message) {
            this.date = java.util.Calendar.getInstance().getTime();
            this.status = Status.WAITING_CONFIRMATION;
            this.message = message;
        }

    }

    
}
