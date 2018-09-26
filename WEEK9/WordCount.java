/**
 * WordCount.java
 * @author Grant Lee and Cole Schiffer
 * Code for the WordCount Object
 */

public class WordCount implements Comparable<WordCount>{
	public String word;
	public int count;

	public WordCount(String word, int count) {
		this.word = word;
		this.count = count;
	}

	/**
	* This method implements the CompareTo method
	* Uses the instantiated count variable 
	* @param aWord is the desired WordCount object being compared to
	* @return the difference between count variables between the two 
	* 		  WordCount objects
	*/
	public int compareTo(WordCount aWord) {
		return this.count - aWord.count;
	}
}