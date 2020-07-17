/*
		Learning : Given an array containing n distinct numbers 
							 taken from 0, 1, 2, ..., n, find the one that 
							 is missing from the array.
		Here this problem you can not be solved by using " Find Missing Number 
		if we have numbers in the range of 0 to N , given size of array is N .

		So you have to solve by using set or any other means. 

*/

/* 
		Code that will make you understand why it
		won't work using the concept of Missing Number .
*/


class Solution {
    public int missingNumber(int[] nums) 
    {
    	for( int i = 0 ; i < nums.length ; i ++ )
    	{

    		if( Math.abs( nums[i] ) <= nums.length - 1 )
    		{
    			nums[Math.abs(nums[i])] = nums[ Math.abs( nums[i] )] * -1 ;
    		}	

    		System.out.println( Arrays.toString( nums ) ) ;
    	}  

    	boolean isLength = false ;

    	for( int i = 0 ; i < nums.length ; i++ )
    	{
    		if( nums[i] > 0 )
    			return i ; 
    		else if( Math.abs( nums[i] ) == arr.length  )
    					isLength = true ;
    	} 
      return ( isLength == true ) ? 1 : arr.length  ; 
    }
}