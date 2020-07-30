/*
		Thought Process : Find the pivot element and then apply
		binary search . But watch the video to have better
		understanding .

		Understand this Question Well . This question gives you
		insights about many new things .

		Finding peak element and finding pivot element of the 
		rotated array is bit different . Because consider the 
		example eg: [7,8,1,2,3,4,5,6] Here peak element can be 
		8 or 6 . But Pivot element is only 8 .

		When you have rotated array thir are three Possiblities
		 - From middle element either left half or right half
		   will be sorted .
		 - Both the parts are sorted .

		 Reference : https://www.youtube.com/watch?v=oTfPJKGEHcc

*/

class Solution 
{
  public int search(int[] nums, int target) 
  {
    	int left  = 0 ;
    	int right = nums.length - 1 ;
    	int mid   = 0 ; 

    	while( left <= right )
    	{
    			mid = left + ( right - left ) / 2 ;

    			if( nums[mid] == target )
    						return mid ;

    			if( nums[ left ] <= nums[mid] )
    			{
    				if( nums[left] <= target && nums[mid] >= target ) 
    							right = mid - 1 ;

    				else left =  mid + 1 ;
    			}
    			else
    			{
    				if( target >= nums[mid] && target <= nums[right] )
    							left = mid + 1 ;
    				
    				else right = mid - 1 ;
    			}
    	}
    return -1 ;
  }
}