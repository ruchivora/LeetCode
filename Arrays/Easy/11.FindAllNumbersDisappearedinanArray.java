/*
		Important Question : Observe the Question says that the numbers of array
												 lies between 1 to n.

		Logic : https://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/
*/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) 
    {
    		List<Integer> list =  new LinkedList<Integer>() ;

    		for( int i = 0 ; i < nums.length ; i++ )
    		{
    			 int position = Math.abs( nums[i] ) - 1  ;

    			 if( nums[position] > 0 )
    			 		 nums[position] = nums[position] * -1 ;
    		}

    		for( int i = 0 ; i < nums.length ; i++ )
    		{
    			if( nums[i] > 0 )
    				  list.add( i + 1 ) ;
    		}
    	return list ;
    }
}