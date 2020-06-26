/*
		Solution : We require two pointers . 
		Approach 2 : clean Code .
		Reference  : https://www.youtube.com/watch?v=vHKXT0cSI54
*/

/*
		Approach 1: Time commplexity : O(N)		
*/

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) 
    {
        Stack<Integer> stack = new Stack<Integer>() ;
        int i = 0 ;
        int j = 0 ; 

        while( i < pushed.length && j < popped.length )
        {
	        	if( pushed[i] != popped[j] ){
	        			stack.push( pushed[i] ) ;
	        			i++ ;
	        	}
	        	else
	        	{
	        			stack.push( pushed[i] ) ;
	        			i++ ;
	        			while( !stack.isEmpty() && stack.peek() == popped[j] ){
	        				      stack.pop() ;
	        				      j++ ;
	        			}
	        			if( stack.isEmpty() && j >= popped.length )
	        						return true ;
	        	}
        }

        while( !stack.isEmpty() )
        {
	        	if( stack.peek() == popped[j] ){
	        		    stack.pop() ;
	        		    j++ ;
	        	}
	        	else return false ;
        }
      return true ;
    }
}

/*
		Clean Code . Approach : 2 ;
*/

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) 
    {
        Stack<Integer> stack = new Stack<Integer>() ;
        int i = 0 ;
        int n = pushed.length ;

        for( int num : pushed )
        {
        		stack.push( num ) ;
        		while( !stack.isEmpty() && stack.peek() == popped[i] )
        		{
        			stack.pop() ;
        			i++ ;
        		}
        } 
      return i == n ;  
      /*
      		At the end i == n because number of 
      		elements in popped array is equal to 
      		number of pushed elements .  
      */

    }

}