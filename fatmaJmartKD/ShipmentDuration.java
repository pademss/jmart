package fatmaJmartKD;


/**
 * Write a description of class ShipmentDuration here.
 *
 * @author fatma
 * @version 20/9/2021
 */
public class ShipmentDuration
{
    
    public static final ShipmentDuration INSTANT = new ShipmentDuration (1 << 0);
    public static final ShipmentDuration SAME_DAY = new ShipmentDuration (1 << 1);
    public static final ShipmentDuration NEXT_DAY = new ShipmentDuration (1 << 2);
    public static final ShipmentDuration REGULER = new ShipmentDuration (1 << 3);
    public static final ShipmentDuration KARGO = new ShipmentDuration (1 << 4);
    private final int bit; 
    
    private ShipmentDuration(int bit){
        this.bit = bit;
    }
    
    public ShipmentDuration(ShipmentDuration... args){
        int total = 0;
        for (ShipmentDuration i: args){
            total = total | i.bit;
        }
        this.bit = total;
            
    }
    
    public boolean isDuration(ShipmentDuration reference){
        if ((bit & reference.bit) != 0){
            return true;
        }
        else{
            return false;
        }
    }
    
    
}
