/*
		Question  : https://www.geeksforgeeks.org/longest-common-substring-dp-29/
		Reference : https://www.youtube.com/watch?v=HrybPYpOvz0&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=22 

		How to convert longest common Subsequence to Longest Common Substring ?
			- In substring if the character of the strings don't match then 
			  start the counter from 0 .

		How to solve ?
		 - Write recursive Solution .
		 - Convert to Dynamic Programming . 

		Related Question : Maximum Length of Repeated Subarray .
*/

/* Recursive Solution */
static int lcs( char[] X , char[] Y , int m , int n , int count ) 
{ 
	if( m == 0 || n == 0 )
					return count ;

	else  if( X[ m - 1 ] == Y[ n - 1 ] )
							 return lcs ( X , Y , m - 1 , n - 1 , count + 1 ) ;

	return Math.max( count , Math.max( lcs ( X , Y , m - 1 , n , 0 ) , lcs ( X , Y , m , n - 1 , 0 ) )  ) ;
} 

/* Dynamic Programming Solution */

class GFG { 

	static int lcs( char[] X , char[] Y , int m , int n , int count ) 
	{
			int t[][] = new int[ m + 1 ][ n + 1 ] ;
			int max   = Integer.MIN_VALUE ;

			for( int  i = 0 ; i <= m ; i++ )
			{
					for( int j = 0 ; j <= n ; j++ )
					{
						if( i == 0 || j == 0 )
								t[i][j] = 0 ;

						else if( X[ i - 1 ] == Y[ j - 1 ] )
								  {
										t[i][j] =  1 + t[ i - 1 ][ j - 1 ] ;
										max     = ( max > t[i][j] ) ? max : t[i][j] ;
									}		
									else t[i][j] =  0  ;
					}
			}
		return max ;
	}

	public static void main(String[] args) 
	{ 
		int n, m; 
		String P = "abcdxyz"; 
		String Q = "xyzabcd"; 

	  char X[] = P.toCharArray() ;
		char Y[] = Q.toCharArray() ; 

		n = X.length ; 
		m = Y.length ; 

		System.out.println( lcs ( X , Y , m , n , 0 ) ); 
	} 
} 
