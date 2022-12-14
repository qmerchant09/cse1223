/*
 * project1.java
 * This is a program that prompts the user to enter two numbers. The code then adds, subtracts, 
 * multiplies, divides, mods, and averages the two numbers.
 * @ Quantez Merchant
 * @ Version 20180827 
 */
package project01;
import java.util.Scanner;
public class project01a {
	public static void main(String[] args) {
			Scanner keyboard = new Scanner(System.in);
		    System.out.print("Enter the first number: ");
		    int numberOne = keyboard.nextInt();
		    System.out.print("Enter the second number: ");
		    int numberTwo = keyboard.nextInt();
		    System.out.println(numberOne + " + " + numberTwo + " = " + (numberOne + numberTwo));
		    System.out.println(numberOne + " - " + numberTwo + " = " + (numberOne - numberTwo));
		    System.out.println(numberOne + " * " + numberTwo + " = " + (numberOne * numberTwo));
		    System.out.println(numberOne + " / " + numberTwo + " = " + (numberOne / numberTwo));
		    System.out.println(numberOne + " % " + numberTwo + " = " + (numberOne % numberTwo));
		    int average = (numberOne + numberTwo)/2;
		    System.out.println( "The average of your two numbers is: "  + average);
			
	}

}
