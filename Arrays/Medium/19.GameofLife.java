/*
		Approach 1 : By creating new array .
		Approach 2 : Using the same Array . 
								 - How to save the previous state of the array ? 
								 - Technique : mark die -> alive -> -1
								 							 mark alive -> die ->  2
								 							 Then update -1 -> 1 and 2 -> 0 . 

	  Check the trick and how is it executed. 
	  Because the way it is implemented is beautiful !!.

	  Reference : https://www.youtube.com/watch?v=sUqYZvfZ9UE
*/



class Solution 
{
	final static int[][] dir = { {0,-1},{0,1},{1,0},{-1,0},
															 {1,1},{1,-1},{-1,1},{-1,-1}
															} ;

  public void gameOfLife(int[][] board) 
  {
	  	if( board == null || board.length == 0 )
	  				return ;

	  	for( int i = 0 ; i < board.length ; i++ )
	  	{
	  		for( int j = 0 ; j < board[0].length ; j++ )
	  		{
	  				if( board[i][j] == 0 )
	  				{
	  					int lives = count( board , i , j ) ;
	  					if( lives == 3 )
	  							board[i][j] = -1 ;
	  				}

	  				if( board[i][j] == 1 )
	  				{
	  					int lives = count( board , i , j ) ;
	  					if( lives < 2 || lives > 3 )
	  								board[i][j] = 2 ;
	  				}
	  		}
	  	}
  	update( board ) ;	
  }

  public void update( int[][] board )
  {
  		for( int i = 0 ; i < board.length ; i++ )
  		{
  			for( int j = 0 ; j < board[0].length ; j++ )
  			{
  				if( board[i][j] == -1 )
  							board[i][j] = 1 ;

  				else if( board[i][j] == 2 )
  									board[i][j] = 0 ;
  			}
  		}
  	}
  

  public int count( int[][] board , int row , int col )
  {
  		int lives = 0 ;
  		for( int i = 0 ; i < dir.length ; i++ )
  		{
  			int newRow = row + dir[i][0] ;
  			int newCol = col + dir[i][1] ;

  			if( newRow >= 0 && newRow < board.length &&
  					newCol >= 0 && newCol < board[0].length &&
  					( board[newRow][newCol] == 1 || 
  						board[newRow][newCol] == 2 )
  				) lives++ ;
  		}
  	return lives ;
  }

}