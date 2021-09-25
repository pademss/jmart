package fatmaJmartKD;


/**
 * Write a description of class Complaint here.
 *
 * @author fatma
 * @version 25/9/2021
 */
public class Complaint extends Transaction implements FileParser
{
    
    public int paymentId;
    public String desc;
    
    /**
     * Constructor for objects of class Complaint
     */
    public Complaint(int id, Payment payment, String desc)
    {
        super(id, 0, 0);
        this.desc = desc;
    }
    
    public Complaint(int id, int buyerId, int storeId, int paymentId, String desc){
        super(id, buyerId, storeId);
        this.desc = desc;
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
