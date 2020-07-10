/* Recursive Solution */
int lcs( char[] X, char[] Y, int m, int n ) 
{ 
	  if( m == 0 || n == 0 )
						return 0 ;

		else  if( X[ m - 1 ] == Y[ n - 1 ] )
							return 1 + lcs( X , Y , m - 1 , n - 1 ) ;

					else return Math.max( lcs( X , Y , m - 1 , n ) , lcs( X , Y , m , n - 1 ) ) ;
} 

/*
		Dynamic Programming Solution .
*/

public class LongestCommonSubsequence 
{ 
	static String lcs( char[] X, char[] Y, int m, int n ) 
	{
			int t[][] = new int[ m + 1 ][ n + 1 ] ;

			/* Code that calculates the DP matrix . */

			for( int i = 0 ; i <= m ; i++ )
			{
				for( int j = 0 ; j <= n ; j++ )
				{
						if( i == 0 || j == 0 )
									t[i][j] = 0 ;

						else  if( X[ i - 1 ] == Y[ j - 1 ] )
											 t[i][j] = 1 + t[ i - 1 ][ j - 1 ] ;

									else t[i][j] = Math.max( t[ i - 1 ][j] , t[i][ j - 1 ] ) ;		
				}
			}
		
		int i = m ; 
		int j = n ;
		StringBuilder result = new StringBuilder() ;

		/* Code for printing the Longest common SubSequence .*/

		while( i > 0 && j > 0 )
		{
				if( X[ i - 1 ] == Y[ j - 1 ] )
				{
						result.append( X[i -1 ] ) ;
						i-- ; 
						j-- ;
				}

				else if( t[ i - 1 ][ j ] > t[ i ][ j - 1 ] )
										i-- ;

							else j-- ;
		}

	 return result.reverse().toString() ;
	}
	

	public static void main(String[] args) 
	{ 
		String s1 = "AGGTAB"; 
		String s2 = "GXTXAYB"; 

		char[] X = s1.toCharArray() ; 
		char[] Y = s2.toCharArray() ; 

		int m = X.length ; 
		int n = Y.length ; 

		System.out.println("Length of LCS is" + " " + 
									lcs( X, Y, m, n ) ); 
	} 

} 

