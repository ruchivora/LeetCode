class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
    	return helper( 0 , 0 , inorder.length - 1 , preorder , inorder ) ;

    }
    /* preStart is the index of preorder array . */
    public TreeNode helper( int preStart , int inStart , int inEnd , int[] preorder , int[] inorder )
    {
    		/* Base case for recurrence : When the array is null */
	    	if( inStart > inEnd ) return null ;

	    	TreeNode root = new TreeNode( preorder[preStart] ) ;

	    	int inIndex = 0 ;

	    	for( int i = inStart ; i <= inEnd ; i++ )
	    	{
	    		if( inorder[i] == root.val )
	    					inIndex = i ; 
	    	}

	    	root.left  = helper( preStart + 1 , inStart , inIndex - 1 , preorder , inorder ) ;
	    	root.right = helper( preStart + inIndex - inStart + 1 , inIndex + 1 , inEnd , preorder , inorder ) ;
	    	/* preStart + inIndex - inStart + 1 This bypasses elements of leftSubtree */

	  return root ;

    }
}