/*
		First write recursive solution and then write Dynamic Programming 
		Approach of it . 

		Question : https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/

		Reference : https://www.youtube.com/watch?v=ntCGbPMeqgg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=5
*/

/* Recursive Approach */

static int knapSack(int W, int wt[], int val[], int n) 
{
		if( n == 0 || W == 0 )
				return 0 ;

		if( wt[ n - 1 ] > W )
				return knapSack( W , wt ,val , n - 1 ) ;

		else return Math.max( val[ n - 1 ] + knapSack( W - wt[n - 1 ] , wt ,val , n - 1 ) , 
												                 knapSack( W , wt , val , n - 1 )
												) ;
}

/* Converting Recursion to Dynamic Approach */

class Knapsack
{ 

	static int knapSack(int W, int wt[], int val[], int n) 
	{ 
		int t[][] = new int [ n + 1 ][ W + 1 ] ;

		for( int i = 0 ; i <= n ; i++ )
		{
			for( int j = 0 ; j <= W ; j++ )
			{
					if( i == 0 || j == 0 )
							t[i][j] = 0 ;

					else if( wt[ i - 1 ] <= j )
					{
						t[i][j] = Math.max( val[ i - 1 ] + t[ i - 1 ][ j - wt[ i - 1] ] , t[ i - 1 ][j] ) ; 
					}
					else 
						t[i][j] = t[ i - 1 ][j] ;
			}
		}
		return t[n][W] ;
	} 

	
	public static void main(String args[]) 
	{ 
		int val[] = new int[] { 60, 100, 120 } ; 
		int wt[]  = new int[] { 10, 20, 30 }   ; 
		int W = 50 ; 
		int n = val.length ; 
		System.out.println( knapSack(W, wt, val, n) ) ; 
	} 
} 

