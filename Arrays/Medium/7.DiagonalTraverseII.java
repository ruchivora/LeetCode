/*
		Logic : All the elements with same sum for ( i + j ) will
						form one group .

		Reference : https://www.youtube.com/watch?v=6t82AO15Pgk&t=253s
*/

class Solution {
  public int[] findDiagonalOrder( List<List<Integer>> nums ) 
  {
      HashMap<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>() ;
      /* We find this in order to avoid use of comaparator */
      int maxIndex = Integer.MIN_VALUE ;
      int count    = 0 ;

      for( int i = 0 ; i < nums.size() ; i++ )
      {
      	for( int j = 0 ; j < nums.get(i).size() ; j++ )
      	{
      		count++ ;
      		maxIndex = ( maxIndex < i + j ) ? ( i + j ) : maxIndex ; 

      			if( !map.containsKey( i + j ) )
      					map.put( i + j , new ArrayList<Integer>() ) ;
      			
      			map.get( i + j ).add( 0 , nums.get(i).get(j) ) ;
      	}
      }

      int ans[] = new int [ count ] ; 
      int index = 0 ;

      for( int i = 0 ; i <= maxIndex ; i++ )
      {
      		if( map.containsKey( i ) )
      		{
      			for( int j = 0 ; j < map.get(i).size() ; j++ )
      							ans[index++] = map.get(i).get(j) ;
      		}
      }
    return ans ;
  }
}