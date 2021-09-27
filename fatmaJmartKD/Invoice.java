package fatmaJmartKD;


/**
 * Abstract class Invoice - write a description of the class here
 *
 * @author fatma
 * @version 27/9/2021
 */
public abstract class Invoice extends Recognizable implements FileParser
{
    public enum Status{
        WAITING_CONFIRMATION,
        CANCELLED,
        ON_PROGRESS,
        ON_DELIVERY,
        COMPLAINT,
        FINISHED,
        FAILED;
    }
    
    public enum Rating{
        NONE,
        BAD,
        NEUTRAL,
        GOOD;
    }
    
    public String date;
    public int buyerId;
    public int productId;
    public int complaintId;
    public Rating rating;
    public Status status;
    
    protected Invoice(int id, int buyerId, int productId){
        super(id);
        this.buyerId = buyerId;
        this.productId = productId;
        this.date = "hai";
        this.rating = Rating.NONE;
        this.status = Status.WAITING_CONFIRMATION;
    }
    
    @Override
    public boolean read(String content){
        return false;
    }
    
    
    public abstract double getTotalPay();
    
}
