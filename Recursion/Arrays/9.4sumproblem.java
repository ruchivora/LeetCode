/*
		ForQuestion : https://www.techiedelight.com/4-sum-problem/
		Solution    : Recursive Approach : Use decision Tree .
									Iterative Approach : 
									Consider every pair and insert in Hash Map 
									where key is sum of pair of elements , value
									is pair of elements . 
									Then find the remaining sum and find in HashMap .
									SC : Depends on number of pairs = NC2 .
									TC : O(N2)
*/

class Main
{
	public static void main(String[] args) 
	{
		int input[] = { 2,7,4,0,9,5,1,3 } ;
		int sum     = 20 ;
		int  k      = 4 ;
		int data[]  = new int[k] ;

		calSum( input  , 0 , data , 0 , 0  , sum , k ) ;
	}

	public static void calSum( int input[] , int i , int data[] , int dataIndex , int curSum , int sum , int k )
	{
		  if( dataIndex == k )
		  {
		 		if( curSum == sum )
		 		{
		 				for( int j = 0 ; j < data.length ; j++ )
		 							System.out.print( data[j] + " ") ;
		 					System.out.println() ;
		 					return ;
		 		}
		 		else return ;
		  }

		  if( i >= input.length || curSum > sum )
		 			return ;
		
		 	data[ dataIndex ] = input[i] ;

		 	calSum( input , i+1 , data , dataIndex+1 , curSum + data[dataIndex] , sum , k ) ;
		 	calSum( input , i+1 , data , dataIndex , curSum  , sum , k ) ;
	}
}