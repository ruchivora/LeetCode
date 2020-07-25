/*
		Important Question ! .
		Binary Search Problem
*/

class Solution {
  public int[] searchRange(int[] nums, int target) 
  {
      int result[] = new int[2] ;
      int left     = 0 ;
      int right    = nums.length ;
      int mid      = 0 ;

      while( left <= right ) 
      {
      	  mid = left + ( right - left ) / 2 ;

      		if( nums[mid] >= target )
      				right = mid - 1 ;

      		else left = mid + 1 ;

      		if( nums[mid] == target )
      				result[0] = mid ;	   	
      }

    	int left  = 0 ; 
    	int right = nums.length ; 

    	while( left <= right )
    	{
	    		mid = left + ( right - left ) / 2 ;

	    		if( nums[mid] <= target )
	    					left = mid + 1 ;

	    		else right = mid + 1 ; 

	    		if( nums[mid] == target )
	    					result[1] = mid ;
    	}
  	return result ;
  }
}