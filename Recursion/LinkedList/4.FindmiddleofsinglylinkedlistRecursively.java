/*
		Executed on LeetCode : https://leetcode.com/problems/middle-of-the-linked-list/
		Question :  https://www.geeksforgeeks.org/find-middle-singly-linked-list-recursively/
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
    public ListNode middleNode( ListNode head ) 
    {
      return middleNode( head , head ) ;
    }

    public ListNode middleNode( ListNode slow , ListNode fast )
    {
    		if( fast == null || fast.next == null )
    				return slow ;

    		slow = slow.next ;
    		fast = fast.next.next ;

    		return middleNode( slow , fast ) ;	
    } 

}