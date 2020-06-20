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
    public ListNode reverseBetween(ListNode head, int m, int n) 
    {
    	if( m == n ) return head ;

    	ListNode start = null ; /* Start of the reverse */
    	ListNode end   = null ; /*End of the reverse */
    	ListNode dummyHead = new ListNode(-1) ;
    	dummyHead.next = head ;
    	head = dummyHead ;
    	ListNode p = head ;
    	ListNode q = head ;
    	ListNode prev = null ;
    	int count = 0 ;

    	while( count <= n )
    	{
	    		if( count == m )
	    		{
	    			prev  = q ;
	    			start = p ;
	    		}
	    		if( count == n )
	    			   end = p ;
	    		
	    		count ++ ;
	    		q = p ;
	    		p = p.next ;
    	}

    		end.next   = null ;
    		prev.next  = reverse( start , end ) ; 
    		start.next = p ;

    	return dummyHead.next ;

    }

    public ListNode reverse( ListNode start , ListNode end )
    {
    	ListNode prev = null ;
    	ListNode curr = start ;
    	ListNode next = null ;

    	while( curr != null )
    	{
    		next = curr.next ;
    		curr.next = prev ;
    		prev = curr ;
    		curr = next ;
    	}
    	return prev ;

    }
}