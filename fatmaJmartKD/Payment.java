package fatmaJmartKD;


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
    
    public Payment(int buyerId, int productId, int productCount, Shipment shipment){
        super(buyerId, productId);
        this.productCount = productCount;
        this.shipment = shipment;
    }
    @Override
    public double getTotalPay(){
        return 0.0;
    }

    
}
