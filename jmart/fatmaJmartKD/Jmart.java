package fatmaJmartKD;


/**
 * Write a description of class Jmart here.
 *
 * @author fatma
 * @version 11/9/2021
 */
public class Jmart
{
    public static void main(String[] args){
        System.out.println(getPromo());
        System.out.println(getCustomer());
        System.out.println(getDiscountPercentage(1000,900));
        System.out.println(getDiscountedPrice(1000,100.0f));
        System.out.println(getOriginalPrice(1000, 0.0f));
        System.out.println(getCommissionMultiplier());
        System.out.println(getAdjustedPrice(500));
        System.out.println(getAdminFee(500));
    }
    
    public static int getPromo(){
        return 0;
    }
    
    public static String getCustomer(){
        return "oop";
    }
    
    public static float getDiscountPercentage(int before,int after){
        if (before < after){
            return 0.0f;
        }
        
        return (float) (before - after) / before * 100;
        
    }
    
    public static int getDiscountedPrice(int price, float discountPercentage){
        if (discountPercentage > 100.0f){
            return 0;
        }
        float priceFloat = (float) price;
        priceFloat = priceFloat - (priceFloat * discountPercentage / 100);
        return (int) priceFloat;
    }
    
    public static int getOriginalPrice(int discountedPrice, float discountPercentage){
        float discountedPriceFloat = (float) discountedPrice;
        discountedPriceFloat = discountedPriceFloat * 100 / (100 - discountPercentage);
        return (int) discountedPriceFloat;
    }
    
    public static float getCommissionMultiplier(){
        return 0.05f;
    }
    
    public static int getAdjustedPrice(int price){
        float priceFloat = (float) price;
        priceFloat = priceFloat + priceFloat * getCommissionMultiplier();
        return (int) priceFloat;
    }
    
    public static int getAdminFee(int price){
        float priceFloat = (float) price;
        return (int) (priceFloat * getCommissionMultiplier());
    }
    
    
}
