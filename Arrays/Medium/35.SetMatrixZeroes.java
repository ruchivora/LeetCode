/*
		My solution : If matrix[i][j] == 0 then convert to -2 and else make oother elements
		 							of rows and cols as -1 .
									But for this solution to pass all the test cases , all the elements 
									should be positive . But no where in the question it is mentioned
									that all the elements are positive .

		Better Solution : https://www.youtube.com/watch?v=1KnLIAvTxjQ

		In this we use first row and first column for marking if the corrsp.
		row contains 0 or corrsp. col contains 0 or not .

*/

class Solution
{
	public void setZeroes(int[][] matrix) 
  {
  	if( matrix.length == 0 || matrix == null || matrix[0].length == 0 )
  				return ;

  	int m = matrix.length ; 
  	int n = matrix[0].length ; 
  	boolean firstRowZero = false ;
  	boolean firstColZero = false ;

  	for( int j = 0 ; j < n ; j++ )
  	{
  		if( matrix[0][j] == 0 )
  		{
  			firstRowZero = true ;
  			break ;
  		}
  	}

  	for( int i = 0 ; i < m ; i++ )
  	{
  		if( matrix[i][0] == 0 )
  		{
  			firstColZero = true ; 
  			break ; 
  		}
  	}

  	for( int i = 1 ; i < m ; i++ )
  	{
  		for( int j = 1 ; j < n ; j++ )
  		{
  			if( matrix[i][j] == 0 )
  			{
  				matrix[0][j] = 0 ;
  				matrix[i][0] = 0 ;
  			}
  		}
  	}

  	for( int i = 1 ; i < m ; i++ )
  	{
  		for( int j = 1 ; j < n ; j++ )
  		{
  			if( matrix[0][j] == 0 || matrix[i][0] == 0 )
  						matrix[i][j] = 0 ;
  		}
  	}

  	if( firstRowZero )
  	{
  		for( int j = 0 ; j < n ; j++ )
  					matrix[0][j] = 0 ;
  	}

  	if( firstColZero )
  	{
  		for( int i = 0 ; i < m ; i++ )
  					matrix[i][0] = 0 ;
  	}

  }
}





















class Solution 
{
  public void setZeroes(int[][] matrix) 
  {
	  	int rows = matrix.length ; 
	  	int cols = matrix[0].length ;

	  	for( int i = 0 ; i < rows ; i++ )
	  	{
	  		for( int j = 0 ; j < cols ; j++ )
	  		{
	  			if( matrix[i][j] == 0 || matrix[i][j] == -2 )
	  						change( matrix , i , j ) ;
	  		}
	  	}

	  	for( int i = 0 ; i < rows ; i++ )
	  	{
	  		for( int j = 0 ; j < cols ; j++ )
	  		{
	  				if( matrix[i][j] < 0 )
	  						matrix[i][j] = 0 ;
	  		}
	  	}
  }

  public void change( int matrix[][] , int row , int col )
  {
  	for( int i = 0 ; i < matrix[0].length ; i++ )
  	{
  		if( matrix[row][i] == 0 )
  					matrix[row][i] = -2 ;

  		else if( matrix[row][i] == -2 )
  							matrix[row][i] = -2 ;

  		else matrix[row][i] = -1 ;
  	}

  	for( int j = 0 ; j < matrix.length ; j++ )
  	{
  		if( matrix[j][col] == 0 )
  					matrix[j][col] = -2 ;

  		else if( matrix[j][col] == -2 )
  							matrix[j][col] = -2 ;

  		else matrix[j][col] = -1 ;
  	}
  }
}