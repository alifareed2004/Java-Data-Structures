//Student Name: Ali Fareed
//Student Number: 219475367

package DataStructures;

public class LinkedListNode {
	
	// Initialize the variables
	public int data;
	public LinkedListNode next;
	
	// Constructor
	public LinkedListNode(int data) {
		this.data = data;
	}
	
	// Insertion method
	public void insertAfter(LinkedListNode newNode) {
		LinkedListNode current = this;
		
		// Check if next node is null, and keep advancing if it is
		while (current.next != null) {
			current = current.next;
		}
		
		// Once the last node has been reached, add the new node
		newNode.next = current.next;
		current.next = newNode;
	}
	
	// Deletion method
	public void deleteNode(int key) {
		LinkedListNode current = this;
		LinkedListNode prev = null;
		
		// Check if Linked List only has one value
		if (current != null && current.next == null) {
			System.out.println("Your Linked List only has one value, and so it cannot be removed.");
			return;
		}
		
		// Check if the head node is the one to be deleted
		if (current != null && current.data == key) {
			this.data = current.next.data;
			this.next = current.next.next;
			return;
		}
		
		// Search for the node that needs to be deleted
		while (current != null && current.data != key) {
			prev = current;
			current = current.next;
		}
		
		// If node was not found, end the method
		if (current == null) return;
		
		// Unlink the node that needs to be deleted
		prev.next = current.next;
	}
	
	// Display Linked List method
	public void displayLinkedList(LinkedListNode head) {
		LinkedListNode current = head;
		
		// Cycle through the Linked List while printing every single node
		while (current != null) {
			System.out.print(current.data + " -> ");
			current = current.next;
		}
		
		System.out.print("null\n");
	}

} // end of class
