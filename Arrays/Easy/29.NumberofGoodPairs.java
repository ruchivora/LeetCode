class Solution {
    public int numIdenticalPairs(int[] nums) 
    {
    		HashMap<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>() ;
    		int count = 0 ;

    		for( int i = 0 ; i < nums.length ; i++ )
    		{
    				if( map.containsKey( nums[i] ) )
    						map.get( nums[i] ).add( i ) ;
    				else
    				{
    					List<Integer> temp = new ArrayList<Integer>() ;
    					temp.add( i ) ;
    					map.put( nums[i] , temp ) ;
    				}
    		}

    		/* Learn to use Hashmap Iterator */
    		Set setOfKeys     = map.keySet() ;
    		Iterator iterator = setOfKeys.iterator() ;

    		while( iterator.hasNext() )
    		{
    			int key   = (Integer) iterator.next() ;
    			int value = map.get( key ).size() ;
    			if( value > 1 )
    					count  = count + ( value * ( value - 1 ) ) / 2 ;
    		}  
    	return count ;
  }
}