/*
    Logic : I knew the logic . But how to implement ? 

    Reference : https://www.youtube.com/watch?v=0r_cx1c8Z1A

    Here the main task is to set the 8 Pointers .

*/


class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) 
    {
      int len = inorder.length ;
    		return constructTree( inorder , postorder , 0 , len - 1 , 0 , len - 1 ) ;    
    }

    public TreeNode constructTree( int[] inorder , int[] postorder , int inStart , int inEnd , int postStart , int postEnd ) 
    {
    		if( inStart > inEnd ) return null ;

    		TreeNode root = new TreeNode( postorder[postEnd] ) ;

    		int rootIndex = 0 ;

    		for( int i = inStart ; i <= inEnd ; i++ )
    		{
    			 if( inorder[i] == postorder[postEnd] )
           {
              rootIndex = i ; 
              break ;
           } 			
    		} 

        int leftTreeSize  = rootIndex - inStart ;
        int rightTreeSize = inEnd - rootIndex ; 
    		/* The equation postStart+ inIndex - inEnd -1 . This will bypass right subtree elements */
        /* Here we are also dividing postorder  array  */
    		root.left  = constructTree( inorder , postorder , inStart , rootIndex - 1 , postStart , postStart + leftTreeSize - 1 ) ;
    		root.right = constructTree( inorder , postorder , rootIndex + 1 , inEnd , postEnd - rightTreeSize , postEnd - 1 ) ;

    		return root ;
    }    

}