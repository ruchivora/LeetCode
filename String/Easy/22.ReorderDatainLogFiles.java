/*
		Understand the Question Properly .
		Read the Question and try to decode the
		Question .

		Reference : https://www.youtube.com/watch?v=RAb3of36dm4 

*/

class Solution 
{
  public String[] reorderLogFiles(String[] logs) 
  {
      /*
      	Overloading Arrays.sort() to provide
      	custome sorting . Writing Anonymous 
      	function ! .
      */

      Arrays.sort( logs , ( log1 , log2 ) ->{

      	/* 
      		Here split will happen uptil first space 
      		and hence we will get Log string divided into
      		two parts .
      	*/	
      	String[] log1Split = log1.split( " " , 2 ) ;
      	String[] log2Split = log2.split( " " , 2 ) ;

      	boolean isLog1DigitLog = Character.isDigit( log1Split[1].charAt(0) ) ;
      	boolean isLog2DigitLog = Character.isDigit( log2Split[1].charAt(0) ) ;

      	if( !isLog1DigitLog && !isLog2DigitLog )
      	{
      		int comparision = log1Split[1].compareTo( log2Split[1] ) ;
      		if( comparision == 0 )
      		{
      			return log1Split[0].compareTo( log2Split[0] )
      		}
      		return comparision ;
      	}

      	if( isLog1DigitLog && isLog2DigitLog )
      				return 0 ;

      	if( isLog1DigitLog && !isLog2DigitLog )
      				return 1 ;

      	//if( !isLog1DigitLog && isLog2DigitLog )
      				return -1 ;
      } );
    return logs ;
  }
}