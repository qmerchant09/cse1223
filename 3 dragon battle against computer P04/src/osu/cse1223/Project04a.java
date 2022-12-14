/*
 * this is a program that asks the user to chose one of three dragons 
 * the computer will then also pick a dragon and whichever dragon beats the other 
 * that player will be declared the winner. 
 * @author Quantez Merchant 
 * @version 20180920 
 */
package osu.cse1223;
import java.util.Scanner;
public class Project04a {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		//System.out.print("Please select one of your dragons [Fire/Plant/Water]: ");
		//String dragon = keyboard.nextLine();
		int dragonNumber = 0;
		int game = 0;
		int win = 0;
		int lose = 0;
		int tie = 0;
		for (game = 0; game <= 4; game++) {
			System.out.print("Please select one of your dragons [Fire/Plant/Water]: ");
			String dragon = keyboard.nextLine();
			if (dragon.equalsIgnoreCase("Fire")|| dragon.equalsIgnoreCase("f")) 
			{
				dragonNumber = dragonNumber + 1;
				System.out.println("You chose: Fire dragon"); 
			} else {
			if (dragon.equalsIgnoreCase("Water") || dragon.equalsIgnoreCase("w")) 
			{
				dragonNumber = dragonNumber + 2;
				System.out.println("You chose: Water dragon"); 
			}else {
			if (dragon.equalsIgnoreCase("Plant")|| dragon.equalsIgnoreCase("p")) 
			{
				dragonNumber = dragonNumber + 3;
				System.out.println("You chose: Plant dragon"); 
			}else {
			if (dragonNumber != 1 && dragonNumber != 2 && dragonNumber != 3) 
			{
				System.out.println("You don't have a "+ dragon + " dragon, so you choose no dragons.");
			}
			}
			}
			}
			
				
			int randomValue =  (int)(3 * Math.random() + 1);
				
			if (randomValue == 1) 
			{
				System.out.println("I Chose: "+ "Fire dragon" );
			}
			if (dragonNumber == 1 && randomValue == 1) {
				System.out.println("A tie!");
				tie++;
			} else {
			if (dragonNumber == 2 && randomValue == 1){
				System.out.println("Water beats Fire - you win!");
				win++;
			}else {
			if (dragonNumber == 3 && randomValue == 1){
				System.out.println("Fire beats Plant - you lose!");
				lose++;
			} else {
				System.out.println("You lose by default!");
				lose++;
			}
			}
			}
			
			
			if (randomValue == 2) 
			{
				System.out.println("I Chose: "+ "Water dragon");
			}
			if (dragonNumber == 1 && randomValue == 2){
				System.out.println("Water beats Fire - you lose!");
				lose++;
			}else {
			if (dragonNumber == 2 && randomValue == 2){
				System.out.println("A tie!");
				tie++;
			}else {
			if (dragonNumber == 3 && randomValue == 2){
				System.out.println("Plant beats Water - you win!");
				win++;
			} else {
				System.out.println("You lose by default!");
				lose++;
			}
			}
			}
			
			
			if (randomValue == 3) 
			{
				System.out.println("I Chose: "+ "Plant dragon");
			}
			if (dragonNumber == 1 && randomValue == 3){
				System.out.println("Fire beats Plant - you win!");
				win++;
			}else {
			if (dragonNumber == 2 && randomValue == 3){
				System.out.println("Plant beats Water - you lose!");
				lose++;
			}else {
			if (dragonNumber == 3 && randomValue == 3){
				System.out.println("A tie!");
				tie++;
			}else {
				System.out.println("You lose by default!");	
				lose++;
			}
			}
			}
		}
		System.out.println("Out of " + game + " matches you won " + win + ", I won " + lose + ", and we tied " + tie + ".");
		if (win > lose) {
			System.out.println("Congratulations - you win the tournament!");
		}else {
			System.out.println("Sorry - you lost the tournament");
		}
	}
}