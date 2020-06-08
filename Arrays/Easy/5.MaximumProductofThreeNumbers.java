/*
		The below solution is not optimal .
		The solution can be optimized by finding 
		3 max values and 2 min values and then calculate 
		the product .
*/


class Solution {
    public int maximumProduct(int[] nums) {
        
    	Arrays.sort(nums) ;

    	int size  = nums.length ;
    	int prod1 = nums[0] * nums[1] ;
    	int prod2 = nums[size-2] * nums[size-3] ;

    	if( prod1 > prod2 )
    			return nums[ nums.length - 1 ] * prod1 ;
    	else 
    			return nums[ nums.length - 1 ] * prod2 ;

    }
}

/*
		Optimal Solution .
*/

class Solution {
    public int maximumProduct(int[] nums) 
    {	
    	int min1 = Integer.MAX_VALUE ;
    	int min2 = Integer.MAX_VALUE ;

    	int max1 = Integer.MIN_VALUE ;
    	int max2 = Integer.MIN_VALUE ;
    	int max3 = Integer.MIN_VALUE ;

    	for( int i = 0 ; i < nums.length ; i++ )
    	{
    			if( nums[i] > max1 )
    			{
    					max3 = max2 ;
    					max2 = max1 ; 
    					max1 = nums[i] ;
    			}
    			else if( nums[i] > max2 )
    						{
    							max3 = max2 ;
    							max2 = nums[i] ;
    						}else if( nums[i] > max3 ) max3 = nums[i] ;

    			if( nums[i] < min1 )
    			{
    				min2 = min1 ;
    				min1 = nums[i] ;
    			}else if( nums[i] < min2 ) min2 = nums[i] ;
    	}

    	return Math.max( min1*min2*max1 , max1*max2*max3 ) ; 

    }
}