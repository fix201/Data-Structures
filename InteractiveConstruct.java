package dataStructures;

import java.util.Scanner;

public class InteractiveConstruct{

	public static void main(String[] args){
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);

		System.out.print("Enter Array Size: ");
		int arrSize = in.nextInt();

		DataStructures data = new DataStructures(arrSize);
		data.printValues();

		System.out.println("1. Basic Data Structures");
		System.out.println("2. Stack");
		System.out.println("3. Queue");

		System.out.print("Choose: ");
		int option = in.nextInt();

		switch(option){
			case 1:
				System.out.println("What process do you want to go through?");

				System.out.println("1. Get number at Index");
				System.out.println("2. Delete Index");
				System.out.println("3. Insert");
				System.out.println("4. Search");
				System.out.println("5. Sort");

				System.out.print("Choose: ");
				int choice = in.nextInt();

				switch(choice){
					// Cases
					case 1:
						System.out.print("Enter Index: ");
						int index = in.nextInt();
						if(data.getNumberAtIndex(index) != -1)
							System.out.println("Number at index is: " + data.getNumberAtIndex(index));
						else{
							System.out.println("There is no number at that index");
						}
						break;

					case 2:
						System.out.print("Enter Index to delete: ");
						int index1 = in.nextInt();
						data.deleteIndex(index1);
						data.printValues();
						System.out.println("Index " + index1 + " was deleted");
						break;

					case 3:
						System.out.print("Enter Value to insert: ");
						int value = in.nextInt();
						data.insertValue(value);
						data.printValues();
						System.out.println(value + " has been inserted");

					case 4:
						System.out.print("Enter search value: ");
						int search = in.nextInt();
						if(data.searchForValue(search))
							System.out.println(search + " is located at index ");
						else{
							System.out.println(search + " was not found");
						}
						break;

					case 5:
						System.out.println("\nValues before sort:");
						data.printValues();
						System.out.println("Values after sort:");
						data.insertionSort();
						data.printValues();
						break;

					default:
						break;
				}

			case 2:
				break;

			default:
				System.out.println("Choose a valid number!");
				break;
		}

	}

}
