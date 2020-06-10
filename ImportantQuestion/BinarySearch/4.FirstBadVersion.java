/*
	In this problem understand how do we arrive at firstBad Version .

	You are a product manager and currently leading a team to develop a new product. 
	Unfortunately, the latest version of your product fails the quality check. 
	Since each version is developed based on the previous version, all the versions 
	after a bad version are also bad.

	Suppose you have n versions [1, 2, ..., n] and you want to find out the first 
	bad one, which causes all the following ones to be bad.

*/

public class Solution extends VersionControl 
{
    public int firstBadVersion(int n) { 

        int left  = 1 ;
        int right = n ;
        int mid  ;
       
      while( left <= right )
        {
        	mid = left + (right-left) / 2 ;

        	if( isBadVersion(mid) )
        		right = mid - 1;
        	else
        		left  = mid +1 ;
        }
        return left ;
    }
}