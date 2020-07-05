/*
		For Question : https://www.techiedelight.com/quickselect-algorithm/
		
		Thought Process : Sort and find the element . TC : O(N Log N)
											But here we are also keeping elements at correct
											position which are not required to be placed at the 
											correct position .

											since the word is largest , use min heap of size k ,
											then insert element one by one and at the end we get
											Kth largest element . TC : O( N Log N )

		Solution        :	Better option is apply partition algorithm . 
											Best  case : O(N) . In the first go found the element .
											Worst case : O(N2) 

		Reference       : https://www.youtube.com/watch?v=hGK_5n81drs&t=1538s 
*/

class Main
{
	public static void main(String[] args) 
	{
		int input[] = { 1,2,5,7,3 } ;
		int k       = 2 ; /* Second Largest Element */
		int index   = input.length - k ; /* Required element will be found at this index */

		System.out.println( quickSelect( input , 0 , input.length-1 , index ) ) ;
	}

	public static int quickSelect( int input[] , int start , int end , int index )
	{
			if( start == end )
					return input[start] ;

			int pivotIndex = Partition( input , start , end ) ;

			if( index == pivotIndex )
						return input[pivotIndex] ;
					
			else if( index < pivotIndex )
									return quickSelect( input , pivotIndex - 1 , end , index ) ;
					 else
									return quickSelect( input , pivotIndex + 1 , end , index ) ;
	}


	public static int Partition( int input[] , int start , int end  )
	{
			int pivot = input[end] ;
			int  i    = start - 1 ;
			int  j    = start ;

			while( j < end )
			{
					if( input[j] < pivot )
					{
						i++ ;
						Swap( input , i , j ) ;
					}
					j++;
			}
			i++ ;
			Swap( input , i , end ) ;

		return i ;
	}

	public static void Swap( int input[] , int i , int j )
	{
		  int temp   = input[i] ;
			input[i]   = input[j] ;
			input[j] = temp ;
	} 

}