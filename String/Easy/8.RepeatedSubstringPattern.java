/*
		MyLogic : The substring that may repeat will lie 
							in either half of the string .

		How to find that substring ? 
			- generate the substring and form the string out of it . 
			- Then comapare the two strings .

		Thought Process: whenever you are stuck with the question ,
										 How to make match ? . Then just try to 
										 generate the same pattern .

		Reference : https://www.youtube.com/watch?v=bClIZj66dVE&t=230s

		The Question Greatest Common Divisor of Strings also has similar Logic !.

*/

class Solution {
  public boolean repeatedSubstringPattern(String s) 
  {
	  	int n = s.length() / 2 ;
	  	StringBuilder sb = new StringBuilder() ;
	  	
	  	for( int i = 0 ; i < n ; i++ )
	  	{
	  		sb.append( s.charAt(i) ) ;

	  		if( s.length() % sb.length() == 0 )
	  		{
	  			String repeat   = sb.toString() ;
	  			int repeatTimes = s.length() / sb.length() ;
	  			StringBuilder result = new StringBuilder() ;

	  			for( int j = 0 ; j < repeatTimes ; j++ )
	  						result.append( sb ) ;
	  			
	  			if( result.toString().equals(s) )
	  						return true ;
	  		}
	  	}
  	return false ;
  }
}