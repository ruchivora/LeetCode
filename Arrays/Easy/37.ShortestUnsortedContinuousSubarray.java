/*
    Very Good Question ! .

    Solution 1: Using a clone Array that consists of sorted array takes 
                more Space . 
    
    So coming up with better Approch .
    
    Solution 2: The basic concept is , if the array is Sorted
                then arr[i] < arr[ i + 1 ] . If some element 
                violates this condition then , that becomes the 
                brgining of sorting .
                Consider test case as : [ 1,3,4,7,6,2,12,10,9,11 ] , [1,3,2,4,5]

    Reference : https://www.youtube.com/watch?v=UfBfr-VRYOU  
  
*/

/* Better Approach*/

class Solution 
{
    public int findUnsortedSubarray(int[] nums) 
    {
        int min = Integer.MAX_VALUE ;
        int max = Integer.MIN_VALUE ; 

        for( int i = 0 ; i < nums.length-1 ; i++ )
        {
            if( nums[i] > nums[ i + 1 ] )
                min = Math.min( min , nums[ i + 1 ] ) ;
        }

        for( int i = nums.length - 1 ; i > 0 ; i-- )
        {
            if( nums[i] < nums[i-1] )
                max = Math.max( max , nums[i-1] ) ;
        }

        int start  = 0 ;
        int end    = 0 ;

        for( int i = 0 ; i < nums.length ; i++ )
        {
            if( nums[i] > min )
            {
              start = i ; break ;
            }
        }

        for( int i = nums.length - 1 ; i >= 0 ; i-- )
        {
            if( nums[i] < max )
            {
              end = i ; break ;
            }
        }
    return( end - start > 0 ) ? end - start + 1 : 0 ;
  }
}


/* Takes more space .*/

class Solution 
{
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
       			end   = Math.max( end   , i ) ;
       		}
       }
     return ( start < end ) ? end - start + 1 : 0 ; 
    }
}

