/*
		This problem is similar to unbounded knapsack but here you have to count 
		the possible occurance of sum .

		Question  : https://www.geeksforgeeks.org/coin-change-dp-7/
		Reference : https://www.youtube.com/watch?v=I4UR2T6Ro3w&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=15
*/

/* Recursive Solution */

static int count( int arr[] , int n , int sum , int count ) 
{ 
	  if( sum == 0 )
					return  ++count ;

		if( n == 0 )
					return count ;

		else if( arr[ n - 1 ] <= sum )
						return  count( arr , n , sum - arr[ n - 1 ] , count ) + count( arr , n - 1 , sum , count ) ;

		else return count( arr , n - 1 , sum , count ) ;
} 

/* Dynamic Programming */

import java.io.*; 

class GFG { 
	
	static int count( int arr[] , int n , int sum , int count ) 
	{
			/* Here parameter count is not required . */

			int t[][] = new int[ n + 1 ][ sum + 1 ] ;

			for( int  i = 0 ; i <= n ; i++ )
			{
				for( int j = 0 ; j <= sum ; j++ )
				{
					  if( i == 0 && j == 0 )
					 			t[i][j] = 1 ;

					 	else if( i == 0 )
					 						t[i][j] = 0 ;

					 	else if( j == 0 )
					 						t[i][j] = 1 ;

					 	else if( arr[ i - 1 ] <= j )
					 					t[i][j] = t[i][ j - arr[ i - 1 ] ] + t[ i - 1 ][j] ;

					 	else  t[i][j] = t[ i - 1 ][j] ; 
				}
			}
		return t[n][sum] ;
	}
	
	public static void main(String[] args) 
	{ 
		int arr[] = { 1, 2, 3 } ; 
		int n     = arr.length  ;
		int sum   = 4 ;
		int count = 0 ;  
		System.out.println( count( arr , n , sum , count ) ) ; 
	} 
} 

