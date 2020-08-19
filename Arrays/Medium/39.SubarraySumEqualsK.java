/*
		Thought Process : Use sliding window approach . 
		Bad choice because the input elements can be 
		negative . So sliding window can not be applied ! .

		Brute Force : Time Complexity : O( N2 ) . 

		But the time complexity can be reduced , by maintaining
		HashMap . The idea is cumulative sum - required Sum = some value .
		And if that value appears in past then that means their exists
		a sum with value k . Good method ! .

		Reference : https://www.youtube.com/watch?v=HbbYPQc-Oo4

    PathSum III problem is also based on this problem .

*/

/* 
	 Using Hash Map that stores value and 
	 count of occurance of value 
*/

class Solution
{
	public int subarraySum( int[] nums, int k ) 
  {
  	HashMap<Integer,Integer> map = new HashMap<Integer,Integer>() ;
  	int cumSum = 0 ;
  	int count  = 0 ;

  	map.put( 0 , 1 ) ;

  	for( int i = 0 ; i < nums.length ; i++ )
  	{
  		cumSum = cumSum + nums[i] ;

  		if( map.containsKey( cumSum - k ) )
  					count = count + map.get( cumSum - k ) ;
  		
  		map.put( cumSum , map.getOrDefault( cumSum , 0 ) + 1 ) ;
  	} 
  	return count ;
  }
}



/* Brute Force */		
class Solution 
{
  public int subarraySum(int[] nums, int k) 
  {
  	int count = 0 ;
  	int sum   = 0 ;   

  		for( int i = 0 ; i < nums.length ; i++ )
  		{
  			sum = nums[i] ;	
  			if( sum == k ) count ++ ;

  			for( int j = i + 1 ; j < nums.length ; j++ )
  			{
  				sum = sum + nums[j] ;
  				if( sum == k ) count++ ;
  			}
  		}  
  	return count ;    
  }
}