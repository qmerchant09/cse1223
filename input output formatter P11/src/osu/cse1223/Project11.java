/*
 * Project11.java
 * 
 *   A program that reads in a text file that uses a specific input format and uses it to
 *   produce a formatted report for output.
 *   
 *   See the write-up for Homework Lab 13 for more details.
 *   
 *   This skeleton is more "skeletal" than previous labs.  You MUST break your code up into
 *   more methods than what you see here.  Consider methods to display the formatted report
 *   as well as more methods to compute values for the report.
 * 
 * @author Quantez Merchant
 * 
 */
package osu.cse1223;
import java.io.*;
import java.util.*;

public class Project11 {
	
	public static void main(String[] args) {
		// Fill in the body
		Scanner keyboard = new Scanner(System.in);
		ArrayList<Integer> score = new ArrayList<Integer>();
		ArrayList<Integer> score2 = new ArrayList<Integer>();
		ArrayList<Integer> score3 = new ArrayList<Integer>();
		ArrayList<Integer> score4 = new ArrayList<Integer>();
		ArrayList<Integer> allAverages = new ArrayList<Integer>();
		String inputName = getInputFileName(keyboard);
		String outputName = getOutputFileName(keyboard);
		while (inputName.equals(outputName)) {
			System.out.println("ERROR!  Your input file and output file MUST be different.");
			inputName = getInputFileName(keyboard);
			outputName = getOutputFileName(keyboard);
		}
		File inputFile = new File (inputName);
		File outputFile = new File (outputName);
		try {
			PrintWriter out = new PrintWriter(outputFile);
			Scanner read = new Scanner(inputFile);
			String player = getName(read);
			score = readNextSeries(read);
			int average = getAverage(score);
			Collections.sort(score);
			int median = getMedian(score);
			int min = getMinMax(score);
			int max = getMaxMin(score);
			String player2 = getName(read);
			score2 = readNextSeries(read);
			int average2 = getAverage(score2);
			Collections.sort(score2);
			int median2 = getMedian(score2);
			int min2 = getMinMax(score2);
			int max2 = getMaxMin(score2);
			String player3 = getName(read);
			score3 = readNextSeries(read);
			int average3 = getAverage(score3);
			Collections.sort(score3);
			int median3 = getMedian(score3);
			int min3 = getMinMax(score3);
			int max3 = getMaxMin(score3);
			String player4 = getName(read);
			score4 = readNextSeries(read);
			int average4 = getAverage(score4);
			Collections.sort(score4);
			int median4 = getMedian(score4);
			int min4 = getMinMax(score4);
			int max4 = getMaxMin(score4);
			allAverages.add(average);
			allAverages.add(average2);
			allAverages.add(average3);
			allAverages.add(average4);
			read.close();
			format(out);
			formatTable(out, player, average, median, max, min);
			formatTable(out, player2, average2, median2, max2, min2);
			formatTable(out, player3, average3, median3, max3, min3);
			formatTable(out, player4, average4, median4, max4, min4);
			String highest = "";
			int maxOfAll = getMaxOfAll(allAverages);
			if (maxOfAll == average) {
				highest = player;
			}else {
				if (maxOfAll == average2) {
					highest = player2;
				}else {
					if (maxOfAll == average3) {
						highest = player3;
					}else {
						highest = player4;
					}
				}
			}
			String lowest = "";
			int minOfAll = getMinOfAll(allAverages);
			if (minOfAll == average) {
				lowest = player;
			}else {
				if (minOfAll == average2) {
					lowest = player2;
				}else {
					if (minOfAll == average3) {
						lowest = player3;
					}else {
						lowest = player4;
					}
				}
			}
			out.println();
			out.println("Total number of participants: 4");
			out.println("Highest average score: " + highest + " (" + maxOfAll +")");
			out.println("Lowest average score: " + lowest + " (" + minOfAll +")");
			out.close();
		}catch(IOException e){
			System.out.println("There was a problem reading from " + inputName);
		}catch(Exception e) {
			System.out.println("Error writing to file " + outputName);
		}

		
		
		
	}
	
	// Given a Scanner as input read in a list of integers one at a time until a negative
	// value is read from the Scanner.  Store these integers in an ArrayList<Integer> and
	// return the ArrayList<Integer> to the calling program.
	private static ArrayList<Integer> readNextSeries(Scanner inScanner) {
		// Fill in the body
		ArrayList<Integer> scores =  new ArrayList<Integer>();
		int i = 0;
		while (inScanner.hasNext()) {
			if (inScanner.hasNextInt()) {
			i = inScanner.nextInt();
			if (i < 0) {
				break;
			}
			scores.add(i);
			}
		}
		return scores;
	}
	
