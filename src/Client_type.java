import java.util.Scanner;

public class Client_type {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String client ;
		System.out.println("Enter the  type of client (metered or unmetered)");
		client = input.next();
		
		switch(client) {
		case "metered":
			  Metered_Client metered = new Metered_Client(client);
			   //metered.getPaymentMethod();
			   System.out.printf("Results: %s%n", metered.toString());
			break;
		case "unmetered":
			 UnMetered_client unmeterd = new  UnMetered_client(client);
			 
			 System.out.printf("Results: %s%n", unmeterd.toString());
			
			break;
	    default:
			System.out.println("No such client exist !!");
			System.out.println("Enter the  type of client (metered or unmetered)");
			client = input.next();
			
		
		}
		

	}

}
