/**
 * This class creates a Tour of Points using a 
 * Linked List implementation.  The points can
 * be inserted into the list using two heuristics.
 * @author Frederick and Cole
 * @author Layla Oesper, modified code 09-22-2017
 */

public class Tour {

    /** A helper class that defines a single node for use in a tour.
     * A node consists of a Point, representing the location of that
     * city in the tour, and a pointer to the next Node in the tour.
     */
    private class Node {
        private Point p;
        private Node next;

	
        /** Constructor creates a new Node at the given Point newP
         * with an intital next value of null.
         * @param newP - the point to associate with the Node.
         */
        public Node(Point newP) {
            p = newP;
            next = null;
        }

        /** Constructor creates a new Node at the given Point newP
         * with the specified next node.
         * @param newP - the point to associate with the Node.
         * @param nextNode - the nextNode this node should point to.
         */
        public Node(Point newP, Node nextNode) {
            p = newP;
            next = nextNode;
        }
	
        /**
         * Return the Point associated with this Node. 
         * (Same value can also be accessed from a Node object node
         * using node.p)
         * @return The Point object associated with this node.
         */
        public Point getPoint() {
            return p;
        }
        
        /**
         * Return the next Node associated with this Node. 
         * (Same value can also be accessed from a Node object node
         * using node.next)
         * @return The next Node object linked from this node..
         */
	   public Node getNext() {
	       return next;
	   }
          
    } // End Node class
    

    // Tour class Instance variables
    private Node head;
    private int size; //number of nodes

    //Add other instance variables you think might be useful.
    
    
    /**
     * Constructor for the Tour class.  By default sets head to null.
     */
    public Tour() {
        head = null;
        size = 0;
        
    }
    
    // ADD YOUR METHODS BELOW HERE
    /**
    * @return int size, size of linked list
    */

    public int size(){
        return size;
    }
    /**
    * @param Point p
    *  Finds the smallest travel distance
    */
    public void insertSmallest(Point p){
        Node n = new Node(p);
        if(size == 0){
            head = n;
        }
        else{
            double smallestDist = Double.MAX_VALUE;
            Node smallest = head;
            Node temp = head;
            double current;
            while(temp.next!=null){
                current = getNewDistance(temp,p);
                if(current < smallestDist){
                    smallest = temp;
                    smallestDist = current;
                }
                temp=temp.next;
            }
            if(smallest == head){
                n.next = head.next;
                head.next = n;
            }
            else {
                n.next = smallest.next;
                smallest.next = n;
            }
        }
        size++;
    }

    /**
    *@return double, total distance the salesman travels.
    */
    public double distance(){
        double distance = 0;
        if(size <= 1)return 0;
        Node temp = head;
        while(temp.next != null){
            distance = distance + temp.p.distanceTo(temp.next.p);
            temp = temp.next;
        }
        distance = distance + temp.p.distanceTo(head.p);
        return distance;
    }
    /**
    *@param Node temp
    *@param Point P
    * Helper method for insertNearest
    */
    private double getNewDistance(Node temp,Point p){

        Point nextPoint;
        Point currentPoint = temp.p;
        double currentTotalDistance = distance();

        double distance = 0;
        Node n = new Node(p);
        if(temp.next == null){
            nextPoint = head.p;
        }
        else{
            nextPoint = temp.next.p;
        }

        return currentTotalDistance - currentPoint.distanceTo(nextPoint) + currentPoint.distanceTo(p) + p.distanceTo(nextPoint);

    }
    /**
    *@return String, to string method
    */
    public String toString() {
        Node temp = head;
        String returned = "";
        while(temp != null)
        {
            returned = returned + temp.p.toString() + "\n";
            temp = temp.next;
        }
        return returned;
    }
    /**
    * @param Point p
    *  Finds the nearest travel distance
    */
    public void insertNearest(Point p) {
        double minDist = Double.MAX_VALUE;
        Node nearest = head;
        Node temp = head;
        Node n = new Node(p);
        if(size == 0)
        {
            head = n;
        }
        else
        {
        while(temp != null){
            if(p.distanceTo(temp.p) < minDist){
                //prev = temp;
                nearest = temp;
                minDist = p.distanceTo(temp.p);
            }
            temp = temp.next;
        }
        if(nearest == head){
            n.next = head.next;
            head.next = n;
        }
        else{
            n.next = nearest.next;
            nearest.next = n;
        }
        }
    size++;
    }

    /**
    *@return void method
    */
    public void draw()
    {
        Node temp = head;
        while(temp.next != null)
        {
            temp.p.draw();
            temp.p.drawTo(temp.next.p);
            temp = temp.next;
        }
        temp.p.draw();
        temp.p.drawTo(head.p);
    }

/*
        1)create new node n that point to null
        2)if index = zero or index = size-1 it is a prob
        2)find node b4 index, call it temp
        3)n.next = temp.next
        4)temp.next = n
        */
   
    
    
    // ADD YOUR METHODS ABOVE HERE
   
    public static void main(String[] args) {
        /* Use your main() function to test your code as you write it. 
         * This main() will not actually be run once you have the entire
         * Tour class complete, instead you will run the NearestInsertion
         * and SmallestInsertion programs which call the functions in this 
         * class. 
         */
        
        
        //One example test could be the follow (uncomment to run):
        
        Tour tour = new Tour();
        Point p = new Point(0,0);
        tour.insertNearest(p);
        p = new Point(0,100);
        tour.insertNearest(p);
        p = new Point(100, 100);
        tour.insertNearest(p);
        System.out.println("Tour distance =  "+tour.distance());
        System.out.println("Number of points = "+tour.size());
        System.out.println(tour);
        
         

        // the tour size should be 3 and the distance 341.42 (don't forget to include the trip back
        // to the original point)
    
        // uncomment the following section to draw the tour, setting w and h to the max x and y 
        // values that occur in your tour points
	
        
        int w = 100 ; //Set this value to the max that x can take on
        int h = 100 ; //Set this value to the max that y can take on
        StdDraw.setCanvasSize(w, h);
        StdDraw.setXscale(0, w);
        StdDraw.setYscale(0, h);
        StdDraw.setPenRadius(.005);
        tour.draw(); 
        
    }
   
}