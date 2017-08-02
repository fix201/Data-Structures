// This program discribes the process that happens when sti
package dataStructures;

public class DataStructures{
	// Private Variables
	private int[] array = new int[50];
	private int arraySize;

	// Constructor
	DataStructures(int arraySize){
		this.arraySize = arraySize;

		for(int i = 0; i < arraySize; i++){
			array[i] = (int) (Math.random() * 10) + 10; // Random number between 10 and 20
		}
	}

	// Prints out the value of in the arrays nd their index
	public void printValues(){
		System.out.println("---------------");
		for(int i = 0; i < arraySize; i++){
			System.out.print("| " + i + " | ");
			System.out.println(array[i] + " |");
			System.out.println("---------------");
		}
	}

	// Returns the number at the index you want
	public int getNumberAtIndex(int index){
		if(index < arraySize)
			return array[index];
		else
			return 0;
	}

	// Searches the array of random numbers to check if it contains the value
	public boolean searchForValue(int searchValue){
		boolean value = false;

		for(int i = 0; i < arraySize; i++){
			if(searchValue == array[i]){
				return true;
			}
		}
		return value;
	}

	// Deletes an index
	public void deleteIndex(int index){
		if(index < arraySize){
			for(int i = index; i < arraySize - 1; i++){
				array[i] = array[i + 1];
			}
			arraySize--;
		}
	}

	// Inserts a value to the bottom of the array
	public void insertValue(int value){
		if(arraySize < 50){
			array[arraySize] = value;
			arraySize++;
		}
	}

	// Linear Search: Searches the entire array for a value and prints it out if the value is found
	public void linearSearch(int value){
		boolean valueFound = false;

		System.out.println("The value was found in the following: ");

		for(int i = 0; i < arraySize; i++){
			if(value == array[i]){
				System.out.print("| " + i + " | ");
				System.out.println(array[i] + " |");
				System.out.println("---------------");
				valueFound = true;
			}
		}
		if( !valueFound)
			System.out.println("None");
	}

	// Bubble Sort: Sorts from lowest to highest or highest to lowest
	public void bubbleSort(){

		System.out.println("Sorting from Lowest to Highest using Bubble sort");

		for(int i = arraySize - 1; i > 0; i--){
			for(int j = 0; j < i; j++){
				if(array[j] > array[j + 1]){
					swapValues(j, j + 1);
				}
			}
		}
	}

	// Binary Search: This is quicker than linear search because all the values are already sorted.
	public void binarySearch(int value){
		int highIndex = arraySize - 1;
		int lowIndex = 0;
		int middleIndex = (lowIndex + highIndex) / 2;

		while(lowIndex <= highIndex){

			middleIndex = (lowIndex + highIndex) / 2;

			// System.out.println("Middle Index is " + middleIndex);

			if(value > array[middleIndex]){
				lowIndex = middleIndex + 1;
				// System.out.println("Low index increased to " + lowIndex );
			}
			else if(value < array[middleIndex]){
				highIndex = middleIndex - 1;
				// System.out.println("High index decreased to " + highIndex);
			}
			else{
				System.out.println("Found a match for " + value + " at index " + middleIndex);
				lowIndex = highIndex + 1;
			}
		}

		if(value != array[middleIndex])
			System.out.println("No match Found");
	}

	// Selection sort: Sorts an array by repeatedly finding the minimum element from unsorted part and putting it at the beginning.
	public void selectionSort(){
		for(int i = 0; i < arraySize; i++){
			// Minimum
			int min = i;
			for(int j = i; j < arraySize; j++){
				// if minimum is greater than the next, means the next value is the minimum
				if(array[min] > array[j])
					min = j;
			}
			swapValues(i, min);
		}
	}

	// Insertion sort
	public void insertionSort(){
		for(int i = 1; i < arraySize; i++){
			int j = i;
			int insert = array[i];
			// Loop from i = 1 to n-1.
			while((j > 0) && array[j - 1] > insert){
				array[j] = array[j - 1];
				j--;
			}
			array[j] = insert;
		}
	}

	// Swaps the values for the sort algorithm
	public void swapValues(int a, int b){
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	// Main
	public static void main(String[] args){
		DataStructures data = new DataStructures(10);

		data.printValues();
	}

}