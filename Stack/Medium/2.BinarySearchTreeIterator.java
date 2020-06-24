/*
	Solution 1 : Since it is a BST so if inorder traversal 
							 is done and corrsp. element is pushed on
							 to the stack , then TC: O(N) and SC: O(N) 

	But question says height of the stack should be equal
	to the height of the tree and not O( N ) .

	Solution 2 : Insert only left nodes of the tree . 
							 Reference : https://www.youtube.com/watch?v=KVyXmNy9zok 
							 TC : O(N) SC : O( Height of the Tree )
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
class BSTIterator {

	Stack<Integer> nodes = new Stack<Integer>() ; 

    public BSTIterator(TreeNode root) 
    {
        traverse( root ) ;
    }
    
    public void traverse( TreeNode root )
    {
    	if( root == null ) return ;

    	traverse( root.right ) ;
    	nodes.push( root.val ) ;
    	traverse(  root.left ) ; 
    } 

    public int next() 
    {
        return nodes.pop() ;
    }
    
    public boolean hasNext() 
    {
        if( !nodes.isEmpty() )
        			return true ;
        else return false ;
    }
}

/*
		Solution 2 : 
*/
class BSTIterator 
{
	Stack<TreeNode> s = new Stack<TreeNode>() ;

    public BSTIterator(TreeNode root) 
    {
        fill( root ) ;
    }
    
    public void fill( TreeNode node )
    {
    		while( node != null )
    		{
    			s.push( node ) ;
    			node = node.left ;
    		}
    }
    
    public int next() 
    {
        TreeNode p = s.pop() ;
        fill( p.right ) ;
        return p.val ;
    }
   
    public boolean hasNext() 
    {
       return !s.isEmpty() ; 
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */