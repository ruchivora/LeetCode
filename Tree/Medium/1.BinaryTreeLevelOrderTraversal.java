/*
		Why we don't need Visited Array while doing BFS on Tree ?
		 - Because in tree we know adjacent Nodes but in Graph
		   as the graph is cyclic , we need visited array to keep
		   track of elements adjacent to current element .

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
  public List<List<Integer>> levelOrder(TreeNode root) 
  {
      List<List<Integer>> result = new ArrayList<List<Integer>>() ;

      if( root == null ) return result ;

      Queue<TreeNode> queue = new LinkedList<TreeNode>() ;
      queue.offer( root ) ;

      while( !queue.isEmpty() )
      {
	      	int size = queue.size() ;
	      	ArrayList<Integer> list = new ArrayList<Integer>() ;

	      	for( int i = 0 ; i < size ; i++ )
	      	{
	      		TreeNode curr = queue.poll() ;

	      		if( curr.left != null )
	      					queue.offer( curr.left ) ;

	      		if( curr.right != null )
	      					queue.offer( curr.right ) ;

	      		list.add( curr.val ) ;
	      	}
      	result.add( list ) ; 
      }
    return result ;
  }
}