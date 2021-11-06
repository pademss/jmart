package fatmaJmartKD;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Write a description of class Shipment here.
 *
 * @author fatma
 * @version 27/9/2021
 */
public class Shipment
{
    public static final SimpleDateFormat ESTIMATION_FORMAT = new SimpleDateFormat("EEE MMMM dd yyyy");
    public static final Plan INSTANT = new Plan((byte)(1<<0)); //0000 0001
    public static final Plan SAME_DAY = new Plan((byte)(1<<1)); //0000 0010
    public static final Plan NEXT_DAY = new Plan((byte)(1<<2)); //0000 0100
    public static final Plan REGULER = new Plan((byte)(1<<3)); //0000 1000
    public static final Plan KARGO = new Plan((byte)(1<<4)); //0001 0000
    public String address;
    public int cost;
    public byte plan;
    public String receipt;
    //inner class Plan
    static class Plan
    {
        public final byte bit;
        private Plan(byte bit)
        {
            this.bit = bit;
        }
    }
    //constructor
    public Shipment(String address, int cost, byte plan, String receipt){
        this.address = address;
        this.cost = cost;
        this.plan = plan;
        this.receipt = receipt;
    }
    public String getEstimatedArrival(Date reference){
        if((plan & INSTANT.bit) != 0 || (plan & SAME_DAY.bit) != 0){
            return ESTIMATION_FORMAT.format(reference);
        }else if((plan & NEXT_DAY.bit) != 0){
            return ESTIMATION_FORMAT.format(reference.getDay() + 1);
        }else if((plan & REGULER.bit) != 0){
            return ESTIMATION_FORMAT.format(reference.getDay() + 2);
        }else {
            return ESTIMATION_FORMAT.format(reference.getDay() + 5); //KARGO
        }
    }
    public boolean isDuration(Plan reference)
    {
        if((plan & reference.bit) != 0){
            return true;
        }else{
            return false;
        }
    }
    public static boolean isDuration(byte object, Plan reference)
    {
        if((object & reference.bit) != 0){
            return true;
        }else{
            return false;
        }
    }
}
