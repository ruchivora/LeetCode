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

		int sum = 0 ;  

    public int rangeSumBST(TreeNode root, int L, int R) 
    {
        if( root == null ) return 0 ;

        if( root.val >= L && root.val <= R )
        	sum = sum + root.val ;

        if( root.val >= L )
        	rangeSumBST( root.left , L , R ) ;
        
        if( root.val <= R )
          rangeSumBST( root.right , L , R ) ;
        
      return sum ;
    }
}