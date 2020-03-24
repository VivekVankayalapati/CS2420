package assign08;

import java.util.ArrayList;

public class BinaryRandom
{
    BinaryRandom()
    {

    }

    public double binaryTimer(ArrayList<Integer> input, int probSize)
    {   
        long stopTime, midpointTime, startTime = System.nanoTime();

        // First, spin computing stuff until one second has gone by.
        // This allows this thread to stabilize
        BinarySearchTree<Integer> binaryInteger = new BinarySearchTree<Integer>();

        for (Integer integer : input)
        {
            binaryInteger.add(integer);
        }

        while (System.nanoTime() - startTime < 1000000000)
        { // empty block
        }

        startTime = System.nanoTime();

        for (int j = 0; j < probSize; j++)
        {
            binaryInteger.contains(j);
        }

        midpointTime = System.nanoTime();

        // Capture the cost of running the loop and any other operations done
        // above that are not the essential method call being timed.
        for (int j = 0; j < probSize; j++)
        {
            
        }

        stopTime = System.nanoTime();

        double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime))/(double)probSize;

        return averageTime;


    }

}
