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
	
	int ans ;
    public int rangeSumBST(TreeNode root, int L, int R) {
        
        ans = 0 ;

    	if( root == null )
    		return 0 ;

    	return sumBFS(root , L , R ) ;
    }

    public int sumBFS( TreeNode root , int left , int right )
    {
    	if( root != null)
    	{
    		if( root.val >= left && root.val <= right)
    			ans = ans + root.val ;
    		if( root.val >= left)
    			sumBFS( root.left , left , right ) ;
    		if( root.val <= right )
    			sumBFS( root.right , left , right ) ;
    	}
    	return ans ;
    }
}