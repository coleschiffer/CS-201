/**
 * @author Cole Schiffer
 * Book.Java
 *Sets up a book with specific fields
 *
 *
 */
public class Book {
		private String title;
		private String author;
		private int pubYear;
		private String genre;
		private static int CUR_YEAR = 2017; //not sure why it has to be static, it works without being static for me

//Constructor #1
	public Book(String aTitle, String anAuthor, int aYear) 
	{
		title = aTitle;
		author = anAuthor;
		pubYear = aYear;
	}
//Constructor #2
	public Book(String aTitle, String anAuthor, int aYear, String aGenre) 
	{
		title = aTitle;
		author = anAuthor;
		pubYear = aYear;
		genre = aGenre;
	}
//acessor methods
	public String getAuthor()
	{
		return author;
	}
	public String getTitle()
	{
		return title;
	}
//finds age
	public int getAge()
	{
		return(CUR_YEAR - pubYear);
	}
//Format for when a book converted to a string
	public String toString()
	{
		return(title + " by " + author + " is " + getAge() + " years old.");
	}
//main method
	public static void main(String[] args)
	{
		// Setting up the books
		Book one = new Book("The Catcher in the Rye","J. D. Salinger", 1951);
		Book two = new Book("The Grapes of Wrath","John Steinbeck", 1939);
		//creating the array
		//printing out the books
		System.out.println(one);
		System.out.println(two);


	}

}