/*
		For Question : https://www.geeksforgeeks.org/shortest-common-supersequence/

		Reference : https://www.youtube.com/watch?v=823Grn4_dCQ&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=24
*/


/* Approach One : Using Longest common subsequence .*/

/* Recursion of Longest common subsequence .*/
static int lcs( char X[] , char Y[] , int m , int n ) 
{ 
		if( m == 0 || n == 0 )
				return 0 ;

		else if( X[ m - 1 ] == Y[ n - 1 ] )
							return 1 + lcs( X , Y , m - 1 , n - 1 ) ;

					else return Math.max( lcs( X , Y , m , n - 1 ) , lcs( X , Y , m - 1 , n  ) ) ;
}

/* Dynamic Programming Aprroach */

class GFG 
{ 
	static int shortestSuperSequence( char X[] , char Y[] , int m , int n ) 
	{ 
			int t[][] = new int[ m + 1 ][ n + 1 ] ;

			for( int i = 0 ; i <= m ; i++ )
			{
				for( int j = 0 ; j <= n ; j++ )
				{
						if( i == 0 || j == 0 )
									t[i][j] = 0 ;

						else  if( X[ i - 1 ] == Y[ j - 1 ] )
												t[i][j] = 1 + t[ i - 1 ][ j - 1 ] ;

									else t[i][j] = Math.max( t[ i - 1 ][j] , t[i][ j - 1] ) ;
				}
			}
		return m + n - t[m][n] ;
	} 
	
	
	public static void main(String args[]) 
	{ 
	 	String p = "AGGTAB"  ; 
		String q = "GXTXAYB" ; 

		char X[] = p.toCharArray() ;
		char Y[] = q.toCharArray() ;

		int m = X.length ;
		int n = Y.length ;
	
		System.out.println("Length of the shortest " + 
							"supersequence is " + 
					shortestSuperSequence( X , Y , m , n) ); 
	} 
} 


/* Approach Two */



/* Recursive Solution */
static int lcs( char X[] , char Y[] , int m , int n ) 
{ 
		if( m == 0 ) return n ;
		if( n == 0 ) return m ;

		else if( X[ m - 1 ] == Y[ n - 1 ] )
							return 1 + lcs( X , Y , m - 1 , n - 1 ) ;

					else return 1 + Math.min( lcs( X , Y , m , n - 1 ) , lcs( X , Y , m - 1 , n  ) ) ;
}

/* Dynamic Programming Solution */
class GFG 
{ 
	static int shortestSuperSequence( char X[] , char Y[] , int m , int n ) 
	{ 
			int t[][] = new int[ m + 1 ][ n + 1 ] ;

			for( int i = 0 ; i <= m ; i++ )
			{
				for( int j = 0 ; j <= n ; j++ )
				{
						if( i == 0  )
									t[i][j] = j ;

						else if( j == 0 )
											t[i][j] = i ; 

						else  if( X[ i - 1 ] == Y[ j - 1 ] )
												t[i][j] = 1 + t[ i - 1 ][ j - 1 ] ;

									else t[i][j] =  1 + Math.min( t[ i - 1 ][j] , t[i][ j - 1] ) ;
				}
			}
		return t[m][n] ;
	} 
	
	
	public static void main(String args[]) 
	{ 
	 	String p = "AGGTAB"  ; 
		String q = "GXTXAYB" ; 

		char X[] = p.toCharArray() ;
		char Y[] = q.toCharArray() ;

		int m = X.length ;
		int n = Y.length ;
	
		System.out.println("Length of the shortest " + 
							"supersequence is " + 
					shortestSuperSequence( X , Y , m , n) ); 
	} 
} 




