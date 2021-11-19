package com.fatmaJmartKD;

import java.util.HashMap;
import java.util.Map;

/**
 * Write a description of class Recognizable here.
 *
 * @author fatma
 * @version 6/11/2021
 */
public class Serializable implements Comparable<Serializable>
{
    // instance variables - replace the example below with your own
    public final int id;
    private static Map<Class<?>, Integer> mapCounter = new HashMap<>();
    
    //constructor
    protected Serializable(){
    	Class countSerial = getClass();
        if (mapCounter.get(countSerial) == null){
            mapCounter.put(countSerial, 0);
        }
        else {
            mapCounter.put(countSerial, mapCounter.get(countSerial) + 1);
        }
        this.id =mapCounter.get(countSerial);
    }

    @Override
    public int compareTo(Serializable other){
        return (this.id < other.id) ? -1 : ((this.id == other.id) ? 0 : 1);
    }
    
    public boolean equals(Object o){
        if(o instanceof Serializable){
            Serializable or = (Serializable) o;
            if(this.id == or.id){
                return true;
            }
            return false;
        }else{
            return false;
        }
    }
    
    public boolean equals(Serializable r){
        if(this.id == r.id){
            return true;
        }else{
            return false;
        }
    }
    
    public static <T extends Serializable> Integer getClosingId(Class<T> clazz){
        return mapCounter.get(clazz.getClass());
    }

    public static<T extends Serializable> Integer setClosingId(Class<T> clazz, int id){
        return mapCounter.put(clazz.getClass(), id);
    }



    
}
