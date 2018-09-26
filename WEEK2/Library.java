/**
 *@author Cole Schiffer
 *Library.java
 *Acesses and interacts with books.
 *
 */
public class Library {
	
	//finds the oldest book in the array, has to be static because it's refereced in the main method which is another static method
	public static Book oldestBook(Book[] lib)
	{
		int old = 0;
		for(int k = 0; k < 3; k++)
		 {
		 	if(lib[k].getAge() >= lib[old].getAge())
		 		old = k;
		 }
		return (lib[old]);
	}
	public static int numberOfBooks(Book[] lib)
	{
		return lib.length;
	}

	public static void main(String[] args)
	{
		// Setting up the books
		Book one = new Book("The Catcher in the Rye","J. D. Salinger", 1951);
		Book two = new Book("The Grapes of Wrath","John Steinbeck", 1939);
		Book three = new Book("Nineteen Eighty-Four","George Orwell", 1949);
		//creating the array
		Book lib[] = {one,two,three};
		//printing out the books
		for(Book k: lib)
		{
			System.out.println(k);
		}
		System.out.println("The oldest book in the Library is: " + oldestBook(lib).getTitle());
		System.out.println("There are " + numberOfBooks(lib) + " books in the Library.");
	

	}
}