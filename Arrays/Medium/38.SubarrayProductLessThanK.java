/*
		This is window approach but in the form of 
		multiplication and division .

		I could derive the logic of window but did not 
		know how to count the combinations . 

		For that the formula is right - left + 1 . 
		Here 1 is for individual element that we add .

		Reference : https://www.youtube.com/watch?v=SxtxCSfSGlo

*/


class Solution 
{
    public int numSubarrayProductLessThanK(int[] nums, int k) 
    {
    		if( k <= 1 ) return 0 ;

        int prod = 1 ;
        int result = 0 ;
        int left = 0 ;
        int right = 0 ;

        while( right < nums.length )
        {
        	prod = prod * nums[right] ;

      		while( prod >= k )
      		{
      			prod = prod / nums[left] ;
      			left++ ;
      		}
      		result = result + right - left + 1 ;
      		right++ ;
        }
      return result ;
    }
}