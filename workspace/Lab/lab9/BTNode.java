package lab9;

import java.io.*;
import java.util.*;

// File: BTNode.java from the package edu.colorado.nodes
// Complete documentation is available from the BTNode link in:
//   http://www.cs.colorado.edu/~main/docs/

//package edu.colorado.nodes;

/******************************************************************************
 * A <CODE>BTNode&lt;<E&gt;</CODE> provides a node for a binary tree. Each node
 * contains a piece of data (which is a reference to an E object) and references
 * to a left and right child. The references to children may be null to indicate
 * that there is no child. The reference stored in a node can also be null.
 *
 * <dl>
 * <dt><b>Limitations:</b>
 * <dd>
 * Beyond <CODE>Int.MAX_VALUE</CODE> elements, <CODE>treeSize</CODE>, is wrong.
 *
 * <dt><b>Java Source Code for this class:</b>
 * <dd>
 * <A HREF="../../../../edu/colorado/nodes/BTNode.java">
 * http://www.cs.colorado.edu/~main/edu/colorado/nodes/BTNode.java </A>
 *
 * @author Michael Main <A HREF="mailto:main@colorado.edu"> (main@colorado.edu)
 *         </A>
 *
 * @version Jul 22, 2005
 ******************************************************************************/
public class BTNode<E> {
	// Invariant of the BTNode<E> class:
	// 1. Each node has one reference to an E Object, stored in the instance
	// variable data.
	// 2. The instance variables left and right are references to the node's
	// left and right children.
	private E data;
	private BTNode<E> left, right;

	/**
	 * Initialize a <CODE>BTNode</CODE> with a specified initial data and links
	 * children. Note that a child link may be the null reference, which
	 * indicates that the new node does not have that child.
	 * 
	 * @param <CODE>initialData</CODE> the initial data of this new node
	 * @param <CODE>initialLeft</CODE> a reference to the left child of this new
	 *        node--this reference may be null to indicate that there is no node
	 *        after this new node.
	 * @param <CODE>initialRight</CODE> a reference to the right child of this
	 *        new node--this reference may be null to indicate that there is no
	 *        node after this new node. <dt><b>Postcondition:</b>
	 *        <dd>
	 *        This node contains the specified data and links to its children.
	 **/
	public BTNode(E initialData, BTNode<E> initialLeft, BTNode<E> initialRight) {
		data = initialData;
		left = initialLeft;
		right = initialRight;
	}

	/**
	 * Accessor method to get the data from this node.
	 * 
	 * @param - none
	 * @return the data from this node
	 **/
	public E getData() {
		return data;
	}

	/**
	 * Accessor method to get a reference to the left child of this node.
	 * 
	 * @param - none
	 * @return a reference to the left child of this node (or the null reference
	 *         if there is no left child)
	 **/
	public BTNode<E> getLeft() {
		return left;
	}

	/**
	 * Accessor method to get the data from the leftmost node of the tree below
	 * this node.
	 * 
	 * @param - none
	 * @return the data from the deepest node that can be reached from this node
	 *         by following left links.
	 **/
	public E getLeftmostData() {
		if (left == null)
			return data;
		else
			return left.getLeftmostData();
	}

	/**
	 * Accessor method to get a reference to the right child of this node.
	 * 
	 * @param - none
	 * @return a reference to the right child of this node (or the null
	 *         reference if there is no right child)
	 **/
	public BTNode<E> getRight() {
		return right;
	}

	/**
	 * Accessor method to get the data from the rightmost node of the tree below
	 * this node.
	 * 
	 * @param - none
	 * @return the data from the deepest node that can be reached from this node
	 *         by following right links.
	 **/
	public E getRightmostData() {
		if (left == null)
			return data;
		else
			return left.getRightmostData();
	}

	/**
	 * Uses an inorder traversal to print the data from each node at or below
	 * this node of the binary tree.
	 * 
	 * @param - none <dt><b>Postcondition:</b>
	 *        <dd>
	 *        The data of this node and all its descendants have been writeen by
	 *        <CODE>System.out.println( )</CODE> using an inorder traversal.
	 **/
	public void inorderPrint() {
		if (left != null)
			left.inorderPrint();
		System.out.println(data);
		if (right != null)
			right.inorderPrint();
	}

	/**
	 * Accessor method to determine whether a node is a leaf.
	 * 
	 * @param - none
	 * @return <CODE>true</CODE> (if this node is a leaf) or <CODE>false</CODE>
	 *         (if this node is not a leaf.
	 **/
	public boolean isLeaf() {
		return (left == null) && (right == null);
	}

