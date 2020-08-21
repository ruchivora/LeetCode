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
      List<List<Integer>> result = new ArrayList<List<Integer>>() ;


  public List<List<Integer>> pathSum( TreeNode root, int sum ) 
  {

  	if( root == null ) 
  		return result ;

      ArrayList<Integer> path = new ArrayList<Integer>() ;

      findPath( root , path , sum ) ;

    return result ;

  }

  public void findPath( TreeNode root , ArrayList<Integer> path , int sum )
  {
  		if( root == null )
  					return  ;

  		sum = sum - root.val ; 
  		path.add( root.val ) ; 

  		if( sum == 0 && root.left == null && root.right == null )
  		{
  			result.add( new ArrayList<Integer>(path) ) ; 
  		}

  		findPath( root.left , path , sum ) ;
  		findPath( root.right , path , sum ) ;
  		path.remove( path.size() - 1 ) ; 
  }

}