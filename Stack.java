package dataStructures;

import java.util.Arrays;

// The Stack class simulates the stack Last in first out (LIFO) operations
public class Stack{

	private String[] stackArray;
	private int stackSize;
	private int stackTop = -1;

	// Constructor
	Stack(int stackSize){
		this.stackSize = stackSize;
		stackArray = new String[stackSize];
		Arrays.fill(stackArray, "-1");
	}

	// Prints out the value of in the stack and their index
	public void printStack(){
		System.out.println("----------------------------------------------------------------------");
		for(int i = 0; i < stackSize; i++){
			System.out.print("|  " + i + " ");
		}
		System.out.println("\n----------------------------------------------------------------------");
		for(int i = 0; i < stackSize; i++){
			System.out.print("| " + stackArray[i] + " ");
		}
	}

	// Push operator adds an item to the top of the stack
	public void push(String input){
		// checks if the stack is free to add one more item
		if(stackTop + 1 < stackSize){
			stackTop++;
			stackArray[stackTop] = input;
		}
		else
			System.out.println("Error! Not enough room.");

		System.out.println("Push " + input + " was added to stack");
	}

	// Pushes lots of values at ones using a white space delimeter separating the values
	public void pushMany(String input){
		// Use white spaces to split the values to be pushed
		String[] temp = input.split(" ");
		// Loop through and push
		for(int i = 0; i < temp.length; i++){
			push(temp[i]);
		}
	}

	// Pop operator deletes the last item that was added to the stack
	public String pop(){

		if(stackTop >= 0){
			stackArray[stackTop] = "-1";
			return stackArray[stackTop--];
		}
		else{
			System.out.println("Error! Stack is empty");
			return "-1";
		}

	}

	// Pops all the values in the stack
	public void popAll(){
		for(int i = stackTop; i >= 0; i--){
			pop();
		}
	}

	// Peek operator sees whats on the top of the stack but not remove it
	public String peek(){

		System.out.println("PEEK " + stackArray[stackTop] + "is at the top of the stack");
		return stackArray[stackTop];
	}

	public static void main(String[] args){
		Stack stack = new Stack(10);

		stack.printStack();
	}

}