	/**
	 * Uses a preorder traversal to print the data from each node at or below
	 * this node of the binary tree.
	 * 
	 * @param - none <dt><b>Postcondition:</b>
	 *        <dd>
	 *        The data of this node and all its descendants have been writeen by
	 *        <CODE>System.out.println( )</CODE> using a preorder traversal.
	 **/
	public void preorderPrint() {
		System.out.println(data);
		if (left != null)
			left.preorderPrint();
		if (right != null)
			right.preorderPrint();
	}

	/**
	 * Uses a postorder traversal to print the data from each node at or below
	 * this node of the binary tree.
	 * 
	 * @param - none <dt><b>Postcondition:</b>
	 *        <dd>
	 *        The data of this node and all its descendants have been writeen by
	 *        <CODE>System.out.println( )</CODE> using a postorder traversal.
	 **/
	public void postorderPrint() {
		if (left != null)
			left.postorderPrint();
		if (right != null)
			right.postorderPrint();
		System.out.println(data);
	}

	/**
	 * Uses an inorder traversal to print the data from each node at or below
	 * this node of the binary tree, with indentations to indicate the depth of
	 * each node.
	 * 
	 * @param <CODE>depth</CODE> the depth of this node (with 0 for root, 1 for
	 *        the root's children, and so on)( <dt><b>Precondition:</b>
	 *        <dd>
	 *        <CODE>depth</CODE> is the depth of this node.
	 *        <dt><b>Postcondition:</b>
	 *        <dd>
	 *        The data of this node and all its descendants have been writeen by
	 *        <CODE>System.out.println( )</CODE> using an inorder traversal. The
	 *        indentation of each line of data is four times its depth in the
	 *        tree. A dash "--" is printed at any place where a child has no
	 *        sibling.
	 **/
	public void print(int depth) {
		int i;

		// Print the indentation and the data from the current node:
		for (i = 1; i <= depth; i++)
			System.out.print("    ");
		System.out.println(data);

		// Print the left subtree (or a dash if there is a right child and no
		// left child)
		if (left != null)
			left.print(depth + 1);
		else if (right != null) {
			for (i = 1; i <= depth + 1; i++)
				System.out.print("    ");
			System.out.println("--");
		}

		// Print the right subtree (or a dash if there is a left child and no
		// left child)
		if (right != null)
			right.print(depth + 1);
		else if (left != null) {
			for (i = 1; i <= depth + 1; i++)
				System.out.print("    ");
			System.out.println("--");
		}
	}

	/**
	 * Remove the leftmost most node of the tree with this node as its root.
	 * 
	 * @param - none <dt><b>Postcondition:</b>
	 *        <dd>
	 *        The tree starting at this node has had its leftmost node removed
	 *        (i.e., the deepest node that can be reached by following left
	 *        links). The return value is a reference to the root of the new
	 *        (smaller) tree. This return value could be null if the original
	 *        tree had only one node (since that one node has now been removed).
	 **/
	public BTNode<E> removeLeftmost() {
		if (left == null)
			return right;
		else {
			left = left.removeLeftmost();
			return this;
		}
	}

	/**
	 * Remove the rightmost most node of the tree with this node as its root.
	 * 
	 * @param - none <dt><b>Postcondition:</b>
	 *        <dd>
	 *        The tree starting at this node has had its rightmost node removed
	 *        (i.e., the deepest node that can be reached by following right
	 *        links). The return value is a reference to the root of the new
	 *        (smaller) tree. This return value could be null if the original
	 *        tree had only one node (since that one node has now been removed).
	 **/
	public BTNode<E> removeRightmost() {
		if (right == null)
			return left;
		else {
			right = right.removeRightmost();
			return this;
		}
	}

	/**
	 * Modification method to set the data in this node.
	 * 
	 * @param <CODE>newData</CODE> the new data to place in this node <dt>
	 *        <b>Postcondition:</b>
	 *        <dd>
	 *        The data of this node has been set to <CODE>newData</CODE>.
	 **/
	public void setData(E newData) {
		data = newData;
	}

	/**
	 * Modification method to set the link to the left child of this node.
	 * 
	 * @param <CODE>newLeft</CODE> a reference to the node that should appear as
	 *        the left child of this node (or the null reference if there is no
	 *        left child for this node) <dt><b>Postcondition:</b>
	 *        <dd>
	 *        The link to the left child of this node has been set to
	 *        <CODE>newLeft</CODE>. Any other node (that used to be the left
	 *        child) is no longer connected to this node.
	 **/
	public void setLeft(BTNode<E> newLeft) {
		left = newLeft;
	}

