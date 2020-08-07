/*
		Here the main Logic is if s.charAt( i - 1 ) < s.charAt( i )
		then instead of adding we have to subtract . 

		eg: IV =  1 < 5 . So , 5 - 1 .

		Reference : https://www.youtube.com/watch?v=hEhf_oz3wsM

*/

class Solution 
{
  public int romanToInt(String s) 
  {
      int sum = 0 ; 
      int index = 0 ;
   
	    for( int i = 0 ; i < s.length() ; i++ )
	    {
	    	/* 
	    		Here we subtract previously added value and then agin subtract previous value from
	    		current value . 
	    	*/
	    	if( i > 0 && getValue( s.charAt( i - 1 ) ) < getValue( s.charAt( i ) )  )
	    			sum = sum - getValue( s.charAt( i - 1 ) ) + getValue( s.charAt( i ) ) - getValue( s.charAt( i - 1 ) ) ;
	    	
	    	else sum = sum + getValue( s.charAt( i ) ) ;
	    }
    return sum ; 
  }

  public int getValue( char c ) 
  {
  		switch( c )
  		{
  			case 'I' : return 1 ;
  			case 'V' : return 5 ;
  			case 'X' : return 10 ;
  			case 'L' : return 50 ;
  			case 'C' : return 100 ;
  			case 'D' : return 500 ;
  			case 'M' : return 1000 ;
  		}
  	return 0 ;
  }
}