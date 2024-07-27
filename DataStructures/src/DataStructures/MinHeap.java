//Student Name: Ali Fareed
//Student Number: 219475367

package DataStructures;

public class MinHeap {
	
	// Initialize the variables
	public int[] heap;
	public int size;
	public int capacity;
	
	// Constructor
	public MinHeap(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		this.heap = new int[capacity];
	}
	
	// Methods that calculate the parent, right child, and left child indices
	private int parentIndex(int i) {
		return (i - 1) / 2;
	}
	
	private int rightChildIndex(int i) {
		return (2 * i) + 2;
	}
	
	private int leftChildIndex(int i) {
		return (2 * i) + 1;
	}
	
	// Swap method
	private void swap(int i, int j) {
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}
	
	// Insert method
	public void insert(int data) {
		// Checks if Min Heap is full before adding data
		if (size == capacity) {
			System.out.println("\nThe Min Heap is now full. Unable to add more data.");
			return;
		}
		
		// Adds the data and increases the size variable
		// The heapifyUp method is used to make sure the newly added data is placed correctly
		heap[size] = data;
		size++;
		heapifyUp();
	}
	
	// Extract minimum method
	public int extractMin() {
		// Checks if the Min Heap is empty
		if (size == 0) {
			System.out.println("\nYour Min Heap is currently empty.");
			return 0;
		}
		
		// The root value is replaced with the last element, removing it from the tree
		// The heapifyDown method is used to make sure every element is placed correctly
		int min = heap[0];
		heap[0] = heap[size - 1];
		size--;
		heapifyDown();
		System.out.println("\nMinimum element extracted: " + min);
		return min;
	}
	
	// Heapify Up method
	private void heapifyUp() {
		int index = size - 1;
		
		// The newly added element is compared to its parent and swapped if it is smaller
		// This process is repeated until the newly added element is in its right place
		while (index > 0 && heap[parentIndex(index)] > heap[index]) {
			swap(parentIndex(index), index);
			index = parentIndex(index);
		}
	}
	
	// Heapify Down method
	private void heapifyDown() {
		int index = 0;
		
		while (leftChildIndex(index) < size) {
			int smallerChildIndex = leftChildIndex(index);
			if (rightChildIndex(index) < size && heap[rightChildIndex(index)] < heap[smallerChildIndex]) {
				smallerChildIndex = rightChildIndex(index);
			}
			
			if (heap[index] < heap[smallerChildIndex]) {
				break;
			} else {
				swap(index, smallerChildIndex);
			}
			index = smallerChildIndex;
		}
	}

} // end of class
