/*
		The Question is similar to Repeat Substring Pattern .
*/
 
/* 
		This Solution is Similar to calculating GCD using 
		Euclidian Formula .
		Here Euclidian formula is applied to calculate GCD 
		on two Strings .
		Remainder between two strings = Str2 - str1 
		where Str2.length() > Str1.length() .

		Refer : https://leetcode.com/problems/greatest-common-divisor-of-strings/discuss/657934/Java-GCD-Solution-With-Explanation
*/

class Solution 
{
  public String gcdOfStrings(String str1, String str2) 
  {
      if( str2.length() > str1.length() )
          return gcdOfStrings( str2, str1 ) ;
		
      if(str2.length() == 0)
          return str1;

      String remainder = "";

      if( str1.charAt(0) == str2.charAt(0) ) 
      {
      	/* This will do Str1 - Str2 . */
        remainder = str1.substring( str2.length() ) ;
      } 
      else return "" ; /* In case of "Leet" and "Code" simply return "" */
      
    return gcdOfStrings(str2, remainder);
  }
}

/*
	The Question can also be solved by generating
	the whole strings again ! 
*/

class Solution 
{
  public String gcdOfStrings(String str1, String str2) 
  {
	  	StringBuilder sb = new StringBuilder() ;
	  	String result = "" ;

	  	for( int i = 0 ; i < str1.length() ; i++ )
	  	{
	    	sb.append( str1.charAt(i) ) ;

	    	if( str1.length() % sb.length() == 0 && str2.length() % sb.length() == 0 )
	    	{
	    		int repeatStr1 = str1.length() / sb.length() ;
	    		int repeatStr2 = str2.length() / sb.length() ;

	    		StringBuilder buildStr1 = new StringBuilder() ;
	    		StringBuilder buildStr2 = new StringBuilder() ;

	    		for( int j = 0 ; j < repeatStr1 ; j++ )
	    					buildStr1.append( sb ) ;

	    		for( int j = 0 ; j < repeatStr2 ; j++ )
	    				 	buildStr2.append( sb ) ;

	    		if( buildStr1.toString().equals( str1 ) && buildStr2.toString().equals( str2 ) )
	    					result = sb.toString() ; 				
	    	}
	  	}
	 	return result ;
  }
}



