/*
		The Question is based on BFS .

		Logic : Do Level Order Traversal and add the elements 
						in the result . 

		Similarly , using level Order Traversal we can find
		left view of the tree .

		Reference : https://www.youtube.com/watch?v=eBdKNoW3VJg

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
class Solution {

  public List<Integer> rightSideView( TreeNode root ) 
  {
	  	List<Integer> result = new ArrayList<Integer>() ;

	  	if( root == null ) return result ;

	  	Queue<TreeNode> queue = new LinkedList<TreeNode>() ;
	  	queue.offer( root ) ;

	  	while( !queue.isEmpty() )
	  	{
	  		int size = queue.size() ; 

	  		for( int i = 0 ; i < size ; i++ )
	  		{
	  			TreeNode curr = queue.poll() ;

	  			if( curr.left != null )
	  						queue.offer( curr.left ) ;

	  			if( curr.right != null )
	  						queue.offer( curr.right ) ;

	  			if( i == size - 1 )
	  						result.add( curr.val ) ;
	  		}
	  	}
	  return result ; 	   
  }
}