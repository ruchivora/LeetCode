/*

	Question And reference : https://www.youtube.com/watch?v=ot_XBHyqpFc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=11
	
	This Question is Similar to find the Count of subsets with sum equal to X . 

*/

import java.util.*; 

class GFG { 
	
	public static int subsetSum( int arr[] , int n , int s1 ) 
	{ 
			int t[][] = new int[ n + 1 ][ s1 + 1 ] ;

			for( int i = 0 ; i <= n ; i++ )
			{
				for( int j = 0 ; j <= s1 ; j++ )
				{
					if( i == 0 && j == 0 )
								t[i][j] = 1 ;

					else if( i == 0 )
										t[i][j] = 0 ;

					else if( j == 0 )
										t[i][j] = 1 ;

					else if( arr[ i - 1 ] <= j )
										t[i][j] = t[ i - 1 ][ j - arr[ i - 1 ] ] + t[ i - 1 ][j] ;

								else t[i][j] = t[ i - 1 ][j] ;
				}
			}
		return t[n][s1] ;
	} 

	public static int findMinDifference( int arr[] , int n, int diff )
	{
			int sum = 0 ; 

			for( int i = 0 ; i < n ; i++ )
							sum += arr[i] ;

			int s1 = diff + sum / 2 ;

			return subsetSum( arr , n , s1 ) ;
	}

	/* Driver program to test above function */
	public static void main(String[] args) 
	{ 
		int arr[] = { 3, 1, 4, 2, 2, 1 } ; 
		int n     = arr.length ;
		int diff  = 1 ; 
		
		System.out.println( findMinDifference( arr , n , diff ) ) ;
	} 
} 
	
