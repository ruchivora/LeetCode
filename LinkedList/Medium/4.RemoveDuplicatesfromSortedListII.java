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
    public ListNode deleteDuplicates(ListNode head) 
    {
    	if( head == null ) return head ;
    	if( head.next == null ) return head ;

    	ListNode dummyHead = new ListNode(-1) ;
    	dummyHead.next = head ;
    	ListNode prev  = dummyHead ;
    	ListNode curr  = head ;
    	ListNode next  = null ; 

    	while( curr != null && curr.next != null )
    	{
    			next = curr.next ;
    			if( curr.val == next.val )
    			{
    				while( next != null && curr.val == next.val )
    							  next = next.next ;
    		
    				prev.next = next ;
    				curr = next ;
    			}
    			else
    			{
    				prev = curr ;
    				curr = next ;
    			}    
    	}
    	return dummyHead.next ;
  }
}