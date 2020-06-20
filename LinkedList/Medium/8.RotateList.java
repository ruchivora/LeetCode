/*
    Solution 1 : Traverse the list and find the length .
                 if( k % n ) != 0 then form a cycle in the list 
                 by assigning head to last node .
                 Then again traverse the list for ( N - k)
                 steps and do some changes . 
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
    public ListNode rotateRight(ListNode head, int k) 
    {
        if( head == null ) return head ;
        if( head.next == null ) return head ;
        
        ListNode p = head ;
        int count = 1 ;
        
        while( p.next != null )
        {
            count++ ;
            p = p.next ; 
        }
        
        k = k % count ;
        if( k == 0 )  return head ;
        
        p.next    = head ;
        int steps = count - k ;
        
        ListNode q = head ;
        p          = head ; 
        count      = 1 ; 
        
        while( count <= steps )
        {
            count++ ;
            p = q ;
            q = q.next ;
        }
        p.next = null ; 
        head   = q ;
       
        return head ;
    }
}