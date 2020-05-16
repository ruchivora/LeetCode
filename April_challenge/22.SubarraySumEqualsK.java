/*
    Given an array of integers and an integer k, you need to 
    find the total number of continuous subarrays whose sum equals to k.

    Example 1:
    Input:nums = [1,1,1], k = 2
    Output: 2
    
    Note: 1 . The length of the array is in range [1, 20,000].
          2 . The range of numbers in the array is [-1000, 1000] and 
              the range of the integer k is [-1e7, 1e7].
    Concept : Learnt new concept .
    Hint    : https://www.youtube.com/watch?v=YkacnIOt2jM&t=451s
              https://www.youtube.com/watch?v=AmlVSNBHzJg 
*/
class Solution {
    public int subarraySum(int[] nums, int k) {

     HashMap<Integer,Integer> arr_sum = new HashMap<Integer,Integer>() ;
     arr_sum.put( 0 , 1 ) ;

     int sum    = 0 ;
     int result = 0 ;

     for( int i = 0 ; i < nums.length ; i++ )
     {
          sum += nums[i] ;
          if( arr_sum.containsKey( sum - k ) )
          {
              result += arr_sum.get( sum - k ) ;
          }
          arr_sum.put( sum , arr_sum.getOrDefault( sum , 0 ) + 1 ) ;
     }
     return result ;
    }
}