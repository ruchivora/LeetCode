/*
		This Question requires good Analytical skills .
		Reference : https://www.youtube.com/watch?v=d558OyD1Oss
    
    Consider Test Case : eg 1 :[1,4,2,3] eg 2 : [3,4,2,3] 

		Very Good Question .
*/

class Solution {
    public boolean checkPossibility(int[] nums) 
    {
    		int count = 0 ; 

    		for( int i = 0 ; i < nums.length - 1 ; i++ )
    		{
    				if( nums[i] > nums[ i + 1 ] )
    				{
    						if( i > 0 )
    						{
    							  if( nums[ i + 1 ] < nums[ i - 1 ] )
    							 			nums[ i + 1 ] = nums[ i ] ;

    							 	else nums[ i ] = nums[i - 1 ] ;
    						}
    						count++ ;
    				}	
    		}
    	return ( count <= 1 ) ;
        
    }
}