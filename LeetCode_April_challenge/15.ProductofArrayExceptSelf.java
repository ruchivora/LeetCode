/*
  Given an array nums of n integers where n > 1, 
  return an array output such that output[i] is equal 
  to the product of all the elements of nums except nums[i].

  Example:  Input:  [1,2,3,4]
          Output: [24,12,8,6]

  Revise for interview : https://www.youtube.com/watch?v=tSRFtR3pv74
*/
class Solution {
    public int[] productExceptSelf(int[] nums) {
       int result[]   = new int[ nums.length ] ;
       int left_prod  = nums[0] ;
       int right_prod = nums[ nums.length - 1 ] ;
        result[0]     = 1 ;
      
      for( int i = 1 ; i < nums.length ; i++ )
      {
          result[i] = left_prod ;
          left_prod = left_prod * nums[i] ;
      }

     for( int i = nums.length-2 ; i >= 0 ; i-- ) 
     {
       result[i]  = right_prod * result[i] ;
       right_prod = right_prod * nums[i]  ; 
     }
    
    return result ;

    }
}