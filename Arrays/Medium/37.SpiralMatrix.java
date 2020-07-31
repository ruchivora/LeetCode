/*
		This is a bit tricky Question . But understand the logic .
		Reference : https://www.youtube.com/watch?v=1ZGJzvkcLsA&t=11s

		The Question Spiral Matrix II is similar to this .

*/

class Solution 
{
  public List<Integer> spiralOrder(int[][] matrix) 
  {
    	List<Integer> result = new ArrayList<Integer>() ;

    	if( matrix.length == 0 ) return result ;

    	int direction = 0 ;
    	int top       = 0 ;
    	int bottom    = matrix.length - 1 ;
    	int left      = 0 ;
    	int right     = matrix[0].length - 1 ;

    	while( left <= right && top <= bottom )
    	{
	    		if( direction == 0 )
	    		{
	    			for( int i = left ; i <= right ; i++ )
	    						result.add( matrix[top][i] ) ;
	    			top++ ;
	    		}
	    		else if( direction == 1 )
	    		{
	    			for( int j = top ; j <= bottom ; j++ )
	    			 				result.add( matrix[j][right] ) ;
	    			right-- ;
	    		}
	    		else if( direction  == 2 )
	    		{
	    			for( int k = right ; k >= left ; k-- )
	    							result.add( matrix[bottom][k] ) ;
	    			bottom-- ;
	    		}
	    		else if( direction == 3 )
	    		{
	    			for( int l = bottom ; l >= top ; l-- )
	    						result.add( matrix[l][left] ) ;
	    			left++ ;
	    		}
    		direction = ( direction + 1 ) % 4 ;
    	}
    return result ;     
  }
}