/*
 * A program that determines if multiple credit card numbers are valid. 
 * 
 * @author Quantez Merchant
 * @version 20181004
 * 
 */
package osu.cse1223;
import java.util.Scanner;
public class Project06a {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		int sum = 0;
		int i = 0;
		int j = 0;
		System.out.print("Enter in a credit card number(enter a blank line to quit): ");
		String cardNumber = keyboard.next();
			if (cardNumber.isEmpty())  {
				System.out.println("Goodbye!");
			}else {
				if (cardNumber.length() > 16 || cardNumber.length() < 16) {
					while(cardNumber.length() != 16 ) {
					System.out.println("ERROR! Number MUST have exactly 16 digits");
					System.out.println("");
					System.out.print("Enter in a credit card number(enter a blank line to quit): ");
					cardNumber = keyboard.next();
					}
				}
					while (!cardNumber.isEmpty()) {
						while (j < cardNumber.length()-1) {
							int inputInt = Character.getNumericValue(cardNumber.charAt(i));
							if (j%2 == 0) {
								inputInt = (inputInt*2);
							}
							if (inputInt >= 10) {
								inputInt = inputInt - 9;
							}
							sum = inputInt + sum;
							i++;
							j++;
							
						}
						sum = sum * 9;
						String checkNumber = Integer.toString(sum);
						checkNumber = checkNumber.substring(2); 
						System.out.println("Check digit should be: " + checkNumber);
						System.out.println("Check digit is: " + cardNumber.charAt(15));
						if (checkNumber.equals(cardNumber.substring(15))) {
							System.out.println("Number is valid");
						}else {
							System.out.println("Number is not valid");
						}
						sum = 0;
						i = 0;
						j = 0;
						System.out.println("");
						System.out.print("Enter in a credit card number(enter a blank line to quit): ");
						cardNumber = keyboard.next();
						if (cardNumber.isEmpty()) {
							System.out.println("Goodbye!");
							break;
					}else {
							if (cardNumber.length() > 16 || cardNumber.length() < 16) {
								while(cardNumber.length() != 16 ) {
									System.out.println("ERROR! Number MUST have exactly 16 digits");
									System.out.println("");
									System.out.print("Enter in a credit card number(enter a blank line to quit): ");
									cardNumber = keyboard.next();
									}
							}
					}
					}
					System.out.println("Goodbye!");
				}
			}
	}