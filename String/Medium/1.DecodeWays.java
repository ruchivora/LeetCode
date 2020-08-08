/*
		Dynamic Programming Approach : 

		https://leetcode.com/problems/decode-ways/discuss/30451/Evolve-from-recursion-to-dp
	
		Improvise the solution . 
		Resolve it .

*/


class Solution 
{
  public int numDecodings(String s) 
  {
      return countWays( s , 0 ) ; 
  }

  public int countWays( String s , int index )
  {
  	if( index == s.length() )
  			return 1 ;

  	if( s.charAt(index) == '0' )
  			return 0 ;
  	
  	int res = countWays( s , index + 1 ) ;

  	if( index < s.length() - 1  && ( s.charAt( index ) == '1' || ( s.charAt( index ) == '2' && s.charAt( index + 1 ) < '7') ) )
  			res = res + countWays( s , index + 2 ) ;

  	return res ;

  }
}



