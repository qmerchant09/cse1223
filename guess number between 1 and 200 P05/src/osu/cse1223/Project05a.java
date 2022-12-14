/*
 * This is a program that randomly selects a number between 1 and 200
 * the program will then ask the user to guess the  number
 * @ author Quantez Merchant
 * @ version 20180927
 * 
 */
package osu.cse1223;
import java.util.Scanner;
public class Project05a {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		int guesses = 0;
		int correct = 1;
		int randomValue = (int)(200* Math.random()+1);
		while (correct != 0) {
		System.out.print("Enter a guess between 1 and 200: ");
		int guess = keyboard.nextInt();
		if (guess < 1 || guess > 200) {
			System.out.println("Your guess is out of range.  Pick a number between 1 and 200.");
		}
		if (guess != randomValue && guess > randomValue && guess <= 200) {
			System.out.println("Your guess was too high. Try again.");
		}else {
			if (guess != randomValue && guess < randomValue && guess >= 1) {
				System.out.println("Your guess was too low. Try again.");
			}else {
				if (guess == randomValue) {
					System.out.println("Congradulations! Your guess was correct!");
					correct--;
				}
			}
		}
		guesses++;
		}
		System.out.println("I had chosen " + randomValue + " as the target number.");
		System.out.println("You guessed it in " + guesses + " tries.");
		if (guesses == 1) {
			System.out.println("That was astounding!");
		}else {
			if (guesses > 1 && guesses <= 4) {
				System.out.println("That was lucky!");

			}else {
				if (guesses > 4 && guesses <=6) {
					System.out.println("That was pretty good.");
				}else {
					if (guesses == 7) {
						System.out.println("That was not that impressive.");
					}else {
						if (guesses > 7 && guesses <=9) {
							System.out.println("Are you sure this is the right game for you?");
						}else {
							if (guesses >= 10) {
								System.out.println("This just isn't your game, is it?");
							}
						}
					}
				}
			}
		}
	}

}
