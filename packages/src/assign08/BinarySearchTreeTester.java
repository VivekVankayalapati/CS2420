package assign08;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test; 

class BinarySearchTreeTester {

	BinarySearchTree<Integer> tree;
	
	@Test
	void testAdd1() {
		tree = new BinarySearchTree<>();

		tree.add(8);
		tree.add(4);
		tree.add(12);
		tree.add(2);
		tree.add(6);
		tree.add(10);
		tree.add(11);
		tree.add(13);
		tree.add(15);
		tree.add(14);
		tree.add(1);
		tree.add(3);
		tree.add(5);
		tree.add(7);
		tree.add(9);
		
		

		tree.add(16);

		ArrayList<Integer> list = tree.toArrayList();
		assertEquals(list,null);
	}

	@Test
	void testAdd2() {
		tree = new BinarySearchTree<>();
		
		tree.add(10);
		tree.add(12);
		tree.add(5);
		tree.add(4);
		tree.add(20);
		tree.add(8);
		tree.add(7);
		tree.add(15);
		tree.add(13);

		tree.remove(13); //leaf
		
		tree.remove(12); //only child

		tree.remove(5); //two children

		assertEquals(null, tree);
	}
}
