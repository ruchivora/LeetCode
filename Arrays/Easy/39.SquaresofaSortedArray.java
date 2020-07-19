/*
		Solved using Pointers . 
		TC : O( N )  , SC : O(N)
	
		It is always better to have time Complexity as 
		O(N) and Space as O(N) . Rather than TC as O(NlogN)

*/

class Solution 
{
    public int[] sortedSquares(int[] A) 
    {
        int i = 0 ; 
        int j = A.length - 1 ; 
        int k = A.length - 1 ;

        int B[] = new int[ A.length ] ; 

        while( i <= j )
        {
        		if( Math.abs( A[i] ) >= Math.abs( A[j] ) )
        		{
        			B[k] = A[i] ;
        			i++ ;
        			k-- ;
        		}
        		else if( Math.abs( A[i] ) < Math.abs( A[j] ) )
        					{
        						B[k] = A[j] ;
        						j-- ; 
        						k-- ;
        					}
        }
        for( int l = 0 ; l < B.length ; l++ )
        			B[l] = B[l] * B[l] ;

      return B ;
    }
}