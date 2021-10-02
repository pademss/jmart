package fatmaJmartKD;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Write a description of class Store here.
 *
 * @author fatma
 * @version 25/9/2021
 */
public class Store extends Recognizable implements FileParser
{
    public static final String REGEX_NAME = "^[a-z]((?!^\\s{2}).){4,20}$";
    public static final String REGEX_PHONE = "[0-9]{9,12}";
    public String name;
    public String address;
    public String phoneNumber;
    
    public Store(int accountId, String name, String address, String phoneNumber)
    {
        super(accountId);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        
    }
    
    public Store(Account account, String name, String address, String phoneNumber){
        super(account.id);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    
    @Override
    public boolean read(String content){
        return false;
    }
    
    @Override
    public String toString(){
        return "name: " + this.name + "\n" +
        "address: " + this.address + "\n" +
        "phoneNumber: " + this.phoneNumber + "\n";
    }
    
    public boolean validate(){
        Pattern pattern = Pattern.compile(REGEX_NAME);
        Matcher matcher = pattern.matcher(this.name);

        Pattern pattern2 = Pattern.compile(REGEX_PHONE);
        Matcher matcher2 = pattern.matcher(this.phoneNumber);
        
        if(matcher.find() && matcher2.find()){
            return true;
        }
        else{
            return false;
        }
    
}

}
