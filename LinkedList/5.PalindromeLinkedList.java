/*
		Here the logic is : Using slow and fast pointer find the middle .
		Then starting from middle element just reverse the string .
		eg: [1,2,3,3,2,1] becomes [1,2,3,1,2,3]
		Then compare using two pointers .

		challenge : Logic for reversing the list .
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
class Solution {
    public boolean isPalindrome(ListNode head) {
        /*
					Find middle of the list .
			 		Then reverse the list from middle till end .
			 		and now compare from head and middle .
        */

			if( head == null ) return true ;

			ListNode slow = head ;
			ListNode fast = head ;

			while( fast != null && fast.next != null )
			{
					slow = slow.next ;
					fast = fast.next.next ;
			}

			slow = reverse( slow ) ;
			fast = head ;
				
			while( slow != null )
			{
				  if(fast.val != slow.val )
				  	return false ;

				  slow = slow.next ;
				  fast = fast.next ;
			}
			return true ;

    }

    public ListNode reverse( ListNode node )
    {
    	ListNode prev = null ;
    	ListNode curr = node ;
    	ListNode next = null ;

    	while( curr != null )
    	{
    		next = curr.next ;
    		curr.next = prev ;
    		prev = curr ;
    		curr = next ;
    	}
    	node = prev ;

    	return node ;
    }
}