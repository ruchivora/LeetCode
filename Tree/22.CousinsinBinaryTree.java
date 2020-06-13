/*
	Thought Process : for both elements x and y 
	I need two parameters => height and parentNode .

	So , to achieve that we need a class that contains this property . 

	Now to calculate this property we need helper method .

	What will be the parameter of the helper method ? 
	Think Iteratively : root(currNode) , value , height , parentNode .

	What will be the base case of helper method ?
	if( root == null ) return null .
	if( root.val == value ) return Pair ;

	otherwise search in left and right subtree .

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


/*
		Beautiful code . 
*/
class Solution {

	class Pair
	{
			int height ;
			TreeNode parent ;

			Pair( int height , TreeNode parent)
			{
				this.height = height ;
				this.parent = parent ;
			}
	}

    public boolean isCousins(TreeNode root, int x, int y) 
    {
        Pair leftPair  = getPair( root , x , null , 0 ) ;
        Pair rightPair = getPair( root , y , null , 0 ) ;

        if( leftPair.height == rightPair.height && leftPair.parent != rightPair.parent)
        	return true ;
      return false ;
    }

    public Pair getPair( TreeNode root , int val , TreeNode parent , int height )
    {
    	if( root == null ) return null ;

    	if( root.val == val )
    	{
    		return new Pair(height , parent) ;
    	}

    	Pair leftPair  = getPair( root.left , val , root , height+1 ) ; 
    	Pair rightPair = getPair( root.right , val , root , height+1 ) ; 

    	return ( leftPair == null ) ? rightPair : leftPair ;
    }
}