/*
		Unbounded Knapsack : Means you can consider one element any number of time .
		Question : https://www.geeksforgeeks.org/unbounded-knapsack-repetition-items-allowed/

		How to write dynamic Programming Solution for it ?
		 - Write recursive solution , convert the recursive
		   solution to Dynamic Programming solution .

		Reference : https://www.youtube.com/watch?v=aycn9KO8_Ls&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=13

*/

/* Recursive Solution . */
static int knapSack( int W , int wt[] , int val[] , int n ) 
{ 
	  if( W == 0 || n == 0 )
					return 0 ;

		if( wt[ n - 1 ] <= W )
					return Math.max( val[ n - 1 ] + knapSack( W - wt[ n - 1 ] , wt , val , n ) , 
																					knapSack( W , wt , val , n - 1 ) 
													) ;

		else return knapSack( W , wt , val , n - 1 ) ;
} 

/*
		Dynamic Programming Solution . 
*/

class Knapsack { 

	static int knapSack( int W , int wt[] , int val[] , int n ) 
	{ 
			int t[][] = new int[ n + 1 ][ W + 1 ] ;

			for( int i = 0 ; i <= n ; i++ )
			{
				for( int j = 0 ; j <= W ; j++ )
				{
						if( i == 0 || j == 0 )
								t[i][j] = 0 ;

						else if( wt[ i - 1 ] <= j )
											t[i][j] = Math.max( val[ i - 1 ] + t[i][ j - wt[ i - 1 ]] , t[ i - 1 ][ j ] ) ;

						else t[i][j] = t[ i - 1 ][ j ] ; 
				}
			}
		return t[n][W] ;
	} 

	public static void main(String args[]) 
	{ 
		int val[] = new int[] { 60, 100, 120 } ; 
		int wt[]  = new int[] { 10, 20, 30 } ; 
		int W = 50 ; 
		int n = val.length ; 
		System.out.println( knapSack( W , wt , val , n ) ); 
	} 
} 
