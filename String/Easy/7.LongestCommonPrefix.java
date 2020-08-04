/*
		Logic : You can go for horizontal or vertical comparison . 

		Below code shows horizontal comaprizon . 

		TC : No of Strings * length of smallest string .
		SC : O(1) .

		But you can also use Trie . 
		Reference : https://www.youtube.com/watch?v=fhyIORFDD0k 

*/

class Solution 
{
  public String longestCommonPrefix(String[] strs) 
  {
  	if( strs.length == 0 )
  			return "" ;

  	String prev = strs[0] ; 

    for( int i = 1 ; i < strs.length ; i++ )
    {
    	int index = 0 ;

    	while( index < prev.length() && index < strs[i].length() && prev.charAt(index) == strs[i].charAt( index ) )
    					index++ ;

    	prev = prev.substring( 0 , index ) ;
    }
    return prev ;
  }
}