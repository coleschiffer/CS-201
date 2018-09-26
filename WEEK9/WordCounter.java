/**
 * WordCounter.java
 *@author Grant Lee and Cole Schiffer
 * Takes in words from a txt file, then processes and outputs words sorted acording to the arguments.
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class WordCounter {
	/**
	 * Main Method
	 * Takes in commands: cloud, alphabetical, or frequency
	 * The commands will be used to process a given txt file
	 */
	public static void main(String[] args) {
		WordCloudMaker help = new WordCloudMaker();
		
		//Cloud Command to Create Word Cloud
		if(args[0].equals("cloud")) {
			WordCountMap map = new WordCountMap();
			String fileName = args[1];
			int size = 0;

			//Checks if command contains int
			try {
				size = Integer.parseInt(args[2]);
			}
			catch(Exception e) {
				System.err.println("Enter a valid command");
				throw new IllegalArgumentException();
			}
			addWords(fileName, map);
			System.out.print(help.getWordCloudHTML(fileName, map.getWordCountsByCount().subList(0, size - 1)));
		}

		//Alphabetical Command to sort words alphabetically
		else if(args[0].equals("alphabetical")) {
			WordCountMap map = new WordCountMap();
			String fileName = args[1];
			addWords(fileName, map);
			for(WordCount word : map.getWordCountsByWord()) {
				System.out.println(word.word + ": " + word.count);
			}
		}

		//Frequency Command to sort words by frequency
		else if(args[0].equals("frequency")) {
			WordCountMap map = new WordCountMap();
			String fileName = args[1];
			addWords(fileName, map);
			for(WordCount word : map.getWordCountsByCount()) {
				System.out.println(word.word + ": " + word.count);
			}
		}

		//In the case of invalid commmand
		else {
			System.err.println("Enter a valid command");
			throw new IllegalArgumentException();
		}
	}

	/**
	 * AddWords
	 *@param String filename - name of txt file
	 *@param WordCountMap  map - for adding words and counts into arraylist.
	 * Adds words and interations of thoes words from a text file into an arraylist
	 */
		private static void addWords(String fileName, WordCountMap map) {
		String stopWords = "";
		File story = new File(fileName);
		File stpwrds = new File("StopWords.txt");
		Scanner input = null;
		Scanner check = null;

		//Check if the input file exists
		try {
			input = new Scanner(story);
		} 
		catch(Exception e) {
			System.err.println("Please enter a valid file");
		}

		//Check if file StopWords.txt exists
		try {
			check = new Scanner(stpwrds);
		} 
		catch(Exception e) {
			System.err.println("Please enter a valid file");
		}

		//Aggregate the text into a single string
		while(check.hasNext()) {
			stopWords += check.next();
		}	
		while(input.hasNext()) {
			String word = input.next();
			if(stopWords.contains(word.replaceAll("[^a-zA-Z]","").toLowerCase())) {
			}
			else {
				map.incrementCount(word.replaceAll("[^a-zA-Z]","").toLowerCase());
			}
		}
	}
}