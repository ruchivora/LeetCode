/*
	Here , We need to find A+B+C+D = 0 but
	doing so will take O(N^4) because of 4 for loops .
	So , if we do A + B = - (C + D) then time complexity 
	will be O(N^2) + O(N^2) = O(N^2) . Which is better .
*/
class Solution {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        
    int total = 0 ;
    HashMap<Integer,Integer> sum = new HashMap<Integer,Integer>() ;

    for( int  i = 0 ; i < A.length ; i++ )
    {
    	for( int j = 0 ; j < B.length ; j++ )
    	{
    		int Sum = A[i]+B[j] ;
    		sum.put( Sum , sum.getOrDefault( Sum , 0 ) + 1 ) ;
    	}
    }

    for( int i = 0 ; i < C.length ; i++ )
    {
    	for( int j = 0 ; j < D.length ; j++ )
    	{
    		int getKey = C[i] + D[j] ;
    		if( sum.containsKey( -getKey ) ) total += sum.get( -getKey ) ;
    	}
    }
    return total ;
    }
}