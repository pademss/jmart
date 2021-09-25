package fatmaJmartKD;


/**
 * Write a description of class Product here.
 *
 * @author fatma
 * @version 24/9/2021
 */
public class Product extends Recognizable implements FileParser
{
  /*  private static int idCounter;
    public int id;
    public String name;
    public int weight;
    public boolean conditionUsed;
    public PriceTag priceTag;
    public ProductCategory category;
    public ProductRating rating; */
    
    public String name;
    public int weight;
    public boolean conditionUsed;
    public PriceTag priceTag;
    public ProductCategory category;
    public ProductRating rating;
    public int storeId;
    
    public Product(int id, int storeId, String name, int weight, 
    boolean conditionUsed, PriceTag priceTag, ProductCategory 
    category){
        super(id);
        this.storeId = storeId;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.category = category;
        this.rating = new ProductRating();
    }
    
    public Product(int id, Store store, String name, int weight, 
    boolean conditionUsed, PriceTag priceTag, ProductCategory 
    category){
        super(id);
        //this.store = store;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.category = category;
        this.rating = new ProductRating();
    }
    
    @Override
    public boolean read(String content){
        return false;
    }
    
    
   /* public Product(String name, int weight, boolean conditionUsed, PriceTag priceTag, ProductCategory category){
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.category = category;
        this.rating = new ProductRating();
        this.id = idCounter;
        idCounter++;
        
    } */
}
