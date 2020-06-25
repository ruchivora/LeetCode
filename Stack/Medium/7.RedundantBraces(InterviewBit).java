/*
    Solution  : The problem can be solved by using Stack .
    Input 1   : A = "((a + b))"
    Output 1  : 1
    Explanation 1 : ((a + b)) has redundant braces so answer will be 1.

    Input 2  : A = " (a + (a + b)) "
    Output 2 : 0
    Explanation 2: (a + (a + b)) doesn't have have any redundant braces so answer will be 0.

    Edge Case : " a + b " output : 0 . Because this is valid input .
    Edge Case : " (a) "   output : 1 . Because here the braces are redundant . 
*/

public class Solution {
    public int braces(String A)
    {
        Stack<Character> seen = new Stack<Character>() ;
        
        for( int i = 0 ; i < A.length() ; i++ )
        {
            if( A.charAt(i) != ')' )
                seen.push( A.charAt(i) ) ;
            else
            {
                if( seen.peek() != '(' )
                {
                    int count = 0 ; /* counter ensures that "(a)" this testcase is not passed . */
                    while( seen.peek() != '(' )
                    {
                       seen.pop() ; 
                       count++ ;
                    }
                    seen.pop() ;
                    count++ ;
                    if( count == 2 ) return 1 ;
                }
                else return 1 ;
            }
        } 
        
        if( !seen.isEmpty() )
        {
            while( !seen.isEmpty() )
            {
              char a = seen.pop() ;
              if( a == '(') return 1 ;
            }
        }   
    return ( seen.isEmpty() ) ?  0 : 1  ;     
  }
}
