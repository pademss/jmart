package fatmaJmartKD;


/**
 * Abstract class Transaction - write a description of the class here
 *
 * @author fatma
 * @version 25/9/2021
 */
public abstract class Transaction extends Recognizable
{
    public enum Rating{
        NONE,
        BAD,
        NEUTRAL,
        GOOD;
    }
    public String time = "Time";
    public int buyerId;
    public int storeId;
    public Rating rating = Transaction.Rating.NONE;
    
    protected Transaction(int id, int buyerId, int storeId){
        super(id);
        this.buyerId = buyerId;
        this.storeId = storeId;
    }
    
    protected Transaction(int id, Account buyer, Store store){
        super(id);
        
        
    }
    
    public abstract boolean validate();
    public abstract Transaction perform();
}
