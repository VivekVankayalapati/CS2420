package assign08;

import java.util.ArrayList;
import java.util.Collections;


public class BinarySearchTreeTimer
{
    public static void main (String[] args)
    {

        int timesToLoop = 10;

        int incr = 1000;
        ArrayList<Double> allTimes = new ArrayList<Double>();
        for (int probSize = 1000; probSize <= 20000; probSize += incr)
        {  
            /* 

            //-------------------------------------------------------------------------------------------------------------------//

            //This is for timing insertion in sorted order

            
            BinarySearchTree<Integer> binaryInteger = new BinarySearchTree<Integer>();

            for (int i = 0; i < probSize; i++)
            {
                binaryInteger.add(i);
            }

            long stopTime, midpointTime, startTime = System.nanoTime();

            // First, spin computing stuff until one second has gone by.
            // This allows this thread to stabilize

            while (System.nanoTime() - startTime < 1000000000)
            { // empty block
            }

            // Collect running times.
            startTime = System.nanoTime();

            for (int i = 0; i < probSize; i++)
            {
                binaryInteger.contains(i);
            }


            midpointTime = System.nanoTime();

            // Capture the cost of running the loop and any other operations done
            // above that are not the essential method call being timed.

            for (int i = 0; i < probSize; i++)
            {
                
            }

            stopTime = System.nanoTime();

            // Compute the time, subtract the cost of running the loop
            // from the cost of running the loop and searching.
            double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime))/probSize;

            System.out.println(probSize + "  " + averageTime);

            
            */

            //-------------------------------------------------------------------------------------------------------------------//
            
            
            //This is for timing insertion in random order
            //My timing results are consistently jumpy, I don't understand why

            //Make a class with parameters of array, and return of array and interated through random 
            
            ArrayList<Integer> integerList = new ArrayList<Integer>();
            //ArrayList<Double> times = new ArrayList<Double>();

            double times = 0;
            BinaryRandom random = new BinaryRandom();
            for (int i = 0; i < probSize; i++)
            {
                integerList.add(i);
            }

            for (int i = 0; i < timesToLoop; i++)
            {
                Collections.shuffle(integerList);
                times += random.binaryTimer(integerList, probSize);
            }

            times = times/timesToLoop;

            allTimes.add(times);
        }
        
        int i = 0;
        for (int probSize = 1000; probSize <= 20000; probSize += incr)
        {
            System.out.println(probSize + "  " + allTimes.get(i));
            i++;
        }
    }
}
