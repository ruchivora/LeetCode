/*
		The Brute Force Approach will take O( N2 ) time .
		if we consider all the possible substring .

		The below code is same as the code which i have 
		written but this code is implemented with set .
		
*/


class Solution 
{
  public int lengthOfLongestSubstring( String s ) 
  {
	  	int aPointer = 0 ;
	  	int bPointer = 0 ;
	  	int max = 0 ;

	  	HashSet<Character> hash = new HashSet<Character>() ;

	  	while( bPointer < s.length() )
	  	{
	  		if( ! hash.contains( s.charAt( bPointer ) ) )
	  		{
	  				hash.add( s.charAt( bPointer ) ) ;
	  				bPointer++ ;
	  				max = Math.max( hash.size() , max ) ;
	  		}	
	  		else
	  		{
	  			hash.remove( s.charAt( aPointer ) ) ;
	  			aPointer++ ;
	  		}
	  	}
		return max ;
	}
 }
 

/* 
		The Below code works fine if the input
	 	contains only lower case letters 
	
		Below i have written sliding window approach using
		two pointers i and j  
		
		I could derive at the solution !
		TC : O( N )     SC : O( 1 )  

		If you don't understand then watch : https://www.youtube.com/watch?v=RoRRpF3eCH4 

*/
class Solution 
{
  public int lengthOfLongestSubstring( String s ) 
  {
  	if( s.length() == 0 || s == null ) return 0 ;
  	if( s.contains( " " ) ) return 1 ;

  	int max = 0 ; 
  	int count = 0 ;
  	int hash[] = new int[26] ;
  	int i = 0 ; 
  	int j = 0 ; 

      while( j < s.length() )
      {
	      	int index = s.charAt(j) - 'a' ;
      		hash[ index ] += 1 ;
      		count++ ;

      		if( hash[ index ] > 1 )
      		{
    				while( i < j  && hash[ index ] != 1 )
    				{
    					hash[ s.charAt( i ) -'a' ] -= 1 ;
    					i++ ;
    					count-- ;
    				}
      		}

      		max = ( max > count ) ? max : count ; 
      		j++ ;
      }

    return max ; 
  }
}