/*
		My Mistake : I wrote recurrence equation based on the decision tree 
								 i.e consider one number and don't consider next. 
								 But here decision is based on index i.e index - 1 
								 and index - 2 .

								 So, understood how to write the decision statement .
*/

/* Dynamic Programming Approach */

class Solution 
{
    public int minCostClimbingStairs(int[] cost) 
    {
	    	int n   = cost.length ;
	    	int t[] = new int[ n ] ;

	    	for( int i = 0 ; i < n ; i++ )
	    	{
	    		if( i == 0 || i == 1 )
	    				t[i] = cost[i] ;

	    		else t[i] = cost[i] + Math.min( t[ i - 1] , t[ i - 2 ] ) ;
	    	} 
    	return Math.min( t[n - 1] , t[ n - 2 ] ) ;
    }
}


/* Recursion Solution */

class Solution 
{
    public int minCostClimbingStairs(int[] cost) 
    {
    	 int n = cost.length ;
    	 return Math.min( calculateCost( cost , n - 2 ) , calculateCost( cost , n - 1  ) ) ;
    }

    public int calculateCost( int cost[] , int index )
    {
   			if( index == 0 || index == 1 ) 
   				return cost[index] ;

    		return cost[index] + Math.min( calculateCost( cost , index - 1 ) , 
    																   calculateCost( cost , index - 2 ) 
    																  ) ;
    }
}

/* Memoziation Approach */

class Solution 
{
    public int minCostClimbingStairs(int[] cost) 
    {
    		int n = cost.length ; 
    		int memo[] = new int[ memo + 1 ] ;
    			Arrays.fill( memo , -1 ) ;
        return Math.min( calculateCost( cost , n - 2 , memo ) , calculateCost( cost , n - 1 , memo ) ) ;
    }

    public int calculateCost( int cost[] , int index ,int memo[] )
    {
   			if( index == 0 || index == 1 ) 
   				return memo[index] = cost[index] ;

   			int left  = 0 ;
   			int right = 0 ;

   			if( memo[index - 1 ] != -1 )
   					left = memo[ index - 1 ] ;
   			else
   				left = calculateCost( cost , index - 1 , memo ) ;

   			if( memo[index - 2 ] != -1 )
   					right = memo[ index - 2 ] ;
   			else
   				right = calculateCost( cost , index - 2 , memo ) ;

    		return cost[index] + Math.min( left , right ) ;
    }
}

