/*
		Don't get scared by two recurrence . 
		Understand the Concept. You will Enjoy! .
		This problem is similar to SubArraySum Equals K .

		Logic1 : BruteForce 
						- For each node , calculate sum of all 
						  possible paths . 
						- pathSum function Traverses all the 
						  nodes of the Tree. 
						- findPathSum function calculates all
						  possible path sum . 
						- TC : O( N2 ) 

		Logic2 : Optimization . 
		Reference : https://www.youtube.com/watch?v=yyZA4v0x16w

*/



/* Optimization */

class Solution 
{
	int total = 0 ;
  public int pathSum(TreeNode root, int sum) 
  {
      if( root == null ) return 0 ; 

      HashMap<Integer,Integer> map = new HashMap<Integer,Integer>() ; 
      map.put( 0 , 1 ) ;
      findPathSum( root , sum , 0 , map ) ;

    return total ;
  }

  public void findPathSum( TreeNode root , int sum , int curSum , HashMap<Integer,Integer> map )
  {
		if( root == null ) return ;

		curSum = curSum + root.val ; 

		if( map.containsKey( curSum - sum ) )
					total = total + map.get( curSum - sum ) ;

		map.put( curSum , map.getOrDefault( curSum , 0 ) + 1 ) ; 

		findPathSum( root.left  , sum , curSum , map ) ; 
		findPathSum( root.right , sum , curSum , map ) ; 

		/* When you do backtracking you have to remove the curSum */

		map.put( curSum , map.get( curSum ) - 1 ) ;
  }
}


/* Brute Force */

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

