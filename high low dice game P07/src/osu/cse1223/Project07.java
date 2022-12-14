/*
 * Project07.java
 * 
 *   A program that plays the dice game high/low
 *   Used to practice breaking code up into methods. 
 * 
 * @author Quantez Merchant
 * @version 20181011
 * 
 */
package osu.cse1223;
import java.util.Scanner;
public class Project07 {
	public static void main(String[] args) {
		// Fill in the body
		 Scanner keyboard = new Scanner(System.in);
         int money = 100;
         int winnings = 0;
         int random1 = 0;
         int random2 = 0;
         int bet = 0;
         System.out.println("You have "+ money +" dollars");
         while (money!=0) {
         bet = getBet(keyboard, money);
         char user = getHighLow(keyboard);
         random1 = getRoll();
         System.out.println("Die 1 rolls: " + random1);
         random2 = getRoll();
         System.out.println("Die 2 rolls: " + random2);
         System.out.println("Total of two diece is: " + (random1+random2));
         winnings = determineWinnings(user, bet, (random1+random2));
         if (winnings < 0) {
                 System.out.println("You lost!");
                 money = money + winnings;
                 System.out.println("You have " + money +  " dollars.");
                 System.out.println
         }
         else {
                 System.out.println("You won "+ winnings +" dollars!");
                 money = money + winnings;
                 System.out.println("You have " + money +  " dollars.");
                 
         }
         } 
		
	}
	
	
	// Given a Scanner and a current maximum amount of money, prompt the user for
	// an integer representing the number of dollars that they want to bet.  This
	// number must be between 0 and to maximum number of dollars.  If the user enters
	// a number that is out of bounds, display an error message and ask again.
	// Return the bet to the calling program.
	private static int getBet(Scanner inScanner, int currentPool) {
		// Fill in the body
		 System.out.print("Enter an amount to bet (0 to quit): ");
         int bet = inScanner.nextInt();
         if (bet == 0) {
                 System.out.println("Goodbye!");
                 System.exit(0);
         }
         while (bet < 0 || bet > currentPool) {
                 System.out.println("You must enter between 0 and "+ currentPool +" dollars");
                 System.out.println("You have "+ currentPool+" dollars");
                 System.out.print("Enter an amount to bet (0 to quit): ");
                 bet = inScanner.nextInt();
                 if (bet == 0) {
                         System.out.println("Goodbye!");
                         break;
                 }
         }      
         return bet;
	}
	
	// Given a Scanner, prompt the user for a single character indicating whet her they
	// would like to bet High ('H'), Low ('L') or Sevens ('S').  Your code should accept
	// either capital or lowercase answers, but should display an error if the user attempts
	// to enter anything but one of these 3 values and prompt for a valid answer.
	// Return the character to the calling program.
	private static char getHighLow(Scanner inScanner) {
		// Fill in the body
		System.out.print("High, Low or Seven (H/L/S): ");
        char betLetter = inScanner.next().charAt(0);
        while (betLetter!='h' && betLetter!='H' && betLetter!='L' && betLetter!='l' && betLetter!='s' && betLetter!='S') {
                System.out.println("Invalid, Please enter again!");
                System.out.print("High, Low or Seven (H/L/S): ");
                betLetter = inScanner.next().charAt(0);
        } return betLetter;   
			
		}
		
	
	// Produce a random roll of a single six-sided die and return that value to the calling
	// program
	private static int getRoll() {
		// Fill in the body
		 int randomValue = (int)(6*Math.random())+1;               
         return randomValue;
		
	}
	
	// Given the choice of high, low or sevens, the player's bet and the total result of
	// the roll of the dice, determine how much the player has won.  If the player loses
	// the bet then winnings should be negative.  If the player wins, the winnings should
	// be equal to the bet if the choice is High or Low and 4 times the bet if the choice
	// was Sevens.  Return the winnings to the calling program.
	private static int determineWinnings(char highLow, int bet, int roll) {
		// Fill in the body
		int result;
        if (highLow =='H' || highLow =='h') {
                if (roll < 7) {
                        result = bet*-1;
                }
                else {
                        result = bet;
                }
        }
        if (highLow =='L'|| highLow =='l') {
                if (roll > 7) {
                        result = bet*-1;
                }
                else {
                        result = bet;
                }
        }
        if (highLow =='S' || highLow =='s') {
                result = bet*4;
                }
        else {

                result = bet*-1;
        }
        return result;               
}
	}


