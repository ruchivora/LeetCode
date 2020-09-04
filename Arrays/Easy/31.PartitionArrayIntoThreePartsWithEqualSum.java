class Solution {
  public boolean canThreePartsEqualSum(int[] A) 
  {
  		int sum = 0 ;

  		for( int i = 0 ; i < A.length ; i++ )
  						sum = sum + A[i] ;

  		if( sum % 3 != 0 )
  				return false ;

  		int reqSum = sum / 3 ; 
  		int curSum = 0 ;
  		int count  = 0 ;

  		for( int i = 0 ; i < A.length ; i++ )
  		{
  				curSum = curSum + A[i] ;

  				if( curSum == reqSum )
  				{
  					curSum = 0 ;
  					count++ ;
  				}			
  		}
  	return count >= 3 ;
  }
}