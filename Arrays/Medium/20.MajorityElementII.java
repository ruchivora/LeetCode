/*
		Beautiful concept . 
		The Question is based on Moore Voting Algorithm .
		
		Questions that may arise .

		1. Why do we need only two variables first and second 
			 to find which element occured more than N/3 times ?
			  - Because their will be atmost 2 elements that 
			    can occur more than N/3 times . 3 elements can
			    not occur more than N/3 times in an Array .

		2. How does the algorithm work ? 
		    - The algorithm works based on the concept of bucket . 
		      Reference : https://leetcode.com/problems/majority-element-ii/discuss/753977/Generalized-majority-voting-algo-with-Detailed-Graphic-Explanation-O(n)-time-O(1)-space 
				
				- It basically says if you find element which does not
				  fit into first and second bucket then simply decrement
				  both the counters counter1 and counter2 .

				This concept can further be extended to any number i.e N/2 -> N/3 -> N/4 etc .

    Check out Majority Element i.e [ N / 2 ] .

*/

class Solution 
{
  public List<Integer> majorityElement(int[] nums) 
  {
    	List<Integer> result = new ArrayList<Integer>() ;
    	int first  = Integer.MAX_VALUE ;
    	int second = Integer.MAX_VALUE ;
    	int count1 = 0 ;
    	int count2 = 0 ;

    	for( int i = 0 ; i < nums.length ; i++ )
    	{
    		  if( first == nums[i] )
    		 			count1++ ;

    		 	else if( second == nums[i] )
    		 						count2++ ;

    		 	else if( count1 == 0 )
    		 	{
    		 			first = nums[i] ;
    		 			count1++ ;
    		 	}
    		 	else if( count2 == 0 )
    		 	{
    		 			second = nums[i] ;
    		 			count2++ ;
    		 	}
    		 	else
    		 	{
    		 		count1-- ;
    		 		count2-- ;
    		 	}
    	}

    	count1 = 0 ;
    	count2 = 0 ; 

    	for( int i = 0 ; i < nums.length ; i++ )
    	{
    			if( first == nums[i] ) count1++ ;
    			else if( second == nums[i] ) count2++ ;
    	} 

    	if( count1 > nums.length / 3 ) 
    				result.add( first ) ;

    	if( count2 > nums.length / 3 )
    				result.add( second ) ;

    return result ;   
  }
}