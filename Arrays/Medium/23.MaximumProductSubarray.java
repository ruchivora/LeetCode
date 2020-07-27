/*
		This Qustion i did not understand well.

		I understood the solution but how do i arrive at it ? 
		
		This is also called modified Kadane's Algorithm .
		
		- The problem becomes complex because the array contains 
		  positive number , negative number and zero .
 
		 Code Reference : https://leetcode.com/problems/maximum-product-subarray/discuss/716775/Simplest-Logic-or-O(n)-Solutionor100-accuracy.
		 Reference : https://www.youtube.com/watch?v=vtJvbRlHqTA
*/

class Solution 
{
  public int maxProduct(int[] nums) 
  {
      if( nums.length == 1 )
      			return nums[0] ;

      int currMax = nums[0] ;
      int currMin = nums[0] ;
      int prevMax = nums[0] ;
      int prevMin = nums[0] ;
      int ans     = nums[0] ;

      for( int i = 1 ; i < nums.size() ; i++ )
      {
      	currMax = Math.max( nums[i] * prevMax , Math.max( nums[i] * prevMin , nums[i] ) ) ;
      	currMin = Math.min( nums[i] * prevMin , Math.min( nums[i] * prevMax , nums[i] ) ) ;
      	ans     = Math.max( ans , currMax ) ;
      	prevMin = currMin ;
      	prevMax = currMax ;
      }
    return ans ;
  }
}