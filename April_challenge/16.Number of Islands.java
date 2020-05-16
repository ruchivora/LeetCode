/*
	Very different question . Here DFS is used to ensure that
	the counter of no_of_islands isincreaded by one .

	Difficult Question . But understood the concept of DFS .
	Source : https://www.youtube.com/watch?v=o8S2bO3pmO4

	Given a 2d grid map of '1's (land) and '0's (water), 
	count the number of islands. An island is surrounded 
	by water and is formed by connecting adjacent lands 
	horizontally or vertically. You may assume all four 
	edges of the grid are all surrounded by water.

	Example 1:

	Input:
	11110
	11010
	11000
	00000

	Output: 1
	
	Example 2:

	Input:
	11000
	11000
	00100
	00011

    Output: 3
*/


class Solution {
    public int numIslands(char[][] grid) {

    int no_of_islands = 0 ;
        

    /*
		Here the array consists of character and not integer . 
    */
    if( grid.length == 0 || grid == null )
    	return 0;

     for( int i = 0 ; i < grid.length ; i++ )
     {
     	for( int j = 0 ; j < grid[i].length ; j++ )
     	{
     		if( grid[i][j] == '1' )
     			no_of_islands += dfs( grid , i , j );
     	}
     }
     	return no_of_islands ;
    }

	    public int dfs( int grid[][] , int i , int j )
	    {
	    	if( i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0' )
	    		return  0 ; 

	    	grid[i][j] = '0' ;
	    	dfs( grid , i+1 , j ) ;
	    	dfs( grid , i-1 , j ) ;
	    	dfs( grid , i , j+1 ) ;
	    	dfs( grid , i , j-1 ) ;

	    	return 1 ;
	    }

}