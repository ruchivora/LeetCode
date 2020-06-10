/*
		The solution is if we have sorted tree then
		middle element forms the root and elements to 
		the left of middle element forms left Node and
		elements to the right of middle element forms the
		right Node . 

		Doing this recursily using binary search will
		help to construct the tree . 
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) 
    {
        if( nums.length == 0 ) return null ;

        return createTree( nums , 0 , nums.length - 1 ) ;
    }

    public TreeNode createTree( int nums[] , int left , int right )
    {
    	
			TreeNode currNode = new TreeNode() ;

    	if( left <=  right )
    	{
    		int mid = left + ( right - left ) / 2 ;
    		
    		currNode.val   =  nums[mid] ;
    		currNode.left  = createTree( nums , left  , mid - 1 ) ;
    		currNode.right = createTree( nums , mid+1 , right   ) ; 
    	}
    	else 
    		return null ; 
    	/* 
    		This will occur in case of leaf node . so we return null
				eg : if the tree is -10,-3,0,5,9 .
						 and -3 is already created as a node .
						 so now left = 0th index and right = 0th index .
						 mid = 0th index . Hence a node of -10 is also
						 created . Now left = 0 , right = -1 . This is 
						 nothing but leaf . So return null .
    	*/
    	return currNode ;
    } 
}