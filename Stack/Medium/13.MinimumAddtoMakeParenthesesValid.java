/*
		Solution 1 : Without Stack 
		Solution 2 : With Stack
*/

/*
		Solution 2 : without stack 
*/
class Solution
{
	public int minAddToMakeValid(String S) 
  {
  	int open  = 0 ; 
  	int close = 0 ;

  	for( int i = 0 ; i < S.length() ; i++ )
  	{
  		if( S.charAt(i) == '(' )
  					open++ ;
  		else
  		{
  			if( open <= 0 )
  					close ++ ;
  			else
  				open--;
  		}
  	}
  return open+close ;
  }
}

/*
		Solution 2 : With stack 
*/

class Solution {
    public int minAddToMakeValid(String S) 
    {
    	Stack<Character> stack = new Stack<Character>() ;
    	int count = 0 ;

    	for( int i = 0 ; i < S.length() ; i++ )
     	{
     			if( S.charAt(i) == '(' )
     					stack.push( ) ;
     			else
     			{
     					if( stack.isEmpty() )
     							count++ ;
     					else
     						stack.pop() ;
     			}
     	} 
     	if( !stack.isEmpty() )
     	{
     		int sum = 0 ;
     		while( !stack.isEmpty() )
     		{
     			stack.pop() ;
     			sum++ ;
     		}
     		count = count + sum ;
     	} 

     	return count ;

    }
}