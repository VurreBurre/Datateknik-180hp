package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bst.BinarySearchTree;


class testTree {
private BinarySearchTree <Integer> myTree;
private BinarySearchTree <String> myTree2;



@BeforeEach
void setUp() {
	myTree = new BinarySearchTree<Integer>();
	myTree2 = new BinarySearchTree<String>((String x, String y) -> x.compareTo(y));
}

	@Test
	void testAdd() {
		myTree.add(9);
		myTree.add(10);
		myTree.add(8);
		assertEquals(2, myTree.height(), "Ska vara 2");
		myTree.add(8);
		assertTrue(myTree.add(3), "SKA VARA TRUE");
		assertFalse(myTree.add(3), "SKA VARA FALSE");
		myTree.add(11);
		assertEquals(3, myTree.height(), "Ska vara 3");
		
		
		myTree2.add("a");
		myTree2.add("b");
		assertEquals(2, myTree2.height(), "Ska vara 2");
		assertTrue(myTree2.add("YY"), "SKA VARA True");
		assertFalse(myTree2.add("YY"), "SKA VARA FALSE");
	}
	
	
	@Test
	void testHeight() {
		myTree.add(9);
		myTree.add(10);
		myTree.add(8);
		assertEquals(2, myTree.height(), "Ska vara 2");
		myTree.add(8);
		myTree.add(10);
		assertEquals(2, myTree.height(), "Ska också vara 2");
		
		myTree2.add("j");
		myTree2.add("b");
		myTree2.add("t");
		assertEquals(2, myTree2.height(), "Ska vara 2");
		myTree2.add("a");
		assertEquals(3, myTree2.height(), "Ska vara 3");
		
	}
	
	@Test
	void testClear() {
		myTree.add(9);
		myTree.add(10);
		myTree.add(8);
		myTree.add(3);
		myTree.add(9);
		assertEquals(3, myTree.height(), "Ska vara 3");
		myTree.clear();
		assertEquals(0, myTree.height());
		
		
		myTree2.add("j");
		myTree2.add("b");
		myTree2.add("t");
		myTree2.clear();
		assertEquals(0, myTree2.height());
		
	}
	
	
	@Test
	void testSize() {
		myTree.add(9);
		myTree.add(10);
		myTree.add(8);
		myTree.add(3);
		myTree.add(5);
		assertEquals(5, myTree.size());
		
		myTree2.add("j");
		myTree2.add("b");
		myTree2.add("t");
		assertEquals(3, myTree2.size());
		
		
		
	}
	

	@AfterEach
	void tearDown(){
		myTree = null;
	}

}
