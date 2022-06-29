import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class Restaurant {
    private static HashMap<String, String> tables = new HashMap<>(){{
        put("table1", null);
        put("table2", null);
    }}; 

    private static Queue<String> myQueue = new LinkedList<String>();

    public static void checkIn(Scanner scanner){ 

        System.out.println("What would you like the name of the Reservation to be under? ");
        String name = scanner.nextLine();
        
        if(availability()){ 
           System.out.println("Anug will seat you");
           tables.put(tableSeat(), name);  
        }else{ 
            System.out.println("Both tables are full");
            System.out.println("We will have to put you on the wait list");
            myQueue.add(name); 
        }
        // System.out.println("---Guest was checked in ---");

    }

    public static void checkOut(){ 
        String[] arr={"table1", "table2"};
      	Random r=new Random();        
      	int randomNum=r.nextInt(arr.length);
        String freeTable = arr[randomNum];
        tables.put(freeTable, null);
        System.out.println("---A guest has checkout ---");
        System.out.println("---Seating next guest ---");

        if(!myQueue.isEmpty()){ 
            System.out.println("Seating " + seatGuest() ); ; 
        }else{ 
            System.out.println("Queue is empty");
        }
         
    }

    public static Boolean availability(){ 
        for (String value : tables.values()) {
           if(value == null){ 
            return true; 
           }
        }
        return false;
    }

    public static String tableSeat(){ 
        if(tables.get("table1") == null){ 
            return "table1"; 
        } else if (tables.get("table2") == null){ 
            return "table2"; 
        }

        return " No tables available ";
    }

    public static String seatGuest(){ 
        return myQueue.remove(); 
    }
}
