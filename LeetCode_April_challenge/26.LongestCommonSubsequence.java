class Solution {
    public int longestCommonSubsequence(String p, String q) {
        
    int arr[][] = new int[ p.length() + 1 ][ q.length() + 1 ] ;

    for( int i = 1 ; i <= p.length() ; i++ )
    {
    	for( int j = 1 ; j <= q.length() ; j++ )
    	{
    		if( p.charAt(i-1) == q.charAt(j-1) )
    			arr[i][j] = arr[i-1][j-1] + 1 ;
    		else
    			arr[i][j] = Math.max( arr[i-1][j] , arr[i][j-1] ) ;
    	}
    }
    return arr[p.length()][q.length()] ;
    }
}