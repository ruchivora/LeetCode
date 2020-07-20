class Solution {
    public int fib(int N) {

    	if( N == 0 ) return  0 ;
    	if( N == 1 ) return  1 ;

    	return fib( N - 1 ) + fib( N - 2 ) ;
    }
}

/* Converting recurrence to Dynamic Programming */

class Solution
{
		public int fib( int N ) 
		{
				int t[] = new int[ N + 1 ] ;

				for( int i = 0 ; i <= N ; i++ )
				{
					if( i == 0 ) t[i] = 0 ;

					else if( i == 1 ) t[i] = 1 ;

						 		else t[i] = t[ i - 1 ] + t[ i - 2 ] ;
				}
			return t[N] ;
		}
}