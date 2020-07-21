/*
		Learning : How to write code for sliding window neatly . 
*/

class Solution {
    public double findMaxAverage(int[] nums, int k) 
    {
    		if( nums.length == 1 ) return (double)nums[0] ;
        if( nums.length < k  ) return (double)0 ; 

        int sum = 0 ;
        double max = Double.NEGATIVE_INFINITY ;

        /* Learn how to write code for sliding window .*/
        for( int i = 0 ; i <= nums.length - 1 ; i++ )
        {
        		sum = sum + nums[i] ;

        		if( i >= k - 1 )
        		{
        			max = ( max > (double)sum / k ) ? max : (double)sum / k ;
        		    sum = sum - nums[ i - k + 1 ] ;
        		}
        }
      return max ; 
    }
}