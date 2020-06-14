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
    public int getDecimalValue(ListNode head) 
    {
    	ListNode p = head ;
    	int sum = 0 ;

    	while( p != null )
    	{
    		sum = sum * 2 + p.val ;
    		System.out.println("sum " + sum ) ; 
    		p   = p.next ;
    	}
    	return sum ;
    }
}