import java.util.GregorianCalendar;
import java.util.Date;

/* Pet
 * @author Fred 
 * @author Cole
 * 9/21/17
 *
 */
public class Pet implements Boardable{
	protected String petName, ownerName, color;
	protected int sex;
	protected Date boardStart;
	protected Date boardEnd;
	public static final String[] sexes = {"male", "female", "spayed", "neutered", "other"};

//contructor
	public Pet(String name, String ownerName, String color){
		petName = name;
		this.ownerName = ownerName;
		this.color = color;
	}
//accessor methods
	public String getPetName(){
		return petName;
	}

	public String getOwnerName(){
		return ownerName;
	}

	public String getColor(){
		return color;
	}
//Sets sex
	public void setSex(int sexID){
		sex = sexID;
	}

	public String getSex(){
		return sexes[sex];
	}
//to string
	public String toString(){
		return petName + " owned by " + ownerName + "\nColor: " + color + "\nSex: " + sex+"\n";
	}

	public void setBoardStart(int month, int day, int year){
		boardStart = new GregorianCalendar(year, month-1, day).getTime();

	}

	public void setBoardEnd(int month, int day, int year){
		boardEnd = new GregorianCalendar(year, month-1, day).getTime();

	}

	public boolean boarding(int month, int day, int year){
		Date test = new GregorianCalendar(year, month-1, day).getTime();
		if ((test.compareTo(boardStart)>0) && (test.compareTo(boardEnd)<0))
			return true;
		else
			return false;
	}

}


