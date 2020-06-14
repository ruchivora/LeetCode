class Solution {
    public boolean hasAlternatingBits(int n) 
    {
    	int last = n % 2 ;
    	n = n >> 1 ;

    	while( n > 0 )
    	{
    		int curr = n % 2 ;

    		if( curr == last ) 
    			  return false ;
 				last = curr ;
 				n = n >> 1 ;
    	} 
    	return true ;
    }
}