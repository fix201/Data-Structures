package dataStructures;

public class BinarySearchTree{
	// A Node must always have a root value
	Node root;

	public void addNode(int key, String name){
		Node newNode = new Node(key, name);

		// If there is no root, the new value entered would be the new node
		if(root == null){
			root = newNode;
		}
		else{
			Node focusNode = root; // because we start with root as we traverse through the tree
			Node parent; // for the future parents of our new nodes

			while(true){
				parent = focusNode;

				// Checks if the new node should go on the left or right side of the parent
				if(key < focusNode.key){
					focusNode = focusNode.leftChild;
					// if the left child has no children, we want to place the new node at the left of it
					if(focusNode == null){
						parent.leftChild = newNode;
						return;
					}
				}
				else{// Put the new node on the right
					focusNode = focusNode.rightChild;
					// if the right child has no children, we want to place the new node at the right of it
					if(focusNode == null){
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}

	public void inOrderTravasal(Node focusNode){

		if(focusNode != null){
			inOrderTravasal(focusNode.leftChild);
			System.out.println(focusNode);
			inOrderTravasal(focusNode.rightChild);
		}

	}

	public void preOrderTravasal(Node focusNode){

		if(focusNode != null){
			System.out.println(focusNode);
			preOrderTravasal(focusNode.leftChild);
			preOrderTravasal(focusNode.rightChild);
		}

	}

	public void postOrderTravasal(Node focusNode){

		if(focusNode != null){
			postOrderTravasal(focusNode.leftChild);
			postOrderTravasal(focusNode.rightChild);
			System.out.println(focusNode);
		}

	}

	public Node findNode(int key){
		Node focusNode = root;

		// Loop through until the noded is found
		while(focusNode.key != key){
			// Whether to move left or right in the tree
			if(key < focusNode.key)
				focusNode = focusNode.leftChild;
			else
				focusNode = focusNode.rightChild;
			// If the node is not found
			if(focusNode == null)
				return null;
		}

		return focusNode;
	}

	public Node numLessThan(int value){

		// Start at the top of the tree to find value
		Node focusNode = root;
		BinarySearchTree tree = new BinarySearchTree();
		// Loop through until the noded is found
		while(focusNode.key != value){
			// Whether to move left or right in the tree
			if(value < focusNode.key){
				focusNode = focusNode.leftChild;
			}
			else{
				focusNode = focusNode.rightChild;
			}
			// If the node is not found
			if(focusNode == null)
				return null;
		}

		return focusNode;
	}

	public boolean removeNode(int key){
		Node focusNode = root;
		Node parent = root;

		boolean isLeft = true;

		// Ssearching through a loop for the value to delete
		while(focusNode.key != key){
			// Starting from the top of the node
			parent = focusNode;

			// If the focus node is right or left child
			if(key < focusNode.key){
				isLeft = true;
				focusNode = focusNode.leftChild;
			}
			else{
				isLeft = false;
				focusNode = focusNode.rightChild;
			}

			// If the value wansnt found
			if(focusNode == null)
				return false;
		}

		// Now we remove
		// If the node doesn't have children at all
		if(focusNode.leftChild == null && focusNode.rightChild == null){
			// And if the focus node is the root node, delete the root node by setting it to null
			if(focusNode == root)
				root = null;
			// Else if it is a left child
			else if(isLeft)
				parent.leftChild = null;
			// Else we know it is a right child and then delete it
			else
				parent.rightChild = null;
		}
		// If there is no right child, setting them in essense so that the nodes dissapear in form of replacing them
		else if(focusNode.rightChild == null){
			if(focusNode == root)
				root = focusNode.leftChild;
			else if(isLeft)
				parent.leftChild = focusNode.leftChild;
			else
				parent.rightChild = focusNode.leftChild;
		}
		// If there is no left child
		else if(focusNode.leftChild == null){
			if(focusNode == root)
				root = focusNode.rightChild;
			else if(isLeft)
				parent.rightChild = focusNode.rightChild;
			else
				parent.rightChild = focusNode.leftChild;
		}
		else{
			Node replacement = getReplacement(focusNode);
			if(focusNode == root)
				root = replacement;
			else if(isLeft)
				parent.leftChild = replacement;
			else
				parent.rightChild = replacement;

			replacement.leftChild = focusNode.leftChild;
		}

		return true;
	}

	// To get the node replacement and return the node
	public Node getReplacement(Node replaceNode){
		Node replacementParent = replaceNode;
		Node replacement = replaceNode;

		Node focusNode = replaceNode.rightChild;

		// Moving the values up after replacement
		while(focusNode != null){
			replacementParent = replacement;
			replacement = focusNode;
			focusNode = focusNode.leftChild;
		}

		if(replacement != replaceNode.rightChild){
			replacementParent.leftChild = replacement.rightChild;
			replacement.rightChild = replaceNode.rightChild;
		}

		return replacement;
	}

	public static void main(String[] args){
		BinarySearchTree tree = new BinarySearchTree();

		tree.addNode(50, "Boss");
		tree.addNode(25, "pussy");
		tree.addNode(30, "Bitch");
		tree.addNode(70, "Baka");
		tree.addNode(100, "Undead");

		// tree.inOrderTravasal(tree.root);

		int l = 100;

		System.out.println("Search for " + l);
		System.out.println(tree.findNode(l));
	}
}

// A Node class that represents the two nodes of a BST
class Node{

	int key;
	String name;

	// A BST Node can only have two children
	Node leftChild;
	Node rightChild;

	// Constructor
	Node(int key, String name){
		this.key = key;
		this.name = name;
	}

	@Override
	public String toString(){
		return name + " has a key " + key;
	}
}
