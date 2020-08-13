/*
		Reference: https://www.youtube.com/watch?v=UflHuQj6MVA&t=457s

    Brute Force : Running two loops to find all the substrings .
                  Then find if the given substring is a palindrome
                  or not . TC : O( N2 ) * O( N )  = O( N3 ) 

    Improved Logic : Expand Around Center . Their are two possiblities 
                      - Odd length      - Even length

    Reference : https://www.youtube.com/watch?v=y2BD4MJqV20

*/

class Solution 
{
  public String longestPalindrome( String s ) 
  {
    if( s == null || s.length() < 1 ) return "" ;

      int start = 0 ; 
      int end = 0 ; 

      for( int i = 0 ; i < s.length() ; i++ )
      {
        int len1 = isPalindrome( s , i , i     ) ; /* Odd length Palindrome  eg : racecar */
        int len2 = isPalindrome( s , i , i + 1 ) ; /* Even length Palindrome eg : abba   */
        int len  = Math.max( len1 , len2 ) ;
        if( len > end - start )
        { 
          /* 
            eg : racecar - if index is at 'e' then 
            start pointer will point to 'r' and end 
            pointer will point to 'r' .
          */
          start = i - ( ( len - 1 ) / 2 ) ; /* This will set the start pointer to the start index of the palindrome */
          end   = i + ( len / 2 ) ;         /* This will set the end pointer to the end of the palindrome */
        } 
      }
    return s.substring( start , end + 1 ) ;
  }

  public int isPalindrome( String s , int left , int right )
  {
      if( s == null || left > right ) return 0 ;

      while( left >= 0 && right < s.length() && s.charAt( left ) == s.charAt( right ) )
      {
        left-- ;
        right++ ;
      }
      /* 
        Here we do right - left - 1 because the index of right 
        will be incremented by 1 and left will be decremented 
        by 1 at the end of while Loop .
      */
    return right - left - 1 ; 
  }
}

/* 
    Brute Force :
    TC : O(N2 * N ) = O(N3) .
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