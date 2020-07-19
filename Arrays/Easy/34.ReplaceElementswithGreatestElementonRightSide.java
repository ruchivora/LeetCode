class Solution {
    public int[] replaceElements(int[] arr) 
    {
        int top = arr[ arr.length -1 ] ;
        arr[ arr.length-1] = -1 ; 
        
        for( int i = arr.length - 2 ; i >= 0 ; i-- )
        {
        		int temp = arr[i] ;
        		arr[i]   = top ;
        		if( top < temp )
        				top = temp ;	
        }

      return arr ;
    }
}