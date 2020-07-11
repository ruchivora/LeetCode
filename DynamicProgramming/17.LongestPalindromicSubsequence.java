/*
			Question 1 : https://www.geeksforgeeks.org/longest-palindromic-subsequence-dp-12/
			Question 2 : https://www.geeksforgeeks.org/minimum-number-deletions-make-string-palindrome/
											[ The above question is solved here ]

			Solution : The problem is variation of Longest common Subsequence.
								 How , because in question we just have one input string ?
								  - Our second input is obtained by reversing the string .
								  - Then find the Longest common Subsequence .

			Reference Q1 : https://www.youtube.com/watch?v=wuOOOATz_IA&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=26
			Reference Q2 : https://www.youtube.com/watch?v=CFwCCNbRuLY&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=28
*/
class GFG { 

	static int lps( char X[] , char Y[] , int m , int n ) 
	{ 
			int t[][] = new int[ m + 1 ][ n + 1 ] ;

			for( int i = 0 ; i <= m ; i++ )
			{
				for( int j = 0 ; j <= n ; j++ )
				{
					if( i == 0 || j == 0 )
							t[i][j] = 0 ;

					else if( X[ i - 1 ] == Y[ j - 1 ] )
										t[i][j] = 1 + t[ i - 1 ][ j - 1 ] ;

								else t[i][j] = Math.max( t[ i - 1 ][j] , t[i][ j - 1 ] ) ;
				}
			}
		 return t[m][n] ;
	} 

	public static void main(String[] args) 
	{ 
		String str1 = "GEEKSFORGEEKS" ;
		char X[] = str1.toCharArray() ;

		/* To find the palindrome just reverse the string .*/
		char Y[] = new char[X.length] ;
      
    int j = 0 ;
    for( int i = X.length - 1 ; i >= 0 ; i-- ) 
    {
        Y[j] = X[i]  ;
        j++ ;
    }
      
		int m = X.length ;
		int n = Y.length ;

		int x = lps( X , Y , m , n ) ;

		System.out.println (" The length of the LPS is %d", x ) ;
		System.out.println (" The minimum number of deletions to make a string palindrome is %d", m - x ) ;



	} 
} 
