/*
	Why mid is always calculated as mid = left + (right-left) / 2 
	instead of mid = ( left + right ) / 2 ?

	Because if both left and right are very large integers then
	it will cause integer Overflow . 

	Hence , calculated as mid = left + (right-left) / 2 .

*/
/*    The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); 
*/

public class Solution extends VersionControl {
    public int firstBadVersion(int n) { 

        int left  = 1 ;
        int right = n ;
        int mid  ;

        while( left < right )
        {
        	mid = left + ( right - left ) / 2 ;

        	if( isBadVersion(mid) )
        		right = mid ;
        	else
        		left  = mid +1 ;
        }
        return left ;
    }
}