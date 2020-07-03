/*
		Variation of First problem .
		Try this problem by drawing recursion Tree .
*/

import java.io.*; 
import java.util.Arrays; 

class Combination 
{
		public static void main( String args[] )
    {
			int input [] = {1,2,3,4,5} ;
			int r = 3 ; /* r = No. of elements . eq: r = 3  . So , 2,3,4 */
			int n = input.length ; 
			int data[] = new int[r] ;
      Arrays.sort( input ) ;
			printCombination( input , n ,data , 0 , 0 , r ) ;
		}

		public static void printCombination( int input[] , int n ,int data[] , int index , int dataIndex , int r )
		{
				if( dataIndex == r )
				{
					for( int i = 0 ; i < data.length ; i++ )
								System.out.print( data[i] + " " ) ;
							System.out.println() ;
					return ;
				}

				if( index >= n )
						return ;

				data[ dataIndex ] = input[ index ] ;

				/* This will handle duplicates */
				while( index < n - 1 && input[index] == input[ index + 1 ])
								index++ ;
						
				printCombination( input , n , data , index , dataIndex+1 , r ) ;
				printCombination( input , n , data , index+1 , dataIndex , r ) ;

		}

}
