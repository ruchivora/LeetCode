/*
		Question is similar to subsetSum which is similar to 0/1 Knapsack .

		Here we have to return the count and not just a boolean value .

		Referene : https://www.youtube.com/watch?v=F7wqWbqYn9g&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=9
*/

/* 	
		Recursive function to return the count 
  	of subsets with sum equal to the given value.

  	The function is similar to subset Sum . 
  	Just understand how variable count is being returned .
*/ 

static int subsetSum( int arr[] , int n , int sum , int count ) 
{
		if( sum == 0 )
				return ++count ;

    if( n == 0 )
        return count ;

    if( arr[i-1] <= sum )
     		return subsetSum( arr , n - 1 , sum - arr[ n - 1 ] , count ) + subsetSum( arr , n - 1 , sum , count ) ;
   
		else return subsetSum( arr , n - 1 , sum , count ) ;
}

/*
		Converting Recursion to DP .
		Also for initializing the matrix of DP , use common sense i.e common base case .
		Here n and sum is replaced by i and j .
*/

import java.util.*; 

class GFG 
{ 
	static int subsetSum( int arr[] , int n , int sum ) 
	{
			int t[][] = new int[ n + 1 ][ sum + 1 ] ;

			for( int i = 0 ; i <= n ; i++ )
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
										t[i][j] = t[ i - 1 ][j - arr[ i - 1 ] ] + t[ i - 1 ] [j] ;

					else  t[i][j] = t[ i - 1 ][ j ] ;
				}
			}
		return t[n][sum] ;
	}

	public static void main(String[] args) 
	{ 
		int arr[] = { 1, 2, 3, 4, 5 }; 
		int sum = 10; 
		int n = arr.length; 

		System.out.print( subsetSum( arr, n , sum, 0 ) ) ; 
	} 
} 


