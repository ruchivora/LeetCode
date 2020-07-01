/*
		For Question : https://www.geeksforgeeks.org/sum-triangle-from-array/

		Solution : The question is similar to pascal triangle , 
							 But in reverse Order .
*/

class SumTriangle
{
		public static void main( String args[] )
		{
			int input[] = { 1,2,3,4,5 } ;

			printArray( input , input.length ) ;
		}

		public static void printArray( int input[] , int n )
		{
			if( n <= 0 )
				return ;

			int arr[] = new int[n-1] ;
			for( int i = 0 ; i < n-1 ; i++ )
						arr[i] = input[ i ] + input[ i + 1 ] ;
			
			printArray( arr , n - 1 ) ;

			System.out.println( Arrays.toString( input ) ) ;
		}
}