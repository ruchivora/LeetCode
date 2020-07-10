/*
		Question  : https://www.geeksforgeeks.org/minimum-number-deletions-insertions-transform-one-string-another/

		Reference : https://www.youtube.com/watch?v=-fx6aDxcWyg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=25

*/

import java.io.*; 

class GFG 
{ 
	static int printMinDelAndInsert( char X[] , char Y[] , int m , int n ) 
	{ 
			int t [][] = new int[ m + 1 ][ n + 1 ] ;

			for( int i = 0 ; i <= m ; i++ )
			{
				for( int j = 0 ; j <= n ; j++ )
				{
					  if( i == 0 || j == 0 )
					  			t[i][j] = 0 ;

					  else if( X[ i - 1 ] == Y[ j - 1 ] )
												t[i][j] = 1 + t[ i - 1 ][ j - 1 ] ;

									else t[i][j] = Math.max( t[ i - 1 ][j] , t[i][ j - 1] ) ;
				}
			}
			return t[m][n] ;
	} 

	public static void NumbOfInsertAndDelete( char X[] , char Y[] , int m , int n )
	{
		int lcs = printMinDelAndInsert( X , Y , m , n ) ;

		System.out.println( " No of deletion  " + ( m - lcs )  ) ;
		System.out.println( " No of insertion " + ( n - lcs ) ) ;

	}

	public static void main(String[] args) 
	{ 
			String str1 = new String( "heap" ) ; 
			String str2 = new String( "pea" )  ; 

			char X[] = str1.toCharArray() ; 
			char Y[] = str2.toCharArray() ;

			int m = X.length ;
			int n = Y.length ;

			NumbOfInsertAndDelete( X , Y , m , n ) ; 
	} 
} 
