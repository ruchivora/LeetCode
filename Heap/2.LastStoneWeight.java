/*
	Priority queue is bydefault minHeap .
	To make it maxHeap we add number with negative sign .
*/


class Solution {
    public int lastStoneWeight(int[] stones) 
    {
        PriorityQueue<Integer> weight = new PriorityQueue<Integer>() ;

        for( int i = 0 ; i < stones.length ; i++ )
        			weight.add(-stones[i]) ;

        while( weight.size() > 1 )
        {
        	int max1 = -weight.poll() ;
        	int max2 = -weight.poll() ;

        	if( max1 != max2 )
        	{
        		int diff = max1-max2 ;
        		weight.add( -diff ) ;
        	}
        }
      return ( weight.isEmpty() ) ? 0 : -weight.poll() ; 
    } 
}