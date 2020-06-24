/*
		Solution : Use two stacks . 
		1.for count  2.storing result .
*/
class Solution {
    public String decodeString(String s) 
    {
    	/*
					We have 4 characters to look for : 
					number , [ ,char ,] .
    	*/

			Stack<Integer> counts = new Stack<Integer>() ;
			Stack<String> result  = new Stack<String>() ;

			String res = "" ;
			int index = 0 ;

			while( index < s.length() )
			{
					if( Character.isDigit( s.charAt(index) ) )
					{
							/* If the count is 30 */
							int count = 0 ;

							while( Character.isDigit( s.charAt(index) ))
							{
								count = 10 * count + ( s.charAt(index) - '0' );
								index++ ;
							}
							counts.push( count ) ;
					}
					else if( s.charAt(index) == '[' )
					{
							result.push(res) ;
							res = "" ;
							index++ ;
					}
					else if(s.charAt(index) == ']')
					{
							StringBuilder temp = new StringBuilder(result.pop()) ;
							int count = counts.pop() ;
							for( int i = 0 ; i < count; i++ )
								    temp.append( res ) ;
							res = temp.toString() ;
							index ++ ;
					}
					else
					{
						res += s.charAt(index) ;
						index += 1 ; 
					}
			} 
		return res ;
    }
}