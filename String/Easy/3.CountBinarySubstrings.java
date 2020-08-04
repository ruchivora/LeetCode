/*
		Good Question ! 
		Covers a good concept .
		Logic : To group the elements . How to group the elements ?
		
		Code 1 : Written by me . But the code is not clean . 
		Code 2 : Same logic . But much clear code !.

*/

class Solution 
{
  public int countBinarySubstrings(String s) 
  {
	   	int index  = 1 ; 
	   	int arr[]  = { -1 , -1 } ;  
	   	int count  = 1 ;
	   	int result = 0 ;

	   	while( index <= s.length() - 1 )
	   	{
		   		if( s.charAt( index ) == s.charAt( index - 1 ) )
		   				count++ ;
		   		else
		   		{
		   			if( arr[0] == -1 )
		   			{
		   				arr[0] = count ;
		   				count  = 1 ;
		   			}
		   			else if( arr[1] == -1 )
		   			{
		   				arr[1] = count ;
		   				count  = 1 ;
		   				result = result + Math.min( arr[0] , arr[1] ) ;
		   				arr[0] = arr[1] ;
		   				arr[1] = -1 ;
		   			}
		   		}
		   	index++ ;
	   	}
	   	if( arr[0] != -1 && arr[1] == -1 )
	   	{
	   		result = result + Math.min( arr[0] , count ) ; 
	   	}
  	return result ;
  }
}

/* Same Logic . But more clear way of writing code! . */

class Solution 
{
  public int countBinarySubstrings(String s) 
  {
	  	int ans  = 0 ;
	  	int prev = 0 ; 
	  	int cur  = 1 ;

	  	for( int i = 1 ; i < s.length() ; i++ )
	  	{
	  		if( s.charAt( i - 1 ) != s.charAt(i) )
	  		{
	  			ans += Math.min( prev , cur ) ;
	  			prev = cur ;
	  			cur  = 1 ;
	  		}
	  		else cur++ ;
	  	}
	  return ans + Math.min( prev , cur ) ; 
  }
}