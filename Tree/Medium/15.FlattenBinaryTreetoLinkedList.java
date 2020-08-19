/*
		This is iterative approach . 
		Difficult to do inPlace . 


		Passes all the test case . 
		However this is not inPlace Algorithm . 

		In place Algorithm . 
		Code : https://leetcode.com/problems/flatten-binary-tree-to-linked-list/discuss/36977/My-short-post-order-traversal-Java-solution-for-share
		Reference : https://www.youtube.com/watch?v=598gdjE6Quo&t=385s 


*/



class Solution {
  public void flatten(TreeNode root) 
  {
  		LinkedList<Integer> list = new LinkedList<Integer>() ;

      inorder( root , list ) ;

      if( root != null )
      {
      	root.left  = null ; 
      	root.right = null ;	
      	list.remove( 0 )  ;

      	flattenTree( list , root , 0 ) ;
      } 
  }

  public void inorder( TreeNode root , LinkedList<Integer> list )
  {
  	if( root == null )
  				return ; 

  	list.add( root.val ) ;
    inorder( root.left  , list ) ;
    inorder( root.right , list ) ;

  }

  public TreeNode flattenTree( LinkedList<Integer> list , TreeNode root , int size )
  {
  		if( size == list.size() ) 
  						return null ;

  		TreeNode newNode = new TreeNode( list.get( size ) ) ;
  		newNode.left = null  ;
  		root.right   = newNode ;

  		newNode.right = flattenTree( list , newNode , size + 1 ) ;

  	return newNode ;
  }

}