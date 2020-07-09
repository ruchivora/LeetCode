/*
		This problem is same as Unbounded Knapsack . 
		In the Question if only price array is given then construct 
		array that consists of length of rod and also define the
		variable size .

		How to solve ?
			- Write recursive solution . 
			- Convert to Dynamic Program .

		Question  : https://www.geeksforgeeks.org/cutting-a-rod-dp-13/
		Reference : https://www.youtube.com/watch?v=SZqAQLjDsag&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=14
								https://www.youtube.com/watch?v=aycn9KO8_Ls&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=13 

*/

/* Recursive Solution */

	static int cutRod( int rod[] , int price[] , int size , int n  ) 
	{ 
			if( size == 0 || n == 0 )
					return 0 ;

			 else if( rod[ n - 1 ] <= size )
							return Math.max( price[n - 1] + cutRod( rod , price , size - rod[ n - 1] , n) ,
																							cutRod( rod , price , size , n - 1 )  
															) ; 

					  else return cutRod( rod , price , size , n - 1 ) ; 
	}


/* Dynamic Programming */
class RodCutting 
{ 
	static int cutRod( int rod[] , int price[] , int size , int n  ) 
	{ 
			int t[][] = new int[ n + 1 ][ size + 1 ] ;

			for( int i = 0 ; i <= n ; i++ )
			{
					for( int j = 0 ; j <= size ; j++ )
					{
							if( i == 0 || j == 0 )
									t[i][j] = 0 ;

							else if( rod[ i - 1 ] <= j )
											 t[i][j] = Math.max( price[ i - 1 ] + t[i][ j - rod[ i - 1 ] ] , t[ i - 1 ][j] ) ;

										else t[i][j] = t[ i - 1 ][j] ; 
					}
			}
		return t[n][size] ;
	} 

	
	public static void main(String args[]) 
	{ 
		/*
				In this problem only price was given . 
				So , you have to construct rod and size Parameters .
		*/

    int rod[]   = new int[] { 1, 2, 3, 4, 5, 6, 7, 8    } ; 
		int price[] = new int[] { 1, 5, 8, 9, 10, 17, 17, 20 } ; 
		int size    = rod.length ; 

		System.out.println("Maximum Obtainable Value is "+ 
							cutRod( rod , price , size , rod.length ) ) ; 
	} 
} 
