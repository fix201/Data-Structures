package dataStructures;

// Recursion is a function that calls itself
public class Recursion{

	// Calculating Factorial with recursion: Factorial of 4 = 4 * 3 * 2 * 1
	public int factorial(int number){
		// Base case so the number decrements and when it reaches 1 it stops
		if(number == 1)
			return 1;
		else{
			// number * (number - 1) // More like 4 * (4 - 1) which is 4 * 3, it returns it, next is 3 * 2...
			int result = number * factorial(number - 1);
			return result;
		}
	}

	// Converting from decimal to binary using recursion
	public int convertToBinary(int decimal){
		if(decimal == 0)
			return 0;
		else{
			int remainder = (decimal % 2 + 10 * convertToBinary(decimal / 2));
			return remainder;
		}
	}

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Recursion recursion = new Recursion();

		System.out.println(recursion.factorial(10));
	}
}
