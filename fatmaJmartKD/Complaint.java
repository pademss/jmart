package fatmaJmartKD;


/**
 * Write a description of class Complaint here.
 *
 * @author fatma
 * @version 25/9/2021
 */
public class Complaint extends Recognizable implements FileParser
{
    public String date;
    public String desc;
    
    /**
     * Constructor for objects of class Complaint
     */
    public Complaint(int id, String desc)
    {
        super(id);
        this.desc = desc;
        this.date = "hai";
    }
    
    
    @Override
    public boolean read(String content){
        return false;
    }
}
