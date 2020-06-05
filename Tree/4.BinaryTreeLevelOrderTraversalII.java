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
/*
	Here to produce the list in reverse order , What we do ?
	Insert into ArrayList only at zeroth Index . 
	So everyting will pushed towards right . 
*/


class Solution {

    public List<List<Integer>> levelOrderBottom(TreeNode root) 
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>() ;

        if( root == null ) return result ;

        Queue<TreeNode> visited = new LinkedList<TreeNode>() ;

        visited.offer( root ) ;

        int size ;

        while( !visited.isEmpty() )
        {
        	size = visited.size() ;
        	ArrayList<Integer> temp = new ArrayList<Integer>() ; 

        	for( int i = 0 ; i < size ; i++ )
        	{
        		TreeNode currNode = visited.poll() ;

        		if( currNode.left != null )  visited.offer( currNode.left ) ;
        		
        		if( currNode.right != null ) visited.offer( currNode.right ) ;

        	    temp.add( currNode.val ) ;	
        	}
        	result.add( 0 , temp ) ;
        } 
       return result ;
    }
}