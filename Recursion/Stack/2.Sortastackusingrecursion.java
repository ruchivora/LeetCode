/*
		Solution : The idea of the solution is to hold all values
							 in Function Call Stack until the stack becomes 
							 empty. When the stack becomes empty, insert all 
							 held items one by one in sorted order. Here 
							 sorted order is important.
*/

import java.util.Stack; 
import java.util.* ;

class SortStack
{
		static Stack<Integer> stack ;

		public static void main( String args[] )
		{
				stack = new Stack<Integer>() ;
				stack.push( -3 ) ;
				stack.push( 14 ) ;
				stack.push( 18 ) ;
				stack.push( -5 ) ;
				stack.push( 30 ) ;
				sortStack() ;

				System.out.println( Arrays.asList(stack) ) ;
		}

		public static void sortStack()
		{
				if( stack.isEmpty() )
							return  ;

				int x = stack.pop() ;
				sortStack() ;
				pushInSortedStack( x ) ;
		}

		public static void pushInSortedStack( int x )
		{
			if( stack.isEmpty() || stack.peek() >= x )
							stack.push( x ) ; 

			else
			{
				int y = stack.pop() ;
				pushInSortedStack( x ) ;
				stack.push( y ) ;
			}
		}
}