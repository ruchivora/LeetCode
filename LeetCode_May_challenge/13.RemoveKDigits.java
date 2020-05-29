class Solution {
    public String removeKdigits(String num, int k) {
        
    if( num.length() == k )
    	return  "0" ;

    Stack<Character> stack = new Stack<Character>() ;

    for( int i = 0 ; i < num.length() ; i++ )
    {
    	while( !stack.isEmpty() && k > 0 && stack.peek() > num.charAt(i) )
    	{
    		stack.pop() ;
    		k-- ;
    	}
    	stack.push( num.charAt(i) ) ;
    }
    /*
    	If all the digits are same then delete from anywhere . 
    */
    while( k > 0 )
    {
    	stack.pop() ;
    	k-- ;
    }
    /*
    	To convert the number from satck to string .
    */
    
    StringBuilder no = new StringBuilder() ;

    while( !stack.isEmpty() )
    {
    	no.append( stack.pop() ) ;
    }

    no.reverse() ;

    /*
    	If the number contains leading zeros .
    	Then remove those zeros .
    */

    while( 	no.length() > 1  && no.charAt(0) == '0' )
    {
    	no.deleteCharAt(0) ;
    }

    return no.toString() ;

    }
}