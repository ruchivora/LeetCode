/*
		Just understand the concept  
		Reference : https://www.youtube.com/watch?v=Z2h3rkVXPeQ&t=1134s
*/

class Solution {
    public int countSquares(int[][] matrix) 
    {
	    	int count = 0 ;

	      for( int i = 0 ; i < matrix.length ; i++ )
	      {
	       	for( int j = 0 ; j < matrix[0].length ; j++ )
	        {
		        	if( i != 0 && j != 0 && matrix[i][j] == 1 )
		        	{
		        			matrix[i][j] = matrix[i][j] + Math.min( matrix[i-1][j-1] , Math.min( matrix[i-1][j] , matrix[i][j-1] ) ) ;
		        	}
	        		count = count + matrix[i][j] ;
	        }
	      }
      return count ;
    }
}