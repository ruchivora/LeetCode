/*
	Here the main twist is given by "Nick White" .
	Whenever an array is given always think about following options .
	1 . Can i solve by moving in forward direction ? .
	2 . Can i solve by moving in backward direction ? .
	3 . Or i have to move first in forward direction and
		then moving in backward direction .

	Hint : https://www.youtube.com/watch?v=Zb4eRjuPHbM&t=118s
*/
class Solution {
    public boolean canJump(int[] nums) {

    int index = nums.length - 1 ;

    for( int i = nums.length - 1 ; i >= 0 ; i-- )
    {
    	if( i+nums[i] >= index )
    		index = i ;   
    }

    return index == 0;
  }
}