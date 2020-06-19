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

      /*
          if( root == null )
              return root ;
          This condition is not required because it will never hit . 
          Why ? If i have a range and i arrive at a node whose left 
          subtree is null , and when you compare the range you will
          find that if the range is greater then current node 
          you will traverse right , if range is smaller than range 
          traverse left , but range won't be lesser .
          Think......... 
      */

    	if( root.val > p.val && root.val > q.val )
    		return lowestCommonAncestor( root.left , p , q ) ;

    	if( root.val < p.val && root.val < q.val )
    		return lowestCommonAncestor( root.right , p , q ) ;

    	else return root ;

    }
}