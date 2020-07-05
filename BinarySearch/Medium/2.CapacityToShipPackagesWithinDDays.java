/*
	Brute force : find sum of all the elements .
	Then range = [ highest num of the wights Array to sum of all elements ] .
	Then starting from first number in the range calculating 
	the number of days required to ship the package .

	Improvement : Instead of selecting number one by one
	we can go for binary search and then calculate number of days
	required to ship the package .  

	Hint : here in binary search logic we don't return if(days == D)
				 because this condition will be satisfied evn if the capacity 
				 is 17 . So , the minimum value will be returned only when the 
				 while loop will end at left <= right .  
    Reference : https://www.youtube.com/watch?v=CoNBRq5JSz0&t=72s  
*/

class Solution {

    public int shipWithinDays(int[] weights, int D) 
    {
        int start = Integer.MIN_VALUE ;
        int end = 0 ;

        for( int i = 0 ; i < weights.length ; i++ )
        {
        		start = Math.max( weights[i] ,start ) ;
        		end  += weights[i] ;
        }
        		 
        while( start <= end )
        {
        	int mid  = start + ( end - start ) / 2 ;
        	int days = daysToLoad( weights , mid ) ;

        	if( days > D ) start = mid + 1 ;
        			else end = mid - 1 ;
        }
       	return start ;
    }

    public int daysToLoad( int weights[] , int capacity )
    {
    	  int days = 0 ;
    	  int sum  = 0 ;

    		for( int i = 0 ; i < weights.length ; i++ )
    		{
    				sum += weights[i] ;
    				if( sum > capacity )
    				{
    					sum = weights[i] ;
    					days++ ;
    				}
    		}
    		return ( sum > 0 ) ? days + 1 : days ;
    }

}