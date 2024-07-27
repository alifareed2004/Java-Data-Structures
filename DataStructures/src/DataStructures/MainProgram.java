//Student Name: Ali Fareed
//Student Number: 219475367

package DataStructures;

import java.util.Scanner;

public class MainProgram {

	public static void main(String[] args) {
		
		// Initialize the variables
		Scanner scan = new Scanner(System.in);
		int user_data_structure = 0;
		int user_options = 0;
		int key = 0;
		
		// Ask user to select data structure
		System.out.println("Please select the data structure you wish to work with:"
				+ "\nEnter 1 for Linked List"
				+ "\nEnter 2 for Stack"
				+ "\nEnter 3 for Queue"
				+ "\nEnter 4 for Min Heap"
				+ "\nEnter 5 for Binary Search Tree (BST)");
		
		System.out.print("\nEnter your choice: ");
		
		// Ask user to enter a valid number if their entry is outside the given range
		// The try catch statement prevents the program from crashing if the user enters a string
		while (user_data_structure < 1 || user_data_structure > 5) {
            try {
            	user_data_structure = Integer.parseInt(scan.next());
                if (user_data_structure < 1 || user_data_structure > 5) System.out.println("Please enter a number between 1 and 5:");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 5:");
            }
        }
		
		// Select the data structure
		switch (user_data_structure) {
		
		// Linked List
		case 1:
			// Create the Linked List
			System.out.println("\nYou've selected Linked List.");
			LinkedListNode head = null;
			
			// Allow user to interact with the Linked List
			while (user_options != 4) {
				
				// Display the options available to the user
				System.out.println("\nWhat do you wish to do with the Linked List?"
						+ "\n1. Add Data"
						+ "\n2. Remove Data"
						+ "\n3. Display the Linked List"
						+ "\n4. Exit Program");
				
				// Allow user to choose their option
				System.out.print("\nEnter your choice: ");
				user_options = scan.nextInt();
				
				// Loop if user enters an incorrect number
				while (user_options < 1 || user_options > 4) {
					System.out.print("Enter a number between 1 and 4: ");
					user_options = scan.nextInt();
				}
				
				// Perform the option selected
				switch (user_options) {
				
				// Add data
				case 1:
					while (key != -1) {
						System.out.print("\nEnter the data to add to the Linked List (-1 to end): ");
						key = scan.nextInt();
						
						if (head == null && key != -1) {
							head = new LinkedListNode(key);
						} else if (key != -1) {
							head.insertAfter(new LinkedListNode(key));
						}
					}
					
					// Reset key to allow user to add again later
					key = 0;
					break; // End of Add case
					
				// Delete data
				case 2:
					while (key != -1) {
						System.out.print("\nEnter the data to delete from the Linked List (-1 to end): ");
						key = scan.nextInt();
						
						if (head != null && key != -1) {
							head.deleteNode(key);
						}
					}
					
					// Reset key to allow user to delete again later
					key = 0;
					break; // End of Delete case
					
				// Display Linked List
				case 3:
					if (head == null) {
						System.out.println("You have not created a Linked List yet.");
					} else {
						head.displayLinkedList(head);
					}
					break; // End of Display Linked List case
					
				} // End of user_options switch statement
				
			} // End of user_options while loop
			
			break; // End of Linked List
			
		// Stack
		case 2:
			// Create the Stack
			System.out.println("\nYou've selected Stack.");
			Stack stack = new Stack();
			
			// Allow user to interact with the Stack
			while (user_options != 4) {
				
				// Display the options available to the user
				System.out.println("\nWhat do you wish to do with the Stack?"
						+ "\n1. Push Element"
						+ "\n2. Pop Element"
						+ "\n3. Top Element"
						+ "\n4. Exit Program");
				
				// Allow user to choose their option
				System.out.print("\nEnter your choice: ");
				user_options = scan.nextInt();
				
				// Loop if user enters an incorrect number
				while (user_options < 1 || user_options > 4) {
					System.out.print("Enter a number between 1 and 4: ");
					user_options = scan.nextInt();
				}
				
				// Perform the option selected
				switch (user_options) {
				
				// Push Element
				case 1:
					while (key != -1) {
						System.out.print("\nEnter the data to push onto the Stack (-1 to end): ");
						key = scan.nextInt();
						
						if (key != -1) {
							stack.push(key);
						}
					}
					
					// Reset key to allow user to pop again later
					key = 0;
					break; // End of Push case
					
				// Pop Element
				case 2:
					stack.pop();
					break; // End of Pop case
					
				// Top Element
				case 3:
					int printResult = stack.showTop();
					if (printResult == -1) {
						System.out.println("\nThe stack is empty.");
					} else {
						System.out.println("\nTop element: " + stack.showTop());
					}
					break; // End of Top case
					
				} // End of user_options switch statement
				
			} // End of user_options while loop
			
			break; // End of Stack
			
		// Queue
		case 3:
			// Create the Queue
			System.out.println("\nYou've selected Queue.");
			Queue queue = new Queue();
			
			// Allow user to interact with the Queue
			while (user_options != 3) {
				
				// Display the options available to the user
				System.out.println("\nWhat do you wish to do with the Queue?"
						+ "\n1. Enqueue"
						+ "\n2. Dequeue"
						+ "\n3. Exit");
				
				// Allow user to choose their option
				System.out.print("\nEnter your choice: ");
				user_options = scan.nextInt();
				
				// Loop if user enters an incorrect number
				while (user_options < 1 || user_options > 3) {
					System.out.print("Enter a number between 1 and 3: ");
					user_options = scan.nextInt();
				}
				
				// Perform the option selected
				switch (user_options) {
				
				// Enqueue
				case 1:
					while (key != -1) {
						System.out.print("\nEnter the data to enqueue (-1 to end): ");
						key = scan.nextInt();
						
						if (key != -1) {
							queue.enqueue(key);
						}
					}
					
					// Reset key to allow user to enqueue again later
					key = 0;
					break; // End of Enqueue case
					
				// Dequeue
				case 2:
					if (queue == null) {
						System.out.print("\nYou do not have a Queue yet.");
					} else {
						System.out.println("\nDequeued element: " + queue.dequeue());
					}
					
					int queueResult = queue.dequeue();
					if (queueResult == -1) {
						System.out.println("\nThe queue is empty.");
					}
					break; // End of Dequeue case
					
				} // End of user_options switch statement
				
			} // End of user_options while loop
			
			break; // End of Queue
			
		// Min Heap
		case 4:
			// Create the Min Heap with the capacity of 10 nodes
			System.out.println("\nYou've selected Min Heap.");
			MinHeap minHeap = new MinHeap(5);
			
			// Allow user to interact with the Min Heap
			while (user_options != 3) {
				
				// Display the options available to the user
				System.out.println("\nWhat do you wish to do with the Min Heap?"
						+ "\n1. Insert"
						+ "\n2. Extract Minimum"
						+ "\n3. Exit");
				
				// Allow user to choose their option
				System.out.print("\nEnter your choice: ");
				user_options = scan.nextInt();
				
				// Loop if user enters an incorrect number
				while (user_options < 1 || user_options > 3) {
					System.out.print("Enter a number between 1 and 3: ");
					user_options = scan.nextInt();
				}
				
				// Perform the option selected
				switch (user_options) {
				
				// Insert data
				case 1:
					while (key != -1) {
						System.out.print("\nEnter the data to insert into the Min Heap (-1 to end): ");
						key = scan.nextInt();
						
						if (key != -1) {
							minHeap.insert(key);
						}
					}
					
					// Reset key to allow user to insert again later
					key = 0;
					break; // End of Insert case
					
				// Extract Minimum
				case 2:
					minHeap.extractMin();
					break; // End of Extract Minimum case
				
				} // End of user_options switch statement
				
			} // End of user_options while loop
			
			break; // End of Min Heap
			
		// Binary Search Tree
		case 5:
			// Create the Binary Search Tree
			System.out.println("\nYou've selected Binary Search Tree (BST).");
			BinarySearchTree bst = new BinarySearchTree();
			
			// Allow user to interact with the Binary Search Tree
			while (user_options != 5) {
				
				// Display the options available to the user
				System.out.println("\nWhat do you wish to do with the BST?"
						+ "\n1. Insert Node"
						+ "\n2. Delete Node"
						+ "\n3. Find Node"
						+ "\n4. Inorder Traversal"
						+ "\n5. Exit");
				
				// Allow user to choose their option
				System.out.print("\nEnter your choice: ");
				user_options = scan.nextInt();
				
				// Loop if user enters an incorrect number
				while (user_options < 1 || user_options > 5) {
					System.out.print("Enter a number between 1 and 5: ");
					user_options = scan.nextInt();
				}
				
				// Perform the option selected
				switch (user_options) {
				
				// Insert Node
				case 1:
					while (key != -1) {
						System.out.print("\nEnter the data to insert into the BST (-1 to end): ");
						key = scan.nextInt();
						
						if (key != -1) {
							bst.insert(key);
						}
					}
					
					// Reset key to allow user to insert again later
					key = 0;
					break; // End of Insert Node case
					
				// Delete Node
				case 2:
					while (key != -1) {
						System.out.print("\nEnter the data to delete from the BST (-1 to end): ");
						key = scan.nextInt();
						
						if (key != -1) {
							bst.delete(key);
						}
					}
					
					// Reset key to allow user to insert again later
					key = 0;
					break; // End of Delete Node case
					
				// Find Node
				case 3:
					System.out.println("\nEnter the data to find in the BST: ");
					key = scan.nextInt();
					
					bst.find(key);
					
					key = 0;
					break; // End of Find Node case
					
				// In-order Traversal
				case 4:
					bst.inOrder();
					break; // End of In-order Traversal case
				
				} // End of user_options switch statement
				
			} // End of user_options while loop
			
			break; // End of Binary Search Tree
		}
		
		// End program message
		System.out.println("\nProgram Ended.");
		
	} // end of main

} // end of class
