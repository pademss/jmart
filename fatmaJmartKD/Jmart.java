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
        
    }
    

    public static Product create(){
        return new Product("meja", 5, false, new PriceTag(50000L), ProductCategory.BOOK);
    }
}
