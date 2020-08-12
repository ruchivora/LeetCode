/*
		Reference: https://www.youtube.com/watch?v=UflHuQj6MVA&t=457s

		Reference : https://www.youtube.com/watch?v=y2BD4MJqV20

*/



class Solution 
{
  public String longestPalindrome( String s ) 
  {
  	if( s.length() == 1 ) return s ; 

  		int maxLen = 0 ;
  		String longestPalindrome = "" ;

  		for( int i = 0 ; i < s.length() ; i++ )
  		{
  			/* We start j from i because even single character is a Palindrome . */
  			for( int j = i ; j < s.length() ; j++ )
  			{
  				if( maxLen < j - i + 1 && isPalindrome( s , i , j ) )
  				{
  					maxLen = j - i + 1 ;
  					longestPalindrome = s.substring( i , j + 1 ) ;			
  				}
  			}
  		}
  	return longestPalindrome ;
  }

  public boolean isPalindrome( String s , int left , int right )
  {
		/* 
				here left >= right means that even if there 
				is single character then return true .
		*/
  	if( left >= right )
  			return true ;

  	if( s.charAt(left) != s.charAt( right) )
  			return false ;

  	return isPalindrome( s , left + 1 , right - 1 ) ;
	}
}