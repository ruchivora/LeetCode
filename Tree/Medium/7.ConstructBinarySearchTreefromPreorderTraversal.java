/*
    Revise this Question !. 

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

    public TreeNode bstFromPreorder(int[] preorder) {
    	return buildTree( preorder , 0 , preorder.length - 1 ) ;
    }

    public TreeNode buildTree( int preorder[] , int left , int right )
    {
     	if( left > right ) return null ;

     	TreeNode root = new TreeNode(preorder[left]) ;

     	int i = left + 1 ;
     	while( i <= right && preorder[i] < preorder[left] )
     	{
     	 	i++ ; 
     	}
     	root.left  = buildTree( preorder , left+1 , i-1) ;
     	root.right = buildTree( preorder , i , right ) ; 

     	return root ;
    } 
}

