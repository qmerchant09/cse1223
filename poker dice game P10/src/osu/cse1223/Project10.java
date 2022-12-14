/*
 * Project10.java
 * 
 *   A program that plays and scores a round of the game Poker Dice.  In this game,
 *   five dice are rolled.  The player is allowed to select a number of those five dice
 *   to re-roll.  The dice are re-rolled and then scored as if they were a poker hand.  
 *   The following hands MUST be scored in this assignment:
 *   	* High card
 *   	* One Pair
 *   	* Two Pair
 *   	* Three of a Kind
 *   	* Full House
 *   	* Four of a Kind
 *   	* Five of a Kind
 *   For extra credit, you may also implement:
 *   	* Straight
 * 
 * @author Quantez Merchant
 * 
 */
package osu.cse1223;
import java.util.Scanner;
import java.util.Arrays;

public class Project10 {

	public static void main(String[] args) {
		// Fill in the body
		Scanner keyboard = new Scanner(System.in);
		int [] poker = new int[5];
		boolean play = true;
		while (play) {	
		resetDice(poker);
		rollDice(poker);
		System.out.println("Your current dice: " + diceToString(poker) /*Arrays.toString(poker)*/);
		promptForReroll(poker, keyboard);
		System.out.println("Keeping remaining dice...");
		System.out.println("Rerolling...");
		poker = reroll(poker);
		System.out.println("Your final dice: " + diceToString(poker) /*Arrays.toString(poker)*/);
		String str = getResult(poker);
		System.out.println(str);
		play = promptForPlayAgain(keyboard);
		System.out.println();
		}
		System.out.println("Goodbye!");
	}
	
	// Given an array of integers as input, sets every element of the array to zero.
	private static void resetDice(int[] dice) {
		// Fill in the body
		int i = 0;
		while (i < dice.length){
			dice[i] = 0;
			i++;
		}
	}
	
	// Given an array of integers as input, checks each element of the array.  If the value
	// of that element is zero, generate a number between 1 and 10 and replace the zero with
	// it.  Otherwise, leave it as is and move to the next element.
	private static void rollDice(int[] dice) {
		// Fill in the body
		int i = 0;
		while (i < dice.length) {
			if (dice[i] == 0) {
				dice[i] = (int)(Math.random()*9)+1;
			}
			i++;
		}
	}
	
	// Given an array of integers as input, create a formatted String that contains the
	// values in the array in the order they appear in the array.  For example, if the 
	// array contains the values [0, 3, 7, 5, 2] then the String returned by this method
	// should be "0 3 7 5 2".
	private static String diceToString(int[] dice) {
		// Fill in the body
		String str = "";
		int i = 0;
		while (i < dice.length) {
			str = str + str.valueOf(dice[i]) + " ";
			i++;
		}
		return str;
	}
	
	
	// Given an array of integers and a Scanner as input, prompt the user with a message
	// to indicate which dice should be re-rolled.  If the user enters a valid index (between
	// 0 and the total number of dice -1) then set the die at that index to zero.  If the 
	// user enters a -1, end the loop and return to the calling program.  If the user enters
	// any other invalid index, provide an error message and ask again for a valid index.
	private static void promptForReroll(int[] dice, Scanner inScanner) {
		// Fill in the body
		int i = 0;
		while (i < dice.length) {
			System.out.print("Select a die to re-roll (-1 to keep remaining dice): ");
			int reroll = inScanner.nextInt();
			if (reroll >= 0 && reroll < dice.length) {
				dice[reroll] = 0;
			}else {
				if (reroll == -1) {
					break;
				}else {
					if (reroll > dice.length-1) {
						System.out.println("Error: Index must be between 0 and 4 (-1 to quit)!");
					}
				}
			}
			System.out.println("Your current dice: " + diceToString(dice)/*Arrays.toString(dice)*/);
			i++;
		}
	}
	
	// Given an array of integers as input, give new values to the user selected values.
	private static int[] reroll (int[] dice) {
		int [] reroll = new int[5];
		int i = 0;
		while (i < dice.length) {
			if (dice[i] == 0) {
				reroll[i] = (int)(Math.random()*9)+1;
			}else {
				reroll[i] = dice[i];
			}
			i++;
		}
		return reroll;
	}
	
