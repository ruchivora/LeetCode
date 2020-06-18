/*
			Solution 1 : Using binary search logic
			Solution 2 : Using fast and slow pointer .   
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
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
    public TreeNode sortedListToBST(ListNode head) 
    {
    	  if( head == null ) 
    	  		return null ;

        ArrayList<Integer> list = new ArrayList<Integer>() ;
        ListNode p = head ;

        while( p != null )
        {
        	list.add( p.val ) ;
        	p = p.next ;
        }

       return  createTree( list , 0 , list.size() - 1 ) ;
    }

    public TreeNode createTree( ArrayList<Integer> list , int left , int right )
    {
    		TreeNode root = new TreeNode() ;

    		if( left <= right )
    		{
    			int mid    = left + ( right - left ) / 2 ;
    			root.val   = list.get(mid) ;
    			root.left  = createTree( list , left ,   mid - 1  ) ;
    			root.right = createTree( list , mid + 1 , right   ) ;
    		}
    		else
    			return null ;

    	return root ;
    }
}


/*
		Using fast and slow pointer 
*/

class Solution 
{
    public TreeNode sortedListToBST(ListNode head) 
    {
    		return sortedListToBST( head , null ) ;
    }

    public TreeNode sortedListToBST( ListNode head , ListNode tail )
    {
    	ListNode slow = head ;
    	ListNode fast = head ;

    	while( fast != tail && fast.next != tail )
    	{
    		slow = slow.next ;
    		fast = fast.next.next ;
    	}

    	/*
				The condition to assign null to a left or
				right address.
    	*/
    	if( slow == tail )
    			return null ;

    	TreeNode root = new TreeNode() ;
    	root.val   = slow.val ;
    	root.left  = sortedListToBST( head , slow ) ;
    	root.right = sortedListToBST( slow.next , tail ) ;

    	return root ;
    }
}