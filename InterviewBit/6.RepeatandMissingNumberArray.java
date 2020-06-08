/*
    New algorithm . Important Question .
    Reference : https://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/

*/
public class Solution {
    
    public int[] repeatedNumber(final int[] A) {
        
        int result[] = new int[2] ;
        
        for( int i = 0 ; i < A.length ; i++ )
        {
            int absValue = Math.abs( A[i] ) ;

            if( A[absValue - 1]  > 0 )
                A[absValue - 1 ] = -  A[absValue - 1 ] ;

            else result[0] = absValue ;
        }
        
        for( int i = 0 ; i < A.length ; i++ )
            if( A[i] > 0 ) result[1] = i+1 ;
    
        return result ;
    }
}