/*
	For Question : https://www.techiedelight.com/find-combinations-of-elements-satisfies-given-constraints/

			Very important concept and Good Question : Recursion with for loop .			
			Why do we need for loop here ? 
			When we make decision tree without for loop then if input is :[1,2,3]
			then starting from 1 , we can move in forward direction only .
			i.e we get combinations like (1,2) , (1,3) ,(2,3) but we can not 
			get combinations like (2,1) . 

			So if we use for loop then 1 can be even placed after a 2 i.e( 2,1 ) .
*/

class Main
{
	public static void main(String[] args) 
	{
		 int n      = 3 ;
		 int arr [] = new int[ n*2 ] ;

		 /* Inititalize the array by -1 . */
		 Arrays.fill( arr , -1 ) ; 
		 int elem = 1 ; 

		 findAllCombination( arr , elem , n ) ;
	}

	public static void findAllCombination( int arr[] , int elem , int n )
	{
			if( elem > n ) 
			{
					System.out.println( Array.toString( arr ) ) ;
					return ;
			}

			for( int i = 0 ; i < n*2 ; i++ )
			{
				if( arr[i] == -1 && i+elem+1 < arr.length && arr[i+elem+1] == -1 )
				{
						/* Include it in the array . */
						arr[i]        = elem ; 
						arr[i+elem+1] = elem ;

						findAllCombination( arr , elem + 1 , n ) ;

						/* Don't include it in the array . */
						arr[i]        = -1 ;
						arr[i+elem+1] = -1 ;
				}
			}

			/* 
				 Even if you don't put return , after the for loop gets over the corrsp. entry will be 
				 removed from the stack automatically .
			*/
	}
}