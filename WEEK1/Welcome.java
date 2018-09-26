import java.util.Scanner;
import java.util.InputMismatchException;

/*
Welcome to Data Structures App
9/13/17
Cole Schiffer
*/
public class Welcome {
	public static void main(String[] args){
		Scanner scanner = new Scanner (System.in); //defining scanner

		System.out.println("Welcome to CS 201: Data Structures!");
		System.out.println("What's your name?");
		String name = scanner.nextLine();  //getting user's name
		System.out.println("Enter an integer");
		int number = 0; //setting up scanner variable
		boolean nonInteger = true;
		while(nonInteger)
		{
			try
			{
				number = scanner.nextInt();
				nonInteger = false; //ends loop
			}
			catch(InputMismatchException e)
			{
				System.err.println("Please enter an INTEGER value below:");//requires integer
				scanner.next(); //resets scanner
			}
		}
		System.out.println("Welcome " + name);

		String backwords = ""; //backwords name
			for(int k = name.length() - 1; k >= 0; k--)
			{
				backwords=backwords + name.charAt(k);
			}
		System.out.println("Your name backwards is " + backwords);


		if (number == 0) {
		System.out.println("Cannot print a triangle of height 0.");	
		}
		else
		{
			for (int k = 1; k <= Math.abs(number); k++) {				
				for (int j = 1; j <= k; j++) {
					if(number < 0)
						System.out.print(k * -1); //for negative numbers
					else
						System.out.print(k); 
					if(k != j)
						System.out.print(","); 
				}
				System.out.println();
			}
		}
		

	}
}