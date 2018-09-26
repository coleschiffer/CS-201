import java.util.NoSuchElementException;
/**
 * LLStack
 * HW 08
 * CS 201
 * @author Cole Schiffer, Grant Lee
 */
public class LLStack<E> implements Stack<E> {
    
    //Instance Variables
    private Node<E> head;
    private int numItems;
    
    private class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E item) {
            data = item;
            next = null;
        }
    }//End Node Class
    
    //CONSTRUCTOR AND METHODS GO HERE
    
    /**
    * Creates an empty LLStack object
    */
    public LLStack() {
        head = null;
        numItems = 0;
    }

     /**
     * Returns true if this stack has no elements
     * @return true if this stack is empty, false otherwise
     */
    public boolean isEmpty()
    {
            return head == null;
    }

    /**
     * Returns, but does not remove, the top element of this stack.
     * @return The top element of the stack
     * @throws NoSuchElementException if this stack is empty
     */
    public E peek()
    {
        if(this.isEmpty()) {
            throw new NoSuchElementException("Please enter some elements!");
        }
        return head.data;
    }

    /**
     * Returns and removes the top element from this stack.
     * @return The top element of this stack
     * @throws NoSuchElementException if this stack is empty
     */
    public E pop()
    {
        Node<E> temp = null;
        if(this.isEmpty()) {
            throw new NoSuchElementException("Please enter some elements!");
        }
        if(head.next == null) 
        {
            temp = head;
            head = null;
        }
        else
        {
            temp = head;
            head = head.next;
        }
            numItems--;
            return temp.data;
    }

    /**
     * Pushes the specified element on this stack
     * @param element - The element of type E to push on the stack.
     */ 
    public void push(E element)
    {
        Node<E> temp = head;
        Node newElement = new Node(element);
        newElement.next = temp;
        head = newElement;
        numItems++;
    }

    /**
     * Returns the size, in terms of number of items currently 
     * stored, of the Queue.
     * @return the number of items in the stack as an int
     */
    public int size()
    {
        return numItems;
    }
    
    /** 
    * Returns the Stack in a formatted line
    * @return the stack as a string
    */
    public String toString() {
        Node<E> current = head;
        String line = "";
        String elements = "";
        if(!this.isEmpty()) {
            while(current.next != null) {
                elements += current.data + " ";
                current = current.next;
            }
            elements += current.data;
            line = "top [ " + elements + " ] bottom\t(stack with " + this.size() + " elements)";
            }
        if(this.isEmpty()) {
            line =  "top [ ] bottom\t(empty stack)";
        }
        return line;
    }
}
/*testing to string:
    public static void main(String[] args)
    {
        LLStack<Integer> stack = new LLStack<Integer>();
        System.out.println(stack.toString());
        stack.push(1);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.toString());
        stack.push(1);
        System.out.println(stack.toString());



    }
   */ 
