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

    List<String> result = new ArrayList<String>() ;

    public List<String> binaryTreePaths(TreeNode root) 
    {
        
        if( root == null ) return result ;

        String currPath = Integer.toString( root.val ) ;

        if( root.left == null && root.right == null )
            result.add( currPath ) ;

        if( root.left != null ) dfs( root.left  , currPath ) ;
        if( root.right != null) dfs( root.right , currPath ) ;

      return result ;
    }

    public void dfs( TreeNode node , String currPath )
    {
        currPath += "->"+node.val ;

        if( node.left == null && node.right == null )
        {
            result.add( currPath ) ;
            return ;
        }

        if( node.left != null ) 
            dfs( node.left , currPath ) ;

        if( node.right != null ) 
            dfs( node.right , currPath ) ;
    }

}