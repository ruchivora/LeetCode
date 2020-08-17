/*
			Recursive solution .

			Imagine you have bank account with 0$ to begin with. 
			If you buy stock with price x, your account balance is -x.
			Later if you sell at price y, your account balance is -x+y. 
			Accounting this way, the account balance at the end of last 
			day is the total profit realized.

			So various decisions are :
			 - We have stock on day i .
			 		- Purchased on day i 
			 		- Carry forward of previous days .

			 - We don't have stock on day i .
			 		- We sold the stock on day i.
			 		- Carry forward .
*/

class Solution {
    public int maxProfit(int[] prices, int fee) 
    {
    		return calculateProfit( prices , fee , 0 , 0 ) ;
    }

    public int calculateProfit( int prices[] , int fee , int index , int bought )
    {
    		if( index == prices.length )
    					return 0 ;

    		int max = Integer.MIN_VALUE ; 

    		if( bought == 0 )
    		{
    			max = Math.max( calculateProfit( prices , fee  , index+1 , 1 ) - prices[index] ,
    											calculateProfit( prices , fee  , index+1 , bought )
    										 );
    		}
    		else
    		{
    			max = Math.max( calculateProfit( prices , fee , index+1 , 0 ) + prices[index] - fee , 
    											calculateProfit( prices , fee , index+1 , bought )
   							 				) ;
    		}
    	return max ;
    }
}

/*
		Recursive with Memoziation .
*/
class Solution 
{
    public int maxProfit(int[] prices, int fee) 
    {
    		int dp[][] = new int[prices.length ][2] ;
    			for( int i = 0 ; i < prices.length ; i++ )
    					for( int j = 0 ; j < 2 ; j++ )
    							dp[i][j] = -1 ;

    		return calculateProfit( prices , fee , 0 , 0 , dp) ;
    }

    public int calculateProfit( int prices[] , int fee , int index , int bought , int dp[][] )
    {
    		if( index == prices.length )
    					return 0 ;

    		if( dp[index][bought] != -1 ) return dp[index][bought] ;

    		int max = Integer.MIN_VALUE ;

    		if( bought == 0 )
    		{
    			max = Math.max( calculateProfit( prices , fee  , index+1 , 1 ,dp) - prices[index] ,
    											calculateProfit( prices , fee  , index+1 , bought , dp)
    										);
    		}
    		else
    		{
    			max = Math.max( calculateProfit( prices , fee , index + 1 , 0 , dp ) + prices[index] - fee , 
    											calculateProfit( prices , fee , index + 1 , bought , dp )
   							 				) ;
    		}
    	return dp[index][bought] = max ;
    }
}
	
		