/*
		Intersection of two LinkedList .

		Solution 1 :
	
		Logic : 1 . Find length of both the lists .
						2 . Which ever is greatear will 

		
		Mistake : An intersaction means the two nodes are the same, 
		so we are comparing their references, not their values. 
		In the example the two ones are different nodes having 
		the same value. So we check for ( p == q ) and not
		( p.val == q.val ) .

		Edge case 1 : If both the lists are of same length .
									Then how will you handle ?
		Edge case 2 : How to find which list is greater in length ?

		Solution 2 : Convert the problem to Linked list Cycle .


*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode( ListNode headA , ListNode headB ) 
    {
        
      int len1 = getListLength( headA ) ;
      int len2 = getListLength( headB ) ;
      int diff = 0;

        if( len1 >= len2 ){
        	diff = len1 - len2 + 1 ;
        	return findIntersection( headA , headB , diff ) ;
        }

        if( len2 > len1 ){
        	diff = len2 - len1 + 1 ;
        	return findIntersection( headB , headA , diff ) ;
        }

       return null ;
    }


    public ListNode findIntersection( ListNode headA , ListNode headB , int intPoint)
    {
    		ListNode p = headA ;
    		ListNode q = headB ;
    		int count  = 1 ;

    		while( count != intPoint ){
    			count++ ;
    			p = p.next ;
    		}

    		while( p != null && q != null ){
    				if( p == q )
    						return p ;
    				p = p.next ;
    				q = q.next ; 
    		}

    	return null ;
    }

    public int getListLength( ListNode head )
    {
    	int count = 0 ; 
    	ListNode p = head ;

    	while( p != null ){
    		count++ ;
    		p = p.next ; 
    	}
    	return count ;
    }
}