/*
		For Question : https://www.geeksforgeeks.org/program-find-minimum-maximum-element-array/

		Recursive Code but it can futher be reduced to minimum
		number of lines .
*/
class FindMaxAndMin
{
	  static int max     = Integer.MIN_VALUE ;
	  static int min     = Integer.MAX_VALUE ;

		public static void main( String args[] )
		{
			int input[] = { 1,5,6,12,55,24,36 } ;
			
			System.out.println( findMax( input , input.length , 0  ) ) ;
			System.out.println( findMin( input , input.length , 0  ) ) ;
		}

		public static int findMax( int input[] , int n , int index  )
		{
			if( index >= n )
					return max ; 
			max  = ( max > input[index] ) ? max : input[ index ] ;
			findMax( input , n , index+1 ) ;
			return max ;
		}

		public static int findMin( int input[] , int n , int index  )
		{
			if( index >= n )
					return min ; 
			min  = ( min < input[index] ) ? min : input[ index ] ;
			findMin( input , n , index+1 ) ;
			return min ;
		}
}

/*
		Recursive Code with minimal number of lines .
*/
class FindMaxAndMin
{
		public static void main( String args[] )
		{
			int input[] = { 1,5,6,12,55,24,36 } ;
			
			System.out.println( findMax( input , input.length - 1 , 0 ) ) ;
			System.out.println( findMin( input , input.length - 1 , 0 ) ) ;
		}

		public static int findMax( int input[] , int n , int index  )
		{
			return ( n == 1 ) ? input[index] : Math.max( input[index] , findMax( input , n - 1 , index + 1 ) ) ;
		}

		public static int  findMin ( int input[] , int n , int index )
		{
			return ( n == 1 ) ? input[index] : Math.min( input[index] , findMin( input , n - 1 , index + 1) ) ;
		}
}