/*
		Just read the explanation of the logic on geeks for geeks . 
		Beautifully Explained

		https://www.geeksforgeeks.org/remove-character-string-make-palindrome/

*/

class Solution 
{
  public boolean validPalindrome(String s) 
  {
	  	char c[]  = s.toCharArray() ;
	    int left  = 0 ;
	    int right = s.length() - 1 ;

	    while( left <= right )
	    {
    		if( c[left] != c[right] )
    		{
    			if( checkPalindrome( c , left+1 , right ) || checkPalindrome( c , left , right - 1 ) )
    						return true ;

    			else return false ;
    		}
    		left++  ;
    		right-- ;
	    }
	  return true ;
  }

  public boolean checkPalindrome( char c[] , int left , int right )
  {
	  	while( left <= right )
	  	{
	  		if( c[left] != c[right] )
	  			return false ;	
	  		
	  		left++  ;
	  		right-- ;
	  	}
	  return true ;
  } 

}