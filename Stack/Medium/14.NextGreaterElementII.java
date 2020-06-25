/*
		Reference - https://www.youtube.com/watch?v=ARkl69eBzhY&t=401s
		Reference - https://www.youtube.com/watch?v=sYINIANAFBY

		Here , each element of the array is visited twice .
		And a stack is maintained that stores the index of the
		element of the array . 
		
*/

class Solution {
    public int[] nextGreaterElements(int[] nums) 
    {
       int n = nums.length ; 
       int outputArr[] = new int[n] ;
       Arrays.fill( outputArr , -1 ) ;

       Stack<Integer> stack = new Stack<Integer>() ;

       for( int i = 0 ; i < 2*n ; i++  )
       {
       		while( !stack.isEmpty() && nums[stack.peek()] < nums[i%n] )
       			outputArr[stack.pop()] = nums[i%n] ;
       		
       		if( i < n )
       			stack.push(i) ;
       }
       return outputArr ;
    }
}