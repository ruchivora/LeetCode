/*
		Read the question properly and then come to solution .
		Mistake : Missed to understand " The digits are stored in 
		reverse order and each of their nodes contain a single digit." 

		Solution : Traverse both the list simulltaneously . 
		If one of the list contains null element then add 
		0 . Keep track of carry .
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
class Solution 
{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
      
    	ListNode dummyHead = new ListNode(-1) ;
    	ListNode p = dummyHead ;
    	int carry  = 0 ;

      while( l1 != null || l2 != null )
      {
      		int num1 = ( l1 == null ) ? 0 : l1.val ;
      		int num2 = ( l2 == null ) ? 0 : l2.val ;

      		int sum = num1 + num2 + carry ;
      		ListNode temp = new ListNode( sum % 10 ) ;
      		carry = sum / 10 ;

      		p.next = temp ;
      		p  = temp ;

      		if( l1 != null ) 
      			   l1 = l1.next ;

      		if( l2 != null ) 
      			   l2 = l2.next ;
      }
      
      if( carry > 0 )
      {
      	ListNode temp = new ListNode(carry) ;
      	p.next = temp ;
      	p = temp ;
      }
      return dummyHead.next ;
    }
}