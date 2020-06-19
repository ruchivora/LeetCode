/*
		Mistake : Struggled in writing condition for while loop .
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
public class Solution 
{
    public boolean hasCycle( ListNode head ) 
    {
    		if( head == null )
    				return false ;

        ListNode hare     = head ;
        ListNode tortoise = head ;

        while( hare != null && tortoise != null && hare.next != null )
        {
        		hare      = hare.next.next ;
        		tortoise  = tortoise.next ;

        		if( tortoise == hare  )
        					return true ;
        }
        /*
						This condition will work when the input is [ 1, 2 ]
						because tortoise.next = 2 and hare.next.next == null .
						So , the loop will break because of hare == null  .

						Also, this condition will also work when [ 1, 2, 3]
						becoz tortoise = tortoise.next and hare = hare.next.next . 
						So hare will point to 3 . and while loop will check hare.next
						and hence while loop will break .

        */

      return false ;
    }
}