/*
		Good Question! .

		I came up with a solution but did not pass test cases like
		eg: 115 .

		But this approach is simple but tricky to think in one go .
		It is a type of greedy approach .

		Reference :https://www.youtube.com/watch?v=ayAtHIwU3Zw .

*/


class Solution 
{
  public int maximumSwap( int num ) 
  {
  	char[] A    = Integer.toString( num ).toCharArray() ;

  	/* Acts as Hash Map .*/
  	int last[]  = new int[10] ;

  	for( int i = 0 ; i < A.length ; i++ )
  				last[ A[i] - '0' ] = i ; 

  	for( int i = 0 ; i < A.length ; i++ )
  	{
  		for( int d = 9 ; d > A[i] - '0' ; d-- )
  		{
  			if( last[d] > i )
  			{
  				char temp    = A[i] ;
  				A[i]         = A[ last[d] ]  ;
  				A[ last[d] ] = temp ;
  				return Integer.valueOf( new String( A ) ) ;
  			}
  		}
  	}
   return num ;
  }  
}