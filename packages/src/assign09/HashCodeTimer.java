package assign09;

import java.util.LinkedList;
import java.util.Random;

public class HashCodeTimer
{
    public static void main (String[] args)
    {
        Random rng = new Random();

        int timesToLoop = 5000;

        int incr = 5000;
        for (int probSize = 5000; probSize <= 100000; probSize += incr)
        {
            //

            long stopTime, midpointTime, startTime = System.nanoTime();

            // First, spin computing stuff until one second has gone by.
            // This allows this thread to stabilize

            while (System.nanoTime() - startTime < 1000000000)
            {
            	// empty block
            }

            // Collect running times.
            startTime = System.nanoTime();
            for (int i = 0; i < timesToLoop; i++)
            {
                //
            }

            midpointTime = System.nanoTime();

            // Capture the cost of running the loop and any other operations done
            // above that are not the essential method call being timed.
            for (int i = 0; i < timesToLoop; i++)
            {
            	//
            }

            stopTime = System.nanoTime();

            // Compute the time, subtract the cost of running the loop
            // from the cost of running the loop and searching.
            // Average it over the number of runs.
            double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime)) / (double) timesToLoop;
            System.out.println(probSize + "  " + averageTime);

        }
    }
}