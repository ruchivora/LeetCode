/*
		Logic : 

		Sum   = ( carry + num1 + num2 ) % 10
		Carry = ( carry + num1 + num2 ) / 10 
*/

class Solution 
{
	public String addStrings(String num1, String num2) 
	{
		  int index1 = num1.length() - 1 ;
		  int index2 = num2.length() - 1 ;
		  int carry  = 0 ;
		  StringBuilder sb = new StringBuilder() ;

		  while( index1 >= 0 || index2 >= 0 )
		  {
		  	int sum = carry ;

		  	if( index1 >= 0 )
		  	{
		  		sum = sum + num1.charAt( index1 ) - '0' ;
		  		index1-- ;
		  	}

		  	if( index2 >= 0 )
		  	{
		  		sum = sum + num2.charAt( index2 ) - '0' ;
		  		index2-- ;
		  	}

		  	sb.insert( 0 , sum % 10 ) ;
		  	carry = sum / 10 ;
		  }

		   if( carry > 0 )
		   			sb.insert( 0 , carry ) ;

		return sb.toString() ;
	}
}