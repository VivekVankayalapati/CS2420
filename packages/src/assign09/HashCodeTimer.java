package assign09;

import java.util.ArrayList;
import java.util.Random;

public class HashCodeTimer
{
    public static void main (String[] args)
    {
    	Random rng = new Random();
    	
        int incr = 1000;
        for (int probSize = 1000; probSize <= 20000; probSize += incr)
        {
        	ArrayList<Integer> uidList = new ArrayList<>();
    		
    		// Populates list of UID's.
            for (int i = 0; i < probSize; i++) 
            {
    			uidList.add(rng.nextInt(10000000));
    		}
            
            
            //Vary this based on which HashCode you want to time

//    		ArrayList<StudentBadHash> hashArray = new ArrayList<>();
//    		ArrayList<StudentMediumHash> hashArray = new ArrayList<>();
    		ArrayList<StudentGoodHash> hashArray = new ArrayList<>();
    		
    		// Populates respective arrays.
            for (int i = 0; i < probSize; i++) 
            {
                //Vary this based on which HashCode you want to time

//    			hashArray.add(new StudentBadHash(uidList.get(i), "John", "Doe"));
//    			hashArray.add(new StudentMediumHash(uidList.get(i), "John", "Doe"));
    			hashArray.add(new StudentGoodHash(uidList.get(i), "John", "Doe"));
    		}

            long stopTime, midpointTime, startTime = System.nanoTime();

            // First, spin computing stuff until one second has gone by.
            // This allows this thread to stabilize

            while (System.nanoTime() - startTime < 1000000000)
            {
            	// empty block
            }

            // Collect running times.
            startTime = System.nanoTime();
            for (int i = 0; i < probSize; i++)
            {
            	hashArray.get(i).hashCode();
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
            // Average it over the problem size.
            double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime)) / (double) probSize;
            System.out.println(probSize + "  " + averageTime);
        }
    }
}