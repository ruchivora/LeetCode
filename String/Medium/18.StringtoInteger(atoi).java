/*
		This Question is Unnecessarily complicated because
		of few TestCases .
*/

class Solution {
  public int myAtoi( String s ) 
  {
      String sb    = s.trim().replaceAll(" +" ," " ) ;
      String str[] = sb.split( " |\\." ) ;
      String input = str[0] ;
      long sum     = 0 ;
      boolean isNegative = false ;

      for( int i = 0 ; i < input.length() ; i++ )
      {
      		if( i == 0 && input.charAt(i) == '-' )
      					isNegative = true ;

      		else if( i == 0 && input.charAt(i) == '+')
      			    		continue ;
			      		else
			      		{
			      			int num = input.charAt(i) - '0' ;

			      			if( num >= 0 && num <= 9 )
			      			{
			      				if( isNegative == true )
			      						sum = sum * 10 + num * -1 ;

			      				else sum = sum * 10 + num ;

			      				if( isNegative == true && sum < Integer.MIN_VALUE )
			      							return Integer.MIN_VALUE ;

			      				if( isNegative == false && sum > Integer.MAX_VALUE )
			      							return Integer.MAX_VALUE ;
			      			}
			      			else return (int)sum ; 
			      		}	
      }
      
    return (int)sum ;
  }
}