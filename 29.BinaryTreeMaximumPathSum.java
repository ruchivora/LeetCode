/*
	Binary tree maximum path sum .
	strategy used : Perform DFS traversal and calculate .
	Hint : https://www.youtube.com/watch?v=mOdetMWwtoI
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
	
	int max = Integer.MIN_VALUE ;

    public int maxPathSum( TreeNode root ) {
    	dfs( root ) ;
    	return max ;
    }

    public int dfs( TreeNode root )
    {
    	if( root == null )
    		return 0 ;

    	int left   = Math.max( 0 , dfs( root.left )  ) ;
    	int right  = Math.max( 0 , dfs( root.right ) ) ;
    	int sum    = root.val + left + right ;
    	max        = Math.max( sum , max ) ;
    	return Math.max( left , right) + root.val ;
    }

}