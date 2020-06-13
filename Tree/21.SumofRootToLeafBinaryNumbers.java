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
    public int sumRootToLeaf(TreeNode root) 
    {
      return calculateSum( root , 0 ) ;
    }
    public int calculateSum(TreeNode root , int value )
    {
    	if( root == null ) return 0 ; 

    	value = value*2 + root.val ;

    	if( root.left == null && root.right == null )
    		return value ;

    	return calculateSum( root.left , value ) + calculateSum( root.right , value ) ;

    }
}

