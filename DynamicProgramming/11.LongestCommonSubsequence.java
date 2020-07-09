/*
		Question : https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/

		How to Solve ?
		 - Write recursive solution .
		 - Then convert it to Dynamic Programming .

		How to write recursive Solution ?
			- Form Decision Tree .

		What are the decisions ?
			- if the caharacter of both the string match , then include .
			- if character of both the string does not match then their 
			  are two choices .

*/

/* Recursive Solution */
int lcs( char[] X, char[] Y, int m, int n ) 
{ 
	  if( m == 0 || n == 0 )
						return 0 ;

		else  if( X[ m - 1 ] == Y[ n - 1 ] )
							return 1 + lcs( X , Y , m - 1 , n - 1 ) ;

					else return Math.max( lcs( X , Y , m - 1 , n ) , lcs( X , Y , m , n - 1 ) ) ;
} 

/*
		Dynamic Programming Solution .
*/
public class LongestCommonSubsequence 
{ 
	int lcs( char[] X, char[] Y, int m, int n ) 
	{
			int t[][] = new int[ m + 1 ][ n + 1 ] ;

			for( int i = 0 ; i <= m ; i++ )
			{
				for( int j = 0 ; j <= n ; j++ )
				{
						if( i == 0 || j == 0 )
									t[i][j] = 0 ;

						else  if( X[ i - 1 ] == Y[ j - 1 ] )
											 t[i][j] = 1 + t[ i - 1 ][ j - 1 ] ;

									else t[i][j] = Math.max( t[ i - 1 ][j] , t[i][ j - 1 ] ) ;		
				}
			}
		return t[m][n] ;
	}
	

	public static void main(String[] args) 
	{ 
		LongestCommonSubsequence lcs = new LongestCommonSubsequence(); 
		String s1 = "AGGTAB"; 
		String s2 = "GXTXAYB"; 

		char[] X = s1.toCharArray() ; 
		char[] Y = s2.toCharArray() ; 

		int m = X.length ; 
		int n = Y.length ; 

		System.out.println("Length of LCS is" + " " + 
									lcs.lcs( X, Y, m, n ) ); 
	} 

} 

/*
		LeetCode Code - Passed all the test cases .
*/
class Solution 
{
    public int longestCommonSubsequence(String p, String q) 
    {
    
	    	char [] X = p.toCharArray() ;
	    	char [] Y = q.toCharArray() ;

	    	int m = X.length ;
	    	int n = Y.length ; 

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
}

