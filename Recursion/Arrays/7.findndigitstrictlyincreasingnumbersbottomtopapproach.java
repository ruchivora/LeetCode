/*
		Question : https://www.techiedelight.com/find-n-digit-strictly-increasing-numbers-bottom-top-approach/
		Thought Process : Form decision tree and then write the recursive
											Equation . 
*/

class Main 
{
	public static void main(String[] args) 
	{
		 /* The input will always be digits from 1-9*/
		 int input[] = { 1,2,3,4,5,6,7,8,9 } ;
		 int d       =  7 ;
		 int data[]  = new int[d] ;

		 increaingOrder( input , input.length , 0 , data , 0 , d ) ;

	}

	public static void increaingOrder( int input[] , int n , int index , int data[] , int dataIndex ,int d )
	{
			if( dataIndex == d )
			{
				 for( int i = 0 ; i < data.length ; i++ )
				 			System.out.print( data[i] ) ;
				 	System.out.print( " ") ;
					return ;
			}

			if( index >= n )
					return ;

			data[ dataIndex ] = input[index] ;
		
		 increaingOrder( input , input.length , index+1 , data , dataIndex+1 , d ) ;
		 increaingOrder( input , input.length , index+1 , data , dataIndex , d ) ;
		 
	}
}