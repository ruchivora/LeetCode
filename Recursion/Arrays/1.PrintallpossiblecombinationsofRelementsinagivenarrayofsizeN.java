/*
		For Question : https://www.geeksforgeeks.org/print-all-possible-combinations-of-r-elements-in-a-given-array-of-size-n/

		Solution : take data[] array , with size equal to r .
							 Write printCombination function . 
							 In this function , if the size of data array ==  r ,
							 then print the data array . 
							 Also if( index >= n ) then simply return .
							 The recursive call : you either inclue the current element in the data array 
							 											printCombination( input , n , data , index+1 , dataIndex+1 , r ) ;
																		Here we include the current element in the data array .
																			Or
							 											you do not include current element in the data array .
							 											printCombination( input , n , data , index+1 , dataIndex , r ) ;
							 											Here dataIndex is not incremented . So the current data element is replaced .
							 											
		Reference : https://www.youtube.com/watch?v=7IQHYbmuoVU

		Thought Process : When you design recursive tree , while going done in recursive tree
											think about behavior of recursion stack as you go down .
*/

import java.io.*; 
import java.util.Arrays; 

class Combination 
{
		public static void main( String args[] )
        {
			int input [] = {1,2,1} ;
			int r = 2 ; /* r = No. of elements . eq: r = 3  . So , 2,3,4 */
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
						
				printCombination( input , n , data , index+1 , dataIndex+1 , r ) ;
				printCombination( input , n , data , index+1 , dataIndex , r ) ;
		}

}
