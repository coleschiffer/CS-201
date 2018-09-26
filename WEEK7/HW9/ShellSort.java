/**
 * Class for ShellSort Investigation, exploring how changing the gap sequence affects run time.
 * You'll only need to look at the shellSort method. You'll modify main, and you're
 * welcome to add any additional methods you'd like. 
 * 
 * @author Anna Rafferty
 * @author Layla Oesepr
 * @author Grant Lee
 * @author Cole Schiffer
 */
public class ShellSort {
    /**
     * Sorts the specified array in increasing order using shell sort. Uses
     * the gap sequence we discussed in class of dividing by 2 and adding
     * one if even.
     * You're welcome to change this method in any way you like for your
     * investigation, including adding parameters to the method.
     * Helper method incrementalInsertionSort handles the gap sorting
     * of subarrays. 
     * @param gapD is the gap devidor for the Shellsort method. We used it as our testing variable.
     */
    public static void shellSort(int[] array, double gapD) {
        int gap = array.length/2; //leave this two alone, you always divide in half to get first gap
        while(gap >= 1) {
            for(int start = 0; start < gap; start++) {
                //We'll "gap sort" starting at index start
                incrementalInsertionSort(array, start, gap);
            }
           
              //the two here is the multiplicative factor           
            if(gap == 2) {
                gap = 1;
            }
            else{
                if(gap/gapD <= 1)
                {
                    gap= 0;
                }
                else {
                    gap = (int)(gap / gapD);
                }

            }

        }
    }
    
   
    
    /**
     * Helper method for shellSort. Does an insertion sort of the subarray at
     * array[first,first+gap, first+gap*2,...]
     */
    private static void incrementalInsertionSort(int[] array, int first, int gap) {
        for(int i = first+gap; i < array.length; i += gap) {
            int nextToInsert = array[i];
            int j = i;
            while(j >= first+gap && nextToInsert < array[j-gap]) {
                array[j] = array[j-gap];

                j -= gap;
            }
            array[j] = nextToInsert;
        }
    }
    
    /**
     * Generates a pseudo-random permutation of the integers from 0 to
     * a.length - 1.
     * See p. 139 of "Seminumerical Algorithms, 2nd edition," by Donald Knuth.
     */
    public static void fillAndShuffle(int[] a) {
        // Fill the array with the integers from 0 to a.length - 1.
        int k;
        for (k = 0; k < a.length; k++) {
            a[k] = k;
        }

        // Shuffle.
        for (k = a.length - 1; k > 0; k--) {
            int swapIndex = (int)Math.floor(Math.random() * (k + 1));
            int temp = a[k];
            a[k] = a[swapIndex];
            a[swapIndex] = temp;
        }
    }
    
  
    /**
     * Main Method
     * 
     */
    public static void main(String[] args) {
    
       double[] numbersForGapD = new double[171];
       double size = 1.5;
       // Fills in numbersForGapD array with values from 1.5 to 5.0 increasing by .05 everytime.
       for (int i = 0; i < 171; i++) {
           numbersForGapD[i] = size;
           size += .05;
       }
       /**
        * Test each value in the numbersForGapD array as the gapD varible in shellsort.
        * For each gapD it sorts three unique but the same sized arrays.
        * It then avarages the sort times of the sorts and out puts the time of the average for each gapD
        */
        for (int i = 0; i < 171; i++) {
            long total = 0;
            for (int j = 0; j < 3; j++) {
                int[] shellSortArray = new int[1000000];
                long[] avg = new long[3];
                fillAndShuffle(shellSortArray);
                long startTime = System.currentTimeMillis();
                shellSort(shellSortArray,numbersForGapD[1]);
                long endTime = System.currentTimeMillis();
                total = total + (endTime - startTime);
            }
            total = total / 3;
            System.out.println((total));      
        }
    }
}
