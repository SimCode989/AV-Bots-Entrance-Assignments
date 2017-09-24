import java.util.Scanner;

public class SoftwareAssignmentPt2 {
	
	public static void main(String[] args) {
		double quarters = 0.25;
		double dimes = 0.10;
		double nickels = 0.05;
		double pennies = 0.01;
		int coins = 0;
		
		//Takes user input
		System.out.println("Type in an amount of dollars:");
		System.out.println("Please don't type in a value more than 2 decimal places");
		Scanner keyboard = new Scanner (System.in);
		double dollars = keyboard.nextDouble();
		double dollars1 = dollars;
		
		//Starts reaching the total dollars, starts with largest coin
		while (dollars >= 0.25){
			dollars = dollars - quarters;
			coins++;
		}

		while (dollars >= 0.10){
			dollars = dollars - dimes;
			coins++;
		}
		
		while (dollars >= 0.05){
			dollars = dollars - nickels;
			coins++;
		}
		
		while (dollars >= 0.01){
			dollars = dollars - pennies;
			coins++;
		}

		coins++;

		System.out.println("Your value was: " + dollars1  );
		System.out.println("Needed a mininum of" + " " + coins + " " + "coins.");
	}
}
