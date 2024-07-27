//Student Name: Ali Fareed
//Student Number: 219475367

package DataStructures;

public class Stack {
	
	// Initialize the variables
	private LinkedListNode bottom;
	public int data;
	
	// Constructor
	public Stack() {
		
	}
	
	// Push method
	public void push(int data) {
		// Create a new Linked List node
		LinkedListNode newNode = new LinkedListNode(data);
		
		// If the bottom of the stack is empty, set it to the newly created node
		if (bottom == null) {
			bottom = newNode;
		} else {  // If the bottom is not empty, advance through the stack and place the node on top
			bottom.insertAfter(newNode);
		}
	}
	
	// Pop method
	public void pop() {
		LinkedListNode current = bottom;
		
		// Check if the bottom of the stack is empty
		if (bottom == null) {
			System.out.println("Your stack is currently empty.");
			return;
		} 
		
		// Store the element that will be popped in a variable
		int poppedElement = showTop();
		
		// If the stack only has one element, pop the bottom
		if (bottom.next == null) {
			bottom = null;
		} else {
			while (current.next != null) {  // Cycle through the stack until the last element is reached
				current = current.next;
			}
			bottom.deleteNode(current.data);  // Pop the last element
		}
		
		// Print the popped element using the variable created earlier
		System.out.println("\nPopped element: " + poppedElement);
	}
	
	// Top method
	public int showTop() {
		LinkedListNode current = bottom;
		
		// If the stack is empty, return 0
		if (current == null) {
			return -1;
		}
		
		// Cycle through the stack until the last element is reached
		while (current.next != null) {
			current = current.next;
		}
		
		// Return the last/top element
		return current.data;
	}
	
} // end of class
