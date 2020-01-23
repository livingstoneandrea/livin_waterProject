import java.security.SecureRandom;
import java.util.Scanner;

public class UnMetered_client implements Payable {

	private  String client_type ;
	private static String pay_method;
	private Scanner input = new Scanner(System.in);
	SecureRandom random_number = new SecureRandom();
	 private double water_units = random_number.nextInt(1000);
	 private static int[] pricePerUnit = {33,30};
	
	
	public  UnMetered_client(String client_type) {
		this.client_type = client_type;
			
	}
	public void setClientType(String client_type) {
		this.client_type = client_type;
	}
	public String getClientType() {
		
		return client_type;
		
	}
	
	public String getPaymentMethod() {
		  String pay_method ;
		  System.out.printf("%s%n", "Enter payment method (Electronically or manual/cash) ?");
		  pay_method = input.next();
		  
		  return pay_method;
	  }
	

	@Override
	public double getPaymentAmount() {
		int discount = 0;
		   int price;
		   double total_pay;
		   pay_method = getPaymentMethod();
		   if(pay_method.equalsIgnoreCase("Electronically")) {
			   discount += 5;
		   }else {
			   discount +=0.0;
		   }
		  
		   if(water_units > 100) {
			   discount +=10;
			  
			   price = pricePerUnit[1];
		   }else {
			   price = pricePerUnit[0];
		   }
		   double princ_amount = water_units * price;
		   double perc_discount = 100-discount;
		   
		   total_pay =((princ_amount * perc_discount)/100) ;
		   
		
		return total_pay;
	}
	
	public String toString() {
		
	 return String.format("Result for the calculation:%n client type => : %s%n water units =>: %.2f%n paid amount => %.2f%n %s%n",this.getClientType(),water_units,this.getPaymentAmount(),pay_method);	
	}

}
