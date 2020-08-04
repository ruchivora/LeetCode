/*
		My Logic : Sum   = Exor of carry , num1 , num2 
							 Carry = And of carry , num1 , num2 

		But Sum and carry can also be achieved by mod and division Operator .
		Sum   = ( sum of carry , num1 , num2 ) % 10 .
		Carry = ( sum of carry , num1 , num2 ) / 10 .

		Reference : https://www.youtube.com/watch?v=tRpusgdZxrE

*/

class Solution 
{
	public String addBinary(String a, String b) 
	{
			int index1 = a.length() - 1 ;
			int index2 = b.length() - 1 ;
			int carry  = 0 ; 
			StringBuilder ans = new StringBuilder() ;

			while( index1 >= 0 || index2 >= 0 )
			{
				int sum = carry ;

				if( index1 >= 0 )
				{
					sum = sum + a.charAt( index1 ) - '0' ;
					index1-- ;
				}
					
				if( index2 >= 0 )
				{
					sum = sum + b.charAt( index2 ) - '0' ;
					index2-- ;
				}		

				ans.insert( 0 , sum % 2 ) ;
				carry = sum / 2 ;
			}

			if( carry > 0 )
					ans.insert( 0 , 1 ) ;

		return ans.toString() ;
	}
}