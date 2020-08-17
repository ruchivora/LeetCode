/*
		Reference : https://www.youtube.com/watch?v=FJOUVx5LFE4
		Time Complexity : O( N ) .

		Tricky Question . Did not understand the Solution .
	
*/

class Solution {

	int i = 0 ;

  public int scoreOfParentheses(String S) 
  {
  	int score = 0 ;

     while( i < s.length() )
     {
     		char first  = s.charAt( i ) ;
     		i++ ;
     		char second = s.charAt( i ) ;

     		if( first == '(')
     		{
     			if( second == ')' ) 
     			{
     				score = score + 1 ;
     				i++ ;
     			} /* That means next Bracket is also a Closing bracket .*/
     			else score = score + 2 * scoreOfParentheses( S ) ;
     		} 
     		else return score ;
     }
    return score ;
  }
}