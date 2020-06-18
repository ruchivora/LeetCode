
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
    public ListNode partition(ListNode head, int x) 
    {
    		if( head == null ) return head ;

        ListNode low  = new ListNode(-1) ;
        ListNode p    = low ;
        ListNode high = new ListNode(-1) ;
        ListNode q    = high ;
        ListNode r    = head ;

        while( r != null )
        {
        	if( r.val < x )
        	{
        		p.next = r ;
        		p = p.next ;
        	}
        	else if( r.val >= x )
        		 	 {
        		 	 		q.next = r ;
        		 	 		q = q.next ;
        		 	 }
        	r = r.next ;
        }
        q.next = null ;
        p.next = high.next ;

        return low.next  ;

    }
}