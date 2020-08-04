/*
		The Solution of this Question is Easy but here consider 
		edge case as eg: "mississippi" "issip"
	
		Logic : Two pointer technique . But try to analyze 
						the above example . Made very lame mistake . 

*/
class Solution {
  public int strStr(String haystack, String needle) 
  {
      if( needle.length() > haystack.length() ) 
     			return -1 ;

      if( needle.length() == 0 ) return 0 ;

      int m = haystack.length() ;
      int n = needle.length() ;

      for( int i = 0 ; i <= m - n ; i++ )
      {
      	int count = 0 ;
      	int index = i ;
      	for( int j = 0 ; j < needle.length() ; j++ )
      	{
      		if( haystack.charAt(index) != needle.charAt(j) )
      					break ;
      		else 
      		{ 
      			count++ ; 
      			index++ ;
      	  }
      	}

      	if( count == n  )  return i ;
      	else count = 0 ;
      }
    return -1 ;
  }
}