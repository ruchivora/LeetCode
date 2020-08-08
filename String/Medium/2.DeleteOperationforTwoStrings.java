/*
		My mistake : Sort both the words and find the common elements 
								 But , then because of sorting order of characters
								 in a word will change . 

								This approach would work for eg: "sea" and "eat"
								But won't work for "seam" and "meat" .
							
		Hint : Whenever Two strings are given and decision is involved 
					 try to think about LCS or some other DP Problem .
					
*/

class Solution
{
	public int minDistance( String word1 , String word2 ) 
  {
  	char x[] = word1.toCharArray() ;
  	char y[] = word2.toCharArray() ;
  	return word1.length() + word2.length() - 2 * lcs( x , y ) ;
  }

  public int lcs( char[] x , char[] y )
  {
	  	int t[][] = new int[ x.length + 1 ][ y.length + 1 ] ;

	  	for( int i = 0 ; i <= x.length ; i++ )
	  	{
	  		for( int j = 0 ; j <= y.length ; j++ )
	  		{
	  				if( i == 0 || j == 0 )
	  						t[i][j] = 0 ;

	  				else if( x[i - 1 ] == y[ j - 1 ] )
	  									t[i][j] = 1 + t[ i - 1 ][ j - 1 ] ;

	  							else t[i][j] =  Math.max( t[ i - 1 ][j] , t[i][ j - 1 ] ) ;
	  		}
	  	}
	  return t[x.length][y.length] ;
  }
}

/* Recursive Solution */
class Solution {
    public int minDistance(String word1, String word2) 
    {
    	char x[] = word1.toCharArray() ;
    	char y[] = word2.toCharArray() ; 
      return word1.length() + word2.length() - 2 * lcs( x , y , x.length , y.length ) ;
    }

    public int lcs( char word1[] , char word2[] , int index1 , int index2 )
    {
    	
    	if( index1 == 0 || index2 == 0 )
    				return 0 ;

    	if( word1[index1 - 1]  == word2[ index2 - 1 ] )
    			return 1 + lcs( word1 , word2 , index1 - 1 , index2 - 1 ) ;

    	else return  Math.max( lcs( word1 , word2 , index1 - 1 , index2 ) , lcs( word1 , word2 , index1 , index2 - 1 ) ) ;
    }

}

