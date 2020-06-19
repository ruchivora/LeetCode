/*
    Here the condition fast != null will hit 
    when the input is [ 1,2,3,4,5,6 ] .

    The condition fast.next != null will hit
    when the input is [1,2,3,4,5] .
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
             
      ListNode slow = head ;   
      ListNode fast = head ;

      while( fast != null && fast.next != null )
      {
        slow = slow.next ;
        fast = fast.next.next ;
      }
    return slow ;
  }
}