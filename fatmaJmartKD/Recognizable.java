package fatmaJmartKD;


/**
 * Write a description of class Recognizable here.
 *
 * @author fatma
 * @version 25/9/2021
 */
public class Recognizable
{
    public final int id;
    
    protected Recognizable(int id){
        this.id = id;
    }
    
    public boolean equals(Object object){
        if (object instanceof Recognizable){
            Recognizable recognizable = (Recognizable) object;
            if (recognizable.id == this.id){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
    
    public boolean equals(Recognizable recognizable){
        if (this.id == recognizable.id){
            return true;
        }
        else{
            return false;
        }
    }
}
