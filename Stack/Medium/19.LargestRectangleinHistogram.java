class Solution {
    public int largestRectangleArea(int[] heights) 
    {
        Stack<Integer> stack = new Stack<Integer>() ;
        int leftElement[]    = new int[ heights.length ] ;
        int rightElement[]   = new int[ heights.length ] ;

        for( int  i = 0 ; i < heights.length ; i++ )
        {
        	if( stack.isEmpty() )
        			leftElement[i] = i ;
        	else
        		{
        				int peek = 0 ; 
        			while( !stack.isEmpty() && heights[ stack.peek() ] >= heights[i] )
        			        	peek = stack.pop() ;
        			
        			if( !stack.isEmpty() )
        						leftElement[i] = peek ;
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
        			
        			if( !stack.isEmpty() )
        						rightElement[i] = peek ;
        			else
        					rightElement[i] = stack.peek() + 1 ;
        			
        		}
        	stack.push(i) ;
        }
        


        System.out.println( Arrays.toString( leftElement ) ) ;
        System.out.println( Arrays.toString( rightElement) ) ;


      return 0 ;
    }
}