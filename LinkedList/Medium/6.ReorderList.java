/*
		Solution 1 : Traverse the list and store the elements in ArrayList .
								 Then arrange the elements . TC : O(N) SC : O(N)

		solution 2  : Separate the two Lists from middle . 
									Reverse the second list .
									Then merge the two list alternativly .
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


/*
		Solution 1 : 
*/

class Solution {
    public void reorderList(ListNode head) 
    {
    		if( head == null )
    			  return  ;

    	ListNode p = head ;
    	ArrayList<ListNode> seen = new ArrayList<ListNode>() ;

    	while( p != null )
    	{
        seen.add( p ) ;
        p = p.next ;
    	}

    	p = head ;
    	int left  = 1 ;
    	int right = seen.size() - 1 ;
    	int turn  = 0 ;

    	while( left <= right )
    	{
    			if( turn == 0 )
    			{
    				p.next = seen.get( right ) ;
    				p = p.next ;
    				right -- ;
    				turn = 1 ;
    			}
    			else if( turn == 1 )
    					 {
    					 	 p.next = seen.get( left ) ;
    					 	 p = p.next ;
    					 	 left ++ ;
    					 	 turn = 0 ;
    					 }
    	}
    	p.next = null ;
    }
}

/*
		Solution 2  : Efficient Algorithm .
*/

class Solution {
    public void reorderList(ListNode head) 
    {
    		if( head == null || head.next == null) return ;

    		ListNode l1   = head ; /*First list start*/
    		ListNode slow = head ; /*Second list start */
    		ListNode fast = head ; /*Second list end */
    		ListNode prev = null ; /*First list end */

    		/*
						Finding middle of the list .
    		*/
    		while( fast != null && fast.next != null )
    		{
    			prev = slow ;
    			slow = slow.next ;
    			fast = fast.next.next ;
    		}

    		prev.next = null ;

    		/* reverse the second list . */
    		ListNode l2 = reverse( slow ) ;

    		/* Merge the two lists . */
    		merge ( l1 , l2) ;
    		
    }

    public void merge( ListNode l1 , ListNode l2 )
    {
	    	while( l1 != null && l2 != null )
	    	{
	    		ListNode l1Next = l1.next ;
	    		ListNode l2Next = l2.next ;

	    		l1.next = l2 ;

	    		/* 
	    			 This condition is not valid when the linked 
	    		   list consits of odd no. of elements eg: [ 1,2,3,4,5 ]
	    		*/

	    		if( l1next != null ) 
	    				l2.next = l1Next ;

	    		l1 = l1Next ;
	    		l2 = l2Next ; 
	    	}
    }

    public ListNode reverse( ListNode head )
    {
    	ListNode prev = null ;
    	ListNode curr = head ;
    	ListNode next = null ;

    	while( curr != null )
    	{
    			next  = curr.next ; 
    			curr.next = prev ;
    			prev = curr ;
    			curr = next ;
    	}
    	return prev ;
    }
}

