/*
		For Question :https://www.geeksforgeeks.org/print-increasing-sequences-length-k-first-n-natural-numbers/
		
*/
class IncreasingSequence
{	
		public static void main( String args[] )
		{
			int k = 3 ;
			int n = 5 ;
			int input[]  = new int[n] ;
			int result[] = new int[k] ;

			for( int i = 0 ; i < n ; i++ )
							input[i] = i+1 ;

			PrintSequence( input , result , n , 0 , 0 , k ) ;
		}

		public static void PrintSequence( int input[] , int result[] , int n , int index , int resultIndex , int k )
		{
				if( resultIndex == k )
				{
					for( int i = 0 ; i < k ; i++ )
					 			System.out.print( result[i] +" " ) ;
					 		System.out.println() ;
					return ;
				}

				if( index >= n ) return ;

				result[ resultIndex ] = input[index] ;

				PrintSequence( input , result , n , index + 1 , resultIndex+1 , k ) ;
				PrintSequence( input , result , n , index + 1 , resultIndex , k ) ;
		}

}