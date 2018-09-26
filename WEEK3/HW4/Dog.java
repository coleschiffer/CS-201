/**
 *Dog
 * Refereces pet and adds some more fields
 *@author Fred
 *@author Cole
 */
public class Dog extends Pet{
	//variables
	private String size;

	//constructors
	Dog(String name, String ownerName, String color, String size){
		super(name, ownerName, color);
		this.size=size;

	}
/**
 *
 *@return size of dog
 */

	public String getSize(){
		return size;
	}
/**
 * Calls pet to string
 *@return String of dog
 */
	public String toString(){
		String dog = "DOG\n";
		dog=dog+"Color: "+color+"\nSex: "+this.getSex()+"\nSize: "+size+"\n";
		return dog;
	}
	

}