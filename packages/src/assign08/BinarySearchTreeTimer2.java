package assign08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;


public class BinarySearchTreeTimer2
{
    static
    { 
        main(new String[] { "1" });
        main(new String[] { "2" }); 
        main(new String[] { "3" }); 
        main(new String[] { "4" }); 
        main(new String[] { "5" }); 
        main(new String[] { "6" }); 
        main(new String[] { "7" });
        main(new String[] { "8" }); 
        main(new String[] { "9" });  

    } 
    public static void main (String[] args)
    {

        //int timesToLoop = 100;

        int incr = 1000;
        ArrayList<Double> treeAdd = new ArrayList<Double>();
        ArrayList<Double> treeContain = new ArrayList<Double>();
        ArrayList<Double> binaryAdd = new ArrayList<Double>();
        ArrayList<Double> binaryContain = new ArrayList<Double>();
        for (int probSize = 1000; probSize <= 20000; probSize += incr)
        {   
            //-------------------------------------------------------------------------------------------------------------------//
            
            //This is for timing insertion in random order

            
            ArrayList<Integer> integerList = new ArrayList<Integer>();
            
            for (int i = 0; i < probSize; i++)
            {
                integerList.add(i);
            }

            Collections.shuffle(integerList);

        
            long stopTime, midpointTime, startTime = System.nanoTime();

            // First, spin computing stuff until one second has gone by.
            // This allows this thread to stabilize
            TreeSet<Integer> treeInteger = new TreeSet<Integer>();
            while (System.nanoTime() - startTime < 1000000000)
            { // empty block
            }

            // Collect running times.
            startTime = System.nanoTime();

            for (Integer integer : integerList)
            {
                treeInteger.add(integer);
            }                

            midpointTime = System.nanoTime();

            // Capture the cost of running the loop and any other operations done
            // above that are not the essential method call being timed.
            for (Integer integer : integerList)
            {

            }  

            stopTime = System.nanoTime();

            // Compute the time, subtract the cost of running the loop
            // from the cost of running the loop and searching.
            // Average it over the number of runs.
            double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime)) / (double) probSize;

            treeAdd.add(averageTime);
            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            while (System.nanoTime() - startTime < 1000000000)
            { // empty block
            }

            // Collect running times.
            startTime = System.nanoTime();

            for (Integer integer : integerList)
            {
                treeInteger.contains(integer);
            }                

            midpointTime = System.nanoTime();

            // Capture the cost of running the loop and any other operations done
            // above that are not the essential method call being timed.
            for (Integer integer : integerList)
            {

            }  

            stopTime = System.nanoTime();

            averageTime = ((midpointTime - startTime) - (stopTime - midpointTime)) / (double) probSize;

            treeContain.add(averageTime);
            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            BinarySearchTree<Integer> binaryTree = new BinarySearchTree<Integer>();
            while (System.nanoTime() - startTime < 1000000000)
            { // empty block
            }

            // Collect running times.
            startTime = System.nanoTime();

            for (Integer integer : integerList)
            {
                binaryTree.add(integer);
            }                

            midpointTime = System.nanoTime();

            // Capture the cost of running the loop and any other operations done
            // above that are not the essential method call being timed.
            for (Integer integer : integerList)
            {

            }  

            stopTime = System.nanoTime();

            // Compute the time, subtract the cost of running the loop
            // from the cost of running the loop and searching.
            // Average it over the number of runs.
            averageTime = ((midpointTime - startTime) - (stopTime - midpointTime)) / (double) probSize;

            binaryAdd.add(averageTime);

            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            while (System.nanoTime() - startTime < 1000000000)
            { // empty block
            }

            // Collect running times.
            startTime = System.nanoTime();

            for (Integer integer : integerList)
            {
                binaryTree.contains(integer);
            }                

            midpointTime = System.nanoTime();

            // Capture the cost of running the loop and any other operations done
            // above that are not the essential method call being timed.
            for (Integer integer : integerList)
            {

            }  

            stopTime = System.nanoTime();

            // Compute the time, subtract the cost of running the loop
            // from the cost of running the loop and searching.
            // Average it over the number of runs.
            averageTime = ((midpointTime - startTime) - (stopTime - midpointTime)) / (double) probSize;

            binaryContain.add(averageTime);
        }
        

        int i = 0;
        // for (int probSize = 1000; probSize <= 20000; probSize += incr)
        // {
        //     System.out.println(treeAdd.get(i));
        //     i++;
        // }

        // System.out.println("//");

        // i = 0;
        // for (int probSize = 1000; probSize <= 20000; probSize += incr)
        // {
        //     System.out.println(binaryAdd.get(i));
        //     i++;
        // }

        // System.out.println("//");

        // i = 0;
        // for (int probSize = 1000; probSize <= 20000; probSize += incr)
        // {
        //     System.out.println(treeContain.get(i));
        //     i++;
        // }
        System.out.println("//");
        i = 0;
        for (int probSize = 1000; probSize <= 20000; probSize += incr)
        {
            System.out.println(binaryContain.get(i));
            i++;
        }

    }
}
