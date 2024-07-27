//Student Name: Ali Fareed
//Student Number: 219475367

package DataStructures;

public class BinarySearchTree {
	
	// Node class to use in BST
	public class Node {
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	} // end of Node class
	
	// Initialize the variables
	Node root;
	
	// Constructor
	public BinarySearchTree() {
		root = null;
	}
	
	// Insert method that is publicly used
	public void insert(int data) {
		root = insertRecursion(root, data);
	}
	
	// Recursive method that inserts the data
	private Node insertRecursion(Node root, int data) {
		// If the root is empty, insert the data into the root
		if (root == null) {
			root = new Node(data);
			return root;
		}
		
		// Check if the data is smaller than the current node
		if (data < root.data) { 
			root.left = insertRecursion(root.left, data);  // Recursively move the data down the left node
		} else if (data > root.data) {  // Check if the data is bigger than the current node
			root.right = insertRecursion(root.right, data);  // Recursively move the data down the right node
		}
		
		return root;
	}
	
	// Delete method that is publicly used
	public void delete(int data) {
		root = deleteRecursion(root, data);
	}
	
	// Recursive method that deletes the data
	private Node deleteRecursion(Node root, int data) {
		// If the root is null then return nothing
		if (root == null) return root;
		
		// Recursively move down the tree
		// If data is smaller than the current node, move down the left nodes
		if (data < root.data) {
			root.left = deleteRecursion(root.left, data);
		} else if (data > root.data) {  // If data is bigger than the current node, move down the right nodes
			root.right = deleteRecursion(root.right, data);
		} else {
			// Nodes with one or no child
			if (root.left == null) return root.right;
			if (root.right == null) return root.left;
			
			// Gets inorder successor for Nodes with two children
			root.data = minValue(root.right);
			
			// Delete inorder successor
			root.right = deleteRecursion(root.right, root.data);
		}
		
		return root;
	}
	
	// Method to get minimum value
	private int minValue(Node root) {
		// Set the minimum value to the root
		int min = root.data;
		
		// While the left child of the parent is not null, move down the left nodes
		while (root.left != null) {
			min = root.left.data;
			root = root.left;
		}
		
		// Return the minimum
		return min;
	}
	
	// Find method that is publicly used
	public void find(int data) {
		Node result = findRecursion(root, data);
		
		// Print whether or not the Node is found
		if (result != null) System.out.println("\nNode found in BST.");
		else System.out.println("\nNode not found in BST.");
	}
	
	// Recursive method that finds that data
	private Node findRecursion(Node root, int data) {
		// If a null Node is reached or the data being searched for is found, return the current Node
		if (root == null || root.data == data) return root;
		
		// If the data being searched for is bigger than the current Node, move down the left Nodes
		if (root.data > data) return findRecursion(root.left, data);
		
		// Move down the right Nodes
		return findRecursion(root.right, data);
	}
	
	// In-order method that is publicly used
	public void inOrder() {
		inOrderRecursion(root);
	}
	
	// Recursive method that does in-order traversal of the BST
	private void inOrderRecursion(Node root) {
		// If the current Node is not null, recursively travel through and print the whole tree in-order
		if (root != null) {
			inOrderRecursion(root.left);
			System.out.print(root.data + " ");
			inOrderRecursion(root.right);
		}
	}

} // end of class
