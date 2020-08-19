/*
		Don't get scared by two recurrence . 
		Understand the Concept. You will Enjoy! .


*/




class Solution 
{
	int total = 0 ; 

  public int pathSum(TreeNode root, int sum) 
  {
	  	if( root == null ) 
	  			return 0 ;

	  	findPathSum( root , sum , 0 ) ; 
	  	pathSum( root.left , sum ) ;
	  	pathSum( root.right, sum ) ;

	  return total ;    
  }

  public void findPathSum( TreeNode root , int sum , int curSum )
  {
  	if( root == null )
  			 		return ; 

  	curSum += root.val ; 

  	if( sum == curSum ) 
  					total++ ; 

  	findPathSum( root.left , sum , curSum ) ;
  	findPathSum( root.right, sum , curSum ) ;
  }

}