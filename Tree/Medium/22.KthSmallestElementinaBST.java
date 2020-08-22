/*
		Solution 1 : Inorder traversal and store the elements in
								 an array . 

		Think : But do you require all the elements ? 
						- Then why are you storing all the elements in a List ? 
						- Optimize it ! . 
*/


/* Storing elements in the List . TC: O(N) , SC: O(N) . */

class Solution 
{
  public int kthSmallest( TreeNode root, int k ) 
  {
  		ArrayList<Integer> list = new ArrayList<Integer>() ; 
      inorder( root , list ) ;

    return list.get( k - 1 ) ; 
  }

  public void inorder( TreeNode root , ArrayList<Integer> list )
  {
  	  if( root == null )
  	 			return  ; 

  	inorder( root.left , list ) ; 
  	list.add( root.val ) ; 
  	inorder( root.right , list ) ;  
  }
}

/* 
		Optimized Version ! . Storing only the kth element .
		TC: O( N )  SC: O(1) 
*/

class Solution 
{
	int count = 0 ; 
	int element = 0 ; 

  public int kthSmallest( TreeNode root , int k ) 
  {
      inorder( root , k ) ; 
    return element ; 
  }

  public void inorder( TreeNode root , int k )
  {
  	if( root == null )
  			return  ; 

  	inorder( root.left , k );
  	count ++ ;

  	if( count == k )
  				element = root.val ; 

  	inorder( root.right , k ) ; 
  }
}