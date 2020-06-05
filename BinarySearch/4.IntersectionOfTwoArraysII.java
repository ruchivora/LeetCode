class Solution {
    public int[] intersect(int[] nums1, int[] nums2) 
    {
    	HashMap<Integer,Integer> seen = new HashMap<Integer,Integer>() ;
    	List<Integer> result = new ArrayList<Integer>() ;

    	for( int i = 0 ; i < nums1.length ; i++ )
    		seen.put(nums1[i] , seen.getOrDefault( nums1[i] , 0 ) + 1 ) ;
    	 
    	for( int i = 0 ; i < nums2.length ; i++ )
    	{
    		if( seen.containsKey( nums2[i] ) )
    		{
    			result.add( nums2[i] ) ;
    			seen.put(nums2[i] , seen.getOrDefault( nums2[i] , 0 ) - 1 ) ;
    			int count = seen.get( nums2[i] ) ;
    			
    			if( count < 1 )
    				seen.remove( nums2[i] ) ;
    		}
    	}

    	int A[] = new int[result.size()] ;

    	for( int i = 0 ; i < A.length ; i++ )
    		  A[i] = result.get(i) ;

    	return A ;

    }
}