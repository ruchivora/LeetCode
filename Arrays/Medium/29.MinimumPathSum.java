/*
		The Recurrence is bit different then dynamic Programming .

		- Because here i have wriiten recurrance starting from [0][0]
			and not from [n-1][m-1] .
			

*/

/* Recurrance Solution */

class Solution {
    public int minPathSum(int[][] grid) 
    {
      return pathSum( grid , 0 , 0 ) ;
    }

    public int pathSum( int[][] grid , int i , int j )
    {
    	if( i == grid.length - 1 && j == grid[0].length - 1 )
    				return grid[ grid.length - 1 ][ grid[0].length - 1 ] ;

    	if( i == grid.length  || j == grid[0].length )
    				return Integer.MAX_VALUE ;

    	return  grid[i][j] + Math.min( pathSum( grid , i ,  j + 1 ) , pathSum( grid , i + 1 , j ) ) ; 

    }
}

/* Dynamic Programming */

class Solution 
{
	public int minPathSum( int [][] grid )
	{
		return pathSum( grid ) ;
	}

	public int pathSum( int[][] grid )
	{
		 int t[][] = new int[ grid.length ][ grid[0].length ] ;

		 for( int i = 0 ; i < grid.length ; i++ )
		 {
		 	  for( int j = 0 ; j < grid[0].length ; j++ )
		 	  {
		 	  		t[i][j] = grid[i][j] ; 

		 	  		if( i > 0 && j > 0 )
		 	  		{
		 	  				t[i][j] = t[i][j] + Math.min( t[ i - 1 ][j] , t[i][ j - 1 ] ) ;
		 	  		}
		 	  		else if( i > 0 )
		 	  						t[i][j] = t[i][j] + t[ i - 1 ][j] ;

		 	  				  else if( j > 0 )
		 	  				  		t[i][j] = t[i][j] + t[i][ j - 1 ] ;
		 	  }
		 }
		return t[ grid.length - 1 ][ grid[0].length - 1 ] ;
	}
}