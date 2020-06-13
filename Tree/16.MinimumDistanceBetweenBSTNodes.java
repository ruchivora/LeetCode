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

		int min = Integer.MAX_VALUE ;
		ArrayList<Integer> nodes = new ArrayList<Integer>() ;

    public int minDiffInBST( TreeNode root ) 
    {
    	traverse( root ) ;  

    	for( int i = 0 ; i < nodes.size() - 1 ; i++ )
    	{
    		int diff = Math.abs( nodes.get(i) - nodes.get(i+1) ) ; 
    		min = ( min > diff ) ? diff : min   ;
    	}

    	return min ;
    }

    public void traverse( TreeNode root )
    {
    		if( root == null ) return ;

    		traverse( root.left ) ;
    		nodes.add( root.val ) ;
    		traverse(root.right ) ;
    }
}