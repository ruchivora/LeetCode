/*
    Here the only order we have to follow is "abc" .
    So till the time we do not encounter charcter c ,
    push all the characters on to the stack .
    
*/

class Solution {
    public boolean isValid(String S) 
    {
        Stack<Character> stack = new Stack<Character>() ;

        for( int i = 0 ; i < S.length() ; i++ )
        {
            if( S.charAt(i) != 'c' )
                stack.push( S.charAt(i) ) ;
            else
            {
                if( !stack.isEmpty() && stack.peek() == 'b' )
                {
                    stack.pop() ;

                  if( !stack.isEmpty() && stack.peek() == 'a' )
                        stack.pop() ;
                  else return false ;
                }
                else return false ;
            }
        }
      return stack.isEmpty() ;
    }
}