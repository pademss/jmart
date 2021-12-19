package com.fatmaJmartKD;


/**
 * Abstract class Transaction - Untuk melakukan transaksi
 *
 * @author fatma
 * @version 25/9/2021
 */
public interface Transactor
{    
    public abstract boolean validate();
    public abstract Invoice perform();
}
