//Student Name: Ali Fareed
//Student Number: 219475367

package DataStructures;

public class Queue {
	
	// Initialize the variables
	private LinkedListNode front;
	private LinkedListNode back;
	public int data;
	
	// Constructor
	public Queue() {
		
	}
	
	// Enqueue method
	public void enqueue(int data) {
		LinkedListNode newNode = new LinkedListNode(data);
		
		// If the front of the queue is empty, set it to the new node
		if (front == null) {
			front = newNode;
		}
		
		// If the back of the queue is not empty, place the new node behind the back of the queue
		if (back != null) {
			back.next = newNode;
		}
		
		// Set the back of the queue to be the newly entered node
		back = newNode;
	}
	
	// Dequeue method
	public int dequeue() {
		int toReturn = 0;
		
		// If the front of the queue is not empty, set the next node to be the front
		if (front != null) {
			toReturn = front.data;
			front = front.next;
		}
		
		// If the front is empty, then set the back to be empty as well
		if (front == null) {
			back = null;
			return -1;
		}
		
		// Return the node that was dequeued, or return 0 if the queue was already empty
		return toReturn;
	}

} // end of class


