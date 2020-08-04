/*
    Reference : https://www.youtube.com/watch?v=TzIuVm1npgw
    This problem is slight variation of two sum problem .
    But beautiful concept .

*/

class Solution 
{
    public int numPairsDivisibleBy60(int[] time) 
    {
    	 return numDivisibleByk( time , 60 ) ;
    }

    public int numDivisibleByk( int time[] , int k )
    {
    		int hash []  = new int[k] ;
    		int answer = 0 ;

    		for( int i = 0 ; i < time.length ; i++ )
    		{
    				int current  = time[i] % k ; 
    				int opposite = ( k - current )%k ;

    				answer = answer + hash[opposite] ;
    				hash[current]++ ;
    		}
    	return answer ;
    }
}