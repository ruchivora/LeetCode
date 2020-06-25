/*
		Solution :  This problem is based on "Next Greater Element" .
							  So , start from end and insert in stack .
		Reference : https://www.youtube.com/watch?v=WGm4Kj3lhRI
*/

class Solution 
{
    public int[] dailyTemperatures(int[] T) 
    {
        Stack<Integer> stack = new Stack<Integer>() ;
        int result[] = new int[T.length] ;
        int size     = T.length - 1 ;

        for( int i = size ; i >=0  ; i-- )
        {
        		if( stack.isEmpty() )
        			result[i] = 0 ;
        		else
        		{
        			while( !stack.isEmpty() && T[stack.peek()] <= T[i] )	
        								stack.pop() ;
        			
        			if( stack.isEmpty() )
        					 result[i] = 0 ;
        			else
        					result[i] = stack.peek() - i ;		
        		}
        	stack.push(i) ;
        }
      return result ;
    }
}