/**
 * An implementation of the List ADT using
 * a linked list.  Specifically, this implementation
 * only allows a List to contain Comparable items.
 * ADD A DESCRIPTION HERE ABOUT THE ADDED METHODS.
 *
 * @author Layla Oesper 
 * @author Cole Schiffer
*/

/* Note <E extends Comparable<E> means this container
 * can only hold objects of type E that are Comparable.
 */
public class RecursiveLinkedList<E extends Comparable<E>> implements List<E>{ 
    
    /* Internal Node class used for creating linked objects.
    */
    private class Node<E> {
        private E data;
        private Node<E> next;
	
        private Node(E dataItem) {
            data = dataItem;
            next = null;
        }
        
        private Node(E dataItem, Node<E> nextNode) {
            data = dataItem;
            next = nextNode;
        }
         
    } // End Node class
    
    //Instance variables for RecursiveLinkedList
    private Node<E> head;
    private int numItems; //Total number items stored in List.
    
    
    /**
     * Creates an empty RecursiveLinkedList
     */
    public RecursiveLinkedList() {
        head = null;
        numItems = 0;
    }
    
    /**
     * Returns the data stored at positon index.
     * @param index
     * @return The data stored at position index. 
     */
    public E get(int index) {
        if (index < 0 || index >= numItems) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        } 
        Node<E> node = getNode(index);
        return node.data;
    }
    
    /*
     * Helper method that retrives the Node<E> stored at 
     * the specified index.
     */
    private Node<E> getNode(int index) {
        Node<E> node = head;
        for (int i = 0; i < index && node != null; i++) {
            node = node.next;
        }
        return node;
    }
    
    /**
     * Removes and returns the data stored at the specified index.
     * @param index The position of the data to remove.
     * @return The data previously stored at index position.
     */
    public E remove(int index) {
        if (index < 0 || index >= numItems) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        
        if (index == 0){
            return removeFirst();
        } else {
            Node<E> before = getNode(index - 1);
            return removeAfter(before);
        }
    }
    
    /*
     * Helper method that removes the Node<E> after the
     * specified Node<E>. Returns the data that was
     * stored in the removed node.
     */
    private E removeAfter(Node<E> node) {
        Node<E> temp = node.next;
        if (temp != null) {
            node.next = temp.next;
            numItems--;
            return temp.data;
        } else {
            return null;
        }
    }
    
    /*
     * Helper method that removes the first Node<E> in
     * the Linked List.  Returns the data that was
     * stored in the removed node.
     */
    private E removeFirst() {
        Node<E> temp = head;
        if (head != null) {
            head = head.next;
        }
        
        if (temp != null) {
            numItems--;
            return temp.data;
        } else {
            return null;
        }
    }
    
    /**
     * Adds the data to the list at the specified index.
     * @param index The position to add the data.
     * @param anEntry The particular data to add to the list.
     */
    public void add(int index, E anEntry) {
        if (index < 0 || index > numItems) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if (index == 0) {
            addFirst(anEntry);
        } else {
            Node<E> node = getNode(index - 1);
            addAfter(node, anEntry);
        }
    }
    
    /*
     * Helper method that adds anEntry to the first
     * position in the list.
     */
    private void addFirst(E anEntry) {
        head = new Node<>(anEntry, head);
        numItems++;
    }
    
    /*
     * Helper method that adds anEntry after the
     * specified Node<E> in the linked list.
     */
    private void addAfter(Node<E> before, E anEntry) {
        before.next = new Node<>(anEntry, before.next);
        numItems++;
    }
    
    /**
     * Add the specified data to the end of the list.
     * @param anEntry The data to add to this list.
     */
    public boolean add(E anEntry) {
        add(numItems, anEntry);
        return true;
    }
    
    /**
     * Returns the size of the list in terms of items stored.
     * @returns the number of items in the list.
     */
    public int size() {
        return numItems;
    }
    
    /**
     * Modifies the list so the specified index now 
     * contains newValue (overwriting the old data).
     * @param index The position int he list to add data.
     * @param newValue The data to place in the list.
     * @return The previous data value stored at index.
     */
    public E set(int index, E newValue) {
        if (index < 0 || index >= numItems) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
        E result = node.data;
        node.data = newValue;
        return result;
    }
    
    /**
     * A string representation of the List.
     * @returns A string representation of the list.
     */
    public String toString() {
        String s = "[";
        Node<E> temp = head;
        for (int i = 0; i < numItems; i++) {
            s = s + temp.data.toString();
            if (i < numItems - 1) {
                s = s + ", ";
            }
            temp = temp.next;
        }
        s = s + "]";
        return s;
    }
    
    //YOUR CODE GOES HERE
    //YOU MADE ADD OTHER HELPER METHODS AS WELL        private E data;

    /**
     * helper method for max()
     *
     * @return maximum element of the list
     * @param Node temp, the curent value in linked list.
     **/
    private E maxHelp(Node<E> temp)
    {
        if (temp.next == null)
        {
            return temp.data;
        }
        E high = maxHelp(temp.next);
        return (temp.data.compareTo(high) > 0) ? temp.data : high;
    }
    /**
     * Return the maximum element in the list using
     * compareTo() method of Comparable.
     *
     * @return maximum element of the list
     **/
    public E max(){
        if(head == null)
            return null;
        else
            return maxHelp(head);
    }

    /**
     * Helper method for remove
     *
     * @param element The element that should be removed
     * @param node, the current spot in list
     **/
    private void removeHelp(E element, Node<E> temp)
    {
        if(temp != null)
        {
            if(temp.data.equals(element))
            {
            numItems--;
            if(temp.next == null)
            {
                return;
            }
            temp.data = temp.next.data;
            temp.next = temp.next.next;
            removeHelp(element, temp);
            }
            else
            removeHelp(element, temp.next);
        }
    }
    /**
     * Remove all elements that match element using the 
     * equals() operator to determine a match. 
     *
     * @param element The element that should be removed
     **/
    public void remover(E element){
       Node<E> temp = head;
       removeHelp(element, temp);

    }

    /**
     * Helper method for duplicate()
     *
     * @param temp the curent spot int the node
     * void
     **/
    private void duplicateHelp(Node temp){
        if(temp != null)
        {
            Node<E> test = new Node(temp.data, temp.next);
            temp.next = test;
            duplicateHelp(test.next);
        }

    }
    /**
     * Duplicate each element of the list
     *
     * For example, the list [ 0 1 2 ] duplicated becomes 
     * [ 0 0 1 1 2 2 ]
     * void
     **/
    public void duplicate(){
        Node temp = head;
        duplicateHelp(temp);
        numItems += numItems;

    }
    
 
    /**
     * Here are a couple short tests. You should 
     * should make sure to thoroughly test your code.
     */
    public static void main(String[] args) {
        RecursiveLinkedList<Integer> l = new RecursiveLinkedList<Integer>();
        l.add(100);
        l.add(20);
        l.add(1);
        l.add(28);
        System.out.println("List is: " + l);
        l.duplicate();
        System.out.println("Duped is: " + l);
        l .remover(1);
        System.out.println("With out 1 is: " + l);
        System.out.println("max is: " + l.max());
    }
    
}