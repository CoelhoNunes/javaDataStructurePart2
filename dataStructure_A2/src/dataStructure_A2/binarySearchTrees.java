/******************************************************************************************* 
Purpose/Description: Operations on binary search tress where keys are integers, while having
provided code to start the implementation of the operations that define the classes. 

Author’s Panther ID: 6194506

Certification:
I hereby certify that this work is my own and none of it is the work of any other person.
*******************************************************************************************/

package dataStructure_A2;

import java.util.ArrayList;
import java.util.List;

public class binarySearchTrees {
	
	// Declaring the instance variables and defined the class
	private binarySearchTreesNode root;
	
	public void insert(int key) {
		root = insertHelper(root, key);
	}
	
	// Creating the definition of insertHelper()
	private binarySearchTreesNode insertHelper(binarySearchTreesNode node, int key) {
		
		int value = 0;
		
		// Loop when the value varies that is inserted (greater-than, less-than, etc) 
		if(node == null)
			return new binarySearchTreesNode(key);
		
		if(key > node.key)
			value =+ 1;
		
		else
			if(key < node.key)
				value =-1;
		
			else
				value = 0;
		if(value < 0)
			node.left = insertHelper(node.left, key);
		else if(value > 0)
			node.right = insertHelper(node.right, key);
		
		else
			node.key = key;
		return node;
	}
	
	//Definition of the deleterMin() that deletes the minimum values
	private binarySearchTreesNode deleteMin(binarySearchTreesNode node) {
		
		if(node.left == null)
			return node.right;
		node.left = deleteMin(node.left);
		return node;
	}
	
	//Find() is created that returns a boolean value
	public boolean find(int key) {
		return findHelper(root, key);
	}
	
	//Definition of the findHelper() that searches for the elements
	public boolean findHelper(binarySearchTreesNode node, int key) {
		
		while(node != null) {
			if(key == node.key)
				return true;
			else if(key < node.key)
				node = node.left;
			
			else
				node = node.right;
		}
		return false;
	}
	
	// A method is created to add the sum of all the keys in the tree
	public int keySum() {
		List <Integer> keyList = new ArrayList<>();
		int sum = 0;
		
		keySumHelper(root, keyList);
		for(int x : keyList) {
			sum += x;
		}
		return sum;
	}
	
	//Definition of the helper method keySumHelper() that takes the BST nodes values
	public void keySumHelper(binarySearchTreesNode node, List <Integer> keyList) {
		
		if(node != null) {
			
			//Recursively with left/right of the tree & adding to the node (key)
			keySumHelper(node.left, keyList);
			keySumHelper(node.right, keyList);
			keyList.add(node.key);
		}
	}
	
	// Creating the method to print the binary tree & the helper method to print
	public void printTree() {
		printTreeHelper(root);
		System.out.println("");
	}
	
	//Definition of the method for printTreeHelper() & increasing order print out
	private void printTreeHelper(binarySearchTreesNode node) {
		
		if(node.left != null) {
			printTreeHelper(node.left);
		}
		
		System.out.print(node.key + " ");
		
		if(node.right != null) {
			printTreeHelper(node.right);
		}
	}
	
	// Printing out the nodes of the tree according to a "postover" traversal
	public void printPostOrder() {
		postOrderHelper(root);
		System.out.println("");
	}
	
	//Definition of postOrderHelper() which print the elements in post-order
	private void postOrderHelper(binarySearchTreesNode node) {
		if(node.left != null) {
			postOrderHelper(node.left);
		}
		
		if(node.right != null) {
			postOrderHelper(node.right);
		}
		
		System.out.print(node.key + " ");
	}
	
	//The main method
	public static void main(String[] args) {
		
		binarySearchTrees BST = new binarySearchTrees();
		
		// Initializing BST (binary tree elements)
		BST.insert(4);
		BST.insert(2);
		BST.insert(5);
		BST.insert(1);
		BST.insert(3);
		
		// Program printouts 
		System.out.println("The sum of the elements of the tree: " + BST.keySum());
		System.out.println("\nThe elements of the tree in increasing order: ");
		BST.printTree();
		
		System.out.println("\nThe elements of the tree in PostOrder: ");
		BST.printPostOrder();
		
		System.out.println("\nDeletes the minimum element of the tree");
		BST.deleteMin(BST.root);
		
		System.out.println("The elements of the tree in increasing order:");
		BST.printTree();
		
		System.out.println("\nElement 10 in the tree: " + BST.find(10));
		System.out.println("\nInsert the element 10 in the tree ");
		BST.insert(10);
		
		System.out.println("The element 10 in the tree (find): " + BST.find(10));
	}
}

/******************* Program output ****************
 * -------------------------------------------------
	The sum of the elements of the tree: 15

	The elements of the tree in increasing order: 
	1 2 3 4 5 
	
	The elements of the tree in PostOrder: 
	1 3 2 5 4 
	
	Deletes the minimum element of the tree
	The elements of the tree in increasing order:
	2 3 4 5 
	
	Element 10 in the tree: false
	
	Insert the element 10 in the tree 
	The element 10 in the tree (find): true
 * -------------------------------------------------
*/