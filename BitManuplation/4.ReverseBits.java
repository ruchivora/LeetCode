/*
		Here the Logic is : 
		initialize one variable rev = 0 ;

		( 1 << i) : Means 1 is shifted by i digits 
		so that at that particular index the value remains one  .

		Then And it with one and if the result is one 
		then "Or" with the rev .
	
		Eg: rev = 000 
		
*/
public class Solution {
	public long reverse(long A) {
	    long rev = 0; 

	    for (int i = 0; i < 32; i++) 
	    {
	    	rev = rev << 1 ;

	    	if( (A & ( 1 << i) ) != 0  )
	    		rev = rev |  ;
	    }
	  return rev;
	}
}
