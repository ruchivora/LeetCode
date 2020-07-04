/*
		For Question : https://www.techiedelight.com/maximum-product-subset-problem/
		Solution     : Recursion : Decision Tree .
									 Iterative : 1. Find count of negative numbers in the input array.
									 						 2. If the count of negative num is odd then find the 
									 						 		lowest absolute number and do not include it in the 
									 						 		product .
									 						 3. Consider all the positive numbers except 0 . 
									 						 4. Calculate the product .
*/

class Main
{
	static int maxProd = Integer.MIN_VALUE ; 
	public static void main(String[] args) 
	{
			int input[] = { -6,4,-5,8,-10,0,8 } ;
			calProduct( input , 0 , 1 ) ;
			System.out.println( maxProd ) ;
	}
	public static void calProduct( int input[] , int i , int prod )
	{
			if( i >= input.length )
					return ;

			int x = prod * input[i] ;
			maxProd = ( maxProd > x ) ? maxProd : x ;

			calProduct( input , i+1 , x ) ;
			calProduct( input , i+1 , prod ) ;
	}
}