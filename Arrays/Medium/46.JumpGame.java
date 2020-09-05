/*
	https://www.youtube.com/watch?v=Zb4eRjuPHbM&ab_channel=NickWhite

	https://www.youtube.com/watch?v=muDPTDrpS28&ab_channel=TECHDOSE

	Observation : If their is no 0 in the array then answer will always be true .
				  If their is 0 then can i reach the end ? 

*/

class Solution {
    public boolean canJump(int[] nums) {

    int index = nums.length - 1 ;

    for( int i = nums.length - 1 ; i >= 0 ; i-- )
    {
    	if( i + nums[i] >= index )
    		index = i ;   
    }

    return index == 0;
  }
}