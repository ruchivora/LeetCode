class Solution 
{
    public int threeSumClosest( int[] nums, int target ) 
    {
        Arrays.sort( nums ) ;
        int left  = 0 ; 
        int right = nums.length - 1 ;
        int min   = Integer.MAX_VALUE ; 
        int ans   = 0 ;

        for( int i = 0 ; i < nums.length ; i++ )
        {
        		left  = i + 1 ;
        		right = nums.length - 1 ;

        		while( left < right )
        		{
        				int sum = nums[i] + nums[left] + nums[right] ;

        				if( Math.abs( min ) > Math.abs( sum - target ) )
        				{
        						min = target - sum  ;
        						ans = sum ;
        				}
        				if( sum < target ) left++ ;
        				else right-- ;	
        		}
        } 
      return ans ;
    }
}




















/*
		As the problem is based on decision . We can use recursion .
		So below is the recursive version .

		So if we convert recursion to Dynamic Programming 
		then Time Complxity : O(N2) and Space Complexity : O(N2) . 
		But i don't know how to convert .
*/
class Solution 
{
		int min = Integer.MAX_VALUE ;
		int ans = 0 ;

    public int threeSumClosest(int[] nums, int target) 
    {
    		threeSum( nums , nums.length , 0 , 0 , target) ;
    		return ans ;
    }

    public void threeSum( int nums[] , int index , int sum , int count , int target )
    {
    		if( count > 2  )
    		{
            if( Math.abs(min) > Math.abs(sum - target) )
            {
            		min = sum - target ; 
            		ans = sum ;
            }
    				return  ;
    		}

    		if( index ==  0 )
    				return  ;

    		threeSum( nums , index - 1 , sum + nums[index-1] , count + 1 , target ) ;
    		threeSum( nums , index - 1 , sum , count , target ) ;
    }
}


/* */