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
    		if( head == null ) return null ;
    		if( head.next == null ) return head ;

        ListNode prev = head ;
        ListNode curr = head.next ;
        ListNode next = null ;

        while( curr != null )
        {
        	next = curr.next ;
        	if( prev.val == curr.val )
        			prev.next = curr.next ;
        	else
        		prev = curr ;

        	curr = next ;
        }
      return head ;
    }
}

/*
    With two pointer .
*/
class Solution {
    public ListNode deleteDuplicates(ListNode head)
    {
        if( head == null ) return null ;
        if( head.next == null ) return head ;

        ListNode p = head ;
        ListNode q = head.next ;

        while( p.next != null )
        {
            if( p.val == q.val )
                p.next = q.next ; 
            else
                p = p.next ;
  
            q = q.next ;
        }
        return head ;
    } 
}

