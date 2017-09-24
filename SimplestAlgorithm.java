
import java.io.*;
import java.lang.*;

public class SimplestAlgorithm {
	static String[] inputs;
	static int[] numinputs;
	static int[] maxfit;
	static int[] counters;
	static int[] coinsused;
	static int coinsusedcounter = 0;
	static int total;
	static int bestcoinsused;
	
	public static void main(String[] args)throws IOException  {
		coinin();
		coinout();
	}
	private static void coinin() throws IOException {
		
		

		
		//Asks user for complete data set
		System.out.println("Type in your number set:");
		System.out.println("This is the format: [dollars] [coinvalue1] [coinvalue2] [coinvalue3] [coinvalue4]");
		System.out.println("Please make all values integers and don't go over 5 total values");
		
		//Defines all arrays and integers used
		inputs = new String[5];
		numinputs = new int[4];
		maxfit = new int[4];
		coinsused = new int[4];
		
		//Takes User Input using Buffered Reader
		BufferedReader num = new BufferedReader(
		new InputStreamReader(System.in));
		inputs = num.readLine().split(" ");
		
		total = Integer.parseInt(inputs[0]);

		
		//Sets all current array values to zero to avoid issues
		for(int counter = 0; counter < 4; counter++){
			coinsused[counter] = 0;
		}
		for(int counter = 0; counter < 4; counter++){
			numinputs[counter] = 0;
		}
		
		
		//Transfers coin values to integer array, excludes total dollars value
		for (int counter = 0; counter < 4; counter++){
			numinputs[counter] = Integer.parseInt(inputs[counter + 1]);
		}
		
		//Calculates the maximum # of times each coin can fit into the total by itself
		for(int counter = 0; counter < 4; counter++){
			maxfit[counter] = total/(numinputs[counter]);
		}
	}
	
	private static void coinout(){
		//Creates large best sum as starting value
		int bestsum = 10000000;
		
		//Loops that are repeated and, using brute force, calculate all possible combinations
		for (int counter1 = 0; counter1 <= maxfit[0]; counter1++){
			
			for (int counter2 = 0; counter2 <= maxfit[1]; counter2++){
				
				for (int counter3 = 0; counter3 <= maxfit[2]; counter3++){
					
					for (int counter4 = 0; counter4 <= maxfit[3]; counter4++){
						//Checks sum to see if it is reached, then records it
						int sum = counter1 * numinputs[0] + counter2 * numinputs[1] +
								counter3 * numinputs[2] +counter4 * numinputs[3];
						if (sum == total){
							//Finds lowest coin sum
							int coinsum = counter1 + counter2 + counter3 + counter4;
							if (coinsum < bestsum){
								bestsum = coinsum;
								coinsused[0] = counter1;
								coinsused[1] = counter2;
								coinsused[2] = counter3;
								coinsused[3] = counter4;
							}
						}
						//If sum is larger than total, don't check or record the coin sum for that specific combination
						else if (sum > total){
							break;
						}
					}
				}
			}
		}
		
		if (bestsum != 10000000){
			System.out.println("Your minimum amount of coins needed is" + " " + bestsum + "." );
			System.out.println("You used "  + coinsused[0] + " " + numinputs[0] + " face-value coins, " + " "
								 + coinsused[1] + " " +  numinputs[1] + " face-value coins, "
								 + coinsused[2] + " " +  numinputs[2] + " face-value coins, and "
								 + coinsused[3] + " " +  numinputs[3] + " face-value coins, ");
		}
		else {
			System.out.println("You couldn't reach your total with the coins you chose.");
		}
	}
}
