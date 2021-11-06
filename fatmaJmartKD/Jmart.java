package fatmaJmartKD;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;

/**
 * Write a description of class Jmart here.
 *
 * @author fatma
 * @version 11/9/2021
 */

public class Jmart{
	
    public static List<Product> filterByCategory(List<Product> list, ProductCategory category){
    	 List<Product> products = new ArrayList<>();
         for(Product product : list){
             if(product.category.equals(category)){
                 products.add(product);
             }
         }
         return products;
    }
    
	public static List<Product> filterByPrice(List<Product> list, double minPrice, double maxPrice){
		 List<Product> products = new ArrayList<>();
	        for(int i = 0; i < list.size(); i++){
	            if(minPrice <= 0.0){
	                if(list.get(i).price <= maxPrice){
	                    products.add(list.get(i));
	                }
	            }else if(maxPrice <= 0.0){
	                if(list.get(i).price >= minPrice){
	                    products.add(list.get(i));
	                }
	            }else{
	                if(list.get(i).price >= minPrice && list.get(i).price <= maxPrice){
	                    products.add(list.get(i));
	                }
	            }
	        }
	        return products;
	}
    
	public static void main(String[] args) {
		try{
            // sesuaikan argument method read sesuai dengan lokasi resource
            List<Product> list = read("C:\\Users\\Flex\\Documents\\Semester 5\\jmart\\randomProductList.json");
            List<Product> filtered = filterByPrice(list, 0.0, 20000.0);
            filtered.forEach(product -> System.out.println(product.price));
        }catch (Throwable t)
        {
            t.printStackTrace();
        }
		
//		System.out.println("account id:" + new Account(null, null, null, -1).id);
//		System.out.println("account id:" + new Account(null, null, null, -1).id);
//		System.out.println("account id:" + new Account(null, null, null, -1).id);
//	
//		System.out.println("payment id:" + new Payment(-1, -1, -1, null).id);
//		System.out.println("payment id:" + new Payment(-1, -1, -1, null).id);
//		System.out.println("payment id:" + new Payment(-1, -1, -1, null).id);
	}
	
	public static List<Product> read(String filepath){
		List<Product> products = new ArrayList<>();
        try{
            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new FileReader(filepath));
            reader.beginArray();
            while(reader.hasNext()){
                products.add(gson.fromJson(reader, Product.class));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return products;
    }
}
    
    
    
//    public static void main(String[] args){
//    	String filepath = "C:\\Users\\Flex\\Documents\\Semester 5\\jmart\\city.json";
//        Gson gson = new Gson();
//        try {
//            BufferedReader br = new BufferedReader(new FileReader(filepath));
//            Country input = gson.fromJson(br, Country.class);
//            System.out.println("name: " + input.name);
//            System.out.println("population: " + input.population);
//            System.out.println("states: ");
//            input.listOfStates.forEach(state -> System.out.println(state));
//        }
//        
//        catch (IOException e){
//            e.printStackTrace();
//        }
//        
//    }
//    
//}

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
