/*
	The below problem can also be solved without using
	Binary Search . 
*/
class Solution {
    public int countNegatives(int[][] grid) 
    {
        int count = 0 ;

    	for( int i = 0 ; i < grid.length ; i++ )
    	{
    		if( grid[i][0] < 0 )
    			count += grid[0].length ;
    		else
    		{
    			int left  = 1 ;
    			int right = grid[0].length - 1 ;
    			while( left <= right )
    			{
	    			int mid = left + ( right - left ) / 2 ;

	    			if( grid[i][mid] < 0 && grid[i][mid-1] > -1 )
	    			{
	    				count += grid[0].length - mid ;
	    				break ;
	    			}

	    			if( grid[i][mid] >= 0 )
	    				    left = mid + 1 ;

	    				 else right = mid - 1 ;   
    			}
    		}
    	}
    return count ;
    }
}