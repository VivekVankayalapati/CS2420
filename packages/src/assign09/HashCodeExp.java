package assign09;

import java.util.ArrayList;
import java.util.Random;

public class HashCodeExp
{
    public static void main (String[] args)
    {
        Random rng = new Random();
        
        int incr = 1000;
        
        for (int probSize = 1000; probSize <= 20000; probSize += incr)
        {
        	HashTable<StudentBadHash, Integer> badHash = new HashTable<>();
            HashTable<StudentMediumHash, Integer> mediumHash = new HashTable<>();
            HashTable<StudentGoodHash, Integer> goodHash = new HashTable<>();
            
            ArrayList<Integer> uidList = new ArrayList<>();
    		
    		// Populates list of UID's.
    		for (int i = 0; i < probSize; i++) {
    			uidList.add(rng.nextInt(10000000));
    		}
    		
    		// Populates respective hash tables.
    		for (int i = 0; i < probSize; i++) {
    			badHash.put(new StudentBadHash(uidList.get(i), "John", "Doe"), i);
    			mediumHash.put(new StudentMediumHash(uidList.get(i), "John", "Doe"), i);
    			goodHash.put(new StudentGoodHash(uidList.get(i), "John", "Doe"), i);
    		}

            System.out.println(probSize + "  " + badHash.collisions() + "  " + mediumHash.collisions() + "  " + goodHash.collisions());
        }
    }
}