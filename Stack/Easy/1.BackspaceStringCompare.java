/*
		Solution 1 : Take two stacks and push the character one by one .
							   Compare the two stacks .
		Time complexity  : O( M + N )
		Space Complexity : O( M + N )

		Solution 2 : Start from of the end of the string 
								 and skip characters if their is # ,
								 form the string and return .
								 Similarly do for other String .
								 Compare the two strings and return the answer .
		Time Complexity  : O(M+N)
		Space Complexity : O(1)
*/

class Solution {
  public boolean backspaceCompare(String S, String T) 
  {
    	Stack<Character> stackS = new Stack<Character>() ;
    	Stack<Character> stackT = new Stack<Character>() ;

    	for( int i = 0 ; i < S.length() ; i++ )
    	{
    			char c = S.charAt(i) ;
    			if( c != '#' )
    				stackS.push(c) ;
    			else if( c == '#' && !stackS.isEmpty() )
    					stackS.pop() ;			
    	}

    	for( int i = 0 ; i < T.length() ; i++ )
    	{
    		char c = T.charAt(i) ;
    		if( c != '#' )
    					stackT.push(c) ;
				else if( c == '#' && !stackT.isEmpty() )
    						stackT.pop() ;	
    	}

    	return stackS.toString().equals( stackT.toString() ) ;
  }
}


/*
		Solution 2 : Start from of the end of the string 
								 and skip characters if their is # ,
								 form the string and return .
								 Similarly do for other String .
								 Compare the two strings and return the answer .
		Time Complexity  : O(M+N)
		Space Complexity : O(1)
*/
class Solution {
  public boolean backspaceCompare(String S, String T) 
  {
  		return getString( S ).equals( getString( T ) ) ;
  }

  public String getString( String S )
  {
  		int p = S.length() - 1 ;
  		int hashCount = 0 ;
  		StringBuilder strS = new StringBuilder() ;

  		while( p >= 0 )
  		{
  			if( S.charAt(p) == '#' )
  						hashCount++ ;
  			else if(S.charAt(p) != '#' && hashCount != 0 )
  								hashCount-- ;
  						else
  							strS.append( S.charAt(p) ) ;
  			p-- ;			
  		}
  	return strS.toString() ;
  }
}