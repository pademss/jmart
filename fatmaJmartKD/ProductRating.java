package fatmaJmartKD;


/**
 * Write a description of class ProductRating here.
 *
 * @author fatma
 * @version 18/9/2021
 */
public class ProductRating
{
    private long total;
    private long count;
    
    public ProductRating(){
        this.total = 0;
        this.count = 0;
    }
    
    public void insert (int rating){
        this.total += rating;
        this.count++;
    }
    
    public double getAverage(){
        if (count == 0){
            return 0;
        }
        else{
            return this.total / this.count;
        }
    }
    
    public long getCount(){
        return this.count;
    }
    
    public long getTotal(){
        return this.total;
    }
}