	// Given a ArrayList<Integer> of integers, compute the median of the list and return it to
	// the calling program.
	private static int getMedian(ArrayList<Integer> inList) {
		// Fill in the body
		int i = 0;
		int j = 0;
		int median = 0;
		if (inList.size()%2 == 0) {
			i = inList.get(inList.size()-3);
			j = inList.get(inList.size()-2);
			median = (i+j)/2;
		}else {
			i = (inList.size()-1)/2;
			median = inList.get(i);
		}
		return median;
	}
	
	// Given a ArrayList<Integer> of integers, compute the average of the list and return it to
	// the calling program.
	private static int getAverage(ArrayList<Integer> inList) {
		// Fill in the body
		int i = 0;
		int sum = 0;
		int count = 0;
		while (i < inList.size()) {
			sum = sum + inList.get(i);
			count++;
			i++;
		}
		return sum/count;
	}
	
	// Given a ArrayList<Integer> of integers, find the smallest number of the list 
	//and return it to the calling program.
	private static int getMinMax(ArrayList<Integer> inList) {
		// Fill in the body
		int i = 0;
		int min = inList.get(0);
		while (i < inList.size()) {
			if (inList.get(i) < min) {
				min = inList.get(i);
			}
			i++;
		}
		return min;
	}
	
	// Given a ArrayList<Integer> of integers, find the biggest number of the list 
	//and return it to the calling program.
	private static int getMaxMin(ArrayList<Integer> inList) {
		// Fill in the body
		int i = 0;
		int max = inList.get(0);
		while (i < inList.size()) {
			if (inList.get(i) > max) {
				max = inList.get(i);
			}
			i++;
		}
		return max;
	}
	
	
	// Given a Scanner as input prompts the user to enter an input file name.  If given an
	// empty line, respond with an error message until the user enters a non-empty line.
	// Return the string to the calling program.
	private static String getInputFileName(Scanner inScanner) {
		System.out.print("Enter an input file name: ");
		String name = inScanner.nextLine();
		if(name.equals("")) {
			while (name.equals("")) {
				System.out.print("Error! Enter a file name: ");
				name = inScanner.nextLine();
			}
		}
	return name;	
	}
	
	
	// Given a Scanner as input prompts the user to enter an output file name.  If given an
	// empty line, respond with an error message until the user enters a non-empty line.
	// Return the string to the calling program. 
	private static String getOutputFileName(Scanner inScanner) {
		System.out.print("Enter an output file name: ");
		String name = inScanner.nextLine();
		if(name.equals("")) {
			while (name.equals("")) {
				System.out.print("Error! Enter a file name: ");
				name = inScanner.nextLine();
			}
		}
	return name;	
	}

	// Given a Scanner as input read the input file for a name. If the next line has 
	// an integer in break the loop and return the string to the calling program. 
	private static String getName(Scanner inScanner) {
		String name = "";
		while(inScanner.hasNextLine()) {
			if (inScanner.hasNextInt()) {
				break;
			}else {
				name = inScanner.nextLine();
			}
		}
	return name;
	}
	
	// Given a PrintWriter as input write the header of the table to the output file. 
	private static void format(PrintWriter out) {
		out.format("%-10s\n","Final Overall Scores Report");
		out.println();
		out.format("%-10s %14s %6s %4s %4s\n","Name", "Mean", "Median", "Max", "Min");
		out.format("%-2s %4s %s %s %s\n", "------------------", "------", "------", "----", "----");
	}
	
	// Given a PrintWriter, a String, and four integers as input write
	// the table to the output file. 
	private static void formatTable(PrintWriter out, String person, int avg, int med, int max, int min) {
		out.printf("%-18.18s %6.6s %6.6s %4.4s %4.4s\n", person, avg, med, max, min);
	}

	// Given an ArrayList of Integers as input determine the highest average score. 
	private static int getMaxOfAll(ArrayList<Integer> inList) {
		int i = 0;
		int max = inList.get(0);
		while (i < inList.size()) {
			if (inList.get(i) > max) {
				max = inList.get(i);
			}
			i++;
		}
		return max;
		}
		
	// Given an ArrayList of Integers as input determine the lowest average score. 
	private static int getMinOfAll(ArrayList<Integer> inList) {
		int i = 0;
		int min = inList.get(0);
		while (i < inList.size()) {
			if (inList.get(i) < min) {
				min = inList.get(i);
			}
			i++;
		}
		return min;
	}
}

