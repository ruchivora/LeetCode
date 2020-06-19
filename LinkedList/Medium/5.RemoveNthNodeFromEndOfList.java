/*
			Solution 1 : Travese the list once and count the number of elements .
									 In the secnd pass remove that node .

			Solution 2 : One pass solution .
									 Traverse till n+1 nodes .
									 Then move slow and fast pointers .
									 We use dummyNode because otherwise it causes "NullPointerException"
									 Without a dummy node it becomes difficult to handle all the cases
									 of "NullPointerException"

*/

/*
		Solution 1 : 
*/
class Solution 
{
    public ListNode removeNthFromEnd(ListNode head, int n) 
    {	
				ListNode  p = head ;
	      int count   = 1 ;
        
        while( p.next != null )
        {
            count++ ;
            p = p.next ; 
        }
       
        int diff = count - B ;
        if( diff < 0 ) return null ;
        
        ListNode dummyHead = new ListNode(-1) ;
        dummyHead.next = head ;
        p = dummyHead ;
        int counter = 0 ;
        
        while( counter != diff && p.next != null )
        {
            counter ++ ;
            p = p.next ;
        }
        
        p.next = p.next.next ;
      
     return dummyHead.next ;
   }
}

/*
		Solution 2 : 
*/
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) 
    {
        ListNode dummyHead = new ListNode(-1) ;
        dummyHead.next     = head ;

        ListNode slow = dummyHead ;
        ListNode fast = dummyHead ;

        for( int i = 1 ; i <= n+1 ; i++ )
        				fast = fast.next ;

        while( fast != null )
        {
        	slow = slow.next ;
        	fast = fast.next ;
        }

        slow.next = slow.next.next ;
        return dummyHead.next ;
    }
}

/*


		Written this solution , without dummy head but leads to
		"Null Pointer Exception ."

		
*/
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) 
    {
    		if( head == null || head.next == null)
    				return null ;
    		
        // ListNode dummyHead = new ListNode(-1) ;
        // dummyHead.next     = head ;

        ListNode slow = head ;
        ListNode fast = head ;

        for( int i = 1 ; i <= n ; i++ )
        				fast = fast.next ;

        while( fast.next != null )
        {
        	slow = slow.next ;
        	fast = fast.next ;
        }

        slow.next = slow.next.next ;
        return head ;
    }
}