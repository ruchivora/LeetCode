/*
		The problem is similar to Longest Palindromic Substring .
		But here we have to consider different cmbination . 

		I could not understand how to derive at the exact count of 
		combination .

		So , if you try out isPalindrome( s , i , i ) and 
		isPalindrome( s , i , i + 1 ) on example "aaa" we 
		will be getting all the required combination .

*/

class Solution 
{
  public int countSubstrings(String s) 
  {
  	if( s == null || s.length() < 1 ) return 0 ;

  		int sum = 0 ;

      for( int i = 0 ; i < s.length() ; i++ )
      {
      	sum += isPalindrome( s , i , i ) ;
      	sum += isPalindrome( s , i , i + 1 ) ;
      }
    return sum ; 
  }

  public int isPalindrome( String s , int left , int right )
  {
	  	if( s == null || left > right ) return 0 ;

	  	int count = 0 ;

	  	while( left >= 0 && right < s.length() && s.charAt( left ) == s.charAt( right ) )
	  	{
	  		left--  ;
	  		right++ ;
	  		count++ ;
	  	}
	  return count ;
  }

}