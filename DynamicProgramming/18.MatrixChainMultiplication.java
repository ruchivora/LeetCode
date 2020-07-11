/*
		In Matrix chain Multiplication , have a clear idea of the
		pointers i , j , k . How will these pointers move .
		Have thorough understanding of it .

		Reference : https://www.youtube.com/watch?v=9uUVFNOT3_Y&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=35
*/

/* Recurrence  Solution */
static int MatrixChainOrder(int arr[] , int i , int j ) 
{ 
		if( i == j )
					return 0 ;

		int min = Integer.MAX_VALUE ;

		for( int k = i ; k <= j - 1 ; k++ )
		{
				int count = MatrixChainOrder( arr , i , k ) + 
									  MatrixChainOrder( arr , k + 1 , j ) + 
									  arr[ i - 1 ] * arr[k] * arr[j] ;

				min = ( count < min ) ? count : min ;
		}
	return min ;
} 

/* Memoziation Approach of Dynamic Programming */

class MatrixChainMultiplication 
{  
	static int MatrixChainOrder(int arr[] , int t[][] , int i , int j ) 
	{
		 if( i == j )
		 			return 0 ;

		 	if( t[i][j] != -1 )
		 				return t[i][j] ;

		 	int min = Integer.MAX_VALUE ;

		 	for( int k = i ; k < j ; k++ )
		 	{
		 			int count = MatrixChainOrder( arr , t , i , k ) + 
									    MatrixChainOrder( arr , t , k + 1 , j ) + 
									    arr[ i - 1 ] * arr[k] * arr[j] ;

					min = ( count < min ) ? count : min ;
		 	}

		 	t[i][j] = min ;

		 	return min ; 

	}
	
	public static void main(String args[]) 
	{ 
		int arr[] = new int[] {1, 2, 3, 4, 3} ; 
		int n     = arr.length ; 
		int t[][] = new int[ n + 1 ][ n + 1 ] ;

		for( int i = 0 ; i <= n ; i++ )
		{
			for( int j = 0 ; j <= n ; j++ )
				   t[i][j] = -1 ;
		}

		System.out.println("Minimum number of multiplications is "+ 
						MatrixChainOrder( arr, t , 1 , n - 1 ) ) ; 

	} 
} 
