class Solution 
{
    public int[] arrayRankTransform(int[] arr) 
    {
       	int clone[] = new int [ arr.length ] ;
       	HashMap<Integer,Integer> map = new HashMap<Integer,Integer>() ;

       	for( int i = 0 ; i < arr.length ; i++ )
       				clone[i] = arr[i] ;

       	Arrays.sort( clone ) ;

       	int rank = 1 ;

       	for( int i = 0 ; i < clone.length ; i++ )
       	{
       			if( !map.containsKey( clone[i] ) )
       						map.put( clone[i] , rank++ ) ;
       	}

       	for( int i = 0 ; i < arr.length ; i++ )
       				clone[i] = map.get( arr[i] ) ;

      return clone ;
    }
}

/*
		TC : O( NlogN )
		SC : O( 2N )
*/