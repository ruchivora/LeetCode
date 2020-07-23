/*
		To Solve this problem , break the problem to
		4 Sum = 1 Sum + 3 Sum . 
		Then 4 Sum = 1 Sum + 3 Sum(3 Sum is divided into 1 Sum + 2 Sum )
	
		So how to solve 2 Sum ?
			- Sort the array and use two pointer Technique . TC: O( NlogN ) SC : O(1)
			- use set and find the required number . TC : O( N ) SC : O(N) .

		So in 4 Sum 
			- Fix two elements using two loops and then for finding other two numbers
			  use any of the 2 Sum  Technique .
			- TC : O( N3 ) SC: O(1) or O(N) . 
*/

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) 
    {
    	List<List<Integer>> result = new ArrayList<List<Integer>>() ;

      Arrays.sort( nums ) ;

    	for( int i = 0 ; i < nums.length - 3 ; i++ )
    	{
    			if( i > 0 && nums[i] != nums[i-1] || i == 0 )
    			{
    				for( int j = i + 1  ; j < nums.length - 2  ; j++ )
    				{
		    				int left  = j + 1 ;
		    				int right = nums.length - 1 ;
		    				int sum   = nums[i] + nums[j] ; 

		    				if(  j == i + 1 || nums[j] != nums[j-1] )
		    				{
		    					while( left < right )
		    					{
		    						if( sum + nums[left] + nums[right] > target )
		    										right-- ;

		    						else  if( sum + nums[left] + nums[right] < target )
		    											left++ ;

		    									else{
		    													ArrayList<Integer> temp = new ArrayList<Integer>() ;
		    													Collections.addAll( temp , nums[i] , nums[j] , nums[left] , nums[right] ) ;
		    													result.add( temp ) ;

		    													while( left < right && nums[left ] == nums[ left  + 1 ] ) left++  ;
		    													while( left < right && nums[right] == nums[ right - 1 ] ) right-- ;
		    														left++  ;
		    														right-- ;
		    											}
		    					} 
		    				}
		    		}
    			}
    	}
    return result ;
  }
}