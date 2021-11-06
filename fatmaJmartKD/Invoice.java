package fatmaJmartKD;
import java.util.Date;
import java.util.ArrayList;

/**
 * Abstract class Invoice - write a description of the class here
 *
 * @author fatma
 * @version 27/9/2021
 */
public abstract class Invoice extends Serializable
{
    public int buyerId;
    public int complaintId;
    public final Date date;
    public ArrayList<Record> history = new ArrayList<>();
    public int productId;
    public Rating rating;
    public Status status;
    enum Status{
        WAITING_CONFIRMATION, CANCELLED, ON_PROGRESS, ON_DELIVERY,
        COMPLAINT, FINISHED, FAILED
    }
    enum Rating{
        NONE, BAD, NEUTRAL, GOOD
    }
    class Record{
        public Date date;
        public String message;
        public Status status;
    }
    protected Invoice(int buyerId, int productId){
        this.buyerId = buyerId;
        this.productId = productId;
        this.date = new Date();
        this.rating = Rating.NONE;
        this.status = Status.WAITING_CONFIRMATION;
        this.complaintId = -1;
    }
    public abstract double getTotalPay();
}
