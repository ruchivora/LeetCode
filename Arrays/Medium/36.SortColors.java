/*
		Question is bit Tricky ! 
		You get to learn something different .

		Understand why do we increment the variable index ! 

		Reference : https://www.youtube.com/watch?v=uvB-Ns_TVis 

*/

class Solution 
{
  public void sortColors(int[] nums) 
  {
  		if( nums.length == 0 || nums.length == 1 )
  					return  ;
  		int start  = 0 ; 
  		int end = nums.length - 1 ;
  		int index = 0 ;

  		while( index <= end && start < end )
  		{
  				if( nums[index] == 0 )
  				{
  					nums[index] = nums[start] ;
  					nums[start] = 0 ;
  					start++ ;
  					index++ ;  
  					/* Here we increment index because 
  						we have already seen elements of start before. 
  						So till start the elements are 0 but after start
  						the elements will only be 1 .
  					*/
  				}
  				else if( nums[index] == 2 )
  				{
  					nums[index] = nums[end] ;
  					nums[end]   = 2 ; 
  					end-- ;
  					/*
								Here we do not increment index
								because we have not seen elements 
								of end . So it can be 2 or 0 . And
								hence we have to process it .
  					*/
  				}
  				else index++ ;
  		} 
  }
}
