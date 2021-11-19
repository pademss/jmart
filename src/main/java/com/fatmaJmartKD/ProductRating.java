package com.fatmaJmartKD;


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
    /**
     * Constructor for objects of class ProductRating
     */
    public ProductRating()
    {
        this.total = 0;
        this.count = 0;
    }
    public void insert(int rating)
    {
        total += rating;
        count++;
    }
    public double getAverage()
    {
        if(count == 0){
            return 0.0;
        }else{
            return total/(double)count;
        }
    }
    public long getCount()
    {
        return count;
    }
    public long getTotal()
    {
        return total;
    }
}
