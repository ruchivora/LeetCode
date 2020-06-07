class Solution {
    public boolean isSubsequence(String S, String T) 
	{

		if( S.equals("") ) return true ;

		int index = 0 ;

		for( int i = 0 ; i < T.length() ; i++ )
		{
			if( S.charAt(index) == T.charAt(i) )
				index++ ;

			if( S.length() <= index )
				return true ;
		}

	  return false ;
    }
}