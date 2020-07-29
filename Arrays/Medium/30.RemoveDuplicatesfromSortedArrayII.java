/*
		I could develop the logic but could not write the
		clean code . 

		Reference : https://www.youtube.com/watch?v=-jHoA0e-IJ0

*/

class Solution
{
	public int removeDuplicates( int[] nums )
	{
			if( nums == null || nums.length == 0 )
						return 0 ;

			int left = 2 ; 
			/*
			   Because even if first two elements are 
				 same they will appear in the array .
			*/

			for( int right = 2 ; right < nums.length ; right++ )
			{
					if( nums[ left - 2 ] != nums[right] )
								nums[left++] = nums[right] ;
			}
			System.out.println(" left "+ left ) ;
			return left ;
	} 
}