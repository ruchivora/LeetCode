/*
	Here , the logic is if both p and q are less than root 
	then we need to search in left subtree .

	If both p and q are greater than root 
	then we need to search in right subtree .

	if both the condition fails then in such case 
	we have encountered the ancestor and hence return 
	the root . 
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
    	if( root.val > p && root.val > q )
    		return lowestCommonAncestor( root.left , p , q ) ;

    	if( root.val < p && root.val < q )
    		return lowestCommonAncestor( root.right , p , q ) ;

    	else return root ;

    }
}