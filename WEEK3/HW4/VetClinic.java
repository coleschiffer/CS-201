/** VetClinic
 * @author Fred 
 * @author Cole
 */
import java.io.File;
import java.util.Scanner;
public class VetClinic{
private Boardable[] pets;
Scanner scanner = null;		

	public VetClinic(String InputFile)
	{
        File inputFile = new File(InputFile);
        //checks if file exists
        try {
            scanner = new Scanner(inputFile);
        } catch (Exception e) {
            System.err.println(e);
            System.exit(1);
        }
        int length = scanner.nextInt();
		String lines[];
        pets = new Boardable[length];
        for(int k = 0; k < length; k++)
        { 
        	String type = scanner.next();
        	String line = scanner.next();
        	lines = line.split(",");
        	String name = lines[0];
			String owner = lines[1];
			String color = lines[2];
			int gender = Integer.parseInt(lines[3]); //converts string to int
			String size = lines[4];
//Checks if dog or cat the creates corisponding objects
        	if(type.equals("DOG"))
        	{
			pets[k] = new Dog(name, owner, color, size); 
			((Pet)pets[k]).setSex(gender); //sets gender 
        	}
        	else
        	{
			pets[k] = new Cat(name, owner, color, size); 
			((Pet)pets[k]).setSex(gender); //sets gender

        	}
        }
          scanner.close();
	}

	public Boardable[] getAllPets()
	{
		return pets;
	}
//prints all pets
	public void printAllPets()
	{
		for(int i = 0; i < pets.length; i++){
			if(pets[i] instanceof Dog)
			{
				System.out.println(pets[i]);
			}
			else
			{
				System.out.println(pets[i]);
			}
		}
	}
//prints pets by boarding
	public void printAllBoarding(int month, int day, int year){
		for(int i = 0; i < pets.length; i++){
			if(pets[i].boarding(month, day, year)){
				System.out.println(pets[i]);
			}
		}
	}
//prints pets by owner
	public void printAllOwnedby(String owner){
		for(int i = 0; i < pets.length; i++){
			if(((Pet)pets[i]).getOwnerName().equals(owner)){
				System.out.println(pets[i]);
			}
		}

	}
}