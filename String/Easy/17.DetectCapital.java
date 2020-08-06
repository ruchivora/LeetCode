class Solution 
{
  public boolean detectCapitalUse( String word ) 
  {
	    int countCapital = 0 ;
	    int countSmall   = 0 ; 

	    for( int i = 0 ; i < word.length() ; i++ )
	    {
	    	int charAscii = word.charAt( i ) ;

	    	if( charAscii >= 65 && charAscii <= 90 )
	    			countCapital++ ;

	    	else if( charAscii >= 97 && charAscii <= 122 )
	    						countSmall++ ;
	    }

	    if( countCapital == word.length() || countSmall == word.length() )
	    			return true ;

	    if( countCapital == 1 )
	    {
	    	int charAscii = word.charAt( 0 ) ;

	    	if( charAscii >= 65 && charAscii <= 90 )
	    				return true ;
	    }
    return false ;
  }
}