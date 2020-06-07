/*
	eg: 1 2 3 8 8 8 8 9 10 11
	This , can be solved by using binary search twice .
*/
class Solution {
	
	int result[] = {-1,-1} ;

    public int[] searchRange(int[] nums, int target) 
    {
    	int left  = 0 ;
    	int right = nums.length - 1 ;

    	while( left <= right )
    	{
    		int mid = left + ( right - left ) / 2 ;
    		if( target <= nums[mid] ) right = mid - 1 ;
    			else left = mid + 1 ;

    		if( nums[mid] == target ) result[0] = mid ; 
    	}

 		left  = 0 ;
    	right = nums.length - 1 ;

    	while( left <= right )
    	{
    		int mid = left + ( right - left ) / 2 ;
    		if( target >= nums[mid] ) left = mid + 1 ;
    			  else right = mid - 1 ;

    		if( nums[mid] == target ) result[1] = mid ; 
    	}

      return result ;
    }
}
   