package fatmaJmartKD;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.google.gson.*;

/**
 * Write a description of class Jmart here.
 *
 * @author fatma
 * @version 11/9/2021
 */

public class Jmart{
    class Country{
        public String name;
        public int population;
        public List<String> listOfStates;
    }
    
    public static void main(String[] args){
    	String filepath = "C:\\Users\\Flex\\Documents\\Semester 5\\jmart\\city.json";
        Gson gson = new Gson();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            Country input = gson.fromJson(br, Country.class);
            System.out.println("name: " + input.name);
            System.out.println("population: " + input.population);
            System.out.println("states: ");
            input.listOfStates.forEach(state -> System.out.println(state));
        }
        
        catch (IOException e){
            e.printStackTrace();
        }
        
    }
    
}

//public class Jmart
//{
//    public static void main(String[] args){
//    /*    System.out.println(Shipment.Duration.SAME_DAY.getEstimatedArrival(new Date()));
//        Store store = new Store(110, "fatma putri", "Jakarta", "085303678965");
//        System.out.println(store);
//        System.out.println(store.validate()); */
//        
//    /*    Account account = new Account(1, "fatma", "fatma.putri@ui.ac.id", "OOPLetsgo123");
//        System.out.println(account.validate());
//        Complaint complaint = new Complaint(2, "lama nyampe");
//        System.out.println(complaint.toString()); */
//    	
//    	System.out.println("Hello from Eclipse!");
//    }
//    
//
//    public static Product createProduct()
//    {
//        return null;
//    }
//    public static Coupon createCoupun()
//    {
//        return null;
//    }
//    public static Shipment.Duration createShipmentDuration()
//    {
//        return null;
//    }
//}
