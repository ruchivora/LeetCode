/* 
	This Question is similar to Longest common Substring . 
	 - Here the key point is once we get the non matching element
	   set the count to zero .

	Writing recursive solution is bit different from writing 
	Dynamic Programming . Because we need to set the counter
	to zero again .

	Then maximum count can occur anywhere in the DP Array . 

*/

/* Brute Force Approach */

class Solution 
{
  public int findLength(int[] A, int[] B) 
  {
  	int count = 0 ; 
  	int max   = 0 ;  

  		for( int i = 0 ; i < A.length ; i++ )
  		{
  			for( int j = 0 ; j < B.length ; j++ )
  			{
  				if( A[i] == B[j] ) 
  				{
  						count = 1 ;

  						int aStart = i + 1 ;
  						int bStart = j + 1 ;

  						while( aStart < A.length && bStart < B.length )
  						{
  							if( A[aStart++] == B[bStart++] ) count++ ;
  							else break ;
  						}
  						max = Math.max( max , count ) ;
  				}
  			}
  		}
    return max ;  
  }
}

/* Dynamic Programming Approach */

class Solution 
{
  public int findLength( int[] A , int[] B ) 
  {
  	int t[][] = new int[A.length + 1][B.length + 1] ;

  	int maxCount = Integer.MIN_VALUE ;

  	for( int i = 0 ; i <= A.length ; i++ )
  	{
  		for( int j = 0 ; j <= B.length ; j++ )
  		{
  			  if( i == 0 || j == 0 )
  			 		  t[i][j] = 0 ;

  			 	else if( A[ i - 1 ] == B [ j - 1 ] )
  			 						t[i][j] = 1 + t[i - 1][j - 1 ] ; 

  			 	else t[i][j] = 0 ;

  			 	maxCount = Math.max( maxCount , t[i][j] ) ;
  		}
  	}
   return maxCount ;
  }
}



class Solution 
{
  public int findLength( int[] A , int[] B ) 
  {
    return findLength( A , B , 0 , 0 , 0 ) ;
  }

  public int findLength( int A[] , int B[] , int aIndex , int bIndex , int count)
  {
  	if(  A.length >= aIndex || B.length >= bIndex )
  			return count ;

    if( A[aIndex] == B[bIndex] )
      		 return  findLength( A , B , aIndex++ , bIndex++ , count + 1 ) ;

    return Math.max( count , Math.max( findLength( A , B , aIndex++ , bIndex   , 0  ) , 
      																 findLength( A , B , aIndex   , bIndex++ , 0  ) 
      																)
      							)  ;	
  }
}