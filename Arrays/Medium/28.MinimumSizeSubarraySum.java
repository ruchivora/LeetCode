/*
		This problem is bit misguiding . 
		Because by looking at problem statement 
		i thought , this is decision based problem
		so tried writing recursion . But if you 
		oberse carefully , this problem can easily 
		be solved by window approach .

		Reference : https://www.youtube.com/watch?v=jKF9AcyBZ6E

		BruteForce : O(N2) 
		Window Approach : O(N) SC:O(1) .

*/

class Solution 
{
  public int minSubArrayLen(int s, int[] nums) 
  {
     int min  = Integer.MAX_VALUE ;
     int left = 0 ;
     int sum  = 0 ;

     for( int i = 0 ; i < nums.length ; i++ )
     {
     		sum = sum + nums[i] ;

     		while( sum >= s )
     		{
     			min = Math.min( min , i + 1 - left ) ;
     			sum = sum - nums[left] ;
     			left++ ;
     		}
     }
    return ( min == Integer.MAX_VALUE ) ? 0 : min ;
  }
}