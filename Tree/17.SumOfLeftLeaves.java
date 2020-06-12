/*
		Here basic idea is , sum of leftSum( root.left ) + Leftsum( root.right )
		Then base case , if( root == null ) return 0 ;
		Action case , if(root.left != null & root.left is also the leaf node )
		then do the calculation.

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
	
  public int sumOfLeftLeaves(TreeNode root) 
  {
    	if( root == null )
    			return 0 ;

    	if( root.left != null && root.left.left == null && root.left.right == null )
    			return root.left.val + sumOfLeftLeaves( root.right ) ;

    	else return sumOfLeftLeaves( root.left ) + sumOfLeftLeaves( root.right ) ;
  }
 
}