import java.util.Scanner;
import java.util.InputMismatchException;

/*
Welcome to Data Structures App
9/13/17
Cole Schiffer
*/
public class WelcomeTest {
	public static void main(String[] args){
		Scanner scanner = new Scanner (System.in); //defining scanner

		System.out.println("Welcome to CS 201: Data Structures!");
		System.out.println("What's your name?");
		String name = scanner.nextLine();  //getting user's name
		System.out.println("Enter an integer");
		int num=0; //setting up scanner variable
		boolean complete = true;
		while(complete)
		{
			try
			{
				num = scanner.nextInt();
				complete = false;
			}
			catch(InputMismatchException e)
			{
				System.err.println("enter an integer value below:");//requires integer
				scanner.next();
			}
		}
		System.out.println("Welcome " + name);

		String backwords =""; //backwords
			for(int k =name.length()-1; k>=0;k--)
			{
				backwords=backwords+name.charAt(k);
			}
		System.out.println("Your name backwards is " + backwords);


		if (num==0) {
		System.out.println("Cannot print a triangle of height 0.");	
		}
		else
		{
			for (int k = 1; k<=Math.abs(num);k++) {				
				for (int j=1; j<=k;j++ ) {
					if(num<0)
						System.out.print(k*-1);
					else
						System.out.print(k);
				}
				System.out.println();
			}
		}
		

	}
}