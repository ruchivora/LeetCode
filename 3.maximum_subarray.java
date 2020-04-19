 /*
    Given an integer array nums, find the contiguous subarray 
    (containing at least one number) which has the largest sum 
    and return its sum.

    Input: [-2,1,-3,4,-1,2,1,-5,4],
    Output: 6
    Explanation: [4,-1,2,1] has the largest sum = 6.

    Solution is based on couple of observation .
    1. The maximum sum subarray will always start and end with positive number . 
    2. https://www.youtube.com/watch?v=hPWJNoaI7t8

*/


class Solution {
    public int maxSubArray(int[] nums) {
        
      if(nums.length == 1)
          return nums[0] ;

      int max = 0 ;
      int sum = 0 ;
      int min = 9999 ;
      boolean flag = false ;
  
      for( int i = 0 ; i < nums.length ; i++ )
      {
         if( nums[i] > 0 )
         {
            flag = true ;
            sum = nums[i] ;
            max = (sum > max) ? sum : max ;
           for( int j = i+1 ; j < nums.length ; j++ )
           {
             sum += nums[j] ;
             if( sum < 0 ){
                break ;
             }
             max = (sum > max) ? sum : max ;
           }
         }
      }

    if(flag == false)
    {
       max = nums[0] ;
      for( int i = 1 ; i <nums.length ; i++)
      {
         max = ( max < nums[i]) ? nums[i] : max ;
      }
    }
    return   max ;
    }
}