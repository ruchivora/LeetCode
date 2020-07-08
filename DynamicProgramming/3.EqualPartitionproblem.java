/*
		This problem is similar to 0/1 napsack .
		But How ? as here Sum is not given . 

		Solution  : We have to partition into two equal sum  . 
								So calculate sum of all elements and if the 
							  sum % 2 = 0 , then we can partition it into
							  two parts . Otherwise return false . 

							  Here our sum would be sum/2 because if we 
							  find one partition with sum/2 then remaining 
							  elements will form sum/2 . i.e other Partition. 

							  Write Recursive Solution and then convert to DP .

	  Reference : https://www.youtube.com/watch?v=UmMh7xp07kY&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=8
*/

/* 
	  A utility function that returns true if there is a 
	  subset of arr[] with sum equal to given sum .
*/
	static boolean isSubsetSum (int arr[], int n, int sum) 
	{ 
		if( sum == 0 )
         return true ;

    if( n <= 0 )
        return false ;
      	
    if( arr[n - 1] >  sum )
        return isSubsetSum( arr, n - 1 , sum ) ;
      	
    return ( isSubsetSum( arr , n - 1 , sum - arr[n-1] ) || isSubsetSum( arr , n - 1 , sum ) ) ; 
	} 

/*
		Dynamic Programming Approach .
		Here n and i of recursive solution is replaced by i and j .
*/
import java.io.*; 

class Partition 
{ 
	static boolean isSubsetSum( int arr[] , int n , int sum )
	{
		boolean t[][] = new boolean[ n + 1 ][ sum + 1 ] ;

			for( int i = 0 ; i <= n ; i++ )
			{
				for( int j = 0 ; j <= sum ; j++ )
				{
					  if( i == 0 && j == 0 )
					 			t[i][j] = true ; 

					 	else if( i == 0 )
					 					 t[i][j] = false ;

					 	else if( j == 0 )
	                    t[i][j] = true ;

	          else if(  arr[ i - 1 ] <= j  )
	          					t[i][j] = t[ i - 1 ][ j - arr[ i - 1 ] ] || t[ i - 1 ][j] ;
	          			else
	          			   t[i][j] = t[ i - 1 ][j] ;  
				}
			} 
		return t[ n ][ sum ] ;
	}

	static boolean findPartition ( int arr[], int n ) 
	{ 
		int sum = 0; 
		for ( int i = 0; i < n; i++ ) 
					sum += arr[i]; 

		if ( sum % 2 != 0) 
			    return false; 

		return isSubsetSum ( arr , n , sum / 2 ); 
	} 

	public static void main (String[] args) 
	{ 
		int arr[] = { 3, 1, 5, 9, 12 } ; 
		int n = arr.length ; 

		if( findPartition( arr , n ) )
		  		System.out.println( "Yes" ) ;
		else  
			System.out.println( "No" )
	} 

} 
