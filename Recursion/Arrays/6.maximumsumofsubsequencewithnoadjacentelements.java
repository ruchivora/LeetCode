/*
		Very good Question .
		For Question : https://www.techiedelight.com/maximum-sum-of-subsequence-with-no-adjacent-elements/
		My Mistake      : Did not understand the question in one go .
		Thought Process : Since their are multiple decision at each point ,
											it is better to use recursion because in iterative  
											approach , it will be difficult to handle all the 
											conditions . 
		using Recursion : Step 1 . Construct recusive tree .
											Need not draw recursive tree for all
											the branches , but upto one leaf is enough .
											Step 2 : Start with return conditions
											Step 3 : Then write the recursive equation .
*/

class maxSum
{
		int max = 0 ;
		public static void main( String args[] )
		{
			int input [] = { 1,2,9,4,5,0,4,11,6 } ;
			int sum1 = maxSum( input , input.length , 0 , 0 ) ;
			System.out.println( maxSum( input , input.length , 0 , 0 ) ) ;
		}

		public static int maxSum( int input[] , int n , int index , int sum )
		{
			 if( index >= n )
					return sum ;

			if( input[index] < 0 )
			{
					while( input[index] < 0 && index < n )
										index++ ;
			}
			
			return ( Math.max( maxSum( input , n , index + 2 , sum + input[index] ) ,
												 maxSum( input , n , index + 1 , sum  ) 
												) 
						  ) ;
		}
}