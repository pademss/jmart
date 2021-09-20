package fatmaJmartKD;


/**
 * Write a description of class Coupon here.
 *
 * @author fatma
 * @version 20/9/2021
 */
public class Coupon
{
    public enum Type{
        DISCOUNT,
        REBATE;
    }
    public final String name;
    public final int code;
    public final double cut;
    public final Type type;
    public final double minimum;
    private boolean used;
    
    public Coupon(String name, int code, Type type, double cut, double minimum){
        this.name = name;
        this.code = code;
        this.type = type;
        this.cut = cut;
        this.minimum = minimum;
        used = false;
    }
    
    public boolean isUsed(){
        return used;
    }
    
    public boolean canApply(PriceTag priceTag){
        if (priceTag.getAdjustedPrice() >= minimum && used == false){
            return true;
        }
        return false;
    }
    
    public double apply(PriceTag priceTag){
        used = true;
        if (type == Type.DISCOUNT){
            return (this.cut / 100);
        }
        else {
            return (priceTag.getAdjustedPrice() * this.cut / 100);
        }
    }
}
