package fatmaJmartKD;


/**
 * Write a description of interface FileParser here.
 *
 * @author fatma
 * @version 25/9/2021
 */
public interface FileParser
{
    boolean read(String content);
    default Object write(){return null;}
    static Object newInstance(String content){return null;}
    

}
