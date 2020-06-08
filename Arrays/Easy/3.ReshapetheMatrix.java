class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) 
    {
    	int result[][] = new int[r][c] ;

     	if( r == 0 || c == 0 )  return result ;

     	if ( nums.length * nums[0].length != r * c ) return nums ;

     	int row = 0 ;
     	int col = 0 ;

     	for( int  i = 0 ; i < r ; i++ )
     	{
     		for( int j = 0 ; j < c ; j++ )
     		{
     			result[i][j] = nums[row][col++] ;
     			if( col > nums[0].length - 1 ) 
     			{
     				col = 0 ;
     				row++ ;
     			} 
     		}
     	}
      return result ;
    }
}