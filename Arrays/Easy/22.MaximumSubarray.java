/*
		Refer Kadane's Algorithm .
*/

class Solution {
    public int maxSubArray(int[] nums) 
    {
    		if( nums.length == 0 ) return 0 ;
    		if( nums.length == 1 ) return nums[0] ;

        int maxSum = Integer.MIN_VALUE ;
        int sum    = 0 ; 

        for( int i = 0 ; i < nums.length ; i++ )
        {
        		sum = sum + nums[i] ;

        		if( maxSum < sum )
        				maxSum = sum ;

        		if( sum < 0 )
        				sum = 0 ;   
        }
      return maxSum ;
    }
}