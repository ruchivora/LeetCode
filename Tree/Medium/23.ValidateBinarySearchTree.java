/*
		Logic 1 : Inorder traversal of the BST leads to sorted array . 
						  So , store elements . And check if the elements are
						  in sorted Order or not . 

						  TC : O( N )  SC : O( N )

		Optimization : Can store previous value and check if the current element is
									 greater than previous Element . 

		Logic 2 : You can use Min , Max Logic . 
							TC : O( N ) , SC : O(1) . 
		Reference : https://www.youtube.com/watch?v=TKvbwPIOGCM&t=1s

		I have tried the second Logic but should also try out first Logic . 

*/

class Solution 
{
  public boolean isValidBST(TreeNode root) 
  {
      if( root == null )
     			return true ; 

    return isValidBST( root , Long.MIN_VALUE , Long.MAX_VALUE ) ;
  }

  public boolean isValidBST( TreeNode root , long min , long max )
  {
  		if( root == null )
  				return true ; 

  		if( root.val > min && root.val < max )
  					return ( isValidBST( root.left , min , root.val ) && isValidBST( root.right , root.val , max ) ) ;

  	return false ;
  }
}