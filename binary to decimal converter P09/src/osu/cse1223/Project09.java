/**
 * Project09.java
 *
 *   A program that converts binary numbers into decimal numbers.
 *   Used to practice breaking code up into methods.
 *
 *   @author Quantez Merchant
 */
package osu.cse1223;
import java.util.Scanner;

public class Project09 {

    public static void main(String[] args) {
        //TODO: Fill in body
        Scanner keyboard = new Scanner(System.in);
        String strBinary = promptForBinary(keyboard);
        if (strBinary.isEmpty()) {
        	System.out.println("Goodbye");
        }else {
        	int decimalNumber = binaryToDecimal(strBinary);
            System.out.println("The binary value " + strBinary + " is " + decimalNumber + " in decimal (base 10).");
            System.out.println("");
            while (!strBinary.equals("")) {
            	strBinary = promptForBinary(keyboard);
            	if (strBinary.isEmpty()) {
                	System.out.println("Goodbye");
                	break;
                }
            	decimalNumber = binaryToDecimal(strBinary);
                System.out.println("The binary value " + strBinary + " is " + decimalNumber + " in decimal (base 10).");
                System.out.println("");
            }
        }
    }

    /**
     * Given a Scanner as input, prompt the user to enter a binary value. Use
     * the function checkForBinaryValue below to make sure that the value
     * entered is actually a binary value and not junk. Then return the value
     * entered by the user as an String to the calling method.
     *
     * @param input
     *            A scanner to take user input from
     * @return a String representing a binary value read from the user
     */
    public static String promptForBinary(Scanner input) {
        // TODO: Fill in body
        System.out.print("Enter a binary value (empty line to quit): ");
        String binary = input.nextLine();
        boolean isBinary = checkForBinaryValue(binary);
        while(isBinary == false){
        System.out.println("");
        System.out.print("Enter a binary value (empty line to quit): ");
        binary = input.nextLine();
        isBinary = checkForBinaryValue(binary);
        }
        return binary;
        
    }

    /**
     * Given a String as input, return true if the String represents a valid
     * binary value (i.e. contains only the digits 1 and 0). Returns false if
     * the String does not represent a binary value.
     *
     * @param value
     *            A String value that may contain a binary value
     * @return true if the String value contains a binary value, false otherwise
     */
    public static boolean checkForBinaryValue(String value) {
        // TODO: Fill in body
        boolean check = true;
        int i = 0;
        while (i < value.length()){
        	if ((value.charAt(i) == '0') || (value.charAt(i) == '1')){
        	check = true;
        }else {
        	System.out.println("ERROR - invalid binary value");
        	check = false;
        	break;
        }
        i++;
      }
        return check;
    }

    /**
     * Given a binary value, return an int value that is the base 10
     * representation of that value. Your implementation must use the algorithm
     * described in the Project 9 write-up. Other algorithms will receive no
     * credit.
     *
     * @param value
     *            A String containing a binary value to convert to integer
     * @return The base 10 integer value of that binary in the String
     */
    public static int binaryToDecimal(String value) {
        // TODO: Fill in body
        int total = 0;
        int multiply;
        int i = value.length()-1;
        int j = 0;
        char input;
        int inputInt;
        String str = "";
       while (i >= 0) {
    	 input = value.charAt(j);
         inputInt = Character.getNumericValue(input); 
         multiply = (int) (Math.pow(2,i) * inputInt);
         total = multiply + total;
         str = total + "";
         i--;
         j++; 
        }
        
        int decimal = Integer.parseInt(str);
        return decimal;
    }
}