class Solution 
{
  public String reverseOnlyLetters(String S) 
  {
	  	char arr[] = S.toCharArray() ;
	    int left   = 0 ; 
	    int right  = S.length() - 1 ;

	    while( left <= right )
	    {
	    	if( isAlphabet( arr[left] ) &&  isAlphabet( arr[right] ) )
	    	{
	    		char temp  = arr[left] ;
	    		arr[left]  = arr[right] ;
	    		arr[right] = temp ;
	    		left++ ;
	    		right-- ;
	    	}
	    	else
	    	{
	  			if( ! isAlphabet( arr[left] )  )
	  						left++ ;

	  			if( ! isAlphabet( arr[right] ) )
	  						right-- ;
	    	}
	    }
	    /* Converting Char Array to String in java */
			String s = new String( arr ) ;
    return s ;
  }

  public boolean isAlphabet( char c )
  {
  	if( c >= 65 && c <= 90 || c >= 97  && c <= 122 )
  				return true ;

  	return false ;
  }
}