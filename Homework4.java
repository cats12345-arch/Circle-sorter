import java.util.Scanner;
public class Homework4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner key = new Scanner(System.in);
		
		//Asking the user for the input for size of array
		System.out.println("How many circles would you like sort?");
		int arraysize = key.nextInt();
		
		//Creating the array based on the size
		double[] circlearray = new double[arraysize];
		
		//This array will be used to find the unique values later by making a copy of the array and then comparing the values 
		double[] array2 = new double[arraysize];
		
		//These two variables will be used to check to see if there is a duplicate value later
		int check = 0;
		int b = 0;
		
		//This variable is used to close the do while loop in case the user inputs a wrong value
		int check2= 0;
		
		//This is gathering the different radiuses for the various values and will ask depending on the number of circles that the user inputed to be stored
		for(int i = 0; i < circlearray.length; i++)
		{
			System.out.println("Enter the radius for the circle at index "+i+":");
			circlearray[i] = key.nextInt();
		}
		
		//This is setting the initial choice to see what the user wishes to choose and then using a switch statement to swap between the differing choices
		System.out.println("Would you like the data displayed as  1. Total number of circles and the radius of each circle. 2. The area of each circle from smallest to largest. 3. The circles area from largest to smallest. 4. See all the unique areas of the circles stored. 5. quit the program?");
		int choice = key.nextInt();
		
		//Do while loop in case the user inputs the wrong value
		do
		{
				switch(choice)
				{
					//Displays the number of circles and then the radius of the circles there are
					case 1:
						System.out.println("The number of circles listed are " +circlearray.length+ " circles and the radius of the circles are");
						
						//For loop to move to the next value in the array and then print out the value. also its nicely spaced
						for(int i = 0; i < circlearray.length; i++)
						{
							System.out.print(circlearray[i]+"  ");
						}
						check2++;
						break;
					
					//Displays the area from smallest to largest
					case 2:
						//Used for converting the radius to area using r^2 pi
						for(int i = 0; i < circlearray.length; i++)
						{
							circlearray[i] = circlearray[i] * circlearray[i] * 3.14;
						}
						
						//Used to sort the values from smallest to largest  by comparing the value stored at position i with the entire array until a smaller value is found
						for(int i = 0; i < circlearray.length; i++)
						{
							int min = i;
							double smallest = circlearray[i];
							
							for(int j = i + 1; j < circlearray.length; j++)
							{
								if(circlearray[j] < smallest)
								{
									smallest = circlearray[j];
									min = j;
									
								}
							}
							
							//Used for swapping the values around so that it is actually sorted. the temp is used to move the values around
							if(smallest < circlearray[i])
							{
								double temp = circlearray[i];
								
								circlearray[i] = circlearray[min];
									
								circlearray[min] = temp;
							}
						}
						
						//Prints the final array after it has been sorted 
						for(int i = 0; i < circlearray.length; i++)
						{
							System.out.print(circlearray[i]+"  ");
							
						}
						System.out.println();
						check2++;
						break;
					case 3:
						//This one sorts from the largest to the smallest and is just slightly modified from the one above
						
						//radius -> area
						for(int i = 0; i < circlearray.length; i++)
						{
							circlearray[i] = circlearray[i] * circlearray[i] * 3.14;
						}
						
						//
						for(int i = 0; i < circlearray.length; i++)
						{
							int max = i;
							double largest = circlearray[i];
							
							for(int j = i+ 1; j < circlearray.length; j++)
							{
								if(circlearray[j] > largest)
								{
									largest = circlearray[j];
									max = j;
								}
							}
							
							if(largest > circlearray[i])
							{
								double temp = circlearray[i];
								
								circlearray[i] = circlearray[max];
									
								circlearray[max] = temp;
							}
						//This prints out the array in largest to smallest
						}
						for(int i = 0; i < circlearray.length; i++)
						{
							System.out.print(circlearray[i]+"  ");
							
						}
						System.out.println();
						check2++;
						break;
						
					case 4:
						//This case statement is used to print out only the unique values
						
						//radius -> area
						for(int i = 0; i < circlearray.length; i++)
						{
							circlearray[i] = circlearray[i] * circlearray[i] * 3.14;
						}
						
						//copying the circle array to array 2 
						for(int i = 0; i < circlearray.length; i++)
						{
							array2[i] = circlearray[i];
						}
						
						//This for loop selects the first position in the original array 
						for(int i = 0; i < circlearray.length; i++)
						{
							//The loop will check all the values in one position for the original array against all values and then every time they are the same it adds one to the check counter and also checks from the next position in the array so that it can at least print 1 of the values if there are multiple of the same vale
							for(int j = b; j < circlearray.length; j++)
							{
								if(circlearray[i] == array2[j])
								{
									check++;
								}
								
								//If the check counter is less than 2 it will print out the number
							}
							if(check < 2)
							{
								System.out.println(circlearray[i]);
							}
							
							// adds one to the b counter and sets checks to zero
							b++;
							check = 0;
						}
						check2++;
						break; 
						
					case 5:
						//Exit case statement
						System.exit(0);
						break;
					default:
						//Allows the user to renter the value if they mess up
						System.out.println("Improper value entered for choice. Please choose again.");
						System.out.println("Would you like the data displayed as  1. Total number of circles and the radius of each circle. 2. The area of each circle from smallest to largest. 3. The circles area from largest to smallest. 4. See all the unique areas of the circles stored. 5. quit the program?");
						choice = key.nextInt();
						
				}
		}while(check2 < 1);
		
	}

}
