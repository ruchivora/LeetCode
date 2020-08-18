/*
		Logic 1 : This is BFS Approach . 
							Calculate the sum at each level and return the
							Sum of the last level .
							TC : O( N ) SC : O( N/2 ) [ Maximum number of nodes at the leaf ] 


		Logic 2 : This is DFS Approach .
							Calculate the max Depth of the tree .
							Then using dfs go to that depth and calculate Sum .
							TC : O( 2*N ) [ Each node will be visited Twice ]         
							SC : O(1)
*/

class Solution {
  public int deepestLeavesSum(TreeNode root) 
  {
      if( root == null ) return  0 ; 

      int sum = 0 ; 

      Queue<TreeNode> queue = new LinkedList<TreeNode>() ; 
      queue.offer( root ) ; 

      while( !queue.isEmpty() )
      {
      	int size = queue.size() ; 
      	sum = 0 ; 

	      	for( int i = 0 ; i < size ; i++ )
	      	{
	      		TreeNode curr = queue.poll() ; 

	      		if( curr.left != null )
	      					queue.offer( curr.left ) ;

	      		if( curr.right != null )
	      					queue.offer( curr.right ) ;

	      		sum = sum + curr.val ;
	      	}
      }
    return sum ;
  }
}


/* */

class Solution 
{
	int sum = 0 ;

  public int deepestLeavesSum(TreeNode root) 
  {
      if( root == null ) return 0 ; 

      int maxDepth = calMaxDepth( root ) ;

      deepestLeavesSum( root , 1 , maxDepth ) ;

    return sum ;
  }

  public void deepestLeavesSum( TreeNode root , int curDepth , int maxDepth )
  {
  	if( root == null )
  				return ; 

  	if( root.left == null && root.right == null )
  	{
  		if(  curDepth == maxDepth )
  					sum = sum + root.val ;
  		return ;
  	}	

  	deepestLeavesSum( root.left , curDepth + 1 , maxDepth ) ;
  	deepestLeavesSum( root.right, curDepth + 1 , maxDepth ) ;

  }

  public int calMaxDepth( TreeNode root )
  {
  	if( root == null )
  			return 0 ; 

  	return 1 + Math.max( calMaxDepth( root.left ) , calMaxDepth( root.right ) ) ;
  }
}