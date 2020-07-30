/*
	Here Binary Search is used very differently . 
	Be careful ( Left < right ) and not ( left <= right ) .
*/

class Solution {
    public int findPeakElement(int[] nums) 
    {
        int left  = 0 ;
        int right = nums.length - 1 ;

        while( left < right )
        {
        	int mid = left + ( right - left ) / 2 ;

        	if( nums[mid] < nums[mid+1] )
        		left = mid + 1 ;
        	else
        		right = mid ; 
        }
      return left ;
    }
}

/* 
    Different way to approach a problem 

    Reference : https://www.youtube.com/watch?v=OINnBJTRrMU&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=17
*/

class Solution {
    public int findPeakElement(int[] nums) 
    {
      if( nums.length == 1 ) return 0 ;

      int left  = 0 ; 
      int right = nums.length - 1 ; 
      int mid   = 0 ;

      while( left <= right )
      {
          mid = left + ( right - left ) / 2 ;

          if( mid > 0 && mid < nums.length - 1 )
          {
              if( nums[ mid - 1 ] < nums[mid] && nums[mid + 1 ] < nums[mid] )
                    return mid ;

              else if( nums[mid - 1] > nums[mid] )
                        right = mid - 1 ; 
                   
                    else left = mid + 1 ;
          }
          else if( mid == 0 )
          {
            if( nums[mid] > nums[mid + 1] ) return mid ;
            else return mid + 1 ; 
          }
          else if( mid == nums.length - 1 )
          {
            if( nums[mid-1] > nums[mid] ) return mid-1;
            else return mid ;
          }
      } 
    return 0 ;
        
    }
}