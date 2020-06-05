class Solution {

	int tilt  = 0 ;

    public int findTilt(TreeNode root) {
        
    	if( root == null ) return 0 ;

    	subTreeSum( root ) ;
    	return tilt ;
    }

    public int subTreeSum( TreeNode root )
    {
    	if( root == null ) return 0 ;

    	int left  = subTreeSum( root.left  ) ; 
    	int right = subTreeSum( root.right ) ;

    	tilt += Math.abs( left - right ) ;

    	return left + right + root.val ; 

    }
}