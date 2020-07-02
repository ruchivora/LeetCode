/*
		If you implement a solution by recursion then ,
		implement every function by recurssion . 

		Logic : The idea of the solution is to hold all values 
						in Function Call Stack until the stack becomes empty.
						When the stack becomes empty, insert all held items 
						one by one at the bottom of the stack .

		Mymistake : To Insert at the bottom of the stack i thought 
							  of using two stack and doing in iterative way
								but , using recursion can be done with one stack
								only . 
*/

import java.util.Stack; 
import java.util.* ;

class ReverseStack
{
		static Stack<Character> stack = new Stack<Character>() ;

		public static void main( String args[] )
		{
				stack.push( '1' ) ;
				stack.push( '2' ) ;
				stack.push( '3' ) ;
				stack.push( '4' ) ;
				stack.push( '5' ) ;

				ReverseStack( ) ;
        System.out.println( Arrays.asList(stack) ) ;    
		}

		public static void ReverseStack( )
		{
				if( stack.isEmpty() )
							return ;

				char x = stack.pop() ;
				ReverseStack() ;
				stackInsert( x ) ;
		}

		public static void stackInsert( char x )
		{
			if( stack.isEmpty() )
							stack.push( x ) ;
			else
			{
				char y = stack.pop() ;
				stackInsert( x ) ;
				stack.push( y ) ;
			}
		} 
}