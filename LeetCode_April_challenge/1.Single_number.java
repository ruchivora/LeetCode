/*
  Given a non-empty array of integers, every element appears twice except for one.
  Find that single one. Can be solved using 

  1 . Using HashSet
  2 . Using XOR
*/

/*
    Solution 1 : Using HashSet
*/

class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> no_count = new HashSet<Integer>() ;
        
        for(int i = 0 ; i < nums.length ; i++)
        {
          if( no_count.contains(nums[i]) )
              no_count.remove(nums[i]) ;
          else
              no_count.add(nums[i]) ;  
        }
      
       for(int i : no_count)
          return i ;
  
      return -1 ;
      
    }
}

/*
    Solution 2 : Using XOR
*/
    class Solution {
    public int singleNumber(int[] nums) {
         int result = 0 ;
         
      for(int i = 0 ; i < nums.length ; i++ )
          result ^= nums[i] ;
      
      
      return result ;
      
      
    }
}