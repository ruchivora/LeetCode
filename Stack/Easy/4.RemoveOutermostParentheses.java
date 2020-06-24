/*
		Generally , in case of parenthesis we use stack ,
		but here stack is not needed .Generally stack is used to
		check valid parenthesis because valid parenthesis include
		examples like , eg: [{] ,({})] . Here the parenthesis 
		are only round brackets and that too it is valid .

		Solution : Take a variable c that is incremented when 
		           '(' is encountered and decremented when ')'
		           is encountered . If c == 0 just append the 
		           substring from the string . 
*/
class Solution {
    public String removeOuterParentheses(String S) 
    {
        int c = 0 ;
        int start = 0 ;
        StringBuilder sb = new StringBuilder() ;
        int n = S.length() ;

        for( int i = 0 ; i < n ; i++ )
        {
        		if( S.charAt(i) == '(' )
        				c++ ;
        		else c-- ;

        		if( c == 0 )
        		{
        			sb.append( S.substring(start+1,i) ) ;
        			start = i + 1 ;
        		}
        }
      return sb.toString() ;
    }
}

