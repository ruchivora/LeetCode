class Solution {
    public boolean checkValidString(String s) {

    Stack<Integer>  para_index  = new Stack<Integer>() ;
    Stack<Integer>  star_index  = new Stack<Integer>() ;

    int count_star = 0 ;

   for ( int  i = 0 ; i < s.length() ; i++ )   
    { 
	    if( s.charAt(i) == '(' )
	    {
	    	para_index.push(i) ;
	    }else if( s.charAt(i) == ')'  )	
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
        if(star_index.isEmpty())
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