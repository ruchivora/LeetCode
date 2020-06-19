/*
		Whenever the given tree is BST , the first thing 
		that should come in mind is " Inorder traversal 
		will give the sorted array " .

		The first Solution takes time = O(N) + O(N)
		and space complexity = O(N) .

		which can be further optimized .
	
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

    public boolean findTarget(TreeNode root, int k) 
    {
    	ArrayList<Integer> elements = new ArrayList<Integer>() ;
    	traverse( root , elements ) ;

    		for( int i = 0 ; i < elements.size() ; i++ )
    		{
    				int diff = k - elements.get(i) ;
    				if( diff != elements.get(i) )
    				{
    					if( elements.contains(diff) )
    							return true;
    				}
    		}
    	return false ;  
    }

    public void traverse( TreeNode root , ArrayList<Integer> elements ) 
    {
    		if( root == null ) return ;

    		traverse( root.left , elements ) ;
    		elements.add(root.val) ; 
    		traverse( root.right , elements ) ;
    }
}

/*
		Optimized solution
*/

class Solution {

    public boolean findTarget(TreeNode root, int k) 
    {
    	HashSet<Integer> result = new HashSet<Integer>() ;
    	return traverse( root , result , k ) ;
    }

    public boolean traverse( TreeNode root , HashSet<Integer> result ,int k )
    {
    		if( root == null ) return false ;

    		if( result.contains( k - root.val ) )
    				return true ;
    		
    		result.add( root.val ) ;
    		
    		return traverse( root.left , result , k ) || traverse( root.right , result , k ) ;
    }

}