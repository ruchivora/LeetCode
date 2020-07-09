/*
		Question :  https://leetcode.com/problems/target-sum/submissions/

		Solution :  This does not pass all the test case . Fails when the 
							  test case contains 0 .

		Reference : https://www.youtube.com/watch?v=Hw6Ygp3JBYw&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=12

*/

class Solution 
{
    public int findTargetSumWays( int[] nums, int S ) 
    {
    		int sum = 0 ;

        for( int i = 0 ; i < nums.length ; i++ )
        					sum += nums[i] ;

       	int S1 = ( sum + S ) / 2 ;

      	return count( nums , nums.length , S1 ) ;
    }

    public int count( int nums[] , int n , int sum )
    {
	    	int t[][] = new int[ n + 1 ][ sum + 1 ] ;

	    	for( int i = 0 ; i <= n ; i++ )
	    	{
	    		for( int j = 0 ; j <= sum ; j++ )
	    		{
	    			if( i == 0 && j == 0 )
	    					t[i][j] = 1 ;

	    			else if( i == 0 )
	    								t[i][j] = 0 ;

	    			else if( j == 0 )
	    								t[i][j] = 1 ;

	    			else if( nums[ n - 1 ] <=  j )
	    									t[i][j] = t[ i - 1 ][ j - nums[ i - 1 ] ] + t[ i - 1 ][j] ;

	    			else  t[i][j] = t[ i - 1 ][j] ;
	    		}
	    	}
	    return t[n][sum] ;
    }

}