/*
		This problem tells the actual use of stack .
*/



class Solution {
    public int[] asteroidCollision(int[] asteroids) 
    {
        Stack<Integer> collide = new Stack<Integer>() ;

        for( int i = 0 ; i < asteroids.length ; i++ )
        {
        		if( collide.isEmpty() )
        				collide.push( asteroids[i] ) ;
        		else 
        		{
        			int ast1 = collide.peek() ;
        			int ast2 = asteroids[i] ;

        			if( ast1 > -1 && ast2 > -1 || ast1 < 0 && ast1 < 0 || ast1 < 0 && ast2 > -1 )
        						collide.push( ast2 ) ;

        			else
        			{
        					while( !collide.isEmpty() )
        					{
        						
        					}
        			}

        		}
        }

        int arr[] = new int [collide.size()] ;
        for( int i = 0 ; i < collide.size() ; i++ )
        			arr[i] = collide.get(i) ;

      return arr ;
    }
}