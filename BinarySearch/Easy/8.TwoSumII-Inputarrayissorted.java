/*
	BinarySearch Solution is not so suitable .
	So , just by looking at word sorted , don't jump to binary search .

	Next , i have also solved with better approach .
*/
class Solution {

	int Sum[] = new int[2] ;

    public int[] twoSum(int[] nums, int target) 
    {	
    	for( int i = 0 ; i < nums.length - 1 ; i++ )   
    	{
    	   int diff  = target - nums[i] ;
    	   int left  = i + 1 ;
    	   int right = nums.length - 1 ;
    	   int mid   = 0 ;

    	   while( left <= right )
    	   {
    	   		mid = left + ( right - left ) / 2 ;

    	   		if( nums[mid] == diff )
    	   		{
    	   			Sum[0] = i+1 ;
    	   			Sum[1] = mid + 1 ;
    	   			break ;
    	   		} 
    	   		else if( nums[mid] > diff ) right = mid - 1 ;
    	   			
    	   			 else left = mid + 1 ;
    	   }
    	} 
    	return Sum ;
    }
}


/* Better Solution */
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