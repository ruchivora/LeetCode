class SumThree
{
	public static void main( String args[] )
	{
		int input[] = { 2,7,4,0,9,5,1,3 } ;
		int sum     = 6 ;
		int k       = 3 ;
		int data[]  = new int[k] ;

		tripletSum( input , 0 , data , 0 , 0 , sum , k ) ;
	}

	public static void tripletSum( int input[] , int index , int data[] , int dataIndex , int curSum , int sum , int k )
	{

			if( data.length == k )
			{
				if( curSum == sum  )
				{
					for( int i = 0 ; i < data.length ; i++ )
								System.out.print( data[i] ) ;
						System.out.println() ;
						return ;
				}
				else return ;
			}

			if( index >= input.length || curSum > sum )
					return ;

			data[ dataIndex ] = input[ index ] ; 

			tripletSum( input , index + 1 , data , dataIndex + 1 , curSum + data[dataIndex] , sum , k ) ;
			tripletSum( input , index + 1 , data , dataIndex  , curSum , sum , k ) ;

	}

}