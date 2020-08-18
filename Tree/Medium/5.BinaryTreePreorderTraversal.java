/*
		Iterative PreOrderTraversal : https://www.youtube.com/watch?v=VQTF_pRTZek&t=6s

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
	List<Integer> result  = new ArrayList<Integer>() ;
	Stack<TreeNode> stack = new Stack<TreeNode>() ;

    public List<Integer> preorderTraversal(TreeNode root) 
    {
    		TreeNode p = root ; 
    		while( true )
    		{
	    				while( p != null )
	    				{
	    					result.add(p.val) ;
	    					stack.push(p) ;
	    					p = p.left  ;
	    				}

	    				if( stack.isEmpty() ) break ;

	    				p = stack.pop() ;
	    				p = p.right ;
    				}
    		
    	return result ;
    }
}