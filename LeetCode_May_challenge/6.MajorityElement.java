/*
	Given an array of size n, find the majority element. 
	The majority element is the element that appears more than ⌊ n/2 ⌋ times.

	You may assume that the array is non-empty and the majority element always exist in the array.

	Example 1:  Input: [3,2,3]
				Output: 3
*/
class Solution {
    public int majorityElement(int[] nums) {

    	if( nums == null || nums.length == 0 )
    	return 0 ;

    	HashMap<Integer,Integer> map = new HashMap<Integer,Integer>() ;

    	int majority = nums.length / 2 ;
        
    	for( int i = 0 ; i < nums.length ; i++ )
    	{
    		if( map.containsKey(nums[i]) && map.get( nums[i] ) + 1 > majority  )
    			return nums[i] ;
    		else
    			map.put( nums[i] , map.getOrDefault( nums[i] , 0 ) + 1 ) ;  
    	}
        return -1 ;
    }
}