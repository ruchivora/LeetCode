class Solution 
{
  public int uniquePaths( int m , int n ) 
  {
   		if( m == 1 || n == 1 ) return 1 ; 

   	return countPath( m , n , m , n ) ; 
  }

  public int countPath( int m , int n , int i , int j )
  {
  	if( i == 1 && j == 1 )
  				return 1 ; 

  	if( i < 1 || j < 1 )
  				return 0 ;

  	return countPath( m , n , i - 1 , j ) + countPath( m , n , i , j - 1 ) ; 
  }
}

/* Convert this to DP array */