package assign09;

import java.util.ArrayList;
import java.util.Random;

public class HashCodeItemTimer
{
    public static void main (String[] args)
    {
        Random rng = new Random();
        
        int timesToLoop = 1000000;
        ArrayList<Integer> uidList = new ArrayList<>();
        
        // Populates list of UID's.
        for (int i = 0; i < timesToLoop; i++) 
        {
            //Vary this to test the size of the uids as an experimental variable

            //uidList.add(rng.nextInt(10000000)+1000000);
            //uidList.add(rng.nextInt(10000)+10000);
            uidList.add(rng.nextInt(1)+1);
        }
        
   		ArrayList<StudentBadHash> hashArrayBad = new ArrayList<>();
   		ArrayList<StudentMediumHash> hashArrayMedium = new ArrayList<>();
        ArrayList<StudentGoodHash> hashArrayGood = new ArrayList<>();
        
        // Populates respective arrays.
        for (int i = 0; i < timesToLoop; i++) {
    		hashArrayBad.add(new StudentBadHash(uidList.get(i), "John", "Doe"));
    		hashArrayMedium.add(new StudentMediumHash(uidList.get(i), "John", "Doe"));
            hashArrayGood.add(new StudentGoodHash(uidList.get(i), "John", "Doe"));
        }

        long stopTime, midpointTime, startTime = System.nanoTime();

        //For StudentBadHash

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
            hashArrayBad.get(i).hashCode();
        }

        midpointTime = System.nanoTime();

        // Capture the cost of running the loop and any other operations done
        // above that are not the essential method call being timed.
        for (int i = 0; i < timesToLoop; i++)
        {
            
        }

        stopTime = System.nanoTime();



        // Compute the time, subtract the cost of running the loop
        // from the cost of running the loop and searching.
        // Average it over the number of runs.

        double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime)) / (double) timesToLoop;
        System.out.println(averageTime);

        //For StudentMediumHash

        // Collect running times.
        startTime = System.nanoTime();
        for (int i = 0; i < timesToLoop; i++)
        {
            hashArrayMedium.get(i).hashCode();
        }

        midpointTime = System.nanoTime();

        // Capture the cost of running the loop and any other operations done
        // above that are not the essential method call being timed.
        for (int i = 0; i < timesToLoop; i++)
        {
            
        }

        stopTime = System.nanoTime();

        

        // Compute the time, subtract the cost of running the loop
        // from the cost of running the loop and searching.
        // Average it over the number of runs.
        averageTime = ((midpointTime - startTime) - (stopTime - midpointTime)) / (double) timesToLoop;
        System.out.println(averageTime);

        //For StudentGoodHash

        // Collect running times.
        startTime = System.nanoTime();
        for (int i = 0; i < timesToLoop; i++)
        {
            hashArrayGood.get(i).hashCode();
        }

        midpointTime = System.nanoTime();

        // Capture the cost of running the loop and any other operations done
        // above that are not the essential method call being timed.
        for (int i = 0; i < timesToLoop; i++)
        {
            
        }

        stopTime = System.nanoTime();

        

        // Compute the time, subtract the cost of running the loop
        // from the cost of running the loop and searching.
        // Average it over the number of runs.
        averageTime = ((midpointTime - startTime) - (stopTime - midpointTime)) / (double) timesToLoop;
        System.out.println(averageTime);
    }
}