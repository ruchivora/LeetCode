/*
			While solving this problem just have a look at the constraints .
			Here i thought of using stack but that is not feasible .
			So form a Hash using an array .
*/

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) 
    {
        int count[]  = new int [101] ;
        int result[] = new int [ nums.length ] ;
        int sum     = 0 ;

        for( int i = 0 ; i < nums.length ; i++ )
        				count[nums[i]]++ ;
        
        for( int i = 0 ; i <= 100 ; i++ )
        {
        	 if( count[i] != 0 )
        	 {
        	 		int temp = count[i] ;
        	 		count[i] = sum ;
        	 		sum      = sum + temp ;
        	 }
        }

        for( int i = 0 ; i < nums.length ; i++ )
        			result[i] = count[ nums[i] ] ; 
        		
      return result ;
    }
}


