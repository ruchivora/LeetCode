class Solution {
    public List<Integer> findDuplicates(int[] nums) 
    {
    		List<Integer> result = new ArrayList<Integer>() ;

    		for( int i = 0 ; i < nums.length ; i++ )
    		{
    			 int x = Math.abs( nums[i] ) ;

    			 if( nums[ x - 1] > 0 )
    			 			nums[x - 1 ] = nums[x - 1] * -1 ;
    			 else
    			 	  result.add( x ) ;
    		}
    	return result ;  
    }
}