class Solution {
    public boolean checkStraightLine(int[][] cords) {

    	int slope = ( cords[1][1] - cords[0][1] ) * ( cords[1][0] - cords[0][0] ) ; 

    	if( cords.length > 2 )
    	{
    		for(int i = 2 ; i < cords.length ; i++ )
    		{
    			if( ( cords[1][1] - cords[0][1] ) * (cords[i][0] - cords[0][0]) != ( cords[1][0] - cords[0][0] ) * (cords[i][1] - cords[0][1]) )
    			return false ;
    		}
    	}
    	return true;
    }
}