package dataStructures;

public class LinkedList{

	public String name;
	public int number;

	public LinkedList next;

	// COnstructor
	public LinkedList(String name, int number){
		this.name = name;
		this.number = number;
	}

	public static void main(String[] args){
		// TODO Auto-generated method stub

	}

}

class LinkList{
	public LinkedList firstLink;

	public LinkList(){
		// First value in a linked list always gets a value of null
		firstLink = null;
	}

	// Checks if the linked list is empty
	public boolean isEmpty(){
		return(firstLink == null);
	}

	// Insert the first link
	public void insertFirstLink(String name, int number){
		LinkedList newLink = new LinkedList(name, number);

		// Next would now be equal to the previous
		newLink.next = firstLink;

		firstLink = newLink;
	}

}
