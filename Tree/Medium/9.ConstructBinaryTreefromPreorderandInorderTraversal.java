/*

		Take the reference of previous Questions .
	
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
class Solution 
{
    public TreeNode buildTree(int[] preorder, int[] inorder) 
    { 
        int len = preorder.length ; 
    	return helper( preorder, inorder , 0 , len - 1 , 0 , len - 1 ) ;
    }
    
    public TreeNode helper( int[] preorder , int[] inorder , int preStart , int preEnd , int inStart , int inEnd )
    {
	    	if( inStart > inEnd ) return null ;

	    	TreeNode root = new TreeNode( preorder[preStart] ) ;

	    	int rootIndex = 0 ;

	    	for( int i = inStart ; i <= inEnd ; i++ )
	    	{
		    		if( inorder[i] == root.val )
		    		{
		    				rootIndex = i ; 
		    				break ;
		    		}			
	    	}

	    	int leftTreeSize  = rootIndex - inStart ; 
	    	int rightTreeSize = inEnd - rootIndex ;

	    	root.left  = helper( preorder , inorder , preStart + 1 , preStart + leftTreeSize , inStart , rootIndex - 1 ) ;
	    	root.right = helper( preorder , inorder , preEnd - rightTreeSize + 1 , preEnd  , rootIndex + 1 , inEnd ) ;
	    
	 	 return root ;

    }
}