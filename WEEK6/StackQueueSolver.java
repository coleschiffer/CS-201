 /**
 * Stack Queue Solver
 * HW 08
 * CS 201
 * @author Cole Schiffer, Grant Lee
 */

 public class StackQueueSolver {
    /** 
    * Returns a new stack that contains the items in stack s in the reverse order
    * @param s The stack that is being reversed
    * @return items of stack s in reverse order as a new Stack
    */
    public static Stack<Object> reverseStack(Stack<Object> s) {
        Stack<Object> newStack = new LLStack<>();
        while(!s.isEmpty())
        {
            newStack.push(s.pop());
        }
        return newStack;
    }
 /** 
    * Creates a stack with m on top prints it,
    * then reverses the stack and prints that stack.
    * @param m, the number on top of the stack.
    */
    public static void testStackReverse(int m) {
        Stack<Object> testStack = new LLStack<Object>();
        for (int i = 1; i <= m; i++) {
            testStack.push(i);
        }
        System.out.println(testStack);
        System.out.println(reverseStack(testStack));
    }
    /** 
    * Returns the customer served last in line after the swaps
    * @param m The total number of customers in line
    * @param n The number of times the front is send to the back
    * @return the number value of the last served customer
    */
    public static int lastCustomer(int m, int n) {
        ArrayQueue<Integer> line = new ArrayQueue<Integer>();
        for(int i = 1; i <= m; i++) {
            line.enqueue(i);
        }
        for(int i = 0; i < n; i++) {
            line.enqueue(line.dequeue());
        }
        for(int i = 1; i < m; i++) {
            line.dequeue();
        }
        return line.dequeue();
    }
    //testing method
    /*
    public static void main(String[] args) {
        testStackReverse(10);
        System.out.println(lastCustomer(1,0));
    }
    */

}