/*
		Inorder by recursion and iterative method.
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
class Solution 
{
		List<Integer> s = new ArrayList<Integer>() ;

    public List<Integer> inorderTraversal(TreeNode root) 
    {
        traverse( root ) ;
        return s ;
    }

    public void traverse(TreeNode root )
    {
    	if( root == null )
    		return ;

    	traverse( root.left ) ;
    	s.add( root.val ) ;
    	traverse( root.right ) ;
    }
}
/*
		Iterative inorder Traversal .
*/
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
        			s.push( p ) ;
        			p = p.left ;
        	}
        	/*
							Here , when the node is null 
							nothing is pushed on to the stack .
        	*/

        	if( s.isEmpty() ) break ;

        	 p = s.pop() ;
        	 result.add( p.val ) ;
        	 p = p.right ;

        }
        return result; 
    }
}