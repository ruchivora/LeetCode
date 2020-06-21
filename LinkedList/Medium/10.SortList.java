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
    public ListNode sortList(ListNode head) 
    {
        if( head == null || head.next == null )
        	   return head ;

        ListNode slow = head ;
        ListNode fast = head ;
        ListNode prev = null ;

        while( fast != null && fast.next != null )
        {
        	prev = slow ;
        	slow = slow.next ;
        	fast = fast.next.next ;
        }
        prev.next = null ;

        ListNode left  = sortList( head ) ;
        ListNode right = sortList( slow ) ;

        return merge( left , right ) ;
    }

    public ListNode merge( ListNode left , ListNode right )
    {
    		if( left  == null ) return right ;
    		if( right == null ) return left  ;

    		ListNode p = left  ;
    		ListNode q = right ;
    		ListNode dummyHead = new ListNode(-1) ;
    		ListNode r = dummyHead ;

    		while( p != null && q != null )
    		{
    				if( p.val < q.val )
    				{
    					r.next = p ;
    					r = r.next ;
    					p = p.next ;
    				}
    				else
    				{
    					r.next = q ;
    					r = r.next ;
    					q = q.next ; 
    				}
    		}
    		if( p == null ) r.next = q ;
    		if( q == null ) r.next = p ;

      return dummyHead.next ;
    }
}