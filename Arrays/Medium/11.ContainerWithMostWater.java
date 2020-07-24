/*
		Here the idea is we move the pointer based on the value that it contains.
		If heights[left] < heights[right] then increment left else increment right .
		 - Here the idea is we will keep the greater element and increase the 
		   pointer of element which is smaller because that may give us higher
		   value for max .

		 Reference : https://www.youtube.com/watch?v=TI3e-17YAlc
*/

class Solution 
{
  public int maxArea(int[] heights) 
  {
  		int left  = 0 ; 
  		int right = heights.length - 1 ;
  		int max   = Integer.MIN_VALUE ;

  		while( left <= right )
  		{
  				int area = Math.min( heights[left] , heights[right] ) * ( right - left ) ;
  				max      = Math.max( max , area ) ;

  				if( heights[ left ] < heights[ right ] )
  						left++ ;
  				else right-- ; 
  		}	
  	return max ;  
	}
}

/* Brute Force Approach */
class Solution 
{
  public int maxArea(int[] heights) 
  {
	  	int max = Integer.MIN_VALUE ; 

	  	for( int i = 0 ; i < heights.length - 1 ; i++ )
	  	{
	    		for( int j = i + 1 ; j < heights.length ; j++ )
	    		{
	    				int area = Math.min( heights[i] , heights[j] ) * ( j - i ) ;
	    				max      = Math.max( max , area ) ;
	    		}
	  	}
	  return max ; 
  }
}