package fatmaJmartKD;


/**
 * Write a description of class Payment here.
 *
 * @author fatma
 * @version 25/9/2021
 */
public class Payment extends Transaction implements FileParser
{
    public int productId;
    public ShipmentDuration shipmentDuration;
    
    public Payment(int id, int buyerId, Product product, ShipmentDuration shipmentDuration){
        super(product.id, buyerId, id);
        this.shipmentDuration = shipmentDuration;
        
    }
    
    public Payment(int id, int buyerId, int storeId, int productId, ShipmentDuration shipmentDuration){
        super(id, buyerId, storeId);
        this.productId = productId;
        this.shipmentDuration = shipmentDuration;
    }
    
    @Override
    public boolean validate(){
        return false;
    }
    
    @Override
    public Transaction perform(){
        return null;
    }
    
    @Override
    public boolean read(String content){
        return false;
    }
}
