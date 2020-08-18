/*
    This Question is based on BFS .
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) 
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>() ;
        Queue<TreeNode> visited    = new LinkedList<TreeNode>() ;

        if( root == null ) return result ;

        visited.offer( root ) ;
        int count = 0 ;

        while( !visited.isEmpty() )
        {
        	int size      = visited.size() ;
        	ArrayList<Integer> temp = new ArrayList<Integer>() ;

        	for( int i = 0 ; i < size ; i++)
        	{
        		TreeNode curr = visited.poll() ; 

        		if( curr.left != null  ) visited.offer( curr.left ) ;

        		if( curr.right != null ) visited.offer( curr.right ) ;

        		temp.add(curr.val) ;
        	}

        	if( count % 2 != 0 )
        			Collections.reverse( temp ) ;

        	count++ ;
        	result.add( temp ) ;
        }

      return result ;
    }
}