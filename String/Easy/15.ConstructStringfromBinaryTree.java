/*
	Analysis is very important in this Question .

	In tree always analyse by considering three base case :
	1. If a Node has both left and right child .
	2. If a Node has only right child .
	3. If a Node has only left child  .

	For Base Case in recurrance 
	- Consider tree With just one node  . 
	- Tree with root and one left Node  .
	- Tree with root and one right Node . 

	Reference : https://www.geeksforgeeks.org/binary-tree-string-brackets/#:~:text=Construct%20a%20string%20consists%20of,and%20the%20original%20binary%20tree.
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
	StringBuilder sb = new StringBuilder() ;

  public String tree2str(TreeNode t) 
  {
      preorder( t ) ;
    return sb.toString() ;
  }

  public void preorder( TreeNode root )
  {
  	if( root == null )
  			return  ;

  	sb.append( root.val ) ;

  	if( root.left == null && root.right == null )
  				return  ;

  	sb.append( "(" ) ;
  	preorder( root.left ) ;
  	sb.append( ")" ) ;

  	if( root.right != null )
  	{
  		sb.append( "(" ) ;
  		preorder( root.right ) ;
  		sb.append( ")" ) ;
  	} 
  }

}