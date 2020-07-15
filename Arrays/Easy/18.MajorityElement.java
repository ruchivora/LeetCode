/*
		Good Question . You will learn MooreVoting Algorithm .
		
		Reference : https://www.youtube.com/watch?v=n5QY3x_GNDg

*/

class Solution {
	public int majorityElement(int[] nums) 
	{
			int majorityCount = nums.length / 2 ;		
			int count = 1 ;
			int majorityElement = nums[0] ; 
			int counter = 0 ;

			for( int i = 1 ; i < nums.length ; i++ )
			{
					if( nums[i] != majorityElement )
					{	
							count-- ;		
							if( count == 0 )
							{
								  majorityElement = nums[i] ;
									count = 1 ; 	
							}
					}
					else count++ ;	
			}
		return majorityElement ;
	}
}