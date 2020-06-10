/*
    Find Peak Element : This is very different problem .
    It is based on somewhat hill climb algorithm .

    Question : A peak element is an element that is greater than its neighbors.
               Given an input array nums, where nums[i] ≠ nums[i+1], find a peak
               element and return its index.The array may contain multiple peaks, 
               in that case return the index to any one of the peaks is fine.
               You may imagine that nums[-1] = nums[n] = -∞ .  
*/
class Solution {
    public int findPeakElement(int[] nums) 
    {
        int left  = 0 ;
        int right = nums.length - 1 ;

        while( left < right )
        {
        	int mid = left + ( right - left ) / 2 ;

        	if( nums[mid] < nums[mid+1] )
        		left = mid + 1 ;
        	else
        		right = mid ; 
        }
      return left ;
    }
}