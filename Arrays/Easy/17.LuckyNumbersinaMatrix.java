
class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) 
    {
    		List<Integer> result = new ArrayList<Integer>() ;

	    	for( int i = 0 ; i < matrix.length ; i++ )
	    	{
	    			int min = Integer.MAX_VALUE ;
	    			int row = 0 ;
	    			int col = 0 ; 

	    			for( int j = 0 ; j < matrix[0].length ; j++ )
	    			{
	    					if( min > matrix[i][j] )
	    					{
	    						min = matrix[i][j] ;
	    						row = i ;
	    						col = j ;
	    					}
	    			}

	    			int max = Integer.MIN_VALUE ;

	    			for( int k = 0 ; k < matrix.length ; k++ )
	    			{
	    					if( matrix[k][col] > max )
	    							max = ( max < matrix[k][col] ) ? matrix[k][col] : max ;
	    			}

	    			if( max == min )
	    						result.add( min ) ;
	      } 
      return result ;
    }
}