/*
		Edge Case : If min1 == min2 . i.e AP can not contain duplicate values .
								If array conatins all zero's then it is in AP .
		Solution  : Store elements in set and calculate min1 and min2 .
								And then calculate AP Sequence again .
								TC: O(N) SC:O(N) 
*/


class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) 
    {
	    	HashSet<Integer> map = new HashSet<Integer>() ;
	    	int min1 = Integer.MAX_VALUE ;
	    	int min2 = Integer.MAX_VALUE ;
	    	int d = 0 ;

	    	for( int i = 0 ; i < arr.length ; i++ )
	    	{
	    			if( min1 > arr[i] )
	    			{
	    					if( min2 > min1 )
	    							min2 = min1 ;

	    					min1 = arr[i] ;
	    			}
	    			else if( min2 > arr[i] )
	    								min2 = arr[i] ;

	    			map.add( arr[i] ) ;
	    	}

        if( min1 == min2 && min1 != 0 )
              return false ;

	    	d = min2 - min1 ;
	    	int sum = min1  ;

	    	for( int i = 0 ; i < arr.length-1 ; i++ )
	    	{
	    			sum = sum + d ;
	    			if( !map.contains(sum) )
	    						return false ;
	    	}
	    	
	    return true ;
    }
}