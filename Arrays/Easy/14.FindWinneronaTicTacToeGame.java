class Solution {
    public String tictactoe(int[][] moves) 
    {
        int ans[][] = new int[3][3] ;

        for( int i = 0 ; i < moves.length ; i++ )
        {
        		if( i % 2 == 0 ) /* For A */
        		{
        				ans[ moves[i][0] ][ moves[i][1] ] = 1 ;

        				if( ( ans[0][0] == 1 && ans[1][0] ==1 && ans[2][0] == 1 ) || 
        						( ans[0][1] == 1 && ans[1][1] ==1 && ans[2][1] == 1 ) ||
        						( ans[0][2] == 1 && ans[1][2] ==1 && ans[2][2] == 1 ) ||
        						( ans[0][0] == 1 && ans[0][1] ==1 && ans[0][2] == 1 ) ||
        						( ans[1][0] == 1 && ans[1][1] ==1 && ans[1][2] == 1 ) ||
        						( ans[2][0] == 1 && ans[2][1] ==1 && ans[2][2] == 1 ) ||
        						( ans[0][0] == 1 && ans[1][1] ==1 && ans[2][2] == 1 ) ||
        						( ans[2][0] == 1 && ans[1][1] ==1 && ans[0][2] == 1 )
        					 )
        					  return "A" ;
        		}
        		else
        		{
        				ans[ moves[i][0] ][ moves[i][1] ] = 2 ;

        				if( ( ans[0][0] == 2 && ans[1][0] ==2 && ans[2][0] == 2 ) || 
        						( ans[0][1] == 2 && ans[1][1] ==2 && ans[2][1] == 2 ) ||
        						( ans[0][2] == 2 && ans[1][2] ==2 && ans[2][2] == 2 ) ||
        						( ans[0][0] == 2 && ans[0][1] ==2 && ans[0][2] == 2 ) ||
        						( ans[1][0] == 2 && ans[1][1] ==2 && ans[1][2] == 2 ) ||
        						( ans[2][0] == 2 && ans[2][1] ==2 && ans[2][2] == 2 ) ||
        						( ans[0][0] == 2 && ans[1][1] ==2 && ans[2][2] == 2 ) ||
        						( ans[2][0] == 2 && ans[1][1] ==2 && ans[0][2] == 2 )
        					 )
        					return "B" ;
        		}
        }

        if( moves.length < 9 ) 
        			return "Pending" ;

      return "Draw" ;
    }
}