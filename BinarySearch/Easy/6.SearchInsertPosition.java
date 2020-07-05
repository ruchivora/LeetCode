/*
	Important note : In Binary Search even if you 
	don't find the given target , your mid element
	after the while loop will land somewhere nearby .
*/
class Solution {
    {
    	if( target < nums[0] ) return 0 ;
    	if( target > nums[nums.length-1] ) return nums.length ;

    	int left  = 0 ;
    	int right = nums.length - 1 ;
    	int mid = 0 ;

    	while( left <= right )
    	{
    		mid = left + ( right - left ) / 2 ;

    		if( nums[mid] == target )
    			return mid ;

    		else if( nums[mid] > target )
    			     right = mid - 1 ;
    		
    			  else left = mid + 1 ;		
    	}
    return left ;
    }
}