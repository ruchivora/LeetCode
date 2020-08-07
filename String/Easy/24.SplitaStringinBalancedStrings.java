class Solution 
{
  public int balancedStringSplit(String s) 
  {
	  	int count  = 0 ;
	  	int countL = 0 ;
	  	int countR = 0 ;

	  	for( int i = 0 ; i < s.length() ; i++ )
	  	{
	  		if( s.charAt(i) == 'R' )
	  					countR++ ;

	  		else if( s.charAt(i) == 'L' )
	  							countL++ ;

	  		if( countR == countL )
	  		{
	  			countL = 0 ;
	  			countR = 0 ; 
	  			count++ ;
	  		}
	  	}
	  return count ;
  }
}