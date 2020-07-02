/*
    Recursive Solution : 
*/

class Solution {
    public int[] productExceptSelf(int[] nums) 
    {
      findProduct( nums , nums.length - 1 , 1 , 0 ) ;
      return nums ;
    }

    public int findProduct( int nums[] , int n , int prod , int i )
    {
      int temp   = nums[i] ;
      nums[i]    = prod ;
      prod       = prod * temp ;

      if( i == n ) return temp ;

      int x = findProduct( nums , n , prod , i+1 ) ;
      nums[i] = nums[i] * x ;

      return x * temp ;
    }
}

/*
    Non recursive Solution .
*/

class Solution {
    public int[] productExceptSelf(int[] nums) 
    {
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
       result[i] = right_prod * result[i] ;
       right_prod = right_prod * nums[i]  ; 
     }
    
    
    return result ;

    }
}