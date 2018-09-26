/**
 *Cat
 * Refereces pet and adds some more fields
 *@author Fred
 *@author Cole
 */
public class Cat extends Pet{
	private String hairLength;
	Cat(String name, String ownerName, String color, String hairLength){
		super(name, ownerName, color);
		this.hairLength=hairLength;

	}
/**
 * 
 *@return Length of hair
 */
 	public String getHairLength(){
		return hairLength;
	}
/**
 * Calls pet to string
 *@return String of cat
 */
	public String toString(){
		String cat = "CAT\n";
		cat=cat+petName+" owned by "+ownerName+"\nColor: "+color+"\nSex: "+this.getSex()+"\nHair: "+hairLength+"\n";
		return cat;
	}

}