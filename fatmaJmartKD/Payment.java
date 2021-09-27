package fatmaJmartKD;


/**
 * Write a description of class Payment here.
 *
 * @author fatma
 * @version 25/9/2021
 */
public class Payment extends Invoice implements Transactor
{
    public int productCount;
    public Shipment shipment;
    
    public Payment(int id, int buyerId, int productId, int productCount, Shipment shipment){
        super(id, buyerId, productId);
        this.productCount = productCount;
        this.shipment = shipment;
    }
    
    @Override
    public double getTotalPay(){
        return 0.0;
    }
    
    @Override
    public boolean validate(){
        return false;
    }
    
    @Override
    public Invoice perform(){
        return null;
    }
}
