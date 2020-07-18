/*
		Whenever we have to deal with pairs , consider 
		sorting of pairs as an option to arrive at the 
		solution .
*/

class Solution {
    public int numEquivDominoPairs(int[][] dominoes) 
    {
        int count = 0 ;

        HashMap<String,Integer> map = new HashMap<String,Integer>() ;

        for( int i = 0 ; i < dominoes.length ; i++ )
        {
        		if( dominoes[i][0] > dominoes[i][1] )
        		{
        			int temp = dominoes[i][0] ;
        			dominoes[i][0]  = dominoes[i][1] ;
        			dominoes[i][1]  = temp ;
        		}

        		StringBuilder temp = new StringBuilder() ;
        		temp.append( dominoes[i][0] ) ;
        		temp.append( dominoes[i][1] ) ;

        		String key = temp.toString() ;

        		map.put( key , map.getOrDefault( key , 0 ) + 1 ) ;
        }

        	/* Using Iterator to get keys from HashMap */
         Set setOfKeys = map.keySet() ;
         Iterator iterator = setOfKeys.iterator() ;

         while( iterator.hasNext() )
         {
         		String key = ( String ) iterator.next() ;
         		int value  = map.get(key) ;
         		count = count + ( value * ( value - 1) ) / 2 ;
         }
      return count ;
    }
}