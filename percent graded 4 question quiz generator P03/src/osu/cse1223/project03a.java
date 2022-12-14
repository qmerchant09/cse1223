/*
 *This is a program that asks the user for their name, 
 *it will then generate a 4 question math quiz. 
 *At the end it will tell the user how many they got correct, and what percent that is.  
 *@author quantez merchant
 *@version 20180912
 */
package osu.cse1223;
import java.util.Scanner;
public class project03a {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter your name: ");
		String name = keyboard.nextLine();
		System.out.println("Welcome " + name + "!" + " Please answer the following questions:");
		int randomValueOne =  (int)(20 * Math.random()) + 1;
		int randomValueTwo =  (int)(20 * Math.random()) + 1;
		System.out.print(randomValueOne + " + " + randomValueTwo + " = ");
		int answerOne = keyboard.nextInt();
		int answersCorrect = 0;
		if (answerOne == randomValueOne + randomValueTwo) {
			System.out.println("Correct");
			answersCorrect++;
		}
		else {
			System.out.println("Wrong!");
			System.out.println("The correct answer is " + (randomValueOne + randomValueTwo));
		}
		System.out.print(randomValueOne + " * " + randomValueTwo + " = ");
		int answerTwo = keyboard.nextInt();
		if (answerTwo == randomValueOne * randomValueTwo) {
			System.out.println("Correct");
			answersCorrect++;
		}
		else {
			System.out.println("Wrong!");
			System.out.println("The correct answer is " + (randomValueOne * randomValueTwo));
		}
		System.out.print(randomValueOne + " / " + randomValueTwo + " = ");
		int answerThree = keyboard.nextInt();
		if (answerThree == randomValueOne / randomValueTwo) {
			System.out.println("Correct");
			answersCorrect++;
		}
		else {
			System.out.println("Wrong!");
			System.out.println("The correct answer is " + (randomValueOne / randomValueTwo));
		}
		System.out.print(randomValueOne + " % " + randomValueTwo + " = ");
		int answerFour = keyboard.nextInt();
		if (answerFour == randomValueOne % randomValueTwo) {
			System.out.println("Correct");
			answersCorrect++;
		}
		else {
			System.out.println("Wrong!");
			System.out.println("The correct answer is " + (randomValueOne % randomValueTwo));
		}
		System.out.println("You got " + answersCorrect + " correct answers");
		double numerator = 100;
		double denominator = 4.0;
		double percentage = (numerator/denominator)*answersCorrect;
		System.out.println("That's " + percentage + "%!" ); 	
	}

}
