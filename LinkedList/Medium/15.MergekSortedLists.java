/*
		Solution : Form heap of all the first element of the list .
							 Then remove the element with lowest value and 
							 add next element of the list . 
		Revise the concept of comparartor . 
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
    public ListNode mergeKLists(ListNode[] lists) 
    {
        PriorityQueue<ListNode> seen = new PriorityQueue((Comparator<ListNode>),(o1,o2)->o1.val - o2.val) ;

        for( ListNode head : lists )
        {
        	if( head != null )
        				seen.offer( head ) ;
        }
              	
        ListNode dummyHead = new ListNode(-1) ;
        ListNode p = dummyHead ;

        while( !seen.isEmpty() )
        {
        	ListNode curr = seen.poll() ;
        	p.next = curr ;

        		if( curr.next != null )
        			   seen.offer( curr.next ) ;

        	p = p.next ;
        }   					
     	return dummyHead.next ; 
    }						
}