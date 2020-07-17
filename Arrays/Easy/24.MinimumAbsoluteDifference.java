/*
			If you have numbers and multiple decisions are needed at 
			each point , So i thought of using Dynamic Programming 
			to find the Minimum difference .

			I could write the recurrence equation but could not convert it to DP .

			Better Approach : Just sort the array . 
*/

class Solution {
    public List<List<Integer>> minimumAbsDifference( int[] arr ) 
    {
    		List<List<Integer>> map = new ArrayList<List<Integer>>() ;
    		int min = Integer.MAX_VALUE ; 

    		Arrays.sort( arr ) ;

    		for( int i = 1 ; i < arr.length ; i++ )
    		{
    				int diff = Math.abs(arr[i - 1] - arr[i] ) ;
    				min = ( min > diff ) ? diff : min ;
    		}
    					  
    		for( int i = 1 ; i < arr.length ; i++ )
    		{
	    			if( Math.abs(arr[i - 1] - arr[i]) == min )
	    			{
	    					List<Integer> temp = new ArrayList<Integer>() ;
	    					temp.add( arr[i - 1] ) ;
	    					temp.add( arr[i] ) ;
	    					map.add( temp ) ;
	    			}		
    		}
    	return map ;
    }
}

/* 
		Recurrence solution to find minimum difference 
*/
class Solution 
{
		int min = Integer.MAX_VALUE ;
		
    public List<List<Integer>> minimumAbsDifference(int[] arr) 
    {
    		List<List<Integer>> map = new ArrayList<List<Integer>>() ;

    		int data[] = new int[2] ;
        int x = calculate( arr , arr.length , data , 0 ) ;
        System.out.println( " x " + x ) ;

      return map ;
    }	

    public int calculate( int arr[] , int index , int data[] , int dataIndex )
    {
    		if( dataIndex == data.length )
    					return Math.abs( data[0] - data[1] ) ;

    		if( index == 0 )
    					return min ;

    		data[ dataIndex ] = arr[ index - 1 ] ;

    		return min = Math.min( min , Math.min( calculate( arr , index - 1 , data , dataIndex + 1 ) ,
    									                         calculate( arr , index - 1 , data , dataIndex ) 
    									                        ) 
    													) ;
    }
}
