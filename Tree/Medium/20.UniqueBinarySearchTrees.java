/*
		Here you can use formula 2N C N / N + 1 . 
		But requires lot of multiplication and division and
		may lead to overflow . 

		So we use catalan number technique . 
		C(0) = C(1) = 1 . 
		C(2) = C0 * C1 + C1 * C0 . 

		Here , we can use recursion . But will give TLE . 
		But their are repeating substructure . 
		So ,we can use Dynamic Programming . 
		Also understand why do we need double for loop .

		Reference : https://www.youtube.com/watch?v=CMaZ69P1bAc&t=247s

*/

/* Recursive Solution */
class Solution 
{
  public int numTrees(int n) 
  {
     return calCatalan( n ) ;
  }

  public int calCatalan( int n ) 
  {
	  	if( n == 0 || n == 1 ) 
	  				return 1 ;

	  	int sum = 0 ; 

	  	for( int i = 0 ; i < n ; i++ )
  				sum = sum + calCatalan( i ) * calCatalan( n - i - 1 ) ;

  	return sum ; 
  }
}

/* Dynamic Solution ! */
class Solution
{
	public int numTrees( int n )
	{
		return calCatalan( n ) ;
	}

	public int calCatalan( int n )
	{
			int t[] = new int[ n + 1 ] ;

			t[0] = 1 ; 
			t[1] = 1 ;

			for( int i = 2 ; i <= n ; i++ )
			{
				t[i] = 0 ;

				for( int j = 0 ; j < i ; j++ )
								t[i] = t[i] + t[j] * t[ i - j - 1 ] ;	
			}
		return t[n] ;
	}
}