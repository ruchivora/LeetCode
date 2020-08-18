/*
    Iterative Approach Reference : https://www.youtube.com/watch?v=SiyEwLrPpyQ&t=189s
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

/* Iterative Approach . */

class Solution 
{
	  List<Integer> result = new ArrayList<Integer>() ;
	  Stack<TreeNode> s     = new Stack<TreeNode>() ;

    public List<Integer> inorderTraversal(TreeNode root) 
    {
    		TreeNode p = root ;
        while( true )
        {
        	while( p != null )
        	{
              System.out.println(p.val) ;
        			s.push( p ) ;
        			p = p.left ;
        	}

        	if( s.isEmpty() ) break ;

        	 p = s.pop() ;
        	 result.add( p.val ) ;
        	 p = p.right ;

        }
        return result; 
    }
}