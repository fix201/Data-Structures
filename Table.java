package dataStructures;

public class Table{

	private int index;
	private int value;
	private int arraySize;

	public Table(){
		this.index = 0;
		this.value = 0;
	}

	public Table(int index, int value){
		// TODO Auto-generated constructor stub
		this.index = index;
		this.value = value;
	}

	public int getIndex(){
		return index;
	}
	public void setIndex(int index){
		this.index = index;
	}

	public int getValue(){
		return value;
	}
	public void setValue(int value){
		this.value = value;
	}

}
