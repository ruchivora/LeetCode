/*
		This solution is with O(N) extra space .
		But below solution can be optimized .
*/
class Solution {
    public int findUnsortedSubarray(int[] nums) 
    {
       int snums[] = nums.clone() ;
       Arrays.sort( snums ) ;

       int start = nums.length ;
       int end   = 0 ;

       for( int i = 0 ; i < snums.length ; i++ )
       {
       		if( nums[i] != snums[i] )
       		{
       			start = Math.min( start , i ) ;
       			end   = Math.max( end , i ) ;
       		}
       }
     return ( start < end ) ? end - start + 1 : 0 ; 
    }
}

