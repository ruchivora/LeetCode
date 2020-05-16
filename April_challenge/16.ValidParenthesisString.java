/*
    Given a string containing only three types of characters: '(', ')' and '*', 
    write a function to check whether this string is valid. We define the validity
    of a string by these rules:

    1 . Any left parenthesis '(' must have a corresponding right parenthesis ')'.
    2 . Any right parenthesis ')' must have a corresponding left parenthesis '('.
    3 . Left parenthesis '(' must go before the corresponding right parenthesis ')'.
    4 . '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
    5 . An empty string is also valid.

    Test case : 
    Example 1 : "*("
    Output    : False  

    Example 2 : "(*))"
    Output    : True

    Example 3 : "(*))"
    Output    : True

    Source : https://www.youtube.com/watch?v=2H9gMIIGyvY
*/
class Solution {
    public boolean checkValidString(String s) {

      /*
         para_index = Stores index of the open paranthesis .
         star_index = Stores index of the * . 
      */

    Stack<Integer>  para_index  = new Stack<Integer>() ;
    Stack<Integer>  star_index  = new Stack<Integer>() ;

    int count_star = 0 ;

   for ( int i = 0 ; i < s.length() ; i++ )   
    { 
      if( s.charAt(i) == '(' )
      {
        para_index.push(i) ;
      }else if( s.charAt(i) == ')' ) 
              {
                if( !para_index.isEmpty() )
                  para_index.pop() ;
                else if( !star_index.isEmpty() )
                       star_index.pop() ;
                     else
                       return false ;
              }
              else if( s.charAt(i) == '*' )
                  star_index.push(i) ;
    }

    if( !para_index.isEmpty()  )
    {
        if(star_index.isEmpty()) //if para_index contains the entries but sthere are no stars .
          return false ;

        while( !para_index.isEmpty() && !star_index.isEmpty() )
        {
           if( para_index.peek() < star_index.peek() )
           {
             para_index.pop() ;
             star_index.pop() ;
           }
           else
            return false ;
        }
        if(!para_index.isEmpty())
            return false ;
    }
    else
      return true ;

  return true ;
  }
}