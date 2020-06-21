/*
		Naming of variables : eg : [1,2,3,4]
		I have inserted dummyHead so eg becomes :[-1,1,2,3,4]
		Then prev = -1 , node1 = 1 , node2 = 2 , next = 3
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
    public ListNode swapPairs(ListNode head) 
    {
        if( head == null || head.next == null ) 
        	    return head ;
        /* Creating dummy node and assigning head to dummyHead . */	  
        ListNode dummyHead = new ListNode(-1) ;
        dummyHead.next = head ;
        head = dummyHead ;

        ListNode prev = head ;
        ListNode node1 = head.next ; 

        while( node1 != null && node1.next != null )
        {
        	ListNode next = node1.next.next ;
        	ListNode node2 = node1.next ;
        	node1.next = next  ;
        	node2.next = node1 ;
        	prev.next  = node2 ; 
        	prev  = node1 ;
        	node1 = next  ;
        }
      return head.next  ;
    }
}