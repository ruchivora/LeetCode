class Solution {
    public int findJudge(int N, int[][] trust) {
        
    if( N == 1 && trust.length == 0 )
    	return 1 ;

  	int num[] = new int[N+1] ;
  	int ans = -1 ;

  	for( int i = 0 ; i < trust.length ; i++ )
  	{
  		num[trust[i][1]] += 1 ;

  		if( num[trust[i][1]] == N - 1 ) 
  				ans = trust[i][1] ;
  	}

  	for(int i = 0 ; i < trust.length ; i++ ){
  		if( trust[i][0] == ans )
  			return -1 ;
  	}
  	
    return ans ;
    }
}