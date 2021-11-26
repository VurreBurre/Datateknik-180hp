package bst;

import java.util.ArrayList;
import java.util.Comparator;


public class BinarySearchTree<E> {
  BinaryNode<E> root;  // Anv√§nds ocks√• i BSTVisaulizer
  int size;            // Anv√§nds ocks√• i BSTVisaulizer
  private Comparator<E> comparator;
  private ArrayList<E> list = new ArrayList<>();
    
	/**
	 * Constructs an empty binary search tree.
	 */
	@SuppressWarnings("unchecked")
	public BinarySearchTree() {//anv‰nds av de objekt som redan har en en comparable i sig ex. String o integer 
		comparator = (e1, e2) -> ((Comparable<E>) e1).compareTo(e2);
		this.size =0;
		root = null;
		
	}
	
	/**
	 * Constructs an empty binary search tree, sorted according to the specified comparator.
	 */
	public BinarySearchTree(Comparator<E> comparator) { // anv‰nds av "egna" objekt d‰r  man mÂste best‰mma hur de ska comparas
		this.comparator = comparator;
		size = 0;
		root = null;
	}
	
	public static void main(String[] args) {
		BSTVisualizer draw = new BSTVisualizer("tr‰d", 500, 500);
		BinarySearchTree tree1 = new BinarySearchTree<Integer>();
		tree1.add(5);
		tree1.add(9);
		tree1.add(2);
		tree1.add(11);
		tree1.add(14);
		tree1.add(2);
		tree1.add(89);
		tree1.add(6);
		tree1.add(7);
		tree1.rebuild();
		draw.drawTree(tree1);
		tree1.printTree();
	}

	/**
	 * Inserts the specified element in the tree if no duplicate exists.
	 * @param x element to be inserted
	 * @return true if the the element was inserted
	 */
	public boolean add(E x) {
		int temp = size;
	root = addLogic(root, x);
	return !(size == temp);
		}
	
	
	
	private BinaryNode<E> addLogic(BinaryNode<E> root, E x){
		
		if (root == null) {
			size++;
			root = new BinaryNode<> (x);
			return root;
		}
		int result = comparator.compare(x, root.element);
		 if (result==0) return root;
		else if (result < 0) root.left = addLogic(root.left, x);
		else root.right = addLogic(root.right, x);
		return root;
	}
	
	/**
	 * Computes the height of tree.
	 * @return the height of the tree
	 */
	public int height() {
		return rekursionHeight(root);
	}
	
	private int  rekursionHeight(BinaryNode<E> node) {
			if (node == null) {
				return 0;
			}
			return	1 + Math.max(rekursionHeight(node.left),rekursionHeight(node.right));
			}
			

	/**
	 * Returns the number of elements in this tree.
	 * @return the number of elements in this tree
	 */
	public int size() {
		return this.size;
	}
	
	/**
	 * Removes all of the elements from this list.
	 */
	public void clear() {
		this.root = null;
	}
	
	/**
	 * Print tree contents in inorder.
	 */
	public void printTree() {
	printTree( this.root);
	}
	
	
	private void printTree(BinaryNode x) {
		if (x != null) {
			printTree(x.left);
			System.out.println(x.element);
			printTree(x.right);
		}
	}

	/** 
	 * Builds a complete tree from the elements in the tree.
	 */
	public void rebuild() {
		toArray(root, list);
		root =buildTree(list, 0,list.size()-1);
	}
	
	
	/*
	 * Adds all elements from the tree rooted at n in inorder to the list sorted.
	 */
	private void toArray(BinaryNode<E> n, ArrayList<E> sorted) {
			if (!(n == null)) {
				toArray(n.left, list);
				sorted.add(n.element);
				toArray(n.right, list);
			}
			
	}
	
	/*
	 * Builds a complete tree from the elements from position first to 
	 * last in the list sorted.
	 * Elements in the list a are assumed to be in ascending order.
	 * Returns the root of tree.
	 */
	private BinaryNode<E> buildTree(ArrayList<E> list, int first, int last) {
		if (first > last) {
			return null;
		}else {
		BinaryNode<E> node = new BinaryNode <E> (list.get((first+last)/2));
		node.left = buildTree(list, first,((first+last)/2)-1);
		node.right =buildTree(list,((first+last)/2)+1, last);
		return node;
		}
	}
	


	static class BinaryNode<E> {
		E element;
		BinaryNode<E> left;
		BinaryNode<E> right;

		private BinaryNode(E element) {
			this.element = element;
		}	
	}

	
}
