/*
    Given a range [m, n] where 0 <= m <= n <= 2147483647,
    return the bitwise AND of all numbers in this range, inclusive.

    Input: [5,7]
    Output: 4
    
    Concept : we can not do for loop because time taken to 
              loop through 2147483647 number will be too long .

    Hint : So , their is a hint https://www.youtube.com/watch?v=ho9cihIwQDY 
*/
class Solution {
    public int rangeBitwiseAnd(int m, int n) {

    int count = 0 ;
        
    	while( m != n )
        {
    		m = m >> 1 ;
    		n = n >> 1 ;
    		count++ ;
    	}
    	for( int i = 1 ; i <= count ; i++ )
    	{
    		m = m << 1 ;
    		n = n << 1 ;
    	}
    	count = m & n ;
    	return count ;
    }
}