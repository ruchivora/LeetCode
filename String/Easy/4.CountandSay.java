/*
		This problem can also be solved in recursive Way ! 
		This problem is similar to Fibonacci Numbers .

*/
class Solution 
{
  public String countAndSay(int n) 
  {
  		if( n == 1 ) return "1"  ;
  		if( n == 2 ) return "11" ;
  		int j = 1 ;
  		
  		StringBuilder input = new StringBuilder("11") ; 

  		for( int i = 2 ; i < n ; i++ )
  		{
  			StringBuilder sb = new StringBuilder() ;
  			int count = 1 ;

  			for( j = 1 ; j < input.length() ; j++ )
  			{
  				if( input.charAt(j) != input.charAt( j - 1 ) )
  				{
  					sb.append( count ) ;
  					sb.append( input.charAt(j - 1) ) ;
  					count = 1 ;
  				} 
  				else count++ ;
  			}
  			sb.append( count ) ;
  			sb.append( input.charAt( j - 1 ) ) ;

  			input = sb ;
  		} 
   	return input.toString() ;
  }
}