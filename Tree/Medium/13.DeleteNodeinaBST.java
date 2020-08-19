/*

		Hint : Whenever BST is given , you can search a particular element
		       without using any of the traversal! .

		Recursive Solution : 
		Steps: Recursively find the node that has the same value as the key, 
		while setting the left/right nodes equal to the returned subtree

		Once the node is found, have to handle the below 4 cases
		1. node doesn't have left or right - return null
    2. node only has left subtree- return the left subtree
		3. node only has right subtree- return the right subtree
		4. node has both left and right - find the minimum value in 
			 the right subtree, set that value to the currently found node, 
		   then recursively delete the minimum value in the right subtree .

		Reference : https://leetcode.com/problems/delete-node-in-a-bst/discuss/93296/Recursive-Easy-to-Understand-Java-Solution

		The second Approach also passes all the test cases. But the time 
		Complexity required would be more .
		
*/

class Solution 
{
  public TreeNode deleteNode( TreeNode root, int key ) 
  {
      if( root == null )
      			return null ;

      if( key < root.val )
        			root.left = deleteNode( root.left , key ) ;
      
      else if( key > root.val )
      		 			root.right = deleteNode( root.right , key ) ;
      		 else
      		 {
      		 		if( root.left == null && root.right == null )
      		 					return null ;

      		 		if( root.left == null ) 
      		 					return root.right ;

      		 		else if( root.right == null )
      		 								return root.left ;

      		 		TreeNode minNode = findMin( root.right ) ; 
      		 		root.val         = minNode.val ; 
      		 		/* 
      		 			This part of Logic is very Brilliant . 
      		 			It basically deletes the inorder successor , 
      		 			that we actually used to balance the tree
      		 			after deletion . 
      		 		*/
      		 		root.right       = deleteNode( root.right , root.val ) ;
      		 }
    return root ;
  }

  public TreeNode findMin( TreeNode root )
  {
  		while( root.left != null )
  					root = root.left ;

  	return root ;
  }
}



/* 
		Whenever BST is given , then we know that Inorder traversal will
		give us sorted Array . And we can construct tree from it .

		This method is bit ( Jugaad ! ) . 

		TC : O( 2*N ) SC : O( N ) .

		Here , the main problem is even the node to be deleted is leaf
		we travel whole tree and unnecesaarily create whole tree . 

		Reference : https://www.youtube.com/watch?v=7pu4a5SW9AI&t=262s
*/

class Solution 
{
  public TreeNode deleteNode(TreeNode root, int key) 
  {
      if( root == null ) return null ;  

      ArrayList<Integer> list = new ArrayList<Integer>() ;

      inorder( list , root , key ) ;

   	return buildTree( list , 0 , list.size() - 1 ) ;
  }

  public TreeNode buildTree( ArrayList<Integer> list , int left , int right )
  {
	  	if( left > right ) 
	  				return null ;

	  	int mid = left + ( right - left ) / 2 ;

	  	TreeNode root = new TreeNode( list.get( mid ) ) ;
	  	root.left     = buildTree( list , left , mid - 1  ) ;
	  	root.right    = buildTree( list , mid + 1 , right ) ;

	  return root ;
  } 

  public void inorder( ArrayList<Integer> list , TreeNode root , int key )
  {
  	if( root == null ) 
  			return  ;

  	inorder( list , root.left , key ) ;

  	if( key != root.val )
  				list.add( root.val ) ;

  	inorder( list , root.right , key ) ; 
  }
}