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

/*
	Reference : https://www.youtube.com/watch?v=_LJO5nBKC1A&ab_channel=NickWhite
	
	Here the main Hint is , if t1.left is not present then you 
	need not create a new node and then insert the value etc .
	Instead just stores the address of t2.left node in t1.left . 
*/
class Solution {
	
	TreeNode temp ;

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        
    	if( t1 == null )
    		return t2 ;
    	if( t2 == null )
    		return t1 ;

    	t1.val += t2.val ; 

    	t1.left  = mergeTrees( t1.left  , t2.left  ) ;
    	t1.right = mergeTrees( t1.right , t2.right ) ;

    	return t1 ;
    }

   
}
