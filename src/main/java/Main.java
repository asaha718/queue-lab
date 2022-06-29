import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Anug's Reservation System ---");

        try (Scanner scanner = new Scanner(System.in)) {
            while(true){ 
                System.out.print("Do you want to check someone in(1) or out(2)?: ");
                String userInput= scanner.nextLine(); 

                if(userInput.equals("1")){ 
                    Restaurant.checkIn(scanner);
                }else if(userInput.equals("2")){ 
                    Restaurant.checkOut();
                }

            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
