/*
    To check if the parenthesis is valid or not 
    we use stack .

*/
class Solution 
{
  public boolean isValid(String s) 
  {
    Stack<Character> seen = new Stack<Character>() ;

    for( int i = 0 ; i < s.length() ; i++ )
    {
    	if( s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{' )
    					seen.push( s.charAt(i) ) ;

    	else if( s.charAt(i) == ')' )
    			 {
    			 		if( !seen.isEmpty() && seen.peek() == '(' ) seen.pop() ;
    			 		else return false ;
    			 }
    			 else if( s.charAt(i) == ']' )
    			 {
    			 		if( !seen.isEmpty() && seen.peek() == '[' ) seen.pop() ;
    			 		else return false ;
    			 }
    			 else if( s.charAt(i) == '}' )
    			 {
    			 		if( !seen.isEmpty() && seen.peek() == '{' ) seen.pop() ;
    			 		else return false ;
    			 }
    }
    return seen.isEmpty() ;
  }
}