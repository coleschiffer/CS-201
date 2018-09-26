import java.util.NoSuchElementException;

/**
 * ArrayQueue
 * HW 08
 * CS 201
 * @author Cole Schiffer, Grant Lee
 */

public class ArrayQueue<E> implements Queue<E> {

	private E[] dataArray;
	private int front;  // index of first item to remove
	private int rear;   // index of next available position
	private int numElements; // for convenience
    private int capacity; // current capacity of array
    
    private static final int DEFAULT_CAPACITY = 1000;

    /**
     * Creates an empty ArrayQueue.
     */
    @SuppressWarnings("unchecked")
	public ArrayQueue() {
        dataArray = (E[]) new Object[DEFAULT_CAPACITY];
        front = 0;
        rear = 0;
        numElements = 0;
        capacity = DEFAULT_CAPACITY;
	}
	
	// YOUR METHODS GO HERE

    /**
     * Removes and returns the element at the front of this queue.
     * @return The element removed from the front of this queue.
     * @throws NoSuchElementException if the queue is empty.
     */
    public E dequeue() {
        if(this.isEmpty()) {
            throw new NoSuchElementException("Please enter some elements!");
        }
        E temp = dataArray[front];
        front = (front + 1) % capacity;
        numElements--;
        return temp;
    }
    
    /**
     * Adds the specified element to the back of this queue.
     * @param element to add on to the rear of this queue.
     */ 
    public void enqueue(E element) { 
        if(numElements == capacity) {
            this.resize();
        }
        dataArray[rear] = element;
        rear = (rear + 1) % capacity;
        numElements++;
    }
    
    /**
     * Returns true if this queue no elements.
     * @return true if this queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        return numElements == 0;
    }
        
    /**
     * Returns, but does not remove, the element at the front of this queue.
     * @return The element at the front of this queue.
     * @throws NoSuchElementException if the queue is empty.
     */
    public E peek() {
        if(this.isEmpty()) {
            throw new NoSuchElementException();
        }
        else {
            return dataArray[0];
        }
    }

    /**
     * Returns the size, in terms of number of items currently 
     * stored, of the Queue.
     * @return The number of elements of this queue 
     */
    public int size() {
        return numElements;
    }

    /**
    * Resizes the array when the number of items is
    * greater than the capacity
    */
    @SuppressWarnings("unchecked")
    private void resize() {
        E[] temp = (E[]) new Object[capacity * 2];
        int start = front;
        for (int i = 0; i < numElements; i++) {
            temp[i] = dataArray[start];
            start = (start + 1) % capacity;
        }
        front = 0;
        rear = numElements;
        capacity = capacity * 2;
        dataArray = temp;
        }


    /**
    * Prints out the Queue as a string in desired format
    * @return The queue as a string
    */    
    public String toString() {
        String frontRear = "front: " + front + " rear: " + rear;
        String frontRearNums = "front [ ";
        int start = front;
        for(int i = front; i < rear; i++)
        {
            frontRearNums = frontRearNums + dataArray[start] + " ";
            start = (start + 1) % capacity;
        }
        frontRearNums = frontRearNums + "] rear";
        return frontRear + "\n" + frontRearNums + "\t (queue with " 
        + numElements + " elements wrapped)";
    }
/*
    testing to string:
    public static void main(String[] args)
    {
        ArrayQueue<Integer> queue = new ArrayQueue<Integer>();
        System.out.println(queue.toString());
        queue.enqueue(1);
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println(queue.toString());
        queue.enqueue(1);
        System.out.println(queue.toString());
    }
*/
}