	/**
	 * Modification method to set the link to the right child of this node.
	 * 
	 * @param <CODE>newLeft</CODE> a reference to the node that should appear as
	 *        the right child of this node (or the null reference if there is no
	 *        right child for this node) <dt><b>Postcondition:</b>
	 *        <dd>
	 *        The link to the right child of this node has been set to
	 *        <CODE>newRight</CODE>. Any other node (that used to be the right
	 *        child) is no longer connected to this node.
	 **/
	public void setRight(BTNode<E> newRight) {
		right = newRight;
	}

	/**
	 * Copy a binary tree.
	 * 
	 * @param <CODE>source</CODE> a reference to the root of a binary tree that
	 *        will be copied (which may be an empty tree where
	 *        <CODE>source</CODE> is null)
	 * @return The method has made a copy of the binary tree starting at
	 *         <CODE>source</CODE>. The return value is a reference to the root
	 *         of the copy.
	 * @exception OutOfMemoryError
	 *                Indicates that there is insufficient memory for the new
	 *                tree.
	 **/
	public static <E> BTNode<E> treeCopy(BTNode<E> source) {
		BTNode<E> leftCopy, rightCopy;

		if (source == null)
			return null;
		else {
			leftCopy = treeCopy(source.left);
			rightCopy = treeCopy(source.right);
			return new BTNode<E>(source.data, leftCopy, rightCopy);
		}
	}

	/**
	 * Count the number of nodes in a binary tree.
	 * 
	 * @param <CODE>root</CODE> a reference to the root of a binary tree (which
	 *        may be an empty tree where <CODE>source</CODE> is null)
	 * @return the number of nodes in the binary tree <dt><b>Note:</b>
	 *         <dd>
	 *         A wrong answer occurs for trees larger than
	 *         <CODE>INT.MAX_VALUE</CODE>.
	 **/
	public static <E> long treeSize(BTNode<E> root) {
		if (root == null)
			return 0;
		else
			return 1 + treeSize(root.left) + treeSize(root.right);
	}

	/**
	 * Ouput all the leaves in the binary tree with this node as its root
	 */
	public void printLeaves() {
		BTNode<E> root = this;
		if (root == null) {
			System.out.println("Root is null");
		} else {
			if (!root.isLeaf()) {
				if (root.getLeft() != null) {
					root.getLeft().printLeaves();
				}
				if (root.getRight() != null) {
					root.getRight().printLeaves();
				}
			} else {
				System.out.println(root.getData());
			}
		}
	}

	/**
	 * Build a tree which representation starts on the next line in input
	 * 
	 * @param input
	 *            - stream of Scanner class which is connected to a text file
	 *            for reading
	 * @return the root of the built tree
	 */
	public static BTNode<String> readFromFile(Scanner input) {
		input = new Scanner(System.in);
		System.out.print("Please enter file name: ");
		String filename = input.next();
		try {
			input = new Scanner(new FileInputStream(filename));
		} catch (FileNotFoundException fnfe) {
			System.out.println("File " + filename
					+ " was not found or could not be opened.");
			System.exit(0);
		}

		BTNode<String> root = null;
		if (input.hasNext()) {
			String line = input.nextLine();
			root = new BTNode<String>(line, null, null);
			System.out.println("Line is " + line);
		}
		while (input.hasNext()) {
			String line1 = input.nextLine();
			System.out.println("Line1 is " + line1);
			BTNode<String> node = new BTNode<String>(line1, null, null);

			if (line1.startsWith("?")) {
				String q = line1.substring(1);
				node = new BTNode<String>(q, null, null);
			}
			if (root.getLeft() == null) {
				root.setLeft(node);
			} else {
				root.setRight(node);
			}

			// if(line1.startsWith("?")) {
			// BTNode<String> nonleaf = new BTNode<String>(line1, null, null);
			// leaf = false;
			// }
			// else {
			// BTNode<String> leafNode = new BTNode<String>(line1, null, null);
			// leaf = true;
			//
			// }
		}
		return root;
	}

	/**
	 * Write a tree with root to output using tha data format
	 * 
	 * @param output
	 *            - stream of the class PrintWriter which is connected to a text
	 *            file for writing
	 * @param root
	 *            - a root of a knowledge tree
	 */
	public static void writeToFile(PrintWriter output, BTNode<String> root) {

	}

	public static void main(String[] args) {

		BTNode<Integer> root = new BTNode<Integer>(45, null, null);
		BTNode<Integer> childL = new BTNode<Integer>(10, null, null);
		root.setLeft(childL);
		BTNode<Integer> childR = new BTNode<Integer>(53, null, null);
		root.setRight(childR);
		// root.print(1);
		// root.printLeaves();
		// root.preorderPrint();
		Scanner input = new Scanner(System.in);
		readFromFile(input);
	}

}
