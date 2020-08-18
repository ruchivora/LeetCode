/*
		Logic : While solving Tree problems , first
						fix the type of traversal .
						Then use the logic to solve the problem .

		Here , if a node has it's left and right child 
		as null and value of node as 0 then return null 
		otherwise return the curr node . 

		Reference : https://leetcode.com/problems/binary-tree-pruning/discuss/122747/Java-4-lines-Solution-using-Recursion

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  public TreeNode pruneTree(TreeNode root) 
  {
	  	if( root == null ) 
	  			return null ; 

	  	root.left  = pruneTree( root.left  ) ;
	  	root.right = pruneTree( root.right ) ;

  	return ( root.val == 1 || root.left != null || root.right != null ) ? root : null ;
  }
}