/*
		Question is Simple . 

		But writing code is bit tricky ! .

		Reference : https://www.youtube.com/watch?v=qKczfGUrFY4&t=22s

*/

class Solution 
{
    public int[][] merge(int[][] intervals) 
    {
        if( intervals.length <= 1 ) return intervals ;

        /* Sorting the interval based on first index */

        Arrays.sort( intervals , ( arr1 , arr2 ) -> Integer.compare( arr1[0] , arr2[0] ) ) ;

        List<int[]> outputArr = new ArrayList() ;

        int curInterval[] = intervals[0] ;
        outputArr.add( curInterval ) ;

        for( int i = 1 ; i < intervals.length ; i++ )
        {
        	int prevEnd   = curInterval[1]  ;
        	int nextBegin = intervals[i][0] ;

        	if( prevEnd >= nextBegin )
        	{
        		/* We need to have Math.max because , consider eg: [1,4] [2,3] */
        		curInterval[1] = Math.max( prevEnd , intervals[i][1] );
        	}
        	else
        	{
        		curInterval = intervals[i]   ;
        		outputArr.add( curInterval ) ; 
        	}
        }
      return outputArr.toArray( new int[outputArr.size()][]) ;
    }
}