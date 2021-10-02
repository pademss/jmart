package fatmaJmartKD;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Write a description of class Jmart here.
 *
 * @author fatma
 * @version 11/9/2021
 */
public class Jmart
{
    public static void main(String[] args){
        System.out.println(Shipment.Duration.SAME_DAY.getEstimatedArrival(new Date()));
        Store store = new Store(110, "fatma putri", "Jakarta", "085303678965");
        System.out.println(store);
        System.out.println(store.validate());
    }
    

    public static Product createProduct()
    {
        return null;
    }
    public static Coupon createCoupun()
    {
        return null;
    }
    public static Shipment.Duration createShipmentDuration()
    {
        return null;
    }
}
