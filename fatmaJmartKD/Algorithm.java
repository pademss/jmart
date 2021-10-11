package fatmaJmartKD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Algorithm {
	
	private Algorithm() {
		
	}
	
	public static<T> List<T> collect(T[] array, T value) {
        List<T> list = new ArrayList<T>();
        for (T i: array) {
            if(i.equals(value)) {
                list.add(i);
            }
        }
        return list;
    }

    public static<T> List<T> collect(Iterable<T> iterable, T value) {
        List<T> list = new ArrayList<T>();
        for (T i: iterable) {
            if(i.equals(value)) {
                list.add(i);
            }
        }
        return list;
    }

    public static<T> List<T> collect(Iterator<T> iterator, T value) {
        List<T> list = new ArrayList<T>();
        while(iterator.hasNext()) {
            T i = iterator.next();
            if(i.equals(value)) {
                list.add(i);
            }
        }
        return list;
    }

    public static<T> List<T> collect(T[] array, Predicate<T> pred) {
        List<T> list = new ArrayList<T>();
        for (T i: array) {
            if(pred.predicate(i)) {
                list.add(i);
            }
        }
        return list;
    }

    public static<T> List<T> collect(Iterable<T> iterable, Predicate<T> pred) {
        List<T> list = new ArrayList<T>();
        for (T i: iterable) {
            if(pred.predicate(i)) {
                list.add(i);
            }
        }
        return list;
    }


    public static<T> List<T> collect(Iterator<T> iterator, Predicate<T> pred) {
        List<T> list = new ArrayList<T>();
        while(iterator.hasNext()) {
            T i = iterator.next();
            if(pred.predicate(i)) {
                list.add(i);
            }
        }
        return list;
    }
	
	public static <T> int count(T[] array, T value) {
		//return 0;
		final Iterator<T> i = Arrays.stream(array).iterator();
		return count(i, value);
	}
	
	public static <T> int count(Iterable<T> iterable, T value) {
		//return 0;
		final Iterator <T> i = iterable.iterator();
		return count(i, value);
	}
	
	public static <T> int count(Iterator<T> iterator, T value) {
		final Predicate <T> pred = value::equals;
		return count(iterator, pred);
	}
	
	public static <T> int count(T[] array, Predicate<T> pred) {
		final Iterator<T> i = Arrays.stream(array).iterator();
		return count(i, pred);
	}
	
	public static <T> int count(Iterable<T> iterable, Predicate<T> pred) {
		final Iterator<T> i = iterable.iterator();
		return count(i, pred);
	}
	
	public static <T> int count(Iterator<T> iterator, Predicate<T> pred) {
		return count(iterator, pred);
	}

	public static <T> boolean exists(T[] array, T value) {
		final Iterator<T> i = Arrays.stream(array).iterator();
		return exists(i, value);
	}
	
	public static <T> boolean exists(Iterable<T> iterable, T value){
		final Iterator<T> i = iterable.iterator();
		return exists(i, value);
	}
	
	public static <T> boolean exists(Iterator<T> iterator, T value) {
		final Predicate <T> pred = value::equals;
		return exists(iterator, pred);
	}
	
	public static <T> boolean exists(T[] array, Predicate<T> pred) {
		final Iterator<T> i = Arrays.stream(array).iterator();
		return exists(i, pred);
	}
	
	public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred) {
		final Iterator <T> i = iterable.iterator();
		return exists(i, pred);
	}
	
	public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred) {
		return exists(iterator, pred);
	}
	
	public static <T> T find(T[] array, T value) {
		final Iterator<T> i = Arrays.stream(array).iterator();
		return find(i, value);
	}
	
	public static <T> T find(Iterable<T> iterable, T value){
		final Iterator <T> i = iterable.iterator();
		return find(i, value);
	}
	
	public static <T> T find(Iterator<T> iterator, T value) {
		final Predicate <T> pred = value::equals;
		return find(iterator, pred);
	}
	
	public static <T> T find(T[] array, Predicate<T> pred) {
		final Iterator<T> i = Arrays.stream(array).iterator();
		return find(i, pred);
	}
	
	public static <T> T find(Iterable<T> iterable, Predicate<T> pred) {
		final Iterator <T> i = iterable.iterator();
		return find(i, pred);
	}
	
	public static <T> T find(Iterator<T> iterator, Predicate<T> pred) {
		return find(iterator, pred);
	}
	
	public static <T extends Comparable<? super T>> T max(T first, T  second)
    {
        T maximum;
		if(first.compareTo(second) >= 0)
        {
            maximum = first;
        }
		else {
			maximum = second;
		}
        return maximum;
    }
	
	public static <T extends Comparable<? super T>> T max(T[] array)
    {
        T maximum = null;
        
        for (T i : array) {
        	if(i.compareTo(maximum) >= 0)
            {
                maximum = i;
            }
    		else {
    			maximum = maximum;
    		}
        }
        return maximum;
    }
	
	public static <T extends Comparable<? super T>> T max(Iterable<T> iterable)
    {
		final Iterator <T> i  = iterable.iterator();
		T maximum = null;
        while(i.hasNext()) {
        	if (i.next().compareTo(maximum) >= 0)
        	{
        		maximum = i.next();
        	}
        }
        return maximum;
    }
	
	public static <T extends Comparable<? super T>> T max(Iterable<T> iterable, Comparator<? super T> comparator)
    {
		final Iterator <T> i  = iterable.iterator();
		T maximum = null;
        while(i.hasNext()) {
        	if (comparator.compare(i.next(), maximum) >= 0)
        	{
        		maximum = i.next();
        	}
        }
        return maximum;
    }
	
	public static <T extends Comparable<? super T>> T max(T first, T  second, Comparator<? super T> comparator)
    {
        T maximum;
		if(comparator.compare(first, second) >= 0)
        {
            maximum = first;
        }
		else {
			maximum = second;
		}
        return maximum;
    }
	
	public static <T extends Comparable<? super T>> T max(T[] array, Comparator<? super T> comparator)
    {
        T maximum = null;
        
        for (T i : array) {
        	if(comparator.compare(i, maximum) >= 0)
            {
                maximum = i;
            }
    		else {
    			maximum = maximum;
    		}
        }
        return maximum;
    }
	
	public static <T extends Comparable<? super T>> T max(Iterator <T> iterator, Comparator<? super T> comparator)
    {
        T maximum = null;
        while(iterator.hasNext()) {
        	if(comparator.compare(iterator.next(), maximum)>= 0) {
        		maximum = iterator.next();
        	}
        }
        return maximum;
    }
	
	public static <T extends Comparable<? super T>> T max(Iterator <T> iterator)
    {
        T maximum = null;
        while(iterator.hasNext()) {
        	if(iterator.next().compareTo(maximum) >= 0) {
        		maximum = iterator.next();
        	}
        }
        return maximum;
    }
	

    public static <T extends Comparable<? super T>> T min(T  first, T  second)
    {
    	T minimum;
		if(first.compareTo(second) <= 0)
        {
			minimum = first;
        }
		else {
			minimum = second;
		}
        return minimum;
    }
    
    public static <T extends Comparable<? super T>> T min(T[] array)
    {
        T minimum = null;
        
        for (T i : array) {
        	if(i.compareTo(minimum) <= 0)
            {
                minimum = i;
            }
    		else {
    			minimum = minimum;
    		}
        }
        return minimum;
    }
    
    public static <T extends Comparable<? super T>> T min(Iterable<T> iterable)
    {
		final Iterator <T> i  = iterable.iterator();
		T minimum = null;
        while(i.hasNext()) {
        	if (i.next().compareTo(minimum) <= 0)
        	{
        		minimum = i.next();
        	}
        }
        return minimum;
    }
    
    public static <T extends Comparable<? super T>> T min(Iterable<T> iterable, Comparator<? super T> comparator)
    {
		final Iterator <T> i  = iterable.iterator();
		T minimum = null;
        while(i.hasNext()) {
        	if (comparator.compare(i.next(), minimum) <= 0)
        	{
        		minimum = i.next();
        	}
        }
        return minimum;
    }
    
    public static <T extends Comparable<? super T>> T min(T first, T  second, Comparator<? super T> comparator)
    {
        T minimum;
		if(comparator.compare(first, second) >= 0)
        {
			minimum = first;
        }
		else {
			minimum = second;
		}
        return minimum;
    }
    
    public static <T extends Comparable<? super T>> T min(T[] array, Comparator<? super T> comparator)
    {
        T minimum = null;
        
        for (T i : array) {
        	if(comparator.compare(i, minimum) <= 0)
            {
        		minimum = i;
            }
    		else {
    			minimum = minimum;
    		}
        }
        return minimum;
    }
    
    public static <T extends Comparable<? super T>> T min(Iterator <T> iterator, Comparator<? super T> comparator)
    {
        T minimum = null;
        while(iterator.hasNext()) {
        	if(comparator.compare(iterator.next(), minimum)>= 0) {
        		minimum = iterator.next();
        	}
        }
        return minimum;
    }
	
	public static <T extends Comparable<? super T>> T min(Iterator <T> iterator)
    {
        T minimum = null;
        while(iterator.hasNext()) {
        	if(iterator.next().compareTo(minimum) >= 0) {
        		minimum = iterator.next();
        	}
        }
        return minimum;
    }
}
