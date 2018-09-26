/**		
 * WordCountMap.java
 *@author Grant Lee and Cole Schiffer
 * Main code for organizing and mapping out the words into a binary tree
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
public class WordCountMap{

	private class Node {
        public String word;
        public int count;
        public Node left;
        public Node right;

        private Node(String word, int count, Node left, Node right) {
        	this.word = word;
        	this.count = count;
        	this.left = left;
        	this.right = right;
        }
        private Node(String word, int count) {
        	this.word = word;
        	this.count = count;
        	this.left = null;
        	this.right = null;
        }
      }

       Node root;

	/**
	* If the specified word is already in this WordCountMap, then its
	* count is increased by one. Otherwise, the word is added to this map
	* with a count of 1.
	*/
	public void incrementCount(String word) {
		if(this.root == null) {
			this.root = new Node(word, 1);
		}
		else {
			incrementCount(this.root, word);
		}
	}
    /*
     * Helper method that has the parameters of the current root and the word
	 * word of interest
	 */
	private void incrementCount(Node root, String word) {
		if(root.word.equals(word)) {
			root.count++;
			return;
		}
		else if(root.word.compareTo(word) < 0) {
			if(root.right == null) {
				root.right = new Node(word, 1);
				return;
			}
			else {
				incrementCount(root.right, word);
			}
		}
		else if(root.word.compareTo(word) > 0) {
			if(root.left == null) {
				root.left = new Node(word, 1);
				return;
			}
			else {
				incrementCount(root.left, word);
			}
		}
	}

	/**
	* Returns an array list of WordCount objects, one per word stored in this
	* WordCountMap, sorted in decreasing order by count.
	* @return An ArrayList of object WordCount sorted by the frequency
	*/
	public ArrayList<WordCount> getWordCountsByCount() {
		ArrayList<WordCount> anArray = new ArrayList<WordCount>();
		helperGetWordCountsByCount(this.root, anArray);
		Collections.sort(anArray);
		Collections.reverse(anArray);
		return anArray;
	}
	/*
	* Helper method for getWordCountsByCount
	* @return Arraylist of WordCount objects
	*/
	private ArrayList<WordCount> helperGetWordCountsByCount(Node root, ArrayList<WordCount> anArray) {
		if(root == null) {
			return anArray;
		}
		helperGetWordCountsByCount(root.left, anArray);
		anArray.add(new WordCount(root.word, root.count));
		helperGetWordCountsByCount(root.right, anArray);
		return anArray;
	}
	
	/**
	* Returns a list of WordCount objects, one per word stored in this
	* WordCountMap, sorted alphabetically by word.
	* @return An ArrayList of WordCount objects sorted alphabetically 
	*/
	public ArrayList<WordCount> getWordCountsByWord() {
		ArrayList<WordCount> wordArray = new ArrayList<WordCount>();
		return 	helperGetWordCountsByWord(root, wordArray);
	}
	/*
	* Helper method for getWordCountsByWord
	* @return an ArrayList of WordCount objects
	*/
	private ArrayList<WordCount> helperGetWordCountsByWord(Node root, ArrayList<WordCount> wordArray)
	{
		if(root == null) {
			return wordArray;
		}
		helperGetWordCountsByCount(root.left, wordArray);
		wordArray.add(new WordCount(root.word, root.count));
		helperGetWordCountsByCount(root.right, wordArray);
		return wordArray;
	}
}
      