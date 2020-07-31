/*
		Since the input may conatins negative numbers
		so , sliding Window won't work ! .

		But cumulative sum can work here , along
		with tracking the remainders .

		Also , remainders can not be negative . So handle
		the negative remainders .

*/

class Solution 
{
  public int subarraysDivByK(int[] A, int k) 
  {
     int cumSum = 0 ;
     int result = 0 ;

     HashMap<Integer,Integer> map = new HashMap<Integer,Integer>() ;
     map.put( 0 , 1 ) ;

     for( int i = 0 ; i < A.length ; i++ )
     {
     		cumSum = cumSum + A[i] ;

     		int remainder = cumSum % k ;

     		if( remainder < 0 )
     				remainder = remainder + k ;

     		if( map.containsKey( remainder ) )
     					result = result + map.get( remainder ) ;

     		map.put( remainder , map.getOrDefault( remainder , 0 ) + 1 ) ;
     } 
    return result ;  
  }   
}