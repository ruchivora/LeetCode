/*
		Don't use two arrays . Instead use pure Maths to find the pivot .
*/

class Solution {
    public int pivotIndex(int[] nums) 
    {
    		if( nums.length == 0 )
    				return -1 ;

    		int sum     = 0  ;
    		int leftsum = 0  ;

    		for( int i = 0 ; i < nums.length ; i++ )
    					sum = sum + nums[i] ;

    		for( int i = 0 ; i < nums.length ; i++ )
    		{
    				if( leftsum == sum - leftsum -nums[i] ) 
    							return i ;

    				leftsum = leftsum + nums[i] ;
    		}
    	return -1 ;
	  }
}