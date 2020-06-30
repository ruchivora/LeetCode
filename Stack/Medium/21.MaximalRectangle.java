/*
		Reference : https://www.youtube.com/watch?v=St0Jf_VmG_g&t=9s
*/
class Solution {
  public int maximalRectangle(char[][] matrix) 
  {
  		if( matrix.length == 0 ) return 0 ;

    	int maxArea = 0 ;
    	int dummy[] = new int[ matrix[0].length ] ;

    	for( int i = 0 ; i < matrix[0].length ; i++ )
    					dummy[i] = matrix[0][i] - '0' ;

    	int area = calArea( dummy ) ;
    	maxArea = ( maxArea > area ) ? maxArea : area ;

    	for( int i = 1 ; i < matrix.length ; i++ )
    	{
    			for( int j = 0 ; j < matrix[0].length ; j++ )
    			{
    				if( matrix[i][j] == '0' )
    							dummy[j] = 0 ;
    				else
    				{
    					int x = matrix[i][j] - '0' ;
    					dummy[j] = dummy[j] + x ;
    				}
    			}
    		area = calArea( dummy ) ;
    		maxArea = ( maxArea > area ) ? maxArea : area ;
    	}
    return maxArea ;    
  }

	public int calArea( int input[] )
  {
  	 int leftEle[]  = new int [input.length] ;
  	 int rightEle[] = new int [input.length] ;
  	 Stack<Integer> stack = new Stack<Integer>() ;
  	 int maxArea = 0 ;
 
  	 for( int i = 0 ; i < input.length ; i++ )
  	 {

  	 		if( stack.isEmpty() || input[i] == 0 )
  	 			leftEle[i] = i ;
  	 		else
  	 		{
  	 				while( !stack.isEmpty() && input[stack.peek()] >= input[i] )
  	 									stack.pop() ;
  	 				if( stack.isEmpty() )
  	 						leftEle[i] = 0 ;
  	 				else
  	 						leftEle[i] = stack.peek() + 1 ;
  	 		}
  	 		stack.push( i ) ;	
  	 }

  	 while( !stack.isEmpty() )
  	 					stack.pop() ;

  	 for( int i = input.length-1 ; i >= 0 ; i-- )
  	 {
  	 		if( stack.isEmpty() || input[i] == 0 )
  	 			  rightEle[i] = i ;
  	 		else
  	 		{
  	 				while( !stack.isEmpty() && input[stack.peek()] >= input[i] )
  	 									stack.pop() ;
  	 				if( stack.isEmpty() )
  	 						rightEle[i] = input.length - 1 ;
  	 				else
  	 						rightEle[i] = stack.peek() - 1 ;
  	 		}
  	 		stack.push( i ) ;	
  	 }

  	 for( int i = 0 ; i < input.length ; i++ )
  	 {
  	 		int area = ( rightEle[i] - leftEle[i] + 1 ) * input[i] ;
  	 		maxArea  = ( maxArea > area ) ? maxArea : area ;
  	 }
   return maxArea ;
  }
}