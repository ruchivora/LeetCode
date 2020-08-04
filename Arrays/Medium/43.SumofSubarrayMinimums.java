class Solution 
{
  public int sumSubarrayMins(int[] A) 
  {
  	if( A.length == 0 ) return 0 ;

  	int min = A[A.length - 1] ; 
  	int sum = 0 ; 
  	int n   = A.length - 1 ;

  	for( int i = A.length - 1 ; i >= 0 ; i-- )
  	{
  		sum = ( sum + A[i] ) % ( 1000000000 + 7 ) ;

  		if( min > A[i] ) 
  				min = A[i] ;

  		sum = ( sum + ( n - i ) * min ) % ( 1000000000 + 7 ) ;  
  	}
  return sum ;
  }
}