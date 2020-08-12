/*
		Here the logic is basic elementary maths multiplication .

		But Optimization is done in terms of storing the result 
		value .

		Key Points : When you multiply two numbers the length 
								 of the result will be maximum m + n .

		Reference : https://www.youtube.com/watch?v=CnEFY5Y3Z68 ( not exact reference )
		Code Reference : https://leetcode.com/problems/multiply-strings/discuss/762851/Java-simple-solution
*/

class Solution 
{
  public String multiply(String num1, String num2) 
  {
  		if( num1.equals("0") || num2.equals("0") )
  					return "0" ;

	  	int m = num1.length() ;
	  	int n = num2.length() ;
	  	int val[] = new int[ m + n ] ;
	  	StringBuilder prev = new StringBuilder() ;

	  	for( int i = m - 1 ; i >= 0 ; i-- )
	  	{
	  		int x = num1.charAt(i) - '0' ;
	  		for( int j = n - 1 ; j >= 0 ; j-- )
	  		{
 					int y      = num2.charAt(j) - '0' ;
 					/* 
 						Position at which product is stored . 
 						eg : 6 * 2 = 12 , then 2 will be stored val[ i + j + 1 ] .
 					*/
 					int pos1   = i + j + 1 ;
 					/*
						Following above example 6 * 2 = 12 , 
						then 1 will be stored at val[ i + j ] .
 					*/ 
 					int pos2   = i + j ; 
 					int prod   = x * y ;
 					val[pos1] += prod % 10 ;
 					val[pos2] += prod / 10 ; 
	  		}
	  	}

	  	StringBuilder sb = new StringBuilder() ;

	  	/* 
	  		Why do we start appending elements , starting from end ?
	  		Because in the val array there might be double digit at
	  		a particular index . So in that case carry needs to be 
	  		added at val[ i - 1 ] .
		
				The maximum length of the multiplication is m + n but
				minimum length will be m + n - 1 . 

				So ( i == 0 && val[i] == 0 )
						will remove the leading zeroes .

	  	*/

	  	for( int i = m + n - 1 ; i >= 0 ; i-- )
	  	{
	  		if( i == 0 && val[i] == 0 )
	  					continue ;

	  		sb.append( val[i] % 10 ) ;

	  		if( val[i] >= 10 )
	  				val[ i - 1 ] += val[i] / 10 ; /* val[i] / 10 adds carry . */
	  	}
  	return sb.reverse().toString() ;
  }
}