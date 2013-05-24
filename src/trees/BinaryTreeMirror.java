package trees;

import java.util.*;
/*
 * A binary tree is a mirror image of itself if its left and right subtrees are identical mirror images 
 * i.e., the binary tree is symmetrical. 
 * 
 * In a programming language of choice, define a Tree class/C struct 
 * and an associated method to check if the tree is a mirror image.
 * 
 */

public class BinaryTreeMirror {
	static class TreeNode {
		public TreeNode Left;
		public TreeNode Right;
		
		public int Value;
		
		public TreeNode(int value, TreeNode left, TreeNode right) {
			this.Left = left;
			this.Right = right;
			this.Value = value;
		}
		
		public boolean isLeaf() {
			if (Left == null && Right == null) {
				return true;
			}
			return false;
		}
	}
	
	// Formatting base recursion is still bad, took a while to come to the return statement.
	static boolean isTreeMirror(TreeNode treeLeft, TreeNode treeRight) {
		if (treeLeft == null || treeRight == null) {
			return treeLeft == null && treeRight == null;
		}
		
		return (treeLeft.Value == treeRight.Value) 
				&& isTreeMirror(treeLeft.Left, treeRight.Right) 
				&& isTreeMirror(treeLeft.Right, treeRight.Right);
	}
	
	public static void main(String args[]) {
		TreeNode myTree = new TreeNode(5,null,null);
		TreeNode left = new TreeNode(5, null, null);
		TreeNode right = new TreeNode(5, null, null);
		
		myTree.Left = left;
		myTree.Right = right;
		
		System.out.println(isTreeMirror(myTree.Left,myTree.Right));
	}
}
