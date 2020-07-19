/*
    Good Question .
    Constraint : Rotate in place. i.e SC: O(1)
    Logic      : 1. So , rotate the whole array . 
                 2. Rotate from ( 0 , k - 1 )
                 3. Rotate from ( k , nums.length )
*/

class Solution {
    public void rotate(int[] nums, int k) 
    {
        k = k%nums.length ; /* Because k can be greater than nums.length .*/
        reverse( nums , 0 , nums.length - 1 ) ;
        reverse( nums , 0 , k - 1 ) ;
        reverse( nums , k , nums.length - 1 ) ;
    }

    public void reverse( int[] nums , int start , int end )
    {
    	while( start < end )
    	{
      		int temp    = nums[start] ;
      		nums[start] = nums[end] ;
      		nums[end]   = temp ;
      		start++ ;
      		end-- ;
    	}
    }
}