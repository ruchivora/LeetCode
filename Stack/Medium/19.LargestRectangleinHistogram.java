/*
		Solution : 1. First find nearest smallest element to the left .
							 2. Find nearest smallest element to the right .
							 3. Then calculate the area .

*/
class Solution {
    public int largestRectangleArea(int[] heights) 
    {
        Stack<Integer> stack = new Stack<Integer>() ;
        int leftElement[]    = new int[ heights.length ] ;
        int rightElement[]   = new int[ heights.length ] ;
        int maxArea = 0 ;

        for( int  i = 0 ; i < heights.length ; i++ )
        {
        	if( stack.isEmpty() )
        			leftElement[i] = i ;
        	else
        		{
        				int peek = 0 ; 
        			while( !stack.isEmpty() && heights[ stack.peek() ] >= heights[i] )
        			        	peek = stack.pop() ;
        			
        			if( stack.isEmpty() )
        						leftElement[i] = 0 ;
        			else
        					leftElement[i] = stack.peek() + 1 ;
        		}
        	stack.push(i) ;
        }

        while( !stack.isEmpty() )
        				stack.pop() ;

        for( int i = heights.length-1 ; i >= 0 ; i-- )
        {
        	if( stack.isEmpty() )
        			rightElement[i] = i ;
        	else
        		{
        				int peek = 0 ; 
        			while( !stack.isEmpty() && heights[ stack.peek() ] >= heights[i] )
        			        	peek = stack.pop() ;
        			
        			if( stack.isEmpty() )
        						rightElement[i] = heights.length - 1 ;
        			else
        					rightElement[i] = stack.peek() - 1 ;
        		}
        	stack.push(i) ;
        }

        for( int i = 0 ; i < heights.length ; i++ )
        {
        	int area = ( rightElement[i] - leftElement[i] + 1 ) * heights[i] ;
        	maxArea  = ( maxArea > area ) ? maxArea : area ;
        }

  	return maxArea ;
  }
}