/*
		Solution : How to find start of the loop ?
							 By Floyds Algorithm .
							 https://www.youtube.com/watch?v=zbozWoMgKW0

*/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) 
    {
				if( head == null || head.next == null )
					 return null ;

				ListNode slow  = head ;
				ListNode fast  = head ;
				Boolean  cycle = false ;

				while( slow != null && fast != null && fast.next != null )
				{
						slow = slow.next ;
						fast = fast.next.next ;

						if( slow == fast )
						{
							cycle = true ;
							break ;
						}		
				}

				if( cycle == false )
						return null ;

				 slow = head ;
				
				while( slow != fast )
				{
					slow = slow.next ;
					fast = fast.next ;
					
				}
			return slow  ;
        
    }
}