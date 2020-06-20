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
    public ListNode insertionSortList(ListNode head) 
    {
        if( head == null || head.next == null )
        	return head ;

        ListNode prev = head ;
        ListNode curr = head.next ;
        ListNode next = null ;

        while( curr != null )
        {
        		next = curr.next ;

        	 	if( curr.val >= prev.val )
        	 	{
        	 		prev = curr ;
        	 		curr = next ;
        	 	}
        	 	else if( curr.val < prev.val && curr.val <= head.val )
        	 				{
        	 						prev.next = curr.next ;
        	 						curr.next = head ;
        	 						head      = curr ;
        	 						curr      = next ; 
        	 				}
        	 				else
        	 				{
        	 					ListNode p = head ;

        	 					while( p.next.val < curr.val )
        	 										p = p.next ;

        	 					prev.next = next ;
        	 					curr.next = p.next ;
        	 					p.next = curr ;
        	 					curr = next ;
        	 				}
        }
    return head ;

    }
}