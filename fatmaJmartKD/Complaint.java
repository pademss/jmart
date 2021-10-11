package fatmaJmartKD;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Write a description of class Complaint here.
 *
 * @author fatma
 * @version 25/9/2021
 */
public class Complaint extends Recognizable implements FileParser
{
    public final Date date;
    public String desc;
    
    /**
     * Constructor for objects of class Complaint
     */
    public Complaint(int id, String desc)
    {
        
        this.desc = desc;
        this.date = new Date();
    }
    
    
    @Override
    public boolean read(String content){
        return false;
    }
    
    @Override
    public String toString(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dateComp = dateFormat.format(this.date);
        return "Complaint{date= " + dateComp + ", desc= '" + this.desc +"'}";
    }
}
