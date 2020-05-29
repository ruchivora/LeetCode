class Solution {
    public int singleNonDuplicate(int[] nums) {
        
      if( nums.length == 0  || nums == null )
      	return -1 ;
      if( nums.length == 1 )
      	return nums[0] ;

      int num   = nums[0] ; 
      int index = 1 ;

     	for( int  i = 0 ; i < nums.length ; i++ )
     	{
     		if( i == 0 && nums[i] != nums[i+1] )
     			return nums[i];

     		else if( i == nums.length-1 && nums[i] != nums[i-1] )
     			 	return nums[i] ;

     			  else if( nums[i-1] != nums[i] && nums[i+1] != nums[i] )
     			 			return nums[i] ;
     	}
    return -1 ;
  }
}