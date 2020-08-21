/*
		Very Good Question! .

		Understood the question . 
		Reference : https://www.youtube.com/watch?v=poOw9DDMZKw&t=616s
		But gives TLE Error .

		Optimization Technique : https://www.youtube.com/watch?v=le-ZZSQRebw
		Here , we use Pair because using pair we can save the TreeNode and the index .


*/

/* Optimized Version ! */
class Solution 
{
  public int widthOfBinaryTree(TreeNode root) 
  {
  	if( root == null ) return  0 ;

    int max = 1 ; 

    /*
    	 We use Deque so that we can get element from both start and end of the Queue using methods
			 getFirst() and getLast() .
    */

    Deque<Pair<TreeNode,Integer>> queue = new LinkedList<Pair<TreeNode,Integer>>() ; 
    queue.offer( new Pair( root , 0 ) ) ;

	    while( !queue.isEmpty() ) 
	    {
	    	int size  = queue.size() ;
	    	Pair<TreeNode,Integer> first = queue.getFirst() ; 
	    	Pair<TreeNode,Integer> last = queue.getLast() ;  

	    	max = Math.max( max , last.getValue() - first.getValue() + 1 ) ; 

	    		for( int i = 0 ; i < size ; i++ )
	    		{
	    			Pair<TreeNode,Integer>curr = queue.poll() ;
	    			 
	    			TreeNode node = curr.getKey() ; 
	    			
	    			if( node.left != null )
	    						queue.offer( new Pair( node.left , (2 * curr.getValue() ) ) ) ; 

	    			if( node.right != null )
	    						queue.offer( new Pair( node.right , (2 * curr.getValue()) + 1 ) ) ;
	    		
	    		}

	    }
	  return max ;
  }
}

/* Approach 1 : Gives TLE Error in some cases.*/


class Solution 
{
  public int widthOfBinaryTree(TreeNode root) 
  {
  	if( root == null ) return  0 ;

    int max = 1 ; 

    Deque<TreeNode> dq = new LinkedList<>() ; 
    dq.add( root ) ;

      while( !dq.isEmpty() )
      {
      	while( !dq.isEmpty() && dq.getFirst() == null ) dq.removeFirst() ;
      	while( !dq.isEmpty() && dq.getLast()  == null ) dq.removeLast()  ;

      	int size = dq.size() ; 
      	max = Math.max( max , dq.size() ) ; 

      		for( int i = 0 ; i < size ; i++ )
      		{
      			TreeNode curNode = dq.poll() ; 

	      			if( curNode == null )
	      			{
	      					dq.add( null ) ; 
	      					dq.add( null ) ; 
	      			}
	      			else
	      			{
	      				dq.add( curNode.left  ) ;
	      				dq.add( curNode.right ) ;
	      			}
      		}
      }
    return max ;
  }

}







