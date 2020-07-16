/*
		If you do not understand howto handle conditions ,
		then first write the understandable simple code .

		Then try to optimize the code .
		The optimal code has a very good Logic .
*/

class Solution {
    public int maxDistToClosest(int[] seats) 
    {
    		int N     = seats.length  ; 
    		int left  = new int[N] ;
		    int right = new int[N] ;
		    Arrays.fill( left  , N ) ;
		    Arrays.fill( right , N ) ;  

		    for( int i = 0 ; i < N ; i++ )
		    {
		    	if( seats[i] == 1 )
		    			left[i] = 0 ; 
		    	else if( i > 0 )
		    					left[i] = left[ i - 1 ] + 1 ;
		    }

		    for( int i = N - 1 ; i >= 0 ; i-- )
		    {
		    		if( seats[i] == 1 )
		    				right[i] = 0 ;
		    		else if( i < N - 1 )
		    						right[i] = right[ i + 1 ] + 1 ;
		    }  

		    int ans = 0 ;

		    for( int i = 0 ; i < N ; i++ ) 
		    {
		    	if( seats[i] == 0 )
		    		ans = Math.max( ans , Math.min( left[i] , right[i] ) ) ;
		    }
		  return ans ;
    }
}
    
/*
		Here underlying concept is we can atleast preserve
		the index which we have visited previously and to 
		calculate index to be visited in future can be
		calculated .
*/
class Solution {
    public int maxDistToClosest(int[] seats) 
    {
		  	int N      = seats.length ;
		  	int prev   = -1 ; 
		  	int future = 0  ;
		    int ans    = 0  ;

		    for( int i = 0 ; i < N ; i++ )
		    {
		    	if( seats[i] == 1 )
		    				prev = i ;
		    	else
		    	{
		    			//How does this logic work ? 
		    			//Beautiful Logic .
		    		 while( future < N && seats[future] == 0 || future < i )
		    		 					future++ ;

		    		 int left  = ( prev == -1  )   ? N : i - prev   ;
		    		 int right = ( future == N )   ? N : future - i ;
		    		 ans       =  Math.max( ans , Math.min( left , right ) ) ;
		    	}
		    }
		    return ans ;
 		}
 }


