class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) 
    {
    		return constructTree( postorder.length - 1 , 0 , inorder.length - 1 , inorder , postorder ) ;    
    }

    public TreeNode constructTree( int postStart , int inStart , int inEnd , int[] inorder , int[] postorder ) 
    {
    		if( inStart > inEnd ) return null ;

    		TreeNode root = new TreeNode( postorder[postStart] ) ;

    		int inIndex = 0 ;

    		for( int i = inStart ; i <= inEnd ; i++ )
    		{
    			 if( inorder[i] == postorder[postStart] )
    			 			inIndex = i ;
    		} 
    		/* The equation postStart+ inIndex - inEnd -1 . This will bypass right subtree elements */
    		root.left  = constructTree( postStart + inIndex - inEnd - 1 , inStart , inIndex - 1 , inorder , postorder ) ;
    		root.right = constructTree( postStart - 1 , inIndex + 1 , inEnd , inorder , postorder ) ;

    		return root ;
    }    

}