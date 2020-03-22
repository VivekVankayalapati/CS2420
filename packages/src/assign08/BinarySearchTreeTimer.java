package assign08;

import java.util.ArrayList;
import java.util.Collections;


public class BinarySearchTreeTimer
{
    public static void main (String[] args)
    {

        int timesToLoop = 10;

        int incr = 100000;
        for (int probSize = 100000; probSize <= 2000000; probSize += incr)
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

            
            ArrayList<Integer> integerList = new ArrayList<Integer>();
            
            for (int i = 0; i < probSize; i++)
            {
                integerList.add(i);
            }

            

            


            long stopTime, midpointTime, startTime = System.nanoTime();

            // First, spin computing stuff until one second has gone by.
            // This allows this thread to stabilize
            Collections.shuffle(integerList);


            while (System.nanoTime() - startTime < 1000000000)
            { // empty block
            }

            // Collect running times.
            startTime = System.nanoTime();


            
            for (int i = 0; i < timesToLoop; i++)
            {
                BinarySearchTree<Integer> binaryInteger = new BinarySearchTree<Integer>();

                

                for (Integer integer : integerList)
                {
                    binaryInteger.add(integer);
                }

                for (int j = 0; j < probSize; j++)
                {
                    binaryInteger.contains(j);
                }
            }


            


            midpointTime = System.nanoTime();

            // Capture the cost of running the loop and any other operations done
            // above that are not the essential method call being timed.

            for (int i = 0; i < timesToLoop; i++)
            {
                BinarySearchTree<Integer> binaryInteger = new BinarySearchTree<Integer>();

                for (Integer integer : integerList)
                {
                    binaryInteger.add(integer);
                }

                for (int j = 0; j < probSize; j++)
                {
                    
                }
            }

            stopTime = System.nanoTime();

            // Compute the time, subtract the cost of running the loop
            // from the cost of running the loop and searching.
            // Average it over the number of runs.
            double totalTime = ((midpointTime - startTime) - (stopTime - midpointTime)) / (double) timesToLoop;
            double averageTime = totalTime/probSize;
            System.out.println(probSize + "  " + averageTime);
            
        }
        
        
        
    }
}
