/*
		For Question : https://www.techiedelight.com/longest-decreasing-subsequence-problem/ 
		Solution :  Recursive solution : Solved using decision Tree .
								But, time complexity will be exponential . So ,
								the problem needs to be broken down into smaller,
								simpler subproblems ,i.e the problem needs to be 
								solved by Dynamic Programming to reduce the time
								complexity from exponential to linear .  
*/
import java.util.Stack;
class Main
{
		static int  maxSize = 0 ; 
		public static void main(String[] args) 
		{
				int input[] = { 0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15 } ;
				Stack<Integer> stack = new Stack<Integer>() ;
				decrSequence( input , 0 , stack) ;
				System.out.println( maxSize ) ;
		}

		public static void decrSequence( int input[] , int i , Stack<Integer> stack )
		{
				maxSize = ( maxSize > stack.size() ) ? maxSize : stack.size() ; 

				if( i >= input.length )
					   return ;

				if( stack.isEmpty() )
				{
					stack.push( input[i] ) ;
					decrSequence( input , i + 1 , stack) ;
					stack.pop() ;
					decrSequence( input , i + 1 , stack) ;
				}
				else
				{
						if( stack.peek() > input[i] )
						{
							stack.push( input[i] ) ;
							decrSequence( input , i + 1 , stack) ;
							stack.pop() ;
						  decrSequence( input , i + 1 , stack) ;
						}
						else
						decrSequence( input , i + 1 , stack) ;		
				}
		}
}