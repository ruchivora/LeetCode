/*
		Solution  : We need S2 - S1 = Minimum Difference .
							  Where S2 = Sum of some of the elements of the array .
							  and   S1 = Sum of remaining elements of the array .

							  If we have S1 then S2 = Sum of all elements - S1 . 
							  Substituting we get , [ Sum of all elements - S1 ] - S1 .
							  Sum of all elements - 2 * S1 , Which should be minimum .
		
		Question  : https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/

		Reference : https://www.youtube.com/watch?v=-GtpxG6l_Mc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=10
*/
import java.util.*; 

class GFG 
{ 
	public static boolean[] subsetSum( int arr[] , int n , int rangeSum ) 
	{ 
			boolean t[][] = new boolean[ n + 1 ][ rangeSum + 1 ] ;

			for( int i = 0 ; i <= n ; i++ )
			{
				for( int j = 0 ; j <= rangeSum ; j++ )
				{
					if( i == 0 && j == 0 )
								t[i][j] = true ;

					else if( i == 0 )
								    t[i][j] = false ;

					else if( j == 0 )
										t[i][j] = true ;

					else if( arr[ i - 1 ] <= j )
										t[i][j] = t[ i - 1 ][ j - arr[ i - 1 ] ] || t[ i - 1 ][j] ;

					else  t[i][j] = t[ i - 1 ][j] ; 
				}
			}
	
		/* Storing Last row of the DP Array */
		boolean result[] = new boolean[ rangeSum + 1 ] ;

		for( int i = 0 ; i <= rangeSum ; i++ )
						result[i] = t[n][i] ;

		return result ;
	} 

	public static int findMinDifference( int arr[] , int n )
	{
		  int range = 0 ;

		  for( int i = 0 ; i < n ; i++ )
		 				range += arr[i] ;

		 	boolean result[] = subsetSum( arr , n , range / 2 ) ; 
		 	int min = Integer.MAX_VALUE ;

		 	/* Here index i is the sum */
		 	for( int i = 0 ; i < result.length ; i++ )
		 	{
		 			if( result[i] == true &&  ( 2 * i ) <= range )
		 						min = ( min < range - (2 * i) ) ? min : range - (2 * i) ;
		 	}
		 	return min ;
	}
	
	/* Driver program to test above function */
	public static void main(String[] args) 
	{ 
		int arr[] = { 3, 1, 4, 2, 2, 1 } ; 
		int n     = arr.length ;
		
		System.out.println( findMinDifference( arr , n ) ) ;
	} 
} 
	
