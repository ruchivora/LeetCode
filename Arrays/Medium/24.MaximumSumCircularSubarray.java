/*
		Here their are two cases 
		 1. We find the maximum sum in the array without considering circular wrap .
		 2. Require Circular Wrap .

		How to calculate first case ? 
		 - Use Kadanes Algorithm .

		How to calculate second case ? 
		 - The logic is Totalsum - Minimum sum subarray = Maximum sum in circular Array .
		 - How to calculate Minimum sum subarray ? 
		 		- Multiply each element by -1 .
		 		- Then apply Kadanes Algorithm .

		Reference : https://www.youtube.com/watch?v=Q1TYVUEr-wY&t=401s
*/

class Solution 
{
  public int maxSubarraySumCircular( int[] A ) 
  {
      int maxSoFar      = Integer.MIN_VALUE ;
      int maxEndingHere = 0 ;
      int sum           = 0 ; 
      int countNegative = 0 ;
      int maxPositive   = 0 ; 
      int maxNegative   = 0 ; 

      /* Finding maximum sum subArray */
 			maxPositive = KadanesAlgo( A ) ; 

	    for( int i = 0 ; i < A.length ; i++ )
	    {
	    	if( A[i] < 0 ) 
	    		countNegative++ ;

	    	sum  = sum + A[i] ;
	    	A[i] = A[i] * -1 ;
	    }

      if( countNegative == A.length ) return maxPositive ;
    			
    	/* Finding minimum sum subArray */
      maxNegative = KadanesAlgo( A ) ; 

   return Math.max( maxPositive , ( sum - maxNegative* -1 ) ) ;
  }

  public int KadanesAlgo( int A[] )
  {
  	  int maxSoFar      = Integer.MIN_VALUE ;
      int maxEndingHere = 0 ;

		  for( int i = 0 ; i < A.length ; i++ )
		  {
		  	maxEndingHere = maxEndingHere + A[i] ;

		  	if( maxEndingHere > maxSoFar )
		  				maxSoFar = maxEndingHere ;

		  	if( maxEndingHere < 0 )
		  			maxEndingHere = 0 ; 
		  }
		return maxSoFar ;
  }
}