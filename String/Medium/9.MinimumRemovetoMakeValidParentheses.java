/*
		Logic : My Logic was with using stack and set . 
						TC: O( N ) SC : O( N ) 

		Improved Logic : There are two cases 
											1 . When Close Braces are more than open Braces .
													- In this case you can simply ignore the closing
														Braces .

											2 . When Open Braces are more than close braces .
													- To resolve this case we use second For loop 
													  in the below Solution .
 	  Reference : https://www.youtube.com/watch?v=thL70BR3yMA

*/

class Solution 
{
  public String minRemoveToMakeValid(String s) 
  {
  		int open = 0 ; 
  		StringBuilder result1 = new StringBuilder() ;

  		for( int i = 0 ; i < s.length() ; i++ )
  		{
	  			if( s.charAt(i) == '(' ) 
	  						open++ ;
	  			else if( s.charAt( i ) == ')' )
	  			{
	  				if( open == 0 ) continue ;
	  						open-- ;
	  			}
	  		result1.append( s.charAt(i) ) ;
  		}

  		StringBuilder result2 = new StringBuilder() ; 

  		/* When Open Braces are more than close braces . */

  		for( int i = result1.length() - 1 ; i >= 0 ; i-- )
  		{
					if( result1.charAt(i) == '(' && open > 0 )
					{
						open-- ;
						continue ;	
					}
  			result2.append( result1.charAt(i) ) ;
  		}
  	return result2.reverse().toString() ;
  }
}