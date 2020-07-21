/*
		Directly by looking at the question don't use decision based approach.
		Because decision based approach will lead to TLE Error .

		So start with brute force approach . Then think about how to convert 3Sum
		Problem to 2Sum problem . Then try to reduce Time Complexity
		By sorting the array and then use two pointer approach .

		So the TC will be reduced to O( N2 ) .

		How to avoid duplicate triplets?
			- Duplicates can be formed if both nums[i] and nums[ i - 1 ] is considered 
			  as nums[ i ] == nums[ i - 1 ] .
			- Duplicates can also be formed if nums[left] == nums[ left + 1 ] Or
				nums[ right ] == nums[ right - 1 ] .
*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) 
    {
	    	List<List<Integer>> result = new ArrayList<List<Integer>>() ;
	    	int left  = 0 ;
	    	int right = nums.length ; 
	    	int sum   = 0 ;

	    	Arrays.sort( nums ) ;

	    	for( int i = 0 ; i < nums.length - 2 ; i++ )
	    	{
	    		/* To handle Duplicates we need this condition */
	    		if( i == 0 ||  i > 0 && nums[i] != nums[ i - 1 ] )
	    		{
		    			sum = nums[i] * -1 ;
		    			left  = i + 1 ;
		    			right = nums.length - 1 ;
	           
		    			while( left < right )
		    			{
		    				if( nums[left] + nums[right] < sum )
		    						  left++ ;

		    				else if( nums[left] + nums[right] > sum )
		    									right-- ;

		    							else if( nums[i] + nums[left] + nums[right] == 0 )
		    							{
		    								ArrayList<Integer> temp = new ArrayList<Integer>() ;
		    								temp.add( nums[i] ) ;
		    								temp.add( nums[left] ) ;
		    								temp.add( nums[right] ) ;
		    								result.add( temp ) ;
		    								
	                      while( left < right && nums[left]  == nums[left  + 1]  ) left++ ;
	                      while( left < right && nums[right] == nums[right - 1]  ) right-- ;

	                      left++ ;
	                      right-- ;
		    							}   
		    			}

	    		}
	    	}
    	return result ;
    }
}