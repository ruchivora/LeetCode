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

	int maxHeight = 0 ;

    public int longestUnivaluePath(TreeNode root) 
    {
    	    
    }

    public int calculateHeight( TreeNode root , int val )
    {


    	if( root.left.val == val )
    	{
    		int height = 1 + calculateHeight( root.left , val ) ;
    		maxHeight  = ( maxHeight > height ) ? maxHeight : height ;
    	}

    	if( root.right.val == val )
    	{
    		int height = 1 + calculateHeight( root.right , val ) ;
    		maxHeight  = ( maxHeight > height ) ? maxHeight : height ;
    	}


    }
}