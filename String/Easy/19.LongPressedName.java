/*
		I could not write good readable code . 
		Reference : https://www.youtube.com/watch?v=IQLAtVE19RQ

*/

class Solution 
{
  public boolean isLongPressedName(String name, String typed) 
  {
	    if( name.length() == typed.length() )
	    		return true ;

	    if( name.length() > typed.length() ) 
	    	return false ;

	    int i = 0 ;
	    int j = 0 ;

	    while( j < typed.length() )
	    {
	    	if( i < name.length() && name.charAt(i) == typed.charAt(j) )
	    			i++ ;
	    	/* 
	    		Here we write j == 0 as the condition because if first
	    		characters of name and typed are not same then it will
	    		hit else condition and return false ;
	    	*/
	    	else if( j == 0 || typed.charAt(j) != typed.charAt(j-1) )
	    						return false ;

	    	j++ ;
	    }
	  return i == name.length() ; /* Whether we went through the whole name String*/
  }
}