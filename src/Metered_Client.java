import java.security.SecureRandom;
import java.util.Scanner;

 public class Metered_Client implements Payable {
 private static final  double METER_RENT = 500;
 SecureRandom random_number = new SecureRandom();
 private String client_type ;
 private double water_units;// = random_number.nextInt(1000);
 private static int[] pricePerUnit = {33,30};
 
  public Metered_Client(String client_type) {
	  
	  this.client_type = client_type;
  }
 
  public void setClientType (String client_type) {
	  this.client_type = client_type;
	  
  }
  public String getClientType() {
	  return this.client_type;
  }
  public double getWaterUnits() {
	  double units;
	  Scanner input = new Scanner(System.in);
	  System.out.printf("%s%n", "Enter the amount of water units  ?");
	  units = input.nextDouble();
	  
	return units;
	  
	  
  }
  public String getPaymentMethod() {
	  String pay_method ;
	  Scanner input = new Scanner(System.in);
	  System.out.printf("%s%n", "Enter payment method (Electronically or manual/cash) ?");
	  pay_method = input.next();
	  
	  return pay_method;
  }
  @ Override          //override method payment from the interface  payable
  
  public double getPaymentAmount() {
	   int discount = 9;   //set discount to 9 because of metered type
	   int price;
	   water_units = getWaterUnits();
	   double total_pay;   //total to pay after deductions
	   String pay_method =getPaymentMethod();  //get the payment method
	   if(  pay_method.equalsIgnoreCase("Electronically")) {
		   discount +=5;
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
	   
	   total_pay = ((princ_amount * perc_discount)/100) ;
	   
	   
	  
	return total_pay ;  
  }
  @Override
  public String toString() {
	return String.format("The calculation result for :%n client type :  %s%n water units : %.2f%n payable amount : %.2f%n",getClientType(),this.water_units,getPaymentAmount());
	  
  }
}
