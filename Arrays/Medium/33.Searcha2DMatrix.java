class Solution {
  public boolean searchMatrix(int[][] matrix, int target) 
  {
  		if( matrix.length == 0 || matrix[0].length == 0 ) return false ;

    	int row = matrix.length ;
    	int col = matrix[0].length ;

    	for( int i = 0 ; i < row ; i++ )
    	{
    			if( target >= matrix[i][0] && target <= matrix[i][ col - 1 ] ) 
    			{
    				int left  = 0  ;
    				int right = col - 1 ;
    				int mid   = 0 ; 

    				while( left <= right )
    				{
    						mid = left + ( right - left ) / 2 ;

    						if( matrix[i][mid] == target )
    									return true ;

    						if( matrix[i][mid] > target )
    							right = mid - 1 ;
    								
    						else left = mid + 1 ;
    				}
    				return false ;
    			} 
    	}
    return false ;
  }
}