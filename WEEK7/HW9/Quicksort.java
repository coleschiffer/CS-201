/**
 * Class for QuickSort Investigation, exploring how changing the switch to
 * insertion sort affects runtime.
 * Note that there are many private methods here for how quicksort works.
 * You'll only need to look at the two methods named quicksort and potentially
 * the insertionSort method. You'll modify main, and you're welcome to add
 * any additional methods you'd like. 
 * 
 * @author Anna Rafferty
 * @author Layla Oesper
 * @author Grant Lee 
 * @author Cole Schiffer
 */
public class Quicksort {
    public static int MIN_SIZE = 10; 

    /** 
     * Sorts an array in increasing order using quicksort.
     * Quicksort code is based off of Carrano and Henry. 
     * array will be sorted in place.
     */
    public static void quicksort(int[] array) {
        quicksort(array, 0, array.length - 1);
    }
    
    /** 
     * Helper method:
     * Sorts the part of the array a between index first and index last
     *  in increasing order using quicksort.
     */
    private static void quicksort(int[] arr, int first, int last) {
        if (last - first + 1 < MIN_SIZE) {
            insertionSort(arr, first, last);
        } else {
            // create the partition: Smaller | Pivot | Larger
            int pivotIndex = partition (arr, first, last);
            // sort subarrays Smaller and Larger
            quicksort(arr, first, pivotIndex - 1);
            quicksort(arr, pivotIndex + 1, last);
        }
    }
    
    /** 
     * Orders two given array entries into ascending order
     * so that arr[i] <= arr[j].
     * @param arr an array of objects
     * @param i an integer >= 0 and < arr.length
     * @param j an integer >= 0 and < arr.length
     */
    private static void order (int[] arr, int i, int j) {
        if (arr[i] > arr[j]) {
            swap(arr, i, j);
        }
    }
    
    /** 
     * Swaps the array entries arr[i] and arr[j]. 
     */
    private static void swap (int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    private static int partition(int[] arr, int first, int last) {
        // select first item as the pivot
        int pivotIndex = first;
        int pivot = arr[pivotIndex];
        
        // determine subarrays Smaller = a[first + 1..endSmaller]
        // and Larger = a[endSmaller+1..last]
        // such that entries in Smaller are < pivot and
        // entries in Larger are > pivot;
        int up = first + 1;
        int down  = last;
        boolean done = false;
        while (!done){
            while(up < arr.length && arr[up] < pivot) { //leave entries that are < pivot
                up++;
            }
            while (down >= 0 && pivot < arr[down]) { //leave entries that are > pivot
                down--;
            }
            
            if (up < down){
                swap(arr, up, down);
                up++;
                down--;
            } else {
                done = true;
                // place pivot between Smaller and Larger subarrays
                swap(arr, first, down);
            }
        }
        return down;
    }
    
    
    /**
     * Sorts the specified array in increasing order using insertion sort.
     */
    public static void insertionSort(int[] arr) {
        insertionSort(arr, 0, arr.length-1);
    }
    
    /**
     * Helper method for insertion sort to enable insertion sorting only part
     * of an array.
     */
    private static void insertionSort(int[] arr, int first, int last) {    
        for(int i = first+1; i <= last; i++) {
            //i is the index in the array we're going to find the right place for
            int j = i;
            while(j > first && arr[j-1] > arr[j]) {
                int numToSwapOut = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = numToSwapOut;
                j--;
            }
        }
    }
    
    /**
     * Generates a pseudo-random permutation of the integers from 0 to
     * a.length - 1.
     * See p. 139 of "Seminumerical Algorithms, 2nd edition," by Donald Knuth.
     */
    public static void fillAndShuffle(int[] arr) {
        // Fill the array with the integers from 0 to a.length - 1.
        int k;
        for (k = 0; k < arr.length; k++) {
            arr[k] = k;
        }

        // Shuffle.
        for (k = arr.length - 1; k > 0; k--) {
            int swapIndex = (int)Math.floor(Math.random() * (k + 1));
            int temp = arr[k];
            arr[k] = arr[swapIndex];
            arr[swapIndex] = temp;
        }
    }
    
    /**
     * Main Method
     */
    public static void main(String[] args) {
        

        int[] minSizeTries = new int[201];
        //Fills minSizeTries array with numbers from 1 to 200, which are the numbers from which MIN_SIZE will be changed. 
        for (int i = 0; i < 201; i++) {
            minSizeTries[i] = i + 1;
        }
        /** 
        * Test each value in the minSizeTries array as the MIN_SIZE varible in Quicksort.
        * For each MIN_SIZE it sorts three unique but the same sized arrays.
        * It then averages the sort times of the sorts and out puts the time of the average for each MIN_SIZE
        */
        for(int i = 0; i < 201; i += 1) {
            MIN_SIZE = minSizeTries[i];
            long total = 0;
            for(int j = 0; j < 3; j++) {
                int[] quicksortArray = new int[1000000];
                fillAndShuffle(quicksortArray);
                long startTime = System.currentTimeMillis();
                quicksort(quicksortArray);
                long endTime = System.currentTimeMillis();
                total = endTime - startTime + total;
            }
            total /= 3;
            System.out.println(total);
        }    
    }   
}
