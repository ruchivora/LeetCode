/*
		Learning : Given an array containing n "DISTINCT" numbers 
							 taken from 0, 1, 2, ..., n, find the one that 
							 is missing from the array.
		Here this problem can not be solved by using " Find Missing Number 
		if we have numbers in the range of 0 to N , given size of array is N and 
    it contains the duplicates .

		Logic 1: As the word distinct is given . You can use set and store elements
             in set . Then find which number is missing . 
             TC : O( N ) SC : O(N) 
    Logic 2: Since all the elements are distinct and all the elements between 0 to n ,
             occur once . So we can find sum of all elements of the array ( sum 1 ) 
             and we also know sum of all elements from 0 to n , by n(n+1) / 2 ( sum 2 )
             So sum 2 - sum 1 = Missing Element . TC : O( N ) SC : O(1)  

*/

class Solution 
{
  public int missingNumber(int[] nums) 
  {
    int sum = 0 ;
    int N   = nums.length ; 

    for( int i = 0 ; i < nums.length ; i++ )
          sum = sum + nums[i] ;

    int totalSum = N( N + 1 ) / 2 ;

   return totalSum - sum  ;
  }
}


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