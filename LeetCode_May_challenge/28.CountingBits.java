class Solution {
    public int[] countBits(int nums) {
        
    int ans[] = new int[ nums + 1 ] ;

    for( int i = 1 ; i <= nums ; i++ )
    {
    	if( i % 2 == 0 )
    	{
    		int num = i ;
    		int count = 0 ;
    		while( num != 0 )
    		{
    			count += num & 1 ;
    			num    = num >> 1 ;
    		}
    		ans[i] = count ;
    	}
    	else
    	{
    		ans[i] = 1 + ans[i-1] ;
    	}
    }
    return ans ;

    }
}