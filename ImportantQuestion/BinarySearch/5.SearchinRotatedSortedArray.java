/*
    Very Important Question : Practice multiple times .
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

      if( target >= nums[left] && target<=nums[nums.length-1] )
        right = nums.length-1 ;
      else left  =  0   ;
      
        while( left <= right )
        {
          int mid = left + (right-left ) / 2 ;
          
          if( nums[mid] == target )
            return mid ;
          else if (nums[mid]> target)
                    right =mid-1 ;
                else  
                  left = mid+1 ; 
        }
    return -1 ;
    }
}