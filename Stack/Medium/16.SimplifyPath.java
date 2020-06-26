/*
		Solution : Split the String into by '/' .
							 So , it will get converted to array . 
							 Then process the input .
*/

class Solution {
    public String simplifyPath(String path) 
    {
        Stack<String> stack = new Stack<String>() ;
        String[] p = path.split("/") ;

        for( int i = 0 ; i < p.length ; i++ )
        {
        		if( p[i].equals("..")  )
        		{
        				if( !stack.isEmpty() )
        						 stack.pop() ;
        		}
        		else if( !p[i].equals("") && !p[i].equals(".") )
        								stack.push( p[i] ) ;		
        }

        StringBuilder result = new StringBuilder() ;

        while( !stack.isEmpty() )
        {
        		result.insert( 0 , stack.pop() ) ;
        		result.insert( 0 , '/' ) ;
        }
        	
        if( result.toString().equals("") )
        			result.insert( 0 ,'/' ) ;

        return result.toString() ;
    }
}