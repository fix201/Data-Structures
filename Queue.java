package dataStructures;

import java.util.Arrays;

// The Queue class simulates a queue that allows the user to access First in First out (FIFO) operations
public class Queue{
	private String[] queueArray;
	private int queueSize;
	private int front, rear, numberOfItems = 0;

	// Constructor
	Queue(int queueSize){
		this.queueSize = queueSize;
		queueArray = new String[queueSize];
		Arrays.fill(queueArray, "-1");
	}

	// Prints out the value of in the queue and their index
	public void printQueue(){
		System.out.println("----------------------------------------------------------------------");
		for(int i = 0; i < queueSize; i++){
			System.out.print("|  " + i + " ");
		}
		System.out.println("\n----------------------------------------------------------------------");
		for(int i = 0; i < queueSize; i++){
			System.out.print("| " + queueArray[i] + " ");
		}
	}

	// Insert: Adds a new to the queue
	public void insert(String input){
		// If there is space in the queue, insert
		if(numberOfItems + 1 <= queueSize){
			queueArray[rear] = input;
			rear++;
			numberOfItems++;
			System.out.println("\nInsert " + input);
		}
		else
			System.out.println("\nError! Queue is full");
	}

	// Insert more than one value at a time using a whitespace as a delimeter
	public void insertMany(String input){
		// Use white spaces to split the values to be inserted
		String[] temp = input.split(" ");
		// Loop through and insert
		for(int i = 0; i < temp.length; i++){
			insert(temp[i]);
		}
	}

	// Inserts item in order from high to low as they are inputted
	public void insertInOrder(String input){
		int i;

		// if there are no elements in the queue inserts like normal, else inserts in order
		if(numberOfItems == 0){
			insert(input);
		}
		else{
			for(i = numberOfItems - 1; i >= 0; i--){
				// if new input is greater than input than previous input
				if(Integer.parseInt(input) > Integer.parseInt(queueArray[i])){
					queueArray[i + 1] = queueArray[i];
				}
				else
					break;
			}

			queueArray[i + 1] = input;
			rear++;
			numberOfItems++;
		}
	}

	// Remove: deletes the first item to enter the queue
	public void remove(){
		if(numberOfItems > 0){
			System.out.println("\nRemove " + queueArray[front]);
			queueArray[front] = "-1";
			front++;
			numberOfItems++;
		}
		else
			System.out.println("\nError! No item to remove");
	}

	// Displays the element at the front of the array
	public void peek(){
		System.out.println("\nThe First Element is " + queueArray[front]);
	}

	public static void main(String[] args){
		Queue queue = new Queue(5);

		queue.printQueue();
	}

}
