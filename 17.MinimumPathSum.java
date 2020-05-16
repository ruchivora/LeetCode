/*
	Given a m x n grid filled with non-negative numbers, 
	find a path from top left to bottom right which minimizes 
	the sum of all numbers along its path.

	Note: You can only move either down or right at any point in time.

	Example:

	Input:
			[
			  [1,3,1],
			  [1,5,1],
			  [4,2,1]
			]
	Output: 7
	Explanation: Because the path 1→3→1→1→1 minimizes the sum.
*/


class Solution {
    public int minPathSum(int[][] grid) {

    if( grid == null || grid.length == 0 )
       return 0 ;

    int sol[][] = new int[grid.length][grid[0].length] ;

    for( int i = 0 ; i < grid.length ; i++ )
    {
    	for( int j = 0 ; j < grid[0].length ; j++ )
    	{
    		sol[i][j] = sol[i][j] + grid[i][j] ;
    		if( i > 0 && j > 0 )
    		{
    			sol[i][j] += Math.min(sol[i-1][j],sol[i][j-1]) ;
    		}
    		else if( i > 0 ){
    				sol[i][j] += sol[i-1][j] ;
    			}
    			else if( j > 0 )
    			     sol[i][j] += sol[i][j-1] ;

    	}
    }

    return sol[grid.length-1][grid[0].length-1] ;
        
    }
}