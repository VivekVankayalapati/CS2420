package assign08;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class BinarySearchTreeTester {

	BinarySearchTree<Integer> tree;
	BinarySearchTree<Integer> expectedTree;
	BinarySearchTree<Integer> blankTree;
	
	@BeforeEach
	void setUp() throws Exception {
		tree = new BinarySearchTree<>();
		
		tree.add(10);
		tree.add(7);
		tree.add(12);
		tree.add(4);
		tree.add(20);
		tree.add(6);
		tree.add(15);
		tree.add(8);
		tree.add(13);
		tree.add(5);
		tree.add(24);
		
		blankTree = new BinarySearchTree<>();
	}
	
	@Test
	void testAddRoot() {
		
	}
	
	@Test
	void testAddLessThanRoot() {
		
	}
	
	@Test
	void testAddGreaterThanRoot() {
		
	}
	
	@Test
	void testAddDuplicate() {
		
	}
	
	@Test
	void testAddAllToExisting() {
		
	}
	
	@Test
	void testAddAllToBlank() {
		
	}
	
	@Test
	void testAddAllNothing() {
		
	}
	
	@Test
	void testAddAllDuplicates() {
		
	}
	
	@Test
	void testClearFromExisting() {
		
	}
	
	@Test
	void testClearFromBlank() {
		
	}
	
	@Test
	void testContainsFromExisting() {
		
	}
	
	@Test
	void testContainsFromBlank() {
		
	}
	
	@Test
	void testContainsRoot() {
		
	}
	
	@Test
	void testContainsAllSample() {
		
	}
	
	@Test
	void testContainsAllWhole() {
		
	}
	
	@Test
	void testContainsAllFromBlank() {
		
	}
	
	@Test
	void testContainsAllNothing() {
		
	}
	
	@Test
	void testContainsAllRoot() {
		
	}
	
	@Test
	void testContainsAllExtraneous() {
		
	}
	
	@Test
	void testFirstFromExisting() {
		
	}
	
	@Test
	void testFirstFromBlank() {
		
	}
	
	@Test
	void testFirstRoot() {
		
	}
	
	@Test
	void testLastFromExisting() {
		
	}
	
	@Test
	void testLastFromBlank() {
		
	}
	
	@Test
	void testLastRoot() {
		
	}
	
	@Test
	void testRemoveFromBlank() {
		assertFalse(blankTree.remove(1));
	}
	
	@Test
	void testRemoveRoot() {
		tree.remove(10);
		
		expectedTree = new BinarySearchTree<>();
		
		expectedTree.add(7);
		expectedTree.add(12);
		expectedTree.add(4);
		expectedTree.add(20);
		expectedTree.add(6);
		expectedTree.add(15);
		expectedTree.add(8);
		expectedTree.add(13);
		expectedTree.add(5);
		expectedTree.add(24);
		
		assertEquals(expectedTree.toArrayList(), tree.toArrayList());
	}

	@Test //You forgot to test removing elements not present in the BST
	void testRemoveNonexistentElements() {
	
		expectedTree = new BinarySearchTree<>();
		expectedTree.add(10);
		expectedTree.add(7);
		expectedTree.add(12);
		expectedTree.add(4);
		expectedTree.add(20);
		expectedTree.add(6);
		expectedTree.add(15);
		expectedTree.add(8);
		expectedTree.add(13);
		expectedTree.add(5);
		expectedTree.add(24);
		
		tree.remove(40);
		tree.remove(30);
		tree.remove(60);
		
		assertEquals(expectedTree.toArrayList(), tree.toArrayList());
	}
	
	@Test
	void testRemoveMultipleRoots() {
		tree.remove(10);
		tree.remove(12);
		tree.remove(13);
		
		expectedTree = new BinarySearchTree<>();
		
		expectedTree.add(7);
		expectedTree.add(4);
		expectedTree.add(20);
		expectedTree.add(6);
		expectedTree.add(15);
		expectedTree.add(8);
		expectedTree.add(5);
		expectedTree.add(24);
		
		assertEquals(expectedTree.toArrayList(), tree.toArrayList());
	}
	
	@Test
	void testRemoveLeftLeaf() {
		tree.remove(13);
		
		expectedTree = new BinarySearchTree<>();
		
		expectedTree.add(10);
		expectedTree.add(7);
		expectedTree.add(12);
		expectedTree.add(4);
		expectedTree.add(20);
		expectedTree.add(6);
		expectedTree.add(15);
		expectedTree.add(8);
		expectedTree.add(5);
		expectedTree.add(24);
		
		assertEquals(expectedTree.toArrayList(), tree.toArrayList());
	}
	
	@Test
	void testRemoveRightLeaf() {
		tree.remove(8);
		
		expectedTree = new BinarySearchTree<>();
		
		expectedTree.add(10);
		expectedTree.add(7);
		expectedTree.add(12);
		expectedTree.add(4);
		expectedTree.add(20);
		expectedTree.add(6);
		expectedTree.add(15);
		expectedTree.add(13);
		expectedTree.add(5);
		expectedTree.add(24);
		
		assertEquals(expectedTree.toArrayList(), tree.toArrayList());
	}
	
	@Test
	void testRemoveLeftBranchLeftChild() {
		tree.remove(15);
		
		expectedTree = new BinarySearchTree<>();
		
		expectedTree.add(10);
		expectedTree.add(7);
		expectedTree.add(12);
		expectedTree.add(4);
		expectedTree.add(20);
		expectedTree.add(6);
		expectedTree.add(8);
		expectedTree.add(13);
		expectedTree.add(5);
		expectedTree.add(24);
		
		assertEquals(expectedTree.toArrayList(), tree.toArrayList());
	}
	
	@Test
	void testRemoveLeftBranchRightChild() {
		tree.remove(4);
		
		expectedTree = new BinarySearchTree<>();
		
		expectedTree.add(10);
		expectedTree.add(7);
		expectedTree.add(12);
		expectedTree.add(20);
		expectedTree.add(6);
		expectedTree.add(15);
		expectedTree.add(8);
		expectedTree.add(13);
		expectedTree.add(5);
		expectedTree.add(24);
		
		assertEquals(expectedTree.toArrayList(), tree.toArrayList());
	}
	
	@Test
	void testRemoveRightBranchLeftChild() {
		tree.remove(6);
		
		expectedTree = new BinarySearchTree<>();
		
		expectedTree.add(10);
		expectedTree.add(7);
		expectedTree.add(12);
		expectedTree.add(4);
		expectedTree.add(20);
		expectedTree.add(15);
		expectedTree.add(8);
		expectedTree.add(13);
		expectedTree.add(5);
		expectedTree.add(24);
		
		assertEquals(expectedTree.toArrayList(), tree.toArrayList());
	}
	
	@Test
	void testRemoveRightBranchRightChild() {
		tree.remove(12);
		
		expectedTree = new BinarySearchTree<>();
		
		expectedTree.add(10);
		expectedTree.add(7);
		expectedTree.add(4);
		expectedTree.add(20);
		expectedTree.add(6);
		expectedTree.add(15);
		expectedTree.add(8);
		expectedTree.add(13);
		expectedTree.add(5);
		expectedTree.add(24);
		
		assertEquals(expectedTree.toArrayList(), tree.toArrayList());
	}
	
	@Test
	void testRemoveLeftParent() {
		tree.remove(7);
		
		expectedTree = new BinarySearchTree<>();
		
		expectedTree.add(10);
		expectedTree.add(12);
		expectedTree.add(4);
		expectedTree.add(20);
		expectedTree.add(6);
		expectedTree.add(15);
		expectedTree.add(8);
		expectedTree.add(13);
		expectedTree.add(5);
		expectedTree.add(24);
		
		assertEquals(expectedTree.toArrayList(), tree.toArrayList());
	}
	
	@Test
	void testRemoveRightParent() {
		tree.remove(20);
		
		expectedTree = new BinarySearchTree<>();
		
		expectedTree.add(10);
		expectedTree.add(7);
		expectedTree.add(12);
		expectedTree.add(4);
		expectedTree.add(6);
		expectedTree.add(15);
		expectedTree.add(8);
		expectedTree.add(13);
		expectedTree.add(5);
		expectedTree.add(24);
		
		assertEquals(expectedTree.toArrayList(), tree.toArrayList());
	}
	
	@Test
	void testRemoveAllSample() {
		ArrayList<Integer> toRemove = new ArrayList<>();
		
		toRemove.add(4);
		toRemove.add(8);
		toRemove.add(20);
		
		tree.removeAll(toRemove);
		
		expectedTree = new BinarySearchTree<>();
		
		expectedTree.add(10);
		expectedTree.add(7);
		expectedTree.add(12);
		expectedTree.add(6);
		expectedTree.add(15);
		expectedTree.add(13);
		expectedTree.add(5);
		expectedTree.add(24);
		
		assertEquals(expectedTree.toArrayList(), tree.toArrayList());
	}
	
	@Test
	void testRemoveAllWhole() {
		ArrayList<Integer> toRemove = new ArrayList<>();
		
		toRemove.add(10);
		toRemove.add(7);
		toRemove.add(12);
		toRemove.add(4);
		toRemove.add(20);
		toRemove.add(6);
		toRemove.add(15);
		toRemove.add(8);
		toRemove.add(13);
		toRemove.add(5);
		toRemove.add(24);
		
		tree.removeAll(toRemove);
		
		expectedTree = new BinarySearchTree<>();
		
		assertEquals(expectedTree.toArrayList(), tree.toArrayList());
	}
	
	@Test
	void testRemoveAllUnbalanced() {
		ArrayList<Integer> toRemove = new ArrayList<>();
		
		toRemove.add(5);
		toRemove.add(4);
		toRemove.add(3);
		toRemove.add(2);
		toRemove.add(1);
		
		BinarySearchTree<Integer> rightUnbalanced = new BinarySearchTree<>();
		
		rightUnbalanced.add(1);
		rightUnbalanced.add(2);
		rightUnbalanced.add(3);
		rightUnbalanced.add(4);
		rightUnbalanced.add(5);
		
		rightUnbalanced.removeAll(toRemove);
		
		BinarySearchTree<Integer> expectedTree = new BinarySearchTree<>();
		
		assertEquals(expectedTree.toArrayList(), rightUnbalanced.toArrayList());
	}
	
	@Test
	void testRemoveAllFromBlank() {
		ArrayList<Integer> toRemove = new ArrayList<>();
		
		toRemove.add(1);
		
		assertFalse(blankTree.removeAll(toRemove));
	}
	
	@Test
	void testRemoveAllNothing() {
		ArrayList<Integer> toRemove = new ArrayList<>();
		
		assertFalse(tree.removeAll(toRemove));
	}
	
	@Test
	void testRemoveAllRoot() {
		ArrayList<Integer> toRemove = new ArrayList<>();
		
		toRemove.add(10);
		
		tree.removeAll(toRemove);
		
		expectedTree = new BinarySearchTree<>();
		
		expectedTree.add(7);
		expectedTree.add(12);
		expectedTree.add(4);
		expectedTree.add(20);
		expectedTree.add(6);
		expectedTree.add(15);
		expectedTree.add(8);
		expectedTree.add(13);
		expectedTree.add(5);
		expectedTree.add(24);
		
		assertEquals(expectedTree.toArrayList(), tree.toArrayList());
	}
	
	@Test
	void testToArrayListFromExisting() {
		ArrayList<Integer> expectedList = new ArrayList<>();
		
		expectedList.add(4);
		expectedList.add(5);
		expectedList.add(6);
		expectedList.add(7);
		expectedList.add(8);
		expectedList.add(10);
		expectedList.add(12);
		expectedList.add(13);
		expectedList.add(15);
		expectedList.add(20);
		expectedList.add(24);
		
		assertEquals(expectedList, tree.toArrayList());
	}
	
	@Test
	void testToArrayListFromBlank() {
		ArrayList<Integer> blankList = new ArrayList<>();
		
		assertEquals(blankList, blankTree.toArrayList());
	}
	
	@Test
	void testToArrayListRoot() {
		BinarySearchTree<Integer> root = new BinarySearchTree<>();
		
		root.add(1);
		
		ArrayList<Integer> expectedList = new ArrayList<>();
		
		expectedList.add(1);
		
		assertEquals(expectedList, root.toArrayList());
	}
}
