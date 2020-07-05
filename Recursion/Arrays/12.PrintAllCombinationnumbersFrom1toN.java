import java.util.Stack;

class Main
{
	public static void main(String[] args) 
	{
			int n = 5 ;
			int input[] = new int[n] ;

			for( int i = 0 ; i < n ; i++ )
						input[i] = i + 1 ;

			Stack<Integer> list = new Stack<Integer>() ;

			printCombination( input , 0 , list , n , 0 ) ;
	}

	public static void printCombination( int input[] , int index , Stack<Integer> stack , int sum , int curSum )
	{

		if( curSum == sum )
		{
			for( int i = 0 ; i < stack.size() ; i++ )
							System.out.print( stack.get(i) ) ;
					System.out.println() ;
					return ;
		}

		if( index >= input.length || curSum  > sum )
					return ;

		stack.push( input[index] ) ;
		printCombination( input , index , stack , sum , curSum + input[index] ) ;

		stack.pop() ;
		printCombination( input , index+1 , stack , sum , curSum ) ;
	}

}