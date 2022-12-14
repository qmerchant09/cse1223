/*
 * A program that prompts the user to enter in a sentence and a word from that sentence.
 * The program will then display the sentence, the word, the length of the sentence, the length of the word,
 * the starting position of the word, the words before and after the selected word.
 * It will them prompt the user into selecting a number between 0 and 1 minus the length of the sentence.
 * It will display the character at the position selected.
 * It will prompt the user to enter in a new word, and then replace the old word with he new word.
 * @Author Quantez Merchant
 * @Version 20180905  
 */
package osu.cse1223;
import java.util.Scanner;
public class project2a {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter a long string: ");
		String STRING = keyboard.nextLine(); 
		System.out.print("Enter a substring: ");
		String SUBSTRING = keyboard.nextLine();
		System.out.println("The length of your string is: " + STRING.length());
		System.out.println("The length of your substring is: " + SUBSTRING.length());
		System.out.println("Starting position of your substring in string: " + STRING.indexOf(SUBSTRING));
		int middle = STRING.indexOf(SUBSTRING);
		String left = STRING.substring(0,middle);
		String right = STRING.substring(middle + SUBSTRING.length());
		System.out.println("String before your substring: " + left);
		System.out.println("String after your substring: " + right);
		int STRING_LENGTH = (STRING.length()-1);
		System.out.print("Enter a position between 0 and " + STRING_LENGTH + ": ");
		int position = keyboard.nextInt();
		System.out.println("The charachter at position " + position + " is " + STRING.charAt(position));
		System.out.println("Enter a replacement string: ");
		String newWord = keyboard.next();
		System.out.print("Your new string is: " + left + newWord + right);
	}
}
