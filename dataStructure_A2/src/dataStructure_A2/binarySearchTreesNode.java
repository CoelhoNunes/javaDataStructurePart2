/******************************************************************************************* 
Purpose/Description: Operations on binary search tress where keys are integers, while having
provided code to start the implementation of the operations that define the classes. (Creating
the getters and setter in this java class.)

Author’s Panther ID: 6194506

Certification:
I hereby certify that this work is my own and none of it is the work of any other person.
*******************************************************************************************/
package dataStructure_A2;

public class binarySearchTreesNode {
	
	// Code that was provided to declare the instance variables
	public int key;
	public binarySearchTreesNode left;
	public binarySearchTreesNode right;
	
	public binarySearchTreesNode (int key) {
		this.left = null;
		this.right = null;
		this.key = key;
	}
	
	// Initializing the setters and getters of the instance variables
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public binarySearchTreesNode getLeft() {
		return left;
	}
	public void setLeft (binarySearchTreesNode left) {
		this.left = left;
	}
	public binarySearchTreesNode getRight() {
		return right;
	}
	public void setRight (binarySearchTreesNode right) {
		this.right = right;
	}

}

