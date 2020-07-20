
/* 
    Time Complexity : O(N) SpaceComplexity: O(N) .
    How to improve space ?
    This problem can also be solved by using constant space .
*/

class Solution {
    public void duplicateZeros(int[] arr) 
    {
        List<Integer> queue = new ArrayList<Integer>() ;
        queue.add( arr[0] ) ;
        int count = 0 ;

        for( int i = 0 ; i < arr.length ; i++ )
        {
            if( i != arr.length - 1 ) 
                queue.add( arr[ i + 1 ] ) ;

            if( queue.get(0) == 0 && count != 2 )
            {
                arr[i] = queue.get(0) ;
                count++ ;
                if( count == 2 )
                {
                  count = 0 ;
                  queue.remove( 0 ) ;
                }       
            }
            else
            {
              arr[i] = queue.get( 0 ) ;
              queue.remove( 0 ) ;
            }
        }
    }
}



