public class Solution {
    public int sqrt(int A) {
        
        int left  = 1 ;
        int right = A ;
        int mid = 0 ;
        
        while( left <= right )
        {
            mid = left + ( right - left ) / 2 ;
            
            if( mid < A / mid )
                left = mid + 1 ;
            else if( mid > A / mid )
                   right =mid - 1 ; 
                   else return mid ;
        }
        
        return left - 1 ;
    }
}