	// Given a Scanner as input, prompt the user to play again.  The only valid entries
	// from the user are 'Y' or 'N', in either upper or lower case.  If the user enters
	// a 'Y' the method should return a value of true to the calling program.  If the user
	// enters a 'N' the method should return a value of false.  If the user enters anything
	// other than Y or N (including an empty line), an error message should be displayed
	// and the user should be prompted again until a valid response is received.
	private static boolean promptForPlayAgain(Scanner inScanner) {
		// Fill in body
		System.out.print("Would you like to play again [Y/N]?: ");
		String str = inScanner.next();
		boolean play = false;
		while (str.charAt(0)!= 'y' && (str.charAt(0) != 'Y') && (str.charAt(0) != 'N') && (str.charAt(0) != 'n')){
			System.out.println("ERROR! Only 'Y' or 'N' allowed as input!");
			System.out.print("Would you like to play again [Y/N]?: ");
			str = inScanner.next();
		}
		if(str.equals("y") || (str.equals("Y"))){
			play = true;
		}
		else{
			play = false;
		}
		return play;
	    
	}
	
	// Given an array of integers, determines the result as a hand of Poker Dice.  The
	// result is determined as:
	//	* Five of a kind - all five integers in the array have the same value
	//	* Four of a kind - four of the five integers in the array have the same value
	//	* Full House - three integers in the array have the same value, and the remaining two
	//					integers have the same value as well (Three of a kind and a pair)
	//	* Three of a kind - three integers in the array have the same value
	//	* Two pair - two integers in the array have the same value, and two other integers
	//					in the array have the same value
	//	* One pair - two integers in the array have the same value
	//	* Highest value - if none of the above hold true, the Highest Value in the array
	//						is used to determine the result
	//
	//	The method should evaluate the array and return back to the calling program a String
	//  containing the score from the array of dice.
	//
	//  EXTRA CREDIT: Include in your scoring a Straight, which is 5 numbers in sequence
	//		[1,2,3,4,5] or [2,3,4,5,6] or [3,4,5,6,7] etc..
	private static String getResult(int[] dice) {
		// Fill in the body
		int[] intCount = new int[9];
		String str = "";
		int i = 0;
		intCount= getCounts(dice);
		while (i < intCount.length) {
			if (intCount[i] == 5) {
				str = "Five of a kind";
				break;
			}else {
				if (intCount[i] == 4) {
					str = "Four of a kind";
					break;
				}else {
					if (intCount[i] == 3) {
						int k = i+1;
						while(k < intCount.length) {
							if (intCount[k] == 2) {
								str = "Full House";
							}else {
								str = "Three of a kind";
							}
							k++;
						}
						break;
					}else {
						if (intCount[i] == 2) {
							int j = i+1;
							str = "One pair";
							while (j < intCount.length) {
								if (intCount[j] == 2) {
									str = "Two pair";
								}
								j++;
							}
							break;
						}else {
							if (intCount[i] == 1) {
								int l = 0;
								int max = dice[0];
								while (l < dice.length) {
									if (dice[l] > max) {
										max = dice[l];
									}
									l++;
								}
								str = "Highest card " + max;
							}	
						}
						}
					}
				}
			i++;
			}
		return str;
	}
	
	
	// Given an array of integers as input, return back an array with the counts of the
	// individual values in it.  You may assume that all elements in the array will have 
	// a value between 1 and 10.  For example, if the array passed into the method were:
	//   [1, 2, 3, 3, 7]
	// Then the array of counts returned back by this method would be:
	// [1, 1, 2, 0, 0, 0, 1, 0, 0, 0]
	// (Where index 0 holds the counts of the value 1, index 1 holds the counts of the value
	//  2, index 2 holds the counts of the value 3, etc.)
	// HINT:  This method is very useful for determining the score of a particular hand
	//  of poker dice.  Use it as a helper method for the getResult() method above.
	private static int[] getCounts(int[] dice) {
		// Fill in the body
		int [] counts = new int[9];
		int i = 0;
		while (i < dice.length) {
			if (dice[i] == 1) {
				counts[0] = counts[0] + 1;
			}else {
				if (dice[i] == 2) {
					counts[1] = counts[1] + 1;
				}else {
					if (dice[i] == 3) {
						counts[2] = counts[2] + 1;
					}else {
						if (dice[i] == 4) {
							counts[3] = counts[3] + 1;
						}else {
							if (dice[i] == 5) {
								counts[4] = counts[4] + 1;
							}else {
								if (dice[i] == 6) {
									counts[5] = counts[5] + 1;
								}else {
									if (dice[i] == 7) {
										counts[6] = counts[6] + 1;
									}else {
										if (dice[i] == 8) {
											counts[7] = counts[7] + 1;
										}else {
											if (dice[i] == 9) {
												counts[8] = counts[8] + 1;
											}
										}
									}
								}
							}
						}
					}
				}
			}
			i++;
		}
		return counts;
	}
	



}
