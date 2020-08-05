/*
		You can create your own split and reverse method ! .
*/

class Solution 
{
  public String reverseWords(String s) 
  {
      String word[] = s.split(" ") ;

      for( int i = 0 ; i < word.length ; i++ )
      {
      	char arr[] = word[i].toCharArray() ;
      	int left  = 0 ;
      	int right = word[i].length() - 1 ;

      	while( left < right )
      	{
      		char temp  = arr[left] ;
      		arr[left]  = arr[right] ;
      		arr[right] = temp ; 
      		left++ ;
      		right-- ;
      	}
      	String ab = new String( arr ) ;
      	word[i]  = ab ; 
      }
      
      StringBuilder sb = new StringBuilder() ;

      for( int i = 0 ; i < word.length  ; i++ )
      {
      	sb.append( word[i] ) ;
      	if( i != word.length - 1 )
      			sb.append(" ") ;
      } 
    return sb.toString() ;
  }
}