/*
			Solution : 1. Calculate maxElement to the left of current element .
								 2. Calculate maxElement to the right of current element .
								 3. Then find Math.min( leftMax[i] , rightMax[i] ) - height[i] .[gives water accumulated]
								 4. Calculate total wate accumulated .
*/
/*
		Much cleaner code .
*/

class Solution {
    public int trap(int[] height) 
    {
    	if( height.length == 0 ) return 0 ; 

    	int leftMax []  = new int[height.length] ;
    	int rightMax [] = new int[height.length] ; 

    	int max = 0 ;
    	int ans = 0 ;

    	for( int i = 0 ; i < height.length ; i++ )
    	{
    			leftMax[i] = max ;
    			max = ( max > height[i] ) ? max : height[i] ;
    	}

    	max = 0 ;

    	for( int i = height.length-1 ; i >= 0 ; i-- )
    	{
    			rightMax[i] = max ;
    			max = ( max > height[i] ) ? max : height[i] ;
    	}

    	for( int i = 0 ; i < height.length ; i++ )
    	{
    		if( leftMax[i] != 0 && rightMax[i] != 0 )
    		{
    				int min = Math.min( leftMax[i] , rightMax[i] ) - height[i] ;
    				if( min > 0 ) ans = ans + min ;
    		}
    	}

    return ans ;
    }
}

/*
		Tried to save the space , but readablity of the code is reduced .
*/

class Solution {
    public int trap(int[] height) 
    {
        if( height.length == 0 ) return 0 ;
  
    	/* Greater element to the right*/
    	Stack<Integer> stack = new Stack<Integer>() ;

       for( int i = height.length - 1 ; i >= 0 ; i-- )
       {
       		if( stack.isEmpty() )
       				stack.push(i) ;
       		else if( height[i] >= height[stack.peek()] )
       				 			stack.push(i) ;
       				 
       }

       int leftMax = height[0] ;
       int ans = 0  ;
 
       for( int i = 1 ; i < height.length - 1 ; i++ )
       {
       		if( stack.peek() == i-1 )
       					stack.pop() ;

       		if( leftMax >= height[i] && height[stack.peek()] >= height[i] )
       		{
 							int diff = Math.min( leftMax , height[stack.peek()] ) - height[i] ;
 							if( diff > 0 ) ans = ans + diff ;
       		}
       		leftMax = ( leftMax > height[i] ) ? leftMax : height[i] ;
       }
			return ans ;
    }
}