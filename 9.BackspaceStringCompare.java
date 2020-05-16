/*
	Given two strings S and T, return if they are equal when both 
	are typed into empty text editors. # means a backspace character.

	Example 1:

	Input: S = "ab#c", T = "ad#c"
	Output: true
	Explanation: Both S and T become "ac".

	Hint  :  Here observe that we opr=erate in only one direction .
			 Hence stack can be used .
	https://www.youtube.com/watch?v=96-d8ZPjHeE
*/
 

class Solution {
    public boolean backspaceCompare(String S, String T) {
        
    	Stack<Character> Sstack = new Stack<Character>() ;
    	Stack<Character> Tstack = new Stack<Character>() ;

    	for( char i : S.toCharArray() )
    	{
    		if( i != '#' )
    			Tstack.push(i) ;
    		else if( !Tstack.isEmpty() )
    			  		Tstack.pop() ;
    	}

    	for( char i : T.toCharArray() )
    	{
    		if( i != '#' )
    			Sstack.push(i) ;
    		else if( !Sstack.isEmpty() )
    			  		Sstack.pop() ;
    	}

    	while( !Sstack.isEmpty() )
    	{
    		char c = Sstack.pop() ;
    		if( Tstack.isEmpty() ||  c != Tstack.pop() )
    			return false ;	    	
    	}
    	return Sstack.isEmpty() && Tstack.isEmpty() ;
    }
}