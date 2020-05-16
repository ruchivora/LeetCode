/*
    Suppose an array sorted in ascending order is rotated at some pivot 
    unknown to you beforehand.
    (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

    You are given a target value to search. If found in the array 
    return its index, otherwise return -1.
    You may assume no duplicate exists in the array.

    Your algorithm's runtime complexity must be in the order of O(log n).

    Example 1:
    Input: nums = [4,5,6,7,0,1,2], target = 0
    Output: 4

    Hint : https://www.youtube.com/watch?v=QdVrY3stDD4
*/

class Solution {
    public int search(int[] nums, int target) {

      if( nums.length == 0 || nums == null )
        return -1 ;

    	int left  = 0 ;
    	int right = nums.length - 1 ; 

    	while( left < right )
    	{
    		int mid =  left+  ( right - left )  / 2 ;

    		if( nums[mid] > nums[right] )
    		   left = mid + 1  ;
    		else
    			right = mid   ;
    	}

      if( target >= nums[left] && target <= nums[nums.length-1] )
         right = nums.length-1 ;       
      else  left  =  0   ;
      
        while( left <= right )
        {
          int mid = left + (right-left ) / 2 ;
          
          if( nums[mid] == target )
            return mid ;
          else if (nums[mid]> target)
                    right = mid-1 ;
                else  
                  left = mid+1 ;
        }
    return -1 ;
    }
}