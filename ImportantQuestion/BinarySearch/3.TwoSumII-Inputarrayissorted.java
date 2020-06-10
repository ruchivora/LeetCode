/*
    Given an array of integers that is already sorted in ascending order, 
    find two numbers such that they add up to a specific target number.

    The function twoSum should return indices of the two numbers such 
    that they add up to the target, where index1 must be less than index2.

    Here , we learn a new technique to approach a question .
*/
class Solution {

	int Sum[] = new int[2] ;

    public int[] twoSum(int[] nums, int target) 
    {
    	int left  = 0 ;
    	int right = nums.length - 1 ;

    	while( left <= right )
    	{
    		if( nums[left] + nums[right] == target )
    		{
    			Sum[0] = left  + 1 ;
    			Sum[1] = right + 1 ;
    			return Sum;
    		}
    		else if( nums[left] + nums[right] > target )
    				right -- ;
    			  else left ++ ;
    	} 
    	return Sum ;
    }
}