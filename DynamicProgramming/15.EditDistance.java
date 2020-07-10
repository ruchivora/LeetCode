/*
		Here their are three choices in the decision tree .
		Insert , Delete Update .

		Question : https://www.geeksforgeeks.org/edit-distance-dp-5/

		How to solve ?
			- Form recursive Function 
			- Convert to Dynamic Programming .		

*/
/* 
			Total three choices : 1. Insert , 2 : Delete , 3 : Update
*/
	static int editDist( char X[] , char Y[] , int m , int n ) 
	{ 
			if( m == 0 ) return n ;

			if( n == 0 ) return m ;

			else if( X[ m - 1 ] == Y[ n - 1 ] )
							 return editDist( X , Y , m - 1 , n - 1 ) ;

					  else return  1 + Math.min(
																				editDist( X , Y , m , n - 1 ), /* Insert after current position */
																				 Math.min (
																 										editDist( X , Y , m - 1 , n - 1 ) , /* Replace  */
																 										editDist( X , Y , m - 1 , n )      /* Delete   */
																 									)
						                 					) ;
	} 

/* Dynamic Programming Solution */

class EDIST { 
	
	static int editDist( char X[] , char Y[] , int m , int n ) 
	{ 
			int t[][] = new int[ m + 1 ][ n + 1 ] ;

			for( int i = 0 ; i <= m ; i++ )
			{
					for( int j = 0 ; j <= n ; j++ )
					{
						if( i == 0 )
								t[i][j] = j ;

						else if( j == 0 )
							 t[i][j] = i ;

						else if( X[ i - 1 ] == Y[ j - 1 ] )
											t[i][j] = t[ i - 1 ][ j - 1 ] ;

									else t[i][j] = 1 + Math.min ( t[ i ][ j - 1 ] ,
																		 						Math.min  ( t[ i - 1 ][ j - 1 ] ,
																														t[ i - 1 ][j]
																													)
																						  ) ;
					}
			}
		return t[m][n] ;
	}
  
	public static void main(String args[]) 
	{ 
		String str1 = "sunday" ; 
		String str2 = "saturday" ;

		char X[] = str1.toCharArray() ; 
		char Y[] = str2.toCharArray() ;

		int m = X.length ;
		int n = Y.length ;

		System.out.println( editDist( X , Y , m , n ) ) ; 
	} 
} 

/* Leet Code Solution */

class Solution {
    public int minDistance( String str1, String str2 ) 
    {
        char X[] = str1.toCharArray() ; 
				char Y[] = str2.toCharArray() ;

				int m = X.length ;
				int n = Y.length ;

				int t[][] = new int[ m + 1 ][ n + 1 ] ;

				for( int i = 0 ; i <= m ; i++ )
				{
						for( int j = 0 ; j <= n ; j++ )
						{
							if( i == 0 ) 
									t[i][j] = j ;

							else if( j == 0 )
											 t[i][j] = i ;

										else if( X[ i - 1 ] == Y[ j - 1 ] )
															t[i][j] = t[ i - 1 ][ j - 1 ] ;

													else t[i][j] = 1 + Math.min( t[ i - 1 ][j] ,
																										   Math.min( t[ i - 1 ][ j - 1 ] ,
																										   					 t[ i ][ j - 1 ]
																										   					)
																										  ) ; 

						}
				}
				return t[m][n] ;
    }
}