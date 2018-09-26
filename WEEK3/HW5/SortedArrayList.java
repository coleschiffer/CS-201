/**
 * A Sorted Array List Data Structure.
 * @author Cole Schiffer
 */

public class SortedArrayList {
    //Instance Variables
    private int[] data;
    private int size, capacity, max, min;
    public SortedArrayList(int cap) {
        //UPDATE THIS CONSTRUCTOR
        data = new int[cap];
        capacity = cap;
        size = 0;
    }
    
    /**
     * @return A string that describes the SortedArrayList
     */
    public String toString() {
        String val = "[";
        for (int i = 0; i < size; i++) {
            val = val + data[i];
            
            if (i < size - 1) {
                val = val + ", ";
            }
        }
        val = val + "]";
        return val;
    }
    
    /*
     * CAN YOU FIGURE OUT WHAT THIS METHOD IS DOING?
     * WHY MIGHT THIS BE USEFUL TO HAVE?
     * YOU WILL USE THIS LATER IN YOUR CODE.
     */
    /**
     * @return Boolean if given int fits in the range of declared elements in array
     * @param int to check if it's in the bounds
     */
    private boolean indexOutOfBounds(int index) {
        return (index < 0 || index >= size);
    }

     //YOUR METHODS GO BELOW HERE
    /**
     * @return int, lowest in array
     */
    public int getMin()
    {
        if (size != 0)
            return data[0];
        else
            return -1;
        
    }
    /**
     * @return int, highest in array
     */
    public int getMax()
    {
    if (size != 0)
            return data[size - 1];
        else
            return -1;
    }
    /**
     * @return int, size of array
     */
    public int getSize()
    {
    return size;
    }
    /**
     * 
     *@return deleted number or negative one if incomputable
     */
    public int deleteMin()
    {
        int min = data[0];
        if (size != 0)
        {
for (int k = 1; k < size; k++) {
         data[k - 1] = data[k];        
        }
        size--;
return min;
        }
         else
            return -1;
        
    }
    /**
     * 
     *@return deleted number or negative one if incomputable
     */
    public int deleteMax()
    {
        if (size != 0)
        {
        int max = data[size - 1];
        data[size - 1] = 0;
        size--;
        return max;
        }
        else
        return -1;
    }
    /**
     * @param int to check if it's in the array
     * @return boolean if int x is in the array
     */
    public boolean contains(int x)
    {
        int k = 0;
        while(indexOutOfBounds(k))
    {
            if(data[k] == x) {
                return true;
            }
        k++;
        }
        return false;
    }
    /**
     * 
     *@param number that will be added to end of the array
     */
    public void add(int x)
    {
        if((size) >= capacity)
        {

            resizeArray();
        }
        int temp;
        data[size] = x;
        size++;  
        for (int k = 0; k < size; k++)
        {
            for (int j = k; j < size; j++)
            {
                if(data[j] < data[k])
                {
                    temp = data[k];
                    data[k] = data[j];
                    data[j] = temp;
                }
            }
        }
    }
    /**
    *Resizes the array
    *
    */
    private void resizeArray()
    {
    int dataTemp[] = new int[capacity*2];
    System.arraycopy(data, 0, dataTemp, 0, capacity);
    capacity = capacity * 2;
    data = new int[capacity];
    System.arraycopy(dataTemp, 0, data, 0, capacity/2);
    data = dataTemp;
    }

    public static void main(String[] args) {

        SortedArrayList one = new SortedArrayList(4);
        one.add(4);
        one.add(3);
        one.add(-2);
        one.deleteMax();
        System.out.println(one);
        one.add(-4);
        System.out.println(one);
        one.add(1);
        System.out.println(one);
        one.deleteMin();
        System.out.println(one);
        System.out.println("Max = " + one.getMax() + ", Min = " + one.getMin() + ", size = " + one.getSize() + ", Contains 399242? " + one.contains(399242) );



    }
}