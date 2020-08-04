/*
		In string the space for HashMap is considered as constant , 
		Because the size of the HashMap is always going to be 26 . 
*/

class Solution 
{
  public int firstUniqChar(String s) 
  {
      int hash[] = new int[26] ;

      for( int i = 0 ; i < s.length() ; i++ )
     				hash[ s.charAt(i) - 'a' ] += 1 ;

     	for( int i = 0 ; i < s.length() ; i++ )
     	{
     		if( hash[ s.charAt(i) - 'a' ] == 1 )
     					return i ;
     	}
    return -1 ;
  }
}


